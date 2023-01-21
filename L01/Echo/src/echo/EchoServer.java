package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Team 2
 */
public class EchoServer
{
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("Simple Echo Server");
        
        //ServerSocket is generated on port 8080
        try (ServerSocket serverSocket = new ServerSocket(8080)){
            System.out.println("Waiting for connection.....");
            
            //ServerSocket attempts to connect to client, and displays text when it succeeds
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected to client");

            //BufferedReader for reading client message and PrintWriter for responding to client is generated
            try (BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                    
                String inputLine;
                //Loop to continue reading from the BufferedReader, as long as relevant text remains 
                //and sends the server's echo response back to the client    
                while ((inputLine = br.readLine()) != null) {
                    System.out.println("Server: " + inputLine);
                    out.println(inputLine);
                }
            }   
            //Exception thrown if communication fails between ServerSocket and client
            catch (IOException ex) {
                Logger.getLogger(EchoServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
        
        //Exception thrown if ServerSocket fails to generate
        catch (IOException ex) {
            Logger.getLogger(EchoServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
