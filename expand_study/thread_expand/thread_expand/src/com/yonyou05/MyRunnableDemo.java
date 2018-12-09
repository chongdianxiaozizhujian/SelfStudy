package com.yonyou05;

public class MyRunnableDemo {
	public static void main(String[] args) {
		MyRunnable my = new MyRunnable();
		Thread t1 = new Thread(my, "线程1");
		Thread t2 = new Thread(my, "线程2");

		t1.start();
		t2.start();
	}
}
