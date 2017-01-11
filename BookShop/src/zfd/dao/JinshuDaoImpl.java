package zfd.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import zfd.bean.BookInfo;
import zfd.bean.BookJinhuo;
import zfd.utils.PageHibernateCallback;

public class JinshuDaoImpl extends HibernateDaoSupport implements JinshuDao {
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BookJinhuo> findAll() {
		return this.getHibernateTemplate().find("from BookJinhuo");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookJinhuo> find(BookJinhuo bookJinhuo) {
		
		String sql = "from BookJinhuo where 1 = 1 ";
		List<Object> params = new ArrayList<Object>();
		
		if(StringUtils.isNotBlank(bookJinhuo.getJinshuMa())){
			sql += "and jinshuMa = ? ";
			params.add(bookJinhuo.getJinshuMa());
		}
		
		if(StringUtils.isNotBlank(bookJinhuo.getBookInfo().getTiaoma())){
			
			BookInfo book = this.findBookInfoByTiaoMa(bookJinhuo.getBookInfo());
			
			sql += "and bookId = ? ";
			if(book == null){
				params.add("-1");
			}else{
				params.add(book.getBookid());
			}
			
		}
		
		
		return this.getHibernateTemplate().find(sql , params.toArray());
	}

	@Override
	public List<BookJinhuo> find(BookJinhuo bookJinhuo, int start, int rongliang) {
		
		String sql = "from BookJinhuo where 1 = 1 ";
		List<Object> params = new ArrayList<Object>();
		
		if(StringUtils.isNotBlank(bookJinhuo.getJinshuMa())){
			sql += "and jinshuMa = ? ";
			params.add(bookJinhuo.getJinshuMa());
		}
		
		if(StringUtils.isNotBlank(bookJinhuo.getBookInfo().getTiaoma())){
			
			BookInfo book = this.findBookInfoByTiaoMa(bookJinhuo.getBookInfo());
			
			
			sql += "and bookId = ? ";
			
			if(book == null){
				params.add("-1");
			}else{
				params.add(book.getBookid());
			}
			
		}
		
		return this.getHibernateTemplate().execute(new PageHibernateCallback<BookJinhuo>(sql, params.toArray(), (start - 1)*5, rongliang));
	}

	@SuppressWarnings("unchecked")
	@Override
	public BookInfo findBookInfoByTiaoMa(BookInfo bookInfo) {
		
		List<BookInfo> book = this.getHibernateTemplate().find("from BookInfo where tiaoma = ? " ,bookInfo.getTiaoma());
		if(book != null && book.size() > 0){
			return book.get(0);
		}else{
			return null;
		}
		
		
	}

	@Override
	public void saveOrUpdateBookJinhuo(BookJinhuo bookJinhuo) {
		this.getHibernateTemplate().saveOrUpdate(bookJinhuo.getBookInfo());
		this.getHibernateTemplate().saveOrUpdate(bookJinhuo);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookJinhuo> findByBookIdWithAscOrder(BookInfo book) {
		String hql = "from BookJinhuo where bookInfo = ? order by caiGouDate asc";
		
		
		return (List<BookJinhuo>)this.getHibernateTemplate().find(hql, book);
	}
	
}
