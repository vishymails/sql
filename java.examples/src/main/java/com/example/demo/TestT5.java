package com.example.demo;
public class TestT5 {
  public static void main(String args[]) {
    StringWriterT5 sw = new StringWriterT5();
    MyThreadT5 t1 = new MyThreadT5(sw, "Thread one");
    MyThreadT5 t2 = new MyThreadT5(sw, "Thread two");

    t1.start();
    t2.start();
  } 
}

class MyThreadT5 extends Thread {
  StringWriterT5 swr;
  String msg;

  public MyThreadT5(StringWriterT5 sw, String name) {
    swr = sw;
    msg = name;
  }

  public void run() {
    swr.writeString(msg);
  } 

}

class StringWriterT5 {
  public synchronized void writeString(String name) {
    System.out.println(name + " starting");
    try {
      Thread.sleep(500);
    } catch (InterruptedException ie) {}
    System.out.println(name + " ending");
  } 
}
