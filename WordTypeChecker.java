import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WordTypeTracker implements KeyListener {
    private StringBuilder currentWord = new StringBuilder();

    public WordTypeTracker() {
        // Voeg deze KeyListener toe aan een JTextField of een ander tekstinvoerveld.
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

        if (typedChar == KeyEvent.VK_SPACE) {
            // Als een spatie wordt ingevoerd, toon het huidige woord en reset het.
            String typedWord = currentWord.toString().trim();
            if (!typedWord.isEmpty()) {
                System.out.println("Getypt woord: " + typedWord);
            }
            currentWord.setLength(0); // Reset het huidige woord.
        } else {
            currentWord.append(typedChar); // Voeg het getypte karakter toe aan het huidige woord.
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Wordt aangeroepen wanneer een toets wordt ingedrukt (nog niet losgelaten).
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Wordt aangeroepen wanneer een ingedrukte toets wordt losgelaten.
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WordTypingTracker());
    }
}

