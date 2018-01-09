package com.shiftpi.semaphore.parallelSystem;

public class MultiSemaphore {
    private int s;

    public MultiSemaphore(int s) {
        this.s = s;
    }

    public synchronized void p(Thread t, int x) {
        System.out.println(t.getName() + " called p(" + x + "); s = " + s);

        while (s < x) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }

    public synchronized void v(Thread t) {
        s++;
        System.out.println(t.getName() + " called v(); s = " + s);

        notifyAll();
    }
}
