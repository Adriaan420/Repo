package project2;
import java.net.*;
import java.io.*;

public class Client {
    private static String site = "www.westminstercollege.edu";
    public static void main(String[] args){
        try {
            Socket sock = new Socket("127.0.0.1",6052);
            
            PrintWriter pout = new PrintWriter(sock.getOutputStream(), true);
            InputStream in = sock.getInputStream();
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));
            pout.println(site);
            // read the date from the socket
            String line;
            while ( (line = bin.readLine()) != null)
            System.out.println(line);
            // close the socket connection
            sock.close();
        }
        catch(IOException ioe){
            System.err.println(ioe);
        }
    }
}
