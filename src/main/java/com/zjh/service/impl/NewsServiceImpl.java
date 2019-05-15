package com.zjh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zjh.dao.NewsDao;
import com.zjh.model.News;
import com.zjh.service.NewsService;
@Service("NewsService")
public class NewsServiceImpl implements NewsService {
	@Resource(name="NewsDao")
	private NewsDao newsDao;
	@Override
	public List<News> getList() {
		return newsDao.getList();
	}
	@Override
	public List<News> getList(int pageNum, int pageSize, int type) {
		return newsDao.getList(pageNum, pageSize, type);
	}
	@Override
	public int getTotalCount(int type) {
		return newsDao.getTotalCount(type);
	}
	@Override
	public News getNewsById(Integer id) {
		return newsDao.getNewsById(id);
	}
	@Override
	public News getNewsPrev(Integer id) {
		return newsDao.getNewsPrev(id);
	}
	@Override
	public News getNewsNext(Integer id) {
		return newsDao.getNewsNext(id);
	}

}
