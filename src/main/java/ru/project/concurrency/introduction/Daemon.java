package ru.project.concurrency.introduction;

public class Daemon {
    public static void main(String[] args) {
        String name = Thread.currentThread().getName();
        System.out.println(name);
        Thread t1 = new Thread(new WorkerDaemon());
        t1.setDaemon(true);
        t1.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t1.isDaemon());
    }
}
class WorkerDaemon implements Runnable{
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("daemon running...");
        }
    }
}