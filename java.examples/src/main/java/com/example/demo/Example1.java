package com.example.demo;


public class Example1 {
	public static void main(String[] s) {
		
		MyThreadT t1 = new MyThreadT(5, 500, "ThreadOne");
		MyThreadT t2 = new MyThreadT(10, 500, "ThreadTwo");
		MyThreadT t3 = new MyThreadT(10, 500, "ThreadThree");
		
		t2.setPriority(7);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t3.start();
		}catch(InterruptedException e) {
			
		}	
	}
	
}


class MyThreadT extends Thread {
	int maxCount, sleepTime;

	public MyThreadT(int maxCount, int sleepTime, String name) {
		super();
		this.maxCount = maxCount;
		this.sleepTime = sleepTime;
		setName(name);
	}
	
	public void run() {
		for(int i = 0; i< maxCount; ++i) {
			System.out.println(getName() + " " + i);
			try {
				Thread.sleep(sleepTime);
			}catch(InterruptedException e) {
				
			}
		}
	}	
}
