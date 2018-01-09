package com.shiftpi.semaphore.parallelSystem;

public class ThreadA extends AbstractThread {
    public ThreadA(MultiSemaphore s) {
        super(s, "A");
    }

    @Override
    public void run() {
        doJob(1);
        s.v(this);
    }
}
