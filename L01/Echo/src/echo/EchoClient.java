package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Team 2 
 * (Aurora Drabik, Jang Won Cho, Tyler Cullen, Kaelynn Davies, Ian Gwillim, Andrew Kochhar, Ryan Waitlevertch)
 */
public class EchoClient
{

    /**
     * @param args the command line arguments
     */
    
    //Main method for generating a client to interact with the echo server
    //This is Client class which will connect to the server(same Socket number)
    public static void main(String[] args)
    {
        //Introductory text displayed for the program
        System.out.println("Simple Echo Client");
        
        //Attempts to generate a socket connecting to the server
        try {
            System.out.println("Waiting for connection.....");
            InetAddress localAddress = InetAddress.getLocalHost();
            
            //The socket is made, set to port 8080
            try (Socket clientSocket = new Socket(localAddress, 8080);
            //PrintWriter is created to send output to server
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            //BufferedReader is created to receive response from server
            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                
                //Text displayed if the client socket communicates with the server
                System.out.println("Connected to server");
                Scanner scanner = new Scanner(System.in);
                
                //continuous loop to keep receiving inputs from the client
                while (true) {
                    System.out.print("Enter text: ");
                    String inputLine = scanner.nextLine();
                    if ("quit".equalsIgnoreCase(inputLine)) 
                        break; //entering 'quit' will break the loop
                    
                    //The inputted line is sent to the server
                    out.println(inputLine);
                    
                    //The text from the BufferedReader is taken from the server and displayed on the client
                    String response = br.readLine();
                    System.out.println("Server response: " + response);
                }
            }   
            //Exception thrown if client socket fails to connect to the server
            catch (IOException ex) {
                Logger.getLogger(EchoClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
        //Exception thrown if the client socket fails to generate
        catch (UnknownHostException ex) {
            Logger.getLogger(EchoClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
