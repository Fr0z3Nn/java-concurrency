package ru.project.concurrency.introduction;

public class TwoWaysToCreate {
    public static void main(String[] args) {
        new Thread(new Runner1()).start();
        new Runner2().start();
    }
}

class Runner1 implements Runnable{
    public void run() {
        for(int i=0;i<10;++i){
            System.out.println("Runner1: " + i);
        }
    }
}

class Runner2 extends Thread{
    public void run() {
        for(int i=0;i<10;++i){
            System.out.println("Runner2: " + i);
        }
    }
}
