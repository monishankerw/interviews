package com.interviews.interviews.interviews;

public class Interview {
    /*
    Thread
    Q. What is synchronized keyword where we can applicable.
        Synchronized Keyword
         -> Synchronized keyword is modifier

         -> It is applicable on method and block but not on class.

          -> If multiple threads are trying to operate simultaneously on the same java object
          then may be a chance of data inconsistency problem.
          -> To overcome the problem we should go for synchronized keyword.

          Advantages
          Thread Safety
          The synchronized keyword in Java is used to ensure thread safety by allowing only
          one thread at a time to execute a block of code or method.

          It’s essential when multiple threads access shared resources to prevent race conditions.

          Disadvantages
          Increasing waiting time of the thread and lower performances

           Why Use synchronized?
	•	Prevent data corruption.
	•	Avoid race conditions.
	•	Make classes thread-safe.
     */

    public  static class Counter {
        private int count = 0;

        public synchronized void increment() {
            count++;  // critical section
        }

        public int getCount() {
            return count;
        }
    }

    public  static class Main {
        public static void main(String[] args) throws InterruptedException {
            Counter counter = new Counter();

            // Create two threads that increment the counter 1000 times each
            Thread t1 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) counter.increment();
            });

            Thread t2 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) counter.increment();
            });

            t1.start();
            t2.start();

            t1.join();
            t2.join();

            System.out.println("Final Count: " + counter.getCount()); // Expected: 2000
        }
    }
}
