package com.yonyou04;

public class ThreadYieldDemo {
	public static void main(String[] args) {
		ThreadYield ty1 = new ThreadYield();
		ThreadYield ty2 = new ThreadYield();

		ty1.setName("线程1");
		ty2.setName("线程2");

		ty1.start();
		ty2.start();
	}
}
