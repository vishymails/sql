package com.example.demo;

class MyDaemon implements Runnable {
  Thread thrd;
  MyDaemon() {
    thrd = new Thread(this);
    thrd.setDaemon(true);
    thrd.start();
  }
  public boolean isDaemon(){
    return thrd.isDaemon();
  }
  public void run() {
    try {
      while(true) {
        System.out.print(".");
        Thread.sleep(100);
      }
    }
    catch(Exception exc) {
      System.out.println("MyDaemon interrupted.");
    }
  }
}

public class DaemonThreadExample {
  public static void main(String args[]) throws Exception{
    MyDaemon dt = new MyDaemon();
    if(dt.isDaemon())
      System.out.println("dt is a daemon thread.");

    Thread.sleep(10000);
    System.out.println("\nMain thread ending.");
  }
}
