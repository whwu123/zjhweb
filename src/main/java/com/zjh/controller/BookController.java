package com.zjh.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjh.util.JdbcUtil;

@Controller
@RequestMapping("book")
public class BookController {
	Logger logger = Logger.getLogger(BookController.class);
	private Connection connection;
	private PreparedStatement ps;
	
	@RequestMapping("saveBook.do")
	@ResponseBody
	public  String saveBookMessage(String nickname,String phone,String company,String email,String title,String content){
		try {
			logger.info("进行留言的插入~~");
			if(title!=null && !title.isEmpty()){
				String sql = " insert into note (nickname,phone,companyname,email,theme,content,createtime,status) values (?,?,?,?,?,?,?,?)";
				connection = JdbcUtil.getConnection();
				connection.setAutoCommit(false);
				ps = connection.prepareStatement(sql);
				ps.setString(1, nickname);
				ps.setString(2, phone);
				ps.setString(3, company);
				ps.setString(4, email);
				ps.setString(5, title);
				ps.setString(6, content);
				ps.setTimestamp(7, new Timestamp(new Date().getTime()));
				ps.setInt(8, 0);
				if(ps.executeUpdate()>0){
					connection.commit();
					return "ok";
				}else{
					connection.rollback();
					return "fail";
				}
				
			}
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		
		}finally{
			JdbcUtil.colseResource(connection, ps, null);
		}
		return "fail";
	}
}
