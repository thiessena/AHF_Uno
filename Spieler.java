public class Spieler {
    private String IP;
    private int Port;
    private String Benutzername;
    private Handkarten handkarten;
    private boolean unoGesagt;

    public Spieler(String IP, int Port, String Benutzername, Handkarten handkarten, boolean unoGesagt) {
        this.IP = IP;
        this.Port = Port;
        this.Benutzername = Benutzername;
        this.handkarten = handkarten;
        this.unoGesagt = unoGesagt;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public int getPort() {
        return Port;
    }

    public void setPort(int Port) {
        this.Port = Port;
    }

    public String getBenutzername() {
        return Benutzername;
    }

    public void setBenutzername(String Benutzername) {
        this.Benutzername = Benutzername;
    }

    public Handkarten getHandkarten() {
        return handkarten;
    }

    public void setHandkarten(Handkarten handkarten) {
        this.handkarten = handkarten;
    }

    public boolean isUnoGesagt() {
        return unoGesagt;
    }

    public void setUnoGesagt(boolean unoGesagt) {
        this.unoGesagt = unoGesagt;
    }
}
