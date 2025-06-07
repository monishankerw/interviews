package com.interviews.interviews.interviews;

public class Interview {
    /*
    Thread

✅ Synchronized Keyword in Java – Interview Notes

🔹 Definition
	•	synchronized is a keyword (modifier) used in Java to control access to critical sections by multiple threads.

⸻

🔹 Where It Can Be Applied
	•	✅ On methods (both instance and static methods)
	•	✅ On code blocks inside methods (synchronized (object) {})
	•	❌ Cannot be applied on a class directly

⸻

🔹 Purpose
	•	To prevent data inconsistency when multiple threads access shared resources simultaneously.
	•	Ensures that only one thread at a time can execute the synchronized code.

⸻

🔹 Advantages
	1.	✅ Ensures thread safety
	2.	✅ Prevents race conditions
	3.	✅ Helps avoid data corruption
	4.	✅ Makes code thread-safe

⸻

🔹 Disadvantages
	1.	❌ Can lead to increased waiting time for threads
	2.	❌ Can cause performance degradation (blocking reduces concurrency)
	3.	❌ Risk of deadlock if not used carefully

⸻

🔹 Types of Synchronization
	1.	Synchronized Instance Method

public synchronized void method() { ... }

	•	Locks on the current object (this)

	2.	Synchronized Static Method

public static synchronized void method() { ... }

	•	Locks on the class object, not instance

	3.	Synchronized Block

synchronized (lockObject) {
    // critical section
}

	•	Gives finer control over synchronization

⸻

🔹 Why Use synchronized?
	•	✅ To prevent data inconsistency
	•	✅ To avoid race conditions
	•	✅ To ensure atomicity of operations
	•	✅ To make your code safe in a multithreaded environment

⸻

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
    /*
       Thread Synchronization
 When two thread are operation on a common data non-synchronous manner,
  data will get corrupted.

   Synchronization Area:
   1. This area can be accessed by only one thread at a
    time having synchronized method and blocks.
    2. When ever we are performing updating operation
    (add,delete,remove/replace)
    i.s state of object is changing

    Non-Synchronization area
    1.This are can be accessed any number of thread having non-synchronized method and blocks.
    2. When even we are performing read operation state of object is changing

Q. When a thread need class level look?
        If a thread wants to execute Static synchronized method it required class level lock.
Q. Synchronization
        If a method is made synchronized then a thread which acquired the object lock can only execute
        the method.

        Every object will have only one lock which ever thread acquired a locked will execute synchronized
        method which the other thread has a wait for the lock to be released.

        Thread will released the lock only after complete execution by doing this we are sure that once a particular thread execute completely only then the next thread
        can start and this will avoid data corruption of common data.


     */

    /*
    Volatile Keyword
    1. Volatile keyword not utilize cach memory.
    2. Volatile keyword is used to modify one value of a variable by different thread.
    3. It is also used to make class thread safe.
    4. The Volatility keyword can be used either with primitive type or object.
    5. Volatile indicates that a field may be accessed by multiple java threads.
     */
}
