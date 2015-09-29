/* package project1;

import java.net.*;
import java.io.*;

public class poging2 implements Runnable {
    public static void main(String[] args){
    
    new Thread(new dnsServer()).start();
    //new Thread(new dnsClient()).start();
    }
    
static class dnsServer implements Runnable {
    public void run(){
        ServerSocket serverSocket = null;
        while(true) {
        try{
            serverSocket = new ServerSocket(6052);
            Socket clientSocket = serverSocket.accept();
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException ioe) {
            System.err.println(ioe);
        }finally{
            try{
                serverSocket.close();
                
            } catch (IOException ioe) {
                System.err.println(ioe);
            }
        }
        }
    }

}
}
/*
InetAddress hostAddress = InetAddress.getByName("www.westminstercollege.edu");
String IPaddress = hostAddress.getHostAddress();
*/