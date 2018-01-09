package com.shiftpi.semaphore.testAndSet;

public class ExampleThread extends Thread {
    public ExampleThread(String name) {
        this.setName(name);
    }

    @Override
    public synchronized void start() {
        super.start();
        System.out.println(this.getName() + " started");
    }

    @Override
    public void run() {
        while (Main.testAndSet()) {
            System.out.println(this.getName() + " is watiting");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
            }
        }

        System.out.println(this.getName() + " entered critical region");
        Main.criticalRegion();
        Main.x = false;
        System.out.println(this.getName() + " left critical region");
    }
}
