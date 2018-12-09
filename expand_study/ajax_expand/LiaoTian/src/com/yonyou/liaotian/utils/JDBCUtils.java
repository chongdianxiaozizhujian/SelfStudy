package com.yonyou.liaotian.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	
	//数据源是一个非常消耗内存的对象，如果每一次获取数据库连接都创建一个新的，会很快耗尽内存
	//所以声明为static，保证其在项目运行时只有一个实例
	private static DataSource dataSource = new ComboPooledDataSource("webDataSource");
	
	/**
	 * 从数据库连接池中获取数据库连接
	 * @return
	 */
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	/**
	 * 释放数据库连接
	 * @param connection
	 */
	public static void releaseConnection(Connection connection) {
		
		//判断是否为空，避免空指针异常
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
