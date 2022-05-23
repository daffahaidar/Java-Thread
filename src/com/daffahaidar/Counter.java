package com.daffahaidar;

// Sebagai contoh saya buat class Counter yang akan melakukan increment dan decrement
public class Counter {
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