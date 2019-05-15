package com.zjh.dao;

import java.util.List;

import com.zjh.model.Affix;

public interface AffixDao {
	/**
	 * 展示首页附件数据
	 * @return
	 */
	public List<Affix> getAffixs(int pageNum,int pageSize); 
	
	/**
	 * 通过ID查找附件
	 */
	public Affix getAffixById(Integer id);
	
	/**
	 * 通过ID查找没有内容的附件以增加查询速度
	 */
	public Affix getAffixByIdNotContent(Integer id);
	
	public int getAffixCount();
}
