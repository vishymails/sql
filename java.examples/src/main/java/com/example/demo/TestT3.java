package com.example.demo;
public class TestT3 {
  public static void main(String args[]) {
    Thread t1 = new Thread() {
      public void run() {
        for (int i = 0; i < 10; ++i) {
          System.out.println(Thread.currentThread().getName() + " " 
                             + i);
          try {
            Thread.sleep(500);
          } catch (InterruptedException ie) {}
        } 
      } 
    };
    t1.setName("Thread one");
    t1.start();

    for (int i = 0; i < 10; ++i) {
      System.out.println("Main method " + i);
      try {
        Thread.sleep(500);
      } catch (InterruptedException ie) {}
    } 
  } 
}
