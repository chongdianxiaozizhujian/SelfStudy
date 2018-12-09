package com.yonyou04;

public class ThreadStopDemo {
	public static void main(String[] args) {
		ThreadStop ts = new ThreadStop();
		ts.start();
		try {
			Thread.sleep(3000);
			// ts.stop();
			ts.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
