package ru.project.concurrency.introduction;

import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl;

public class TwoWaysToCreate {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runner1());
        t1.start();
        Thread t2 = new Runner2();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Finish all threads....");
    }
}

class Runner1 implements Runnable{
    public void run() {
        for(int i=0;i<5;++i){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Runner1: " + i);
        }
    }
}

class Runner2 extends Thread{
    public void run() {
        for(int i=0;i<5;++i){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Runner2: " + i);
        }
    }
}
