package com.yonyou05;

public class MyRunnableDemo {
	public static void main(String[] args) {
		MyRunnable my = new MyRunnable();
		Thread t1 = new Thread(my, "�߳�1");
		Thread t2 = new Thread(my, "�߳�2");

		t1.start();
		t2.start();
	}
}
