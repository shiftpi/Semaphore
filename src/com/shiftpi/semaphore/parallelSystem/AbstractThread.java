package com.shiftpi.semaphore.parallelSystem;

import java.util.Random;

public abstract class AbstractThread extends Thread {
    protected int result;
    protected MultiSemaphore s;

    public AbstractThread(MultiSemaphore s, String name) {
        this.s = s;
        this.setName(name);
    }

    public int getResult() {
        return result;
    }

    protected void doJob(int result, int x) {
        this.result = result + x;

        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
        }
    }

    protected void doJob(int result, AbstractThread[] threads) {
        int sum = 0;
        for (AbstractThread t : threads) {
            sum += t.getResult();
        }

        doJob(result, sum);
    }

    protected void doJob(int result) {
        doJob(result, 0);
    }
}
