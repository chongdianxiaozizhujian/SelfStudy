package com.yonyou01;

public class MyThread extends Thread {
	
	public void run() {
		for (int x = 0; x < 200; x++) {
			System.out.println(x);
		}
	}
}
