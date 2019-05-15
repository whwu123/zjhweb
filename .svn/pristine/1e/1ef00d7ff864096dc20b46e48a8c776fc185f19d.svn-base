package com.zjh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zjh.dao.NewsDao;
import com.zjh.model.News;
import com.zjh.util.JdbcUtil;
@Repository("NewsDao")
public class NewsDaoImpl implements NewsDao {
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public List<News> getList() {
		List<News> list = new ArrayList<News>();
    	//取前三条新闻
    	try{
    		String sql = "SELECT * FROM news where type =1  and status = 0 order by createtime desc limit 0,2";
    		connection = JdbcUtil.getConnection();
    		ps = connection.prepareStatement(sql);
    		rs = ps.executeQuery();
    		while(rs.next()){
    			News news = new News();
    			news.setId(rs.getInt("id"));
    			news.setTitle(rs.getString("title"));
    			news.setAuthor(rs.getString("author"));
    			news.setSources(rs.getString("sources"));
    			news.setContent(rs.getString("content"));
    			//news.setCreatetime();
    			news.setShowtime(sdf.format(new Date((rs.getTimestamp("createtime")).getTime())));
    			news.setType(rs.getInt("type"));
    			news.setStatus(rs.getInt("status"));
    			news.setImgpath(rs.getString("img"));
    			news.setDescription(rs.getString("description"));
    			news.setSmallimg(rs.getString("smallimg"));
    			list.add(news);
    		}
    	}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.colseResource(connection, ps, rs);
		}
    	return list;
	}

	@Override
	public List<News> getList(int pageNum, int pageSize,int type) {
		List<News> list = new ArrayList<News>();
    	//取前三条新闻
    	try{
    		String sql = "select * from news where type =?  and status = 0 order by createtime desc limit ? , ? ";
    		connection = JdbcUtil.getConnection();
    		ps = connection.prepareStatement(sql);
    		ps.setInt(1, type);
    		ps.setInt(2, (pageNum-1)*pageSize);
    		ps.setInt(3, pageSize);
    		rs = ps.executeQuery();
    		while(rs.next()){
    			News news = new News();
    			news.setId(rs.getInt("id"));
    			news.setTitle(rs.getString("title"));
    			news.setAuthor(rs.getString("author"));
    			news.setSources(rs.getString("sources"));
    			news.setContent(rs.getString("content"));
    			news.setShowtime(sdf.format(new Date((rs.getTimestamp("createtime")).getTime())));
    			news.setType(rs.getInt("type"));
    			news.setStatus(rs.getInt("status"));
    			news.setImgpath(rs.getString("img"));
    			news.setDescription(rs.getString("description"));
    			news.setSmallimg(rs.getString("smallimg"));
    			list.add(news);
    		}
    	}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.colseResource(connection, ps, rs);
		}
    	return list;
	}

	@Override
	public int getTotalCount(int type) {
		int totalCount = 0;
		try{
			String sql =" select count(id) as count from news where type = ? and status = 0 ";
			connection = JdbcUtil.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, type);
			rs = ps.executeQuery();
			while(rs.next()){
				totalCount = rs.getInt("count");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.colseResource(connection, ps, rs);
		}
		return totalCount;
	}

	@Override
	public News getNewsById(Integer id) {
		News news = new News();
		try {
			String sql = " select * from news where id = ? ";
			connection = JdbcUtil.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
    			news.setId(rs.getInt("id"));
    			news.setTitle(rs.getString("title"));
    			news.setAuthor(rs.getString("author"));
    			news.setSources(rs.getString("sources"));
    			news.setContent(rs.getString("content"));
    			news.setShowtime(sdf.format(new Date((rs.getTimestamp("createtime")).getTime())));
    			news.setType(rs.getInt("type"));
    			news.setStatus(rs.getInt("status"));
    			news.setImgpath(rs.getString("img"));
    			news.setDescription(rs.getString("description"));
    			news.setSmallimg(rs.getString("smallimg"));
    			news.setAffixid(rs.getInt("affixid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.colseResource(connection, ps, rs);
		}
		return news;
	}

	@Override
	public News getNewsPrev(Integer id) {
		News news = new News();
		try {
			String sql = " select * from news where news.id < ? and status =0 order by id desc limit 0,1 ";
			connection = JdbcUtil.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
    			news.setId(rs.getInt("id"));
    			news.setTitle(rs.getString("title"));
    			news.setDescription(rs.getString("description"));
    			news.setSmallimg(rs.getString("smallimg"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.colseResource(connection, ps, rs);
		}
		return news;
	}

	@Override
	public News getNewsNext(Integer id) {
		News news = new News();
		try {
			String sql = " select * from news where news.id > ? and status =0 order by id asc limit 0,1 ";
			connection = JdbcUtil.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
    			news.setId(rs.getInt("id"));
    			news.setTitle(rs.getString("title"));
    			news.setDescription(rs.getString("description"));
    			news.setSmallimg(rs.getString("smallimg"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.colseResource(connection, ps, rs);
		}
		return news;
	}

}
