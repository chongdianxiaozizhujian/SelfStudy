package com.yonyou02;

public class MyThreadDemo {
	public static void main(String[] args) {
		MyThread my1 = new MyThread("�߳�1");
		MyThread my2 = new MyThread("�߳�2");
		//my1.setName("�߳�1");
		//my2.setName("�߳�2");
		my1.start();
		my2.start();
		System.out.println(Thread.currentThread().getName());
	}
}
