package com.shiftpi.semaphore.parallelSystem;

public class ThreadD extends AbstractThread {
    private AbstractThread threads[] = new AbstractThread[3];

    public ThreadD(MultiSemaphore s, AbstractThread a, AbstractThread b, AbstractThread c) {
        super(s, "D");

        threads[0] = a;
        threads[1] = b;
        threads[2] = c;
    }

    @Override
    public void run() {
        s.p(this, 3);
        System.out.println(this.getName() + " passed p(3)");

        doJob(4, threads);

        System.out.println("Result of " + getName() + ": " + getResult());
    }
}
