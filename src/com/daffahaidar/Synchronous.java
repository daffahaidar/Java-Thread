package com.daffahaidar;

// class ini akan menjalankan thread secara Synchronous
class Synchronous implements Runnable {

    public void run() {
        // buat object dari class Counter
        Counter counter = new Counter();

        // bedanya synchronous akan menjalankan thread secara berurutan (single thread)

        // misalkan saya akan membuat thread 1 untuk increment
        // maka thread 1 akan dijalankan pertama kali
        for (int i = 0; i < 5; i++) {
            counter.increment();
            System.out.println("Synchronous 1: " + counter.getCount());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // setelah thread 1 selesai dijalankan
        // thread 2 akan dijalankan setelah selesai dijalankannya thread 1
        for (int i = 0; i < 5; i++) {
            counter.decrement();
            System.out.println("Synchronous 2: " + counter.getCount());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
