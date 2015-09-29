package project1;
import java.io.*;
import java.net.*;

class Runner implements Runnable {
    public void run(){
        
    }
}
public class Project1 {
    public static void main(String[] args) throws IOException{
        Thread t1 = new Thread(new Runner());
        Thread t2 = new Thread(new Runner());
        t1.start();
        t2.start();
        
        InetAddress hostAddress = InetAddress.getByName("www.westminstercollege.edu");
        String IPaddress = hostAddress.getHostAddress();
        try {
            ServerSocket srv = new ServerSocket(6052);
            while(true){
            Socket clt = srv.accept();
            PrintWriter pout = new PrintWriter(clt.getOutputStream(), true);
            BufferedReader bin = new BufferedReader(new InputStreamReader(clt.getInputStream()));
            if("www.westminstercollege.edu".equals(bin.readLine())) {
                try{ 
                pout.println(IPaddress);
                clt.close(); 
                }catch(UnknownHostException e) {
                System.err.println(e);
                }
           // }else{
           //     pout.println("Unable to resolve host" + bin.readLine());
           //     clt.close();
            }
            }

            
            }catch(IOException ioe){
                System.err.println(ioe);
            }
        }
    }