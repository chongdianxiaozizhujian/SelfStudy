package com.yonyou09;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallableDemo {
	public static void main(String[] args) {
		// �����̳߳ض���
		ExecutorService pool = Executors.newFixedThreadPool(2);

		// ����ִ��Runnable�������Callable���������߳�
		pool.submit(new MyCallable());
		pool.submit(new MyCallable());

		// ����
		pool.shutdown();
	}
}
