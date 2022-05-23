package com.daffahaidar;

// class ini akan menjalankan thread secara Asyncronous
public class Asynchronous implements Runnable {
    public void run() {
        // buat object dari class Counter
        Counter counter = new Counter();

        /*
         * buat thread untuk increment (disini saya menggunakan lambda expression,
         * mirip seperti arrow function kalau di javascript)
         */

        // misalkan thread 1 akan melakukan increment
        Thread thread1 = new Thread(() -> {

            for (int i = 0; i < 5; i++) {
                // jalankan method increment
                counter.increment();
                // tampilkan nilai count
                System.out.println("Asynchronous 1: " + counter.getCount());

                // jeda selama 1 detik untuk melihat pergerakannya
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // misalkan thread 2 akan melakukan decrement
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                counter.decrement();
                System.out.println("Asynchronous 2: " + counter.getCount());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        /*
         * Asynchronous akan menjalankan kedua thread tersebut apabila thread 1
         * memerlukan
         * waktu lebih lama dari thread 2, maka thread 1 akan menunggu dan thread 2
         * akan dijalankan terlebih dahulu hingga selesai dan kemudian thread 1 akan
         * dijalankan
         */
        thread1.start();
        thread2.start();
    }
}