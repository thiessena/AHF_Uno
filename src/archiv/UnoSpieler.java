package archiv;

public class UnoSpieler {
    private String IP;
    private int Port;
    private String Benutzername;
    private Handkarten handkarten;
    private boolean unoGesagt;

    public UnoSpieler(String benutzername) {
        this.Benutzername = benutzername;
        this.handkarten = new Handkarten();
        this.unoGesagt = false;
    }

    public UnoSpieler(String IP, int Port, String benutzername, Handkarten handkarten, boolean unoGesagt) {
        this.IP = IP;
        this.Port = Port;
        this.Benutzername = benutzername;
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

    public String getIPPort() {
        return IP + ":" + Port;
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
