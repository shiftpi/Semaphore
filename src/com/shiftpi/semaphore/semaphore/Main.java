package com.shiftpi.semaphore.semaphore;

public class Main {
    public static void criticalRegion() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) {
        Semaphore s = new Semaphore(1);

        for (int i = 0; i < 5; i++) {
            ExampleThread t = new ExampleThread("t" + i, s);
            t.start();
        }
    }
}
