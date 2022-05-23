package com.daffahaidar;

// Sebagai contoh saya buat class Counter yang akan melakukan increment dan decrement
class Counter {
    // sebagai contoh data awal saya buat dengan nilai 0
    private int count = 0;

    // ini adalah method increment
    public void increment() {
        // jika method ini dipanggil pertama kali maka nilai count akan ditambah 1
        count += 1;
    }

    // ini adalah method decrement
    public void decrement() {
        // jika method ini dipanggil pertama kali maka nilai count akan dikurangi 1
        count -= 1;
    }

    // ini adalah method getCount untuk mengambil nilai count
    public int getCount() {
        return count;
    }
}

// class ini akan menjalankan thread secara Asyncronous
class Asynchronous implements Runnable {
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

class Main {
    public static void main(String[] args) {
        // jika ingin menjalankan thread secara Asyncronous uncomment code dibawah ini
        // System.out.println("Asynchronous thread: ");
        // runAsync();

        // jika ingin menjalankan thread secara Synchronous uncomment code dibawah ini
        // System.out.println("\nSynchronous thread: ");
        // runSync();

        // jika ingin menjalankan thread secara Asyncronous dan Synchronous uncomment
        // keduanya
    }

    public static void runAsync() {
        // buat object dari class Asynchronous
        Asynchronous asynchronous = new Asynchronous();
        // buat thread untuk menjalankan asynchronous
        Thread thread = new Thread(asynchronous);
        // jalankan thread asynchronous
        thread.start();
    }

    public static void runSync() {
        // buat object dari class Synchronous
        Synchronous synchronous = new Synchronous();
        // buat thread untuk menjalankan synchronous
        Thread thread = new Thread(synchronous);
        // jalankan thread synchronous
        thread.start();
    }
}
