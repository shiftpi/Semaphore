package com.shiftpi.semaphore.semaphore;

import java.util.LinkedList;

public class Semaphore {
    private static int s;
    private LinkedList<Thread> queue = new LinkedList<>();

    public Semaphore(int s) {
        Semaphore.s = s;
        System.out.println("s = " + Semaphore.s);
    }

    @SuppressWarnings("deprecation")
    public void p(Thread t) {
        System.out.println(t.getName() + " called p(); s = " + s);

        if (s >= 1) {
            s--;
        } else {
            queue.add(t);
            t.suspend();
        }
    }

    @SuppressWarnings("deprecation")
    public void v(Thread t) {
        System.out.println(t.getName() + " called v(); s = " + s);

        s++;

        if (queue.size() > 0) {
            Thread next = queue.getFirst();
            queue.removeFirst();
            next.resume();
        }
    }
}
