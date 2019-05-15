package com.zjh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zjh.dao.AffixDao;
import com.zjh.model.Affix;
import com.zjh.util.JdbcUtil;

@Repository("AffixDao")
public class AffixDaoImpl implements AffixDao {
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	@Override
	public List<Affix> getAffixs(int pageNum, int pageSize) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		List<Affix> list = new ArrayList<Affix>();
		try {
			String sql = " select id, affixname, affixtype, affixtime, `status`,size,descrption,affixpath from affix where status = 0 ORDER BY affixtime desc limit ? , ? ";
			connection = JdbcUtil.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, (pageNum-1)*pageSize);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			while(rs.next()){
				Affix affix = new Affix();
				affix.setId(rs.getInt("id"));
				affix.setAffixname(rs.getString("affixname"));
				affix.setAffixtype(rs.getString("affixtype"));
				affix.setAffixtime(new Date((rs.getTimestamp("affixtime")).getTime()));
				affix.setDescrption(rs.getString("descrption"));
				affix.setSize(rs.getLong("size"));
				affix.setStatus(rs.getInt("status"));
				//affix.setContent(rs.getBytes("content"));
				affix.setAffixpath(rs.getString("affixpath"));
				affix.setShowtime(sdf.format(new Date((rs.getTimestamp("affixtime")).getTime())));
				list.add(affix);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.colseResource(connection, ps, rs);
		}
		return list;
	}
	@Override
	public Affix getAffixById(Integer id) {
		Affix affix = new Affix();
		try {
			String sql = "select id,affixname,affixtype,affixtime,descrption,`status`,size,affixpath from affix where id = ? ";
			connection = JdbcUtil.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				affix.setId(rs.getInt("id"));
				affix.setAffixname(rs.getString("affixname"));
				affix.setAffixtype(rs.getString("affixtype"));
				affix.setAffixtime(new Date((rs.getTimestamp("affixtime")).getTime()));
				affix.setDescrption(rs.getString("descrption"));
				affix.setSize(rs.getLong("size"));
				affix.setStatus(rs.getInt("status"));
				affix.setAffixpath(rs.getString("affixpath"));
				//affix.setContent(rs.getBytes("content"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.colseResource(connection, ps, rs);
		}
		return affix;
	}
	@Override
	public int getAffixCount() {
		int result = 0;
		try {
			String sql = "select count(id) as totalCount from affix where status = '0' ";
			connection =  JdbcUtil.getConnection();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				result = rs.getInt("totalCount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.colseResource(connection, ps, rs);
		}
		return result;
	}
	@Override
	public Affix getAffixByIdNotContent(Integer id) {
		Affix affix = new Affix();
		try {
			String sql = "select id, affixname, affixtype, affixtime, `status`,size,descrption from affix where id = ? ";
			connection = JdbcUtil.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				affix.setId(rs.getInt("id"));
				affix.setAffixname(rs.getString("affixname"));
				affix.setAffixtype(rs.getString("affixtype"));
				affix.setAffixtime(new Date((rs.getTimestamp("affixtime")).getTime()));
				affix.setDescrption(rs.getString("descrption"));
				affix.setSize(rs.getLong("size"));
				affix.setStatus(rs.getInt("status"));
				//affix.setContent(rs.getBytes("content"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.colseResource(connection, ps, rs);
		}
		return affix;
	}

}
