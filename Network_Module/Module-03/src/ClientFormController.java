import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ClientFormController {
    @FXML
    private TextField textMassage;

    @FXML
    private TextArea textArea;

    final int PORT =5000;
    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;

    String massage = "";

    public void initialize(){
        new Thread(() -> {
            try {
                socket = new Socket("localhost",PORT);

                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataInputStream = new DataInputStream(socket.getInputStream());

                //           bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                massage = dataInputStream.readUTF();
                System.out.println(massage);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();
    }

    @FXML
    void ClientSendbtnOnAction(ActionEvent event) throws IOException {
        String massageText = textMassage.getText();
        dataOutputStream.writeUTF(massageText);
        dataOutputStream.flush();

    }
}
