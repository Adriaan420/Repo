package com.company;

import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class Main
{
    public static final int PORT = 7789;

    public static void main(String[] args) {
        Socket connection;

        try {
            ServerSocket server = new ServerSocket(PORT);

            while (true) {
                connection = server.accept();
                Thread worker = new Thread(new ConnectionWorker(connection));
                worker.start();
            }
        }
        //	catch (InterruptedException ie) { }
        catch (java.io.IOException ioe) { }
    }
}
