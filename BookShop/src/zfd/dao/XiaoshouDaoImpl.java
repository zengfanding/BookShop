package zfd.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import zfd.bean.BookInfo;
import zfd.bean.BookJinhuo;
import zfd.bean.BookXiaoshou;
import zfd.utils.PageHibernateCallback;

public class XiaoshouDaoImpl extends HibernateDaoSupport implements XiaoshouDao{

	@Override
	public List<BookXiaoshou> findAll() {
		
		
		return this.getHibernateTemplate().find("from BookXiaoshou order by xiaoshouId");
	}

	@Override
	public List<BookXiaoshou> find(BookXiaoshou xs, int startIndex, int rongliang) {
		
		String sql = "from BookXiaoshou where 1 = 1 ";
		List<Object> params = new ArrayList<Object>();
		
		if(StringUtils.isNotBlank(xs.getXiaoshouMa())){
			sql += "and xiaoshouMa = ? ";
			params.add(xs.getXiaoshouMa());
		}
		
		if(StringUtils.isNotBlank(xs.getBookInfo().getTiaoma())){
			String s = "from BookInfo where tiaoma = ?";
			BookInfo b = (BookInfo) this.getHibernateTemplate().find(s, xs.getBookInfo().getTiaoma()).get(0);
			sql += " and bookId = ? ";
			params.add(b.getBookid());
		}
		
		sql+=" order by xiaoshouId ";
		
		return this.getHibernateTemplate().execute(new PageHibernateCallback<BookXiaoshou>(sql,params.toArray(),(startIndex - 1)*5,rongliang));
	}

	@Override
	public List<BookXiaoshou> find(BookXiaoshou xs) {
		
		String sql = "from BookXiaoshou where 1 = 1 ";
		List<Object> params = new ArrayList<Object>();
		
		if(StringUtils.isNotBlank(xs.getXiaoshouMa())){
			sql += "and xiaoshouMa = ? ";
			params.add(xs.getXiaoshouMa());
		}
		
		if(StringUtils.isNotBlank(xs.getBookInfo().getTiaoma())){
			String s = "from BookInfo where tiaoma = ?";
			BookInfo b = (BookInfo) this.getHibernateTemplate().find(s, xs.getBookInfo().getTiaoma()).get(0);
			sql += " and bookId = ? ";
			params.add(b.getBookid());
		}
		
		sql+=" order by xiaoshouId ";
		return this.getHibernateTemplate().find(sql, params.toArray());
	}

	@Override
	public List<BookXiaoshou> findByBookIdWithAscOrder(BookInfo book) {
		String hql = "from BookXiaoshou where bookInfo = ? order by xiaoshouDate asc";
		
		
		return (List<BookXiaoshou>)this.getHibernateTemplate().find(hql, book);
	}

}
