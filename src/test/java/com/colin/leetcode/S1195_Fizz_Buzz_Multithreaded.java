package com.colin.leetcode;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class S1195_Fizz_Buzz_Multithreaded {

    class FizzBuzz {
        private Semaphore fizz = new Semaphore(0);
        private Semaphore buzz = new Semaphore(0);
        private Semaphore fizzbuzz = new Semaphore(0);
        private Semaphore number = new Semaphore(1);

        private int n;
        private volatile int idx = 1;

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            while (true) {
                fizz.acquire();
                if (idx > n) {
                    break;
                }
                idx++;
                printFizz.run();
                number.release();
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            while (true) {
                buzz.acquire();
                if (idx > n) {
                    break;
                }
                idx++;
                printBuzz.run();
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (true) {
                fizzbuzz.acquire();
                if (idx > n) {
                    break;
                }
                idx++;
                printFizzBuzz.run();
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            while (true) {
                number.acquire();
                if (idx > n) {
                    break;
                }
                if (idx % 3 == 0 && idx % 5 == 0) {
                    fizzbuzz.release();
                } else if (idx % 5 == 0) {
                    buzz.release();
                } else if (idx % 3 == 0) {
                    fizz.release();
                } else {
                    printNumber.accept(idx);
                    idx++;
                }

                number.release();
            }

            fizz.release();
            buzz.release();
            fizzbuzz.release();
        }
    }

    @Test
    public void test() {

    }
}

