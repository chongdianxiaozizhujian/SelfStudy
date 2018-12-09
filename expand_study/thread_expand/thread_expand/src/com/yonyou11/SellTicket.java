package com.yonyou11;

public class SellTicket implements Runnable {
	// 定义100张票
	private static int tickets = 100;
	// 定义同一把锁
	/*private Object obj = new Object();
	 * 
	//同步代码块用obj做锁
	@Override
	public void run() {
		while (true) {
			synchronized (obj) {
				if (tickets > 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票 ");
				}
			}
		}
	}*/
	
	//定义一把锁
	/*private Demo demo = new Demo();
	//同步代码块用任意对象做锁
	@Override
	public void run() {
		while (true) {
			synchronized (demo) {
				if (tickets > 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票 ");
				}
			}
		}
	}*/
	
	/*private int x = 0;
	private Demo demo = new Demo();
	@Override
	public void run() {
		while (true) {
			if(x%2==0){
				synchronized (demo) {
					if (tickets > 0) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()
								+ "正在出售第" + (tickets--) + "张票 ");
					}
				}
			}else {
				synchronized (demo) {
					if (tickets > 0) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()
								+ "正在出售第" + (tickets--) + "张票 ");
					}
				}
				
			}
			x++;
		}
	}*/
	/*private int x = 0;
	private Demo demo = new Demo();
	@Override
	public void run() {
		while (true) {
			if(x%2==0){
				synchronized (demo) {
					if (tickets > 0) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()
								+ "正在出售第" + (tickets--) + "张票 ");
					}
				}
			}else {
				sellTicket();
			}
			x++;
		}
	}
	
	private void sellTicket() {
		synchronized (demo) {
			if (tickets > 0) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()
						+ "正在出售第" + (tickets--) + "张票 ");
			}
		}
	}*/
	/*private int x = 0;
	//private Demo demo = new Demo();
	@Override
	public void run() {
		while (true) {
			if(x%2==0){
				synchronized (this) {
					if (tickets > 0) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()
								+ "正在出售第" + (tickets--) + "张票 ");
					}
				}
			}else {
				sellTicket();
			}
			x++;
		}
	}
	
	private synchronized void sellTicket() {
		if (tickets > 0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票 ");
		}
	}*/
	private int x = 0;
	//private Demo demo = new Demo();
	@Override
	public void run() {
		while (true) {
			if(x%2==0){
				synchronized (SellTicket.class) {
					if (tickets > 0) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()
								+ "正在出售第" + (tickets--) + "张票 ");
					}
				}
			}else {
				sellTicket();
			}
			x++;
		}
	}
	
	private static synchronized void sellTicket() {
		if (tickets > 0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票 ");
		}
	}
}
class Demo {
}