
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;
public final class EchoClient {

    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket("localhost", 22222)) {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            Scanner sc = new Scanner(System.in);
            OutputStream os = socket.getOutputStream();
            PrintStream out = new PrintStream(os, true, "UTF-8");

            System.out.print("Client> ");

            while(sc.hasNextLine()){
            String line = sc.nextLine();
            String exit = "exit";

            if(line.equals(exit))
            {

               break;
            }else{
              out.println(line);
              System.out.print("Server> " );
              line = br.readLine();
              System.out.println(line);
            }

            System.out.print("Client> ");
            }
        sc.close();
      }
    }
    
}















