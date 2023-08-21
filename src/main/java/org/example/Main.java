import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        WordTypeTracker wordTypeTracker = new WordTypeTracker();
    }

    public static class WordTypeTracker implements KeyListener {
        private StringBuilder currentWord = new StringBuilder();

        public WordTypeTracker() {
            JTextField textField = new JTextField();
            textField.addKeyListener(this);

            JFrame frame = new JFrame("Woordtypetracker");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(textField);
            frame.pack();
            frame.setVisible(true);
        }

        @Override
        public void keyTyped(KeyEvent e) {
            char typedChar = e.getKeyChar();

            if (typedChar == KeyEvent.VK_ENTER || typedChar == KeyEvent.VK_SPACE) {
                processCurrentWord();
            } else {
                currentWord.append(typedChar);
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_SPACE) {
                // Voeg hier je code toe om te reageren op de Enter-toets of spatiebalk.
                if (keyCode == KeyEvent.VK_ENTER) {
                    System.out.println("Enter ingedrukt!");
                } else if (keyCode == KeyEvent.VK_SPACE) {
                    System.out.println("Spatie ingedrukt!");
                }
                processCurrentWord();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // Wordt aangeroepen wanneer een ingedrukte toets wordt losgelaten.
        }

        private void processCurrentWord() {
            String typedWord = currentWord.toString().trim();
            if (!typedWord.isEmpty()) {
                // Toon de leesbare tekst
                System.out.println("Getypt woord: " + typedWord);

                // Converteer de tekst naar bytecode en toon het
                byte[] byteData = typedWord.getBytes(StandardCharsets.UTF_8);
                System.out.print("UTF-8 Bytecode: ");
                for (byte b : byteData) {
                    System.out.print(String.format("%02X ", b));
                }
                System.out.println(); // Voeg een nieuwe regel toe na de bytecode
            }
            currentWord.setLength(0);
        }
    }
}
