package lk.ijse.gdse;

import sun.awt.windows.WPrinterJob;

import java.io.*;
import java.net.Socket;

public class ClientApp {
    public static void main(String[] args)  {
        final int PORT =8000;
        try {
            Socket socket = new Socket("localhost" ,PORT);

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            // bufferReader use read karana tika ganna

            String massage = "",reply = "";

            while (!massage.equals("finish")){
                reply = bufferedReader.readLine(); //1st send msg to Server
                dataOutputStream.writeUTF(reply);  //convert to UTF

                massage = dataInputStream.readUTF(); //read karanwa UTF walin
                System.out.println(massage);  //print msg
                dataOutputStream.flush();
            }

            dataInputStream.close();
            dataOutputStream.close();
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
