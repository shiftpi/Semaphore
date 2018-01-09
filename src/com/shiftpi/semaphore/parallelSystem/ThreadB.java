package com.shiftpi.semaphore.parallelSystem;

public class ThreadB extends AbstractThread {
    public ThreadB(MultiSemaphore s) {
        super(s, "B");
    }

    @Override
    public void run() {
        doJob(2);
        s.v(this);
    }
}
