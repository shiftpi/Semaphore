package com.shiftpi.semaphore.parallelSystem;

public class ThreadC extends AbstractThread {
    public ThreadC(MultiSemaphore s) {
        super(s, "C");
    }

    @Override
    public void run() {
        doJob(3);
        s.v(this);
    }
}
