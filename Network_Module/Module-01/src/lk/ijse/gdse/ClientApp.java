package lk.ijse.gdse;

import sun.awt.windows.WPrinterJob;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientApp {
    public static void main(String[] args) throws IOException {
        final int PORT =8000;
        Socket socket = new Socket("localhost" ,8000);

        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println("Hellow Server,How Are u.....?");
        printWriter.flush();


    }
}
