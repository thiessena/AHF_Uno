import java.io.*;
import java.net.Socket;

public class Client {
    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    public void connect(String serverIP, int port) {
        try {
            socket = new Socket(serverIP, port);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
            System.out.println("Connected to server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            socket.close();
            outputStream.close();
            inputStream.close();
            System.out.println("Disconnected from server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registerUser(String username) {
        try {
            outputStream.writeObject("REGISTER_USER");
            outputStream.writeObject(username);
            outputStream.flush();
            System.out.println("User registered successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playCard(UnoKarte card) {
        try {
            outputStream.writeObject("PLAY_CARD");
            outputStream.writeObject(card.toNetString());
            outputStream.flush();
            System.out.println("Card played successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void chooseColor(String color) {
        try {
            outputStream.writeObject("CHOOSE_COLOR");
            outputStream.writeObject(color);
            outputStream.flush();
            System.out.println("Color chosen successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Karte receiveTopCard() {
        try {
            outputStream.writeObject("RECEIVE_TOP_CARD");
            outputStream.flush();
            return (Karte) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int[] receiveOtherPlayerCardCounts() {
        try {
            outputStream.writeObject("RECEIVE_OTHER_PLAYER_CARD_COUNTS");
            outputStream.flush();
            return (int[]) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}