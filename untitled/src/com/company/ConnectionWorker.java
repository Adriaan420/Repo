package com.company;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.management.BufferPoolMXBean;
import java.net.Socket;
import java.util.concurrent.Semaphore;

public class ConnectionWorker implements Runnable {

    private Socket connection;

    public ConnectionWorker(Socket connection) {
        this.connection = connection;
    }

    public void run() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //Get the DOM Builder
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            //Load and Parse the XML document
            //document contains the complete XML as a Tree.
            BufferedReader bin = new BufferedReader(new InputStreamReader(this.connection.getInputStream()));
            String line;

            while((line = bin.toString()) != null) {
                System.out.println(line);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}