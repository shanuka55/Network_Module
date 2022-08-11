
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.spec.RSAOtherPrimeInfo;


public class ServerFormController {
    @FXML
    private TextField textMassage;

    @FXML
    private TextArea textArea;

    final int PORT =5000;
    ServerSocket serverSocket;
    Socket accept;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    BufferedReader bufferedReader;

    public void initialize(){
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(PORT);
                System.out.println("Server Started...");
                accept = serverSocket.accept();
                System.out.println("Cleant Connected..");

                dataOutputStream = new DataOutputStream(accept.getOutputStream());
                dataInputStream = new DataInputStream(accept.getInputStream());

     //           bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                String massage = dataInputStream.readUTF();
                System.out.println(massage);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();
    }

    @FXML
    void serverBtnOnAction(ActionEvent event) {

    }


}

