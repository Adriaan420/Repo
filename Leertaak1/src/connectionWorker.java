import org.w3c.dom.Document;
import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.Semaphore;

public class connectionWorker implements Runnable
{
	private int sleepTime = 10;
        private Semaphore sem;

	private Socket connection;

	public connectionWorker(Socket connection) {
		this.connection = connection;
	}

	public void run() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //Get the DOM Builder
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            //Load and Parse the XML document
            //document contains the complete XML as a Tree.
            Document document = builder.parse(this.connection.getInputStream());

            System.out.println("");
        }
    }
}