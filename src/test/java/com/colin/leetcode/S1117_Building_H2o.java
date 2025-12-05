package com.colin.leetcode;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;

public class S1117_Building_H2o {

    class H2O {
        private Semaphore h = new Semaphore(2);
        private Semaphore o = new Semaphore(0);

        public H2O() {
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            h.acquire(1);
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            o.release(1);
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            o.acquire(2);
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            h.release(2);
        }
    }

    @Test
    public void test() {

    }
}
