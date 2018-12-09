package com.yonyou05;

public class GetThread implements Runnable {

	private Student s;

	public GetThread(Student s) {
		this.s = s;
	}

	@Override
	public void run() {
		while(true) {
			synchronized (s) {
				if(!s.flag){
					try {
						s.wait(); //t2就等待了。立即释放锁。将来醒过来的时候，是从这里醒过来的时候
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println(s.name + "---" + s.age);
				//充电---27
				//小子---30
				
				//修改标记
				s.flag = false;
				//唤醒线程
				s.notify(); //唤醒t1
			}
		}
	}

}
