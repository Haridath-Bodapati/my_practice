package com.test.wissen;

public class Lock {
	
	public static void main(String[] args) {
		String resource1 = "Resource1";
		Runnable t1 = () -> System.out.println("This is thread1");
		Thread t = new Thread(t1);
		
		Thread t2 = new Thread(() -> System.out.println("This is thread2"));
		
		t.start();
		t2.start();
		
		synchronized(resource1) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
