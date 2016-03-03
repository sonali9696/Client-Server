import java.net.*;
import java.io.*;

public class client
{
  public static void main(String arg[]) throws IOException
   {
     DataInputStream inp=new DataInputStream(System.in);  // To Read data from keyboard
     System.out.print("Enter Server IP Address :"); 
     String servadd=inp.readLine();  // Read IP ADDRESS of server that run server program
     Socket sct=new Socket(servadd,1212);
     PrintStream out=new PrintStream(sct.getOutputStream());  // Get output stream to send -
                                                                                              // - request/data to server
     DataInputStream in=new DataInputStream(sct.getInputStream());   // Receive response/data -
                                                                                                          //  -from server              
    while(true)
     {
        System.out.println("Enter Your Request to Server :");
        String req=inp.readLine();
        out.println(req);
        String res=in.readLine(); // Read request from Keyboard
        if(res.equalsIgnoreCase("Ok. Bye!")==true)   // Chatting continue untill server-
                                                                            // -response Ok. Bye!
          break;
      System.out.println("Server Responded : "+res);
    }
  }
}

