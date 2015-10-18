package com.company;

import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class Main
{
    public static final int PORT = 7789;

    public static void main(String[] args) {
        Socket connection;
        Semaphore sem = new Semaphore(1);

        try {
            ServerSocket server = new ServerSocket(PORT);

            while (true) {
                connection = server.accept();
                //sem.acquire();
                Thread worker = new Thread(new ConnectionWorker(connection));
                worker.start();
                System.out.println("connection opened, worker started");
            }
        }
        //	catch (InterruptedException ie) { }
        catch (java.io.IOException ioe) { }
    }
}
