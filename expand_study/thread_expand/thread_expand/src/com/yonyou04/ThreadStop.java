package com.yonyou04;

import java.util.Date;

public class ThreadStop extends Thread {
	@Override
	public void run() {
		System.out.println("��ʼִ�У�" + new Date());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// e.printStackTrace();
			System.out.println("�̱߳���ֹ��");
		}
		System.out.println("����ִ�У�" + new Date());
	}
}