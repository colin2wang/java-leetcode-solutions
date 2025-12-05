package com.colin.leetcode;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

public class S1114_Print_In_Order {

    class Foo {
        private CountDownLatch second = new CountDownLatch(1);
        private CountDownLatch third = new CountDownLatch(1);
        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            second.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            second.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            third.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            third.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    @Test
    public void test() {
    }
}

