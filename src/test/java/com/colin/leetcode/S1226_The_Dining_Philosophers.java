package com.colin.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;

public class S1226_The_Dining_Philosophers {

    public class DiningPhilosophers {
        private final Semaphore[] forks = new Semaphore[5];
        private final Semaphore limit = new Semaphore(4); // 限制最多4个哲学家同时尝试进餐

        public DiningPhilosophers() {
            for (int i = 0; i < 5; i++) {
                forks[i] = new Semaphore(1); // 每根叉子初始为可用
            }
        }

        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
            int left = philosopher;
            int right = (philosopher + 1) % 5;

            // 限制并发数量
            limit.acquire();

            // 确定先拿哪根叉子（避免死锁）
            int first = Math.min(left, right);
            int second = Math.max(left, right);

            forks[first].acquire();
            pickLeftFork.run(); // 实际上是拿编号小的叉子

            forks[second].acquire();
            pickRightFork.run();

            eat.run(); // 吃面

            putLeftFork.run();
            forks[left].release();

            putRightFork.run();
            forks[right].release();

            limit.release(); // 释放并发限制
        }
    }

    @Test
    public void test() {
        DiningPhilosophers diningPhilosophers = new DiningPhilosophers();

        // TODO?
    }
}