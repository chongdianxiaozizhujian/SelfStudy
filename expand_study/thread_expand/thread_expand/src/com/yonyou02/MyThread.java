package com.yonyou02;

public class MyThread extends Thread {
	
	public MyThread() {
		
	}
	
	public MyThread(String name) {
		super(name);
	}
	
	public void run() {
		for (int x = 0; x < 200; x++) {
			System.out.println(getName() + ":" + x);
		}
	}
}