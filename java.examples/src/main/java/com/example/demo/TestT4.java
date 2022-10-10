package com.example.demo;
public class TestT4 {
  public static void main(String args[]) {
    StringWriter sw = new StringWriter();
    MyThreadT3 t1 = new MyThreadT3(sw, "Thread one");
    MyThreadT3 t2 = new MyThreadT3(sw, "Thread two");

    t1.start();
    t2.start();
  } 
}

class MyThreadT3 extends Thread {
  StringWriter swr;
  String msg;

  public MyThreadT3(StringWriter sw, String name) {
    swr = sw;
    msg = name;
  }

  public void run() {
    synchronized (swr) {
      swr.writeString(msg);
    } 
  } 
}

class StringWriter {
  public void writeString(String name) {
    System.out.println(name + " starting");
    try {
      Thread.sleep(500);
    } catch (InterruptedException ie) {}
    System.out.println(name + " ending");
  } 
}
