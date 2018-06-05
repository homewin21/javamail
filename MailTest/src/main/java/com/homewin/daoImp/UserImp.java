package com.homewin.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.homewin.bean.User;
import com.homewin.dao.UserDao;
import com.homewin.util.DBUtil;


public class UserImp implements UserDao {

	@Override
	public int save(User user) throws SQLException {
		int flag=0;
		Connection connection = DBUtil.getConnection();
		String sql ="insert into user(username,email,password,state,code) values(?,?,?,?,?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getEmail());
		pstmt.setString(3, user.getPassword());
		pstmt.setInt(4, user.getState());
		pstmt.setString(5, user.getCode());
		flag=pstmt.executeUpdate();
		DBUtil.close(connection, pstmt, null);
		return flag;
	}

	@Override
	public int activeUser(String code) throws SQLException {
		// TODO Auto-generated method stub
		int flag=0;
		Connection connection = DBUtil.getConnection();
		String sql="update user set state=1 where code=?";
		PreparedStatement pstmt=connection.prepareStatement(sql);
		pstmt.setString(1, code);
		flag=pstmt.executeUpdate();
		DBUtil.close(connection, pstmt, null);
		return flag;
	}

}
