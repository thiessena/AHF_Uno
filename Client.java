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

    public void playCard(Card card) {
        try {
            outputStream.writeObject("PLAY_CARD");
            outputStream.writeObject(card.toNetString());
            outputStream.flush();
            System.out.println("Card played successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void chooseColor(Color color) {
        try {
            outputStream.writeObject("CHOOSE_COLOR");
            outputStream.writeObject(color);
            outputStream.flush();
            System.out.println("Color chosen successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Card receiveTopCard() {
        try {
            outputStream.writeObject("RECEIVE_TOP_CARD");
            outputStream.flush();
            return (Card) inputStream.readObject();
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
```




Dokumentation:

@startuml

class Client {
    - socket: Socket
    - outputStream: ObjectOutputStream
    - inputStream: ObjectInputStream

    + connect(serverIP: String, port: int): void
    + disconnect(): void
    + registerUser(username: String): void
    + playCard(card: Card): void
    + chooseColor(color: Color): void
    + receiveTopCard(): Card
    + receiveOtherPlayerCardCounts(): int[]
}

Client -- Socket
Client -- ObjectOutputStream
Client -- ObjectInputStream

@enduml
Diese Dokumentation zeigt die Struktur der Klasse "Client" mit ihren Attributen und Methoden. Die Assoziationen zu den Klassen "Socket", "ObjectOutputStream" und "ObjectInputStream" werden ebenfalls dargestellt.

