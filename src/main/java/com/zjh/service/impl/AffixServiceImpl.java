package com.zjh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zjh.dao.AffixDao;
import com.zjh.model.Affix;
import com.zjh.service.AffixService;

@Service("AffixService")
public class AffixServiceImpl implements AffixService {
	@Resource(name="AffixDao")
	private AffixDao affixDao;
	@Override
	public List<Affix> getAffixs(int pageNum, int pageSize) {
		return affixDao.getAffixs(1, 3);
	}
	@Override
	public Affix getAffixById(int id) {
		return affixDao.getAffixById(id);
	}
	@Override
	public List<Affix> getAffixsAll(int pageNum, int pageSize) {
		return affixDao.getAffixs(pageNum, pageSize);
	}
	@Override
	public int getAffixCount() {
		// TODO Auto-generated method stub
		return affixDao.getAffixCount();
	}
	@Override
	public Affix getAffixByIdNotContent(Integer id) {
		
		return affixDao.getAffixByIdNotContent(id);
	}

}
