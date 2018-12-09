package com.yonyou08;

public class SellTicket implements Runnable {

	// 定义100张票
		private int tickets = 100;
//      同票卖了多次
//		@Override
//		public void run() {
//			while (true) {
//				// t1,t2,t3三个线程
//				// tickets = 100;
//				if (tickets > 0) {
//					try {
//						Thread.sleep(100); // t1就稍作休息,t2就稍作休息
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					System.out.println(Thread.currentThread().getName() + "正在出售第"
//							+ (tickets--) + "张票");
//					// 理想状态：
//					// 窗口1正在出售第100张票
//					// 窗口2正在出售第99张票
//					// 实际状态：
//					// CPU的每一次执行必须是一个原子性(最简单基本的)的操作。
//					// 先记录以前的值 100
//					// 接着把ticket--  100--还没有变成99
//					// 然后输出以前的值(t2来了)
//					// ticket的值就变成了99
//					// 窗口1正在出售第100张票
//					// 窗口2正在出售第100张票
//				}
//			}
//		}
		//出现了负票
		@Override
		public void run() {
			while (true) {
				// t1,t2,t3三个线程
				// tickets = 1;
				if (tickets > 0) {
					try {
						Thread.sleep(100); //t1进来了并休息，t2进来了并休息，t3进来了并休息，
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println(Thread.currentThread().getName() + "正在出售第"
							+ (tickets--) + "张票");
					//窗口1正在出售第1张票,tickets=0
					//窗口2正在出售第0张票,tickets=-1
					//窗口3正在出售第-1张票,tickets=-2
				}
			}
		}

}
