package com.yonyou11;

public class SellTicket implements Runnable {
	// ����100��Ʊ
	private static int tickets = 100;
	// ����ͬһ����
	/*private Object obj = new Object();
	 * 
	//ͬ���������obj����
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
					System.out.println(Thread.currentThread().getName() + "���ڳ��۵�" + (tickets--) + "��Ʊ ");
				}
			}
		}
	}*/
	
	//����һ����
	/*private Demo demo = new Demo();
	//ͬ��������������������
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
					System.out.println(Thread.currentThread().getName() + "���ڳ��۵�" + (tickets--) + "��Ʊ ");
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
								+ "���ڳ��۵�" + (tickets--) + "��Ʊ ");
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
								+ "���ڳ��۵�" + (tickets--) + "��Ʊ ");
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
								+ "���ڳ��۵�" + (tickets--) + "��Ʊ ");
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
						+ "���ڳ��۵�" + (tickets--) + "��Ʊ ");
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
								+ "���ڳ��۵�" + (tickets--) + "��Ʊ ");
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
			System.out.println(Thread.currentThread().getName() + "���ڳ��۵�" + (tickets--) + "��Ʊ ");
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
								+ "���ڳ��۵�" + (tickets--) + "��Ʊ ");
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
			System.out.println(Thread.currentThread().getName() + "���ڳ��۵�" + (tickets--) + "��Ʊ ");
		}
	}
}
class Demo {
}