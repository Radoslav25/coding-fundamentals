package no.hvl.dat107.sorting;

public class CaesarCipherDecoder {

    // Method to decrypt text with a given key
    public static String decrypt(String text, int key) {
        String decryptedText = "";
        
        for (char charAt : text.toCharArray()) {
            if (Character.isLetter(charAt)) {
               

                // Shift character back by key and wrap around the alphabet
                char decryptedChar = (char) ((charAt - key) % 26);
                decryptedText += decryptedChar; // Use string concatenation
            } else {
                decryptedText += charAt; // Keep non-alphabet characters unchanged
            }
        }
        
        return decryptedText;
    }

    public static void main(String[] args) {
        String ciphertext = "xcy"; // Example ciphertext
        int key = 20; // Key calculated from plaintext "die"

        // Decrypt the text using the key
        String decryptedText = decrypt(ciphertext, key);
        System.out.println("Decrypted text with key " + key + ": " + decryptedText);
    }
}

