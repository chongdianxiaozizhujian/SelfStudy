package com.yonyou.liaotian.dao;

import java.util.List;

import com.yonyou.liaotian.bean.Message;

public class MessageDao extends BaseDao<Message>{
	
	//�������¼��Ϣ���浽���ݿ���
	public void saveMessage(Message message) {
		String sql = "INSERT INTO MESSAGE (MESSAGE_CONTENT,MESSAGE_TIME) VALUES(?,?)";
		this.update(sql, message.getMessage(), message.getMessageTime());
	}
	
	//�������������ı���������ϢID��ѯ�ȱ�����Ϣ��Ҫ�µ������¼
	public List<Message> getNewMessage(String finalMessageId) {
		String sql = "SELECT `MESSAGE_ID` messageId,`MESSAGE_CONTENT` message,`MESSAGE_TIME` messageTime FROM `message` WHERE MESSAGE_ID>? ORDER BY MESSAGE_ID";
		return this.getBeanList(sql, finalMessageId);
	}
	
	//�������������ı���������ϢID��ѯ�Ƿ�����µ������¼
	public boolean hasNew(String finalMessageId) {
		String sql = "SELECT COUNT(*) FROM `message` WHERE `MESSAGE_ID`>?";
		long count = this.getSingleValue(sql, finalMessageId);
		return count > 0;
	}

}
