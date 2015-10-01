package project1;
import java.io.*;
import java.net.*;

public class Project1 {
    public static void main(String[] args){
        new Project1();
    }
    public Project1(){
        try {
            ServerSocket server = new ServerSocket(6052);
            while(true){
                Socket client = server.accept();
                HandleClient task = new HandleClient(client);
                new Thread(task).start();
            }
        }catch(IOException ioe){
            System.err.println(ioe);
    }
 }
class HandleClient implements Runnable {
    private Socket client;
    
    public HandleClient(Socket client) {
        this.client = client;
    }
    public void run(){
        try{
            InputStream in = client.getInputStream();
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));
            //DataInputStream in = new DataInputStream(client.getInputStream());
            //DataOutputStream out = new DataOutputStream(client.getOutputStream());
            PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
            while(true){
                InetAddress hostAddress = InetAddress.getByName(bin.readLine());
                String IPaddress = hostAddress.getHostAddress();
                pout.println(IPaddress);
                client.close();
            }
        }catch(UnknownHostException e){
            System.err.println(e);
        }catch(IOException ioe){
            System.err.println(ioe);
        }
    }
}
}