package com.homewin.dao;

import java.sql.SQLException;

import com.homewin.bean.User;

public interface UserDao {
	int save(User user) throws SQLException;//�����û���Ϣ
	int activeUser(String code) throws Exception;//�����û�

}
