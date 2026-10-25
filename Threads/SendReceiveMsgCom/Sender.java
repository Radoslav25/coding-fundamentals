package SendReceiveMsgCom;

import javax.swing.JOptionPane;

public class Sender extends Thread {

    private Melding melding;
    
    public Sender(Melding melding) {
        this.melding = melding;
    }
    
    @Override
    public void run() {
        while(true) {
            String nyTekst = JOptionPane.showInputDialog("Skriv inn tekst: ");
            if (nyTekst == null) break; // Handle cancel button
            
            melding.setMelding(nyTekst);
            System.out.println("Sender har sendt meldingen: " + nyTekst);
        }
    }
}