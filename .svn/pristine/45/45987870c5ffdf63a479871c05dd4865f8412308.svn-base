package com.zjh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zjh.dao.ExampleDao;
import com.zjh.model.Example;
import com.zjh.util.JdbcUtil;
@Repository("ExampleDao")
public class ExampleDaoImpl implements ExampleDao {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	@Override
	public List<Example> getExamples(int pageNum,int pageSize) {
		List<Example> examples = new ArrayList<Example>();
		try{
			String sql = " select * from example where status = 0 order by createtime desc limit ?,? ";
			connection = JdbcUtil.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, (pageNum-1)*pageSize);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			while(rs.next()){
				Example  example = new Example();
				example.setId(rs.getInt("id"));
				example.setTitle(rs.getString("title"));
				example.setCreatetime(new Date((rs.getTimestamp("createtime")).getTime()));
				example.setContent(rs.getString("content"));
				example.setStatus(rs.getInt("status"));
				example.setAuthor(rs.getString("author"));
				example.setImg(rs.getString("img"));
				example.setDescription(rs.getString("description"));
				examples.add(example);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.colseResource(connection, ps, rs);
		}
		return examples;
	}
	@Override
	public int getCountExample() {
		int totalCount = 0;
		try{
			String sql =" select count(id) as count from example where status = 0 ";
			connection = JdbcUtil.getConnection();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				totalCount = rs.getInt("count");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.colseResource(connection, ps, rs);
		}
		return totalCount;
	}
	@Override
	public Example getExampleById(int id) {
		Example example = new Example();
		try {
			String sql = " select * from example where status = 0 and id = ? ";
			connection = JdbcUtil.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				example.setId(rs.getInt("id"));
				example.setTitle(rs.getString("title"));
				example.setCreatetime(new Date((rs.getTimestamp("createtime")).getTime()));
				example.setContent(rs.getString("content"));
				example.setStatus(rs.getInt("status"));
				example.setAuthor(rs.getString("author"));
				example.setImg(rs.getString("img"));
				example.setDescription(rs.getString("description"));
				example.setShowTime(sdf.format(new Date((rs.getTimestamp("createtime")).getTime())));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.colseResource(connection, ps, rs);
		}
		return example;
	}
	@Override
	public Example getExamplePrev(int id) {
		Example example = new Example();
		try {
			String sql = " select * from example where status = 0 and id < ? order by id desc limit 0,1 ";
			connection = JdbcUtil.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				example.setId(rs.getInt("id"));
				example.setTitle(rs.getString("title"));
				example.setCreatetime(new Date((rs.getTimestamp("createtime")).getTime()));
				example.setContent(rs.getString("content"));
				example.setStatus(rs.getInt("status"));
				example.setAuthor(rs.getString("author"));
				example.setImg(rs.getString("img"));
				example.setDescription(rs.getString("description"));
				example.setShowTime(sdf.format(new Date((rs.getTimestamp("createtime")).getTime())));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.colseResource(connection, ps, rs);
		}
		return example;
	}
	@Override
	public Example getExampleNext(int id) {
		Example example = new Example();
		try {
			String sql = " select * from example where status = 0 and id > ? order by id asc limit 0,1 ";
			connection = JdbcUtil.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				example.setId(rs.getInt("id"));
				example.setTitle(rs.getString("title"));
				example.setCreatetime(new Date((rs.getTimestamp("createtime")).getTime()));
				example.setContent(rs.getString("content"));
				example.setStatus(rs.getInt("status"));
				example.setAuthor(rs.getString("author"));
				example.setImg(rs.getString("img"));
				example.setDescription(rs.getString("description"));
				example.setShowTime(sdf.format(new Date((rs.getTimestamp("createtime")).getTime())));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.colseResource(connection, ps, rs);
		}
		return example;
	}
	@Override
	public List<Example> getExamplesAll() {
		List<Example> examples = new ArrayList<Example>();
		try{
			String sql = " select * from example where status = 0 ORDER BY createtime desc ";
			connection = JdbcUtil.getConnection();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Example  example = new Example();
				example.setId(rs.getInt("id"));
				example.setTitle(rs.getString("title"));
				example.setCreatetime(new Date((rs.getTimestamp("createtime")).getTime()));
				example.setContent(rs.getString("content"));
				example.setStatus(rs.getInt("status"));
				example.setAuthor(rs.getString("author"));
				example.setImg(rs.getString("img"));
				example.setDescription(rs.getString("description"));
				examples.add(example);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.colseResource(connection, ps, rs);
		}
		return examples;
	}

}
