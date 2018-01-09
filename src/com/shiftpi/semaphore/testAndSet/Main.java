package com.shiftpi.semaphore.testAndSet;

public class Main {
    public static boolean x = false;

    public static void criticalRegion() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    public synchronized static boolean testAndSet() {
        boolean returnValue = Main.x;
        Main.x = true;
        return returnValue;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            ExampleThread t = new ExampleThread("t" + i);
            t.start();
        }
    }
}
