package com.zjh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zjh.dao.ItemsDao;
import com.zjh.model.Items;
import com.zjh.util.JdbcUtil;

@Repository("ItemsDao")
public class ItemsDaoImpl implements ItemsDao {
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	@Override
	public List<Items> getList() {
		List<Items> list = new ArrayList<Items>();
		try {
			String sql = " select * from items where f_status = 1 and f_type = 1 ORDER BY f_status desc limit 0,5";
			connection = JdbcUtil.getConnection();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Items items = new Items();
				items.setfId(rs.getString("f_id"));
				items.setfContent(rs.getString("f_content"));
				items.setfCreatetime(rs.getTimestamp("f_createtime"));
				items.setfDescrition(rs.getString("f_description"));
				items.setfImgsrc(rs.getString("f_imgsrc"));
				items.setfKey(rs.getString("f_key"));
				items.setfOpennewTab(rs.getString("f_opennewtab"));
				items.setfPid(rs.getString("f_pid"));
				items.setfSort(rs.getInt("f_sort"));
				items.setfStatus(rs.getInt("f_status"));
				items.setfStyle(rs.getString("f_style"));
				items.setfTitle(rs.getString("f_title"));
				items.setfType(rs.getInt("f_type"));
				items.setfUrl(rs.getString("f_url"));
				list.add(items);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.colseResource(connection, ps, rs);
		}
		return list;
	}
	@Override
	public Items gtItemsByKey(String fKey) {
		Items items = new Items();
		try {
			String sql = " select * from items where f_key = ?";
			connection = JdbcUtil.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, fKey);
			rs = ps.executeQuery();
			while(rs.next()){
				items.setfId(rs.getString("f_id"));
				items.setfContent(rs.getString("f_content"));
				items.setfCreatetime(rs.getTimestamp("f_createtime"));
				items.setfDescrition(rs.getString("f_description"));
				items.setfImgsrc(rs.getString("f_imgsrc"));
				items.setfKey(rs.getString("f_key"));
				items.setfOpennewTab(rs.getString("f_opennewtab"));
				items.setfPid(rs.getString("f_pid"));
				items.setfSort(rs.getInt("f_sort"));
				items.setfStatus(rs.getInt("f_status"));
				items.setfStyle(rs.getString("f_style"));
				items.setfTitle(rs.getString("f_title"));
				items.setfType(rs.getInt("f_type"));
				items.setfUrl(rs.getString("f_url"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.colseResource(connection, ps, rs);
		}
		return items;
	}

}
