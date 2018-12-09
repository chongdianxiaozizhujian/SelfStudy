package com.yonyou03;

public class SetThread implements Runnable {

	private Student s;

	public SetThread(Student s) {
		this.s = s;
	}

	@Override
	public void run() {
		s.name = "³äµçĞ¡×Ó";
		s.age = 25;
	}
}
