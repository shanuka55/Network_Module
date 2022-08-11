package lk.ijse.gdse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) throws IOException {
        final int PORT =8000;
        ServerSocket serverSocket = new ServerSocket(PORT);

        System.out.println("Server is runing " +PORT);

        //PORT request forword to localShocket
        Socket localShocket = serverSocket.accept();
        System.out.println("Port  "+localShocket.getPort());
        System.out.println("IP " +localShocket.getInetAddress());

        InputStreamReader inputStreamReader 
                = new InputStreamReader(localShocket.getInputStream());

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String cLieMsg = bufferedReader.readLine();

        System.out.println("Client says  :" +cLieMsg);
    }
}
