package com.daffahaidar;

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
