import java.net.*;
import java.io.*;
public class server
{
   public static void main(String arg[]) throws IOException
   {
            DataInputStream dis=new DataInputStream(System.in); // To read Data from Keyboard
           ServerSocket serv=new ServerSocket(1212);
           Socket sc=serv.accept();
           InetAddress cMachine=sc.getInetAddress();
           PrintStream out=new PrintStream(sc.getOutputStream());
           DataInputStream in=new DataInputStream(sc.getInputStream());                 
         while(true)
         {
           String reqstr=in.readLine(); //read request
           if(reqstr.equalsIgnoreCase("exit"))   // Chatting continue until client requested "exit"
             {
              out.println("Ok. Bye!");
              sc.close();
              serv.close();
              break;
             }
           System.out.println(cMachine.getHostAddress()+" Requested : "+reqstr);
           System.out.println("Enter Response to client :");
           String res=dis.readLine();
           out.println(res); // to send response to client machine

         }
    }
}
