package lk.ijse.gdse;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) {
        final int PORT =8000;
       
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is runing " +PORT);

            //PORT request forword to localShocket
            Socket localShocket = serverSocket.accept();
            System.out.println("Client assepted.....!");


            DataOutputStream dataOutputStream = new DataOutputStream(localShocket.getOutputStream()); // data send karanna
            DataInputStream dataInputStream = new DataInputStream(localShocket.getInputStream()); // data ganna
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); //type karana tika ganna

            String massage = "",reply = "";

            // masg eka finish neweinam
            while (!massage.equals("finish")){
                massage = dataInputStream.readUTF(); //UTF eken read karanwa
                System.out.println(massage); // 1 print massage

                reply = bufferedReader.readLine(); //send reply
                dataOutputStream.writeUTF(reply);  //convert to UTF
                dataOutputStream.flush(); //msg eka yanwa
            }

            dataInputStream.close();
            dataOutputStream.close();
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
