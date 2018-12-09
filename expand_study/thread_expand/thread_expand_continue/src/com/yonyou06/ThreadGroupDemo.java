package com.yonyou06;

public class ThreadGroupDemo {
	public static void main(String[] args) {
		// method1();
		method2();
	}

	private static void method2() {
		// ThreadGroup(String name)
		ThreadGroup tg = new ThreadGroup("�µ��߳���");

		MyRunnable my = new MyRunnable();
		// Thread(ThreadGroup group, Runnable target, String name)
		Thread t1 = new Thread(tg, my, "���");
		Thread t2 = new Thread(tg, my, "С��");

		System.out.println(t1.getThreadGroup().getName());
		System.out.println(t2.getThreadGroup().getName());

		// ����Ϊ��̨�߳�
		tg.setDaemon(true);
	}

	private static void method1() {
		MyRunnable my = new MyRunnable();
		Thread t1 = new Thread(my, "���");
		Thread t2 = new Thread(my, "С��");
		// �߳�������ķ�����public final ThreadGroup getThreadGroup()
		ThreadGroup tg1 = t1.getThreadGroup();
		ThreadGroup tg2 = t2.getThreadGroup();
		// �߳�������ķ�����public final String getName()
		String name1 = tg1.getName();
		String name2 = tg2.getName();
		System.out.println(name1);
		System.out.println(name2);
		// �߳�Ĭ�����������main�߳���
		// Ĭ������£����е��̶߳�����ͬһ����
		System.out.println(Thread.currentThread().getThreadGroup().getName());
	}
}