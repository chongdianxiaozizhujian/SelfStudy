package com.yonyou11;

public class ThreadDemo {
	public static void main(String[] args) {
		/*
		 * new Thread() { public void run() { for (int x = 0; x < 100; x++) {
		 * System.out.println(Thread.currentThread().getName() + ":" + x); } }
		 * }.start();
		 */

		/*new Thread(new Runnable() {

			@Override
			public void run() {
				for (int x = 0; x < 100; x++) {
					System.out.println(Thread.currentThread().getName() + ":" + x);
				}
			}
		}) {

		}.start();*/
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int x = 0; x < 100; x++) {
					System.out.println("充电:" + x);
				}
			}
		}) {
			//会执行下面的代码
			public void run() {
				for (int x = 0; x < 100; x++) {
					System.out.println("小子:" + x);
				}
			}
		}.start();
	}
}
