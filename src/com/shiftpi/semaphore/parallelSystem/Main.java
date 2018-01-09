package com.shiftpi.semaphore.parallelSystem;

public class Main {
    public static void main(String[] args) {
        MultiSemaphore s = new MultiSemaphore(0);

        AbstractThread a = new ThreadA(s);
        AbstractThread b = new ThreadB(s);
        AbstractThread c = new ThreadC(s);
        AbstractThread d = new ThreadD(s, a, b, c);

        a.start();
        b.start();
        c.start();
        d.start();
    }
}
