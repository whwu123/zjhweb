package com.zjh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zjh.dao.ItemsDao;
import com.zjh.model.Items;
import com.zjh.service.ItemsService;
@Service("ItemsService")
public class ItemsServiceImpl implements ItemsService {
	@Resource(name="ItemsDao")
	private ItemsDao itemsDao;
	@Override
	public List<Items> getList() {
		return itemsDao.getList();
	}
	@Override
	public Items gtItemsByKey(String fKey) {
		return itemsDao.gtItemsByKey(fKey);
	}

}
