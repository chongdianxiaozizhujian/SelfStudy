package com.yonyou04;

public class ThreadJoinDemo {
	public static void main(String[] args) {
		ThreadJoin tj1 = new ThreadJoin();
		ThreadJoin tj2 = new ThreadJoin();
		ThreadJoin tj3 = new ThreadJoin();

		tj1.setName("�߳�1");
		tj2.setName("�߳�2");
		tj3.setName("�߳�3");

		tj1.start();
		try {
			tj1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		tj2.start();
		tj3.start();
	}
}
