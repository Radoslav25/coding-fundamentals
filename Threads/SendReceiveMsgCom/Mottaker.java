package SendReceiveMsgCom;

public class Mottaker extends Thread {

    private Melding melding;
    
    public Mottaker(Melding melding) {
        this.melding = melding;
    }
    
    @Override
    public void run() {
        while(true) {
            // getMelding will block safely until a new message is available
            String mottattTekst = melding.getMelding();
            if (mottattTekst != null) {
                System.out.println("Mottaker har mottatt melding: " + mottattTekst);
            }
        }
    }
}