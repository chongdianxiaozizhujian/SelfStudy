package com.yonyou07;

public class StudentDemo {
	public static void main(String[] args) {
		// ������Դ
		Student s = new Student();

		// ���úͻ�ȡ����
		SetThread st = new SetThread(s);
		GetThread gt = new GetThread(s);

		// �߳���
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(gt);

		// �����߳�
		t1.start();
		t2.start();
	}
}