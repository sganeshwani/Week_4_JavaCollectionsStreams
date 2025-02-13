package com.javastreams.problem8;

import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    public void run() {
        try {
            String message = "Hello from Writer Thread!";
            pos.write(message.getBytes()); // Write data
            pos.close(); // Close stream after writing
        } catch (IOException e) {
            System.out.println("Writer Error: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    public void run() {
        try {
            int data;
            while ((data = pis.read()) != -1) {
                System.out.print((char) data); // Read and print data
            }
            pis.close();
        } catch (IOException e) {
            System.out.println("Reader Error: " + e.getMessage());
        }
    }
}

public class PipedStream {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos); // Connect pipes

            Thread writer = new WriterThread(pos);
            Thread reader = new ReaderThread(pis);

            writer.start();
            reader.start();
        } catch (IOException e) {
            System.out.println("Pipe Error: " + e.getMessage());
        }
    }
}

