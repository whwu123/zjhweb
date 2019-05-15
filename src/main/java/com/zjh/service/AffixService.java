package com.zjh.service;

import java.util.List;

import com.zjh.model.Affix;

public interface AffixService {
	
	/**
	 * 展示首页附件数据
	 * @return
	 */
	public List<Affix> getAffixs(int pageNum,int pageSize); 
	/**
	 * 展示首页附件数据
	 * @return
	 */
	public List<Affix> getAffixsAll(int pageNum,int pageSize); 
	
	/**
	 * 通过ID查找附件
	 */
	public Affix getAffixById(int id);
	
	/**
	 * 查询总数量
	 */
	public int getAffixCount();
	
	/**
	 * 通过ID查找没有内容的附件以增加查询速度
	 */
	public Affix getAffixByIdNotContent(Integer id);
}
