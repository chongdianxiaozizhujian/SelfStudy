package com.yonyou04;

public class ThreadSleepDemo {
	public static void main(String[] args) {
		ThreadSleep ts1 = new ThreadSleep();
		ThreadSleep ts2 = new ThreadSleep();
		ThreadSleep ts3 = new ThreadSleep();

		ts1.setName("�߳�1");
		ts2.setName("�߳�2");
		ts3.setName("�߳�3");

		ts1.start();
		ts2.start();
		ts3.start();
	}
}
