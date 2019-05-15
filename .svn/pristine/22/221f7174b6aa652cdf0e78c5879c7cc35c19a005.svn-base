package com.zjh.service;

import java.util.List;

import com.zjh.model.Example;

public interface ExampleService {
	/**
	 * 首页案例展示数据
	 * @return
	 */
	public List<Example> getExamples(int pageNum,int pageSize);
	/**
	 * 首页案例所有展示数据
	 * @return
	 */
	public List<Example> getExamplesAll();
	
	/**
	 * 取得总数量
	 */
	public int getCountExample();
	
	/**
	 * 根据ID查看案例
	 */
	public Example getExampleById(int id);
	
	/**
	 * 通过ID取得上一篇案例
	 */
	public Example getExamplePrev(int id);
	/**
	 * 通过ID取得下一篇案例
	 */
	public Example getExampleNext(int id);
}
