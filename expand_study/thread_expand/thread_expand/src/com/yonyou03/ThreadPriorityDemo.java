package com.yonyou03;

public class ThreadPriorityDemo {
	public static void main(String[] args) {
		ThreadPriority tp1 = new ThreadPriority();
		ThreadPriority tp2 = new ThreadPriority();
		ThreadPriority tp3 = new ThreadPriority();
		tp1.setName("线程1");
		tp2.setName("线程2");
		tp3.setName("线程3");
		tp1.setPriority(10);
		tp3.setPriority(1);
		System.out.println(tp1.getPriority());
		System.out.println(tp2.getPriority());
		System.out.println(tp3.getPriority());
	}
}
