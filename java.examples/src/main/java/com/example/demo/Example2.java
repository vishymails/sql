package com.example.demo;

public class Example2 {
	public static void main(String[] s) {
		
		Thread t1 = new Thread(new MyThreadT2(5, 500));
		Thread t2 = new Thread(new MyThreadT2(10, 500));
		Thread t3 = new Thread(new MyThreadT2(10, 500));
		
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



class MyThreadT2 implements Runnable {
	int maxCount, sleepTime;

	public MyThreadT2(int maxCount, int sleepTime) {
		super();
		this.maxCount = maxCount;
		this.sleepTime = sleepTime;
		
	}
	
	public void run() {
		for(int i = 0; i< maxCount; ++i) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			try {
				Thread.sleep(sleepTime);
			}catch(InterruptedException e) {
				
			}
		}
	}	
}
