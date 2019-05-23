package com.zjh.dao;

import java.util.List;

import com.zjh.model.Items;

public interface ItemsDao {
	
	/**
	 * 取得最新七个友情链接
	 * @return
	 */
	public List<Items> getList();
}
