package zfd.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import zfd.bean.BookInfo;
import zfd.bean.BookJinhuo;
import zfd.bean.BookXiaoshou;
import zfd.utils.PageHibernateCallback;

public class BookDaoImpl extends HibernateDaoSupport implements BookDao{

	@Override
	public void saveOrUpdateBook(BookInfo bookInfo) {
		
		this.getHibernateTemplate().saveOrUpdate(bookInfo);
		

	}

	@SuppressWarnings("unchecked")
	@Override
	public BookInfo findByTiaoma(String tiaoma) {
		
		List<BookInfo> list =   this.getHibernateTemplate().find("from BookInfo where tiaoma = ?", tiaoma);
		
		if(list != null && list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookInfo> findAll() {
		return  this.getHibernateTemplate().find("from BookInfo order by bookid ");
	}

	@Override
	public List<BookInfo> find(BookInfo bookInfo , int start , int rongliang) {
		
		String sql = "from BookInfo where 1 = 1 ";
		List<Object> params = new ArrayList<Object>();
		
		if(StringUtils.isNotBlank(bookInfo.getTiaoma())){
			sql += "and tiaoma = ? ";
			params.add(bookInfo.getTiaoma());
			
		}
		
		if(StringUtils.isNotBlank(bookInfo.getName())){
			sql += "and name like ? ";
			params.add("%"+bookInfo.getName()+"%");
		}
		
		if(StringUtils.isNotBlank(bookInfo.getAuthor())){
			sql += "and author = ? ";
			params.add(bookInfo.getAuthor());
		}
		
		if(StringUtils.isNotBlank(bookInfo.getPublishing())){
			sql += "and publishing like ? ";
			params.add("%"+bookInfo.getPublishing()+"%");
		}
		
		sql += " order by bookid ";
		
	
		return this.getHibernateTemplate().execute(new PageHibernateCallback<BookInfo>(sql,params.toArray(),(start - 1)*5,rongliang));
	}

	@Override
	public void deleteBookByBookId(BookInfo bookInfo) {
		
		this.getHibernateTemplate().delete(bookInfo);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookInfo> find(BookInfo bookInfo) {
		
		String sql = "from BookInfo where 1 = 1 ";
		List<Object> params = new ArrayList<Object>();
		
		if(StringUtils.isNotBlank(bookInfo.getTiaoma())){
			sql += "and tiaoma = ? ";
			params.add(bookInfo.getTiaoma());
			
		}
		
		if(StringUtils.isNotBlank(bookInfo.getName())){
			sql += "and name like ? ";
			params.add("%"+bookInfo.getName()+"%");
		}
		
		if(StringUtils.isNotBlank(bookInfo.getAuthor())){
			sql += "and author = ? ";
			params.add(bookInfo.getAuthor());
		}
		
		if(StringUtils.isNotBlank(bookInfo.getPublishing())){
			sql += "and publishing like ? ";
			params.add("%"+bookInfo.getPublishing()+"%");
		}
		
		sql +=" order by bookid ";
		
		return this.getHibernateTemplate().find(sql , params.toArray());
	}

	@Override
	public void saveOrUpdateJinhuo(BookJinhuo bookJinhuo) {
		
		
		this.getHibernateTemplate().saveOrUpdate(bookJinhuo);
		
		
		
	}

	@Override
	public List<BookInfo> findBookWithEmergency(int start ,int rongliang) {
		
		String sql = "from BookInfo where num < 10";
		return this.getHibernateTemplate().execute(new PageHibernateCallback<BookInfo>(sql,null,(start - 1)*5,rongliang));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookInfo> findBookWithEmergency() {
		String sql = "from BookInfo where num < 10";
		return this.getHibernateTemplate().find(sql);
	}

	@Override
	public void saveSale(BookXiaoshou sale) {
		
			this.getHibernateTemplate().save(sale);
		
	}

	
}


