package com.zjh.dao;

import java.util.List;

import com.zjh.model.News;

public interface NewsDao {
	
	public List<News> getList();
	
	public List<News> getList(int pageNum,int pageSize,int type);
	
	public int getTotalCount(int type);
	/**
	 * 通过新闻ID取得新闻的
	 */
	public News getNewsById(Integer id);
	/**
	 * 通过新闻ID取得新闻的上一篇
	 */
	public News getNewsPrev(Integer id);
	/**
	 * 通过新闻ID取得新闻的下一篇
	 */
	public News getNewsNext(Integer id);

}	
