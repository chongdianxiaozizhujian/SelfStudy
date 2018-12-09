package com.yonyou.liaotian.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.yonyou.liaotian.utils.JDBCUtils;

/**
 * Dao����
 * ��ɾ�Ĳ�
 * @author Administrator
 *
 */
public class BaseDao<T> {
	
	private QueryRunner runner = new QueryRunner();
	
	private Class<T> beanType = null;
	
	public BaseDao() {
		Class clazz = this.getClass();
		
		Class superclass = clazz.getSuperclass();
		
		Type type = clazz.getGenericSuperclass();
		
		if(type instanceof ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) type;
			Type[] typeArguments = pt.getActualTypeArguments();
			Type realType = typeArguments[0];
			if(realType instanceof Class) {
				beanType = (Class<T>) realType;
			}
		}
		
	}
	
	public Integer insertWithId(String sql, Object ... param) {
		Integer id = null;
		
		//1.��ȡ���ݿ�����
		Connection connection = JDBCUtils.getConnection();
		
		//2.��ȡPreparedStatement����
		PreparedStatement ps = null;
		
		//3.��ȡResultSet�����������淵�ص�����ID��ֵ
		ResultSet rs = null;
		
		try {
			//�ڻ�ȡPreparedStatement����ʱ��ͨ����������һ�������ķ�ʽ��PreparedStatement����
			//����Ϊ��������������ģʽ
			ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < param.length; i++) {
				ps.setObject(i+1, param[i]);
			}
			ps.execute();
			
			//�������������Խ������ʽ���ص�
			rs = ps.getGeneratedKeys();
			
			if(rs.next()) {
				id = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			//4.�ͷ���Դ
			JDBCUtils.releaseConnection(connection);
			
			try {
				DbUtils.close(ps);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				DbUtils.close(rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return id;
	}
	
	/**
	 * ִ���������²���
	 * @param sql
	 * @param params ִ����������ʱ��SQL���Ĳ������Ƕ�ά��������
	 * �ڷ��������������£�SQL���Ĳ�����һά���飬��ӦSQL����һ��ִ��
	 * ���������������£�SQL���Ĳ����Ƕ�ά���飬��ӦSQL���Ķ��ִ��
	 * 		����ÿһ��һά�����һ��SQL����Ƕ�Ӧ��
	 * 		�ڶ�ά�����ÿһ��Ԫ�طֱ��ӦSQL����е�һ������
	 */
	public void batchUpdate(String sql, Object [] ... params ) {
		Connection connection = JDBCUtils.getConnection();
		try {
			runner.batch(connection, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtils.releaseConnection(connection);
	}
	
	/**
	 * ��ȡ��һֵ�ķ����������ķ��Ͳ����Ǹ��ݽ��շ���ֵ�ı��������ʹ����
	 * ���ִ�е���COUNT()������Ҫע�������ص���Long��װ����
	 * @param sql
	 * @param params
	 * @return
	 */
	public <E> E getSingleValue(String sql, Object ... params) {
		E e = null;
		
		Connection connection = JDBCUtils.getConnection();
		try {
			e = (E) runner.query(connection, sql, new ScalarHandler(), params);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		JDBCUtils.releaseConnection(connection);
		
		return e;
	}
	
	/**
	 * ��ѯ���ݿⷵ��ʵ�������ļ���
	 * @param sql
	 * @param params
	 * @returnʵ�������ļ���
	 */
	public List<T> getBeanList(String sql, Object ... params) {
		
		Connection connection = JDBCUtils.getConnection();
		
		List<T> list = null;
		
		try {
			list = runner.query(connection, sql, new BeanListHandler<>(beanType), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JDBCUtils.releaseConnection(connection);
		
		return list;
		
	}
	
	/**
	 * ���ص�һ����Ĳ�ѯ����
	 * @param sql
	 * @param params
	 * @return �����ݿ��ѯ�����װ�õ��Ķ���
	 */
	public T getBean(String sql, Object ... params) {
		T t = null;
		
		Connection connection = JDBCUtils.getConnection();
		try {
			t = runner.query(connection, sql, new BeanHandler<>(beanType), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtils.releaseConnection(connection);
		
		return t;
	}
	
	/**
	 * ִ����ɾ�ĵ�ͨ�÷���
	 * @param sql
	 * @param params
	 */
	public void update(String sql, Object ... params) {
		
		Connection connection = JDBCUtils.getConnection();
		try {
			runner.update(connection, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtils.releaseConnection(connection);
		
	}

}
