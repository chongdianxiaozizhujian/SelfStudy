package com.yonyou02;

public class MyThreadDemo {
	public static void main(String[] args) {
		MyThread my1 = new MyThread("线程1");
		MyThread my2 = new MyThread("线程2");
		//my1.setName("线程1");
		//my2.setName("线程2");
		my1.start();
		my2.start();
		System.out.println(Thread.currentThread().getName());
	}
}
