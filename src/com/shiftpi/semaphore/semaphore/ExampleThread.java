package com.shiftpi.semaphore.semaphore;

public class ExampleThread extends Thread {
    private Semaphore s;

    public ExampleThread(String name, Semaphore s) {
        this.setName(name);
        this.s = s;
    }

    @Override
    public synchronized void start() {
        super.start();
        System.out.println(this.getName() + " started");
    }

    @Override
    public void run() {
        s.p(this);
        System.out.println(this.getName() + " entered critical region");
        Main.criticalRegion();

        s.v(this);
        System.out.println(this.getName() + " left critical region");
    }
}
