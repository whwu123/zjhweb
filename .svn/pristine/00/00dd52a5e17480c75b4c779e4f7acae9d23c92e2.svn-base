package com.zjh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zjh.dao.ExampleDao;
import com.zjh.model.Example;
import com.zjh.service.ExampleService;

@Service("ExampleService")
public class ExampleServiceImpl implements ExampleService {
	@Resource(name="ExampleDao")
	private ExampleDao exampleDao;
	@Override
	public List<Example> getExamples(int pageNum,int pageSize) {
		return exampleDao.getExamples(pageNum,pageSize);
	}
	@Override
	public List<Example> getExamplesAll() {
		return exampleDao.getExamplesAll();
	}
	@Override
	public int getCountExample() {
		return exampleDao.getCountExample();
	}
	@Override
	public Example getExampleById(int id) {
		return exampleDao.getExampleById(id);
	}
	@Override
	public Example getExamplePrev(int id) {
		return exampleDao.getExamplePrev(id);
	}
	@Override
	public Example getExampleNext(int id) {
		return exampleDao.getExampleNext(id);
	}

}
