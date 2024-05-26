package TrabajoGrupoMemory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameFrame extends JFrame {
    private Board board;
    private Card firstCard;
    private Card secondCard;
    private int revealedCount;
    private int attempts;
    private JLabel attemptsLabel;

    public GameFrame() {
        board = new Board();
        firstCard = null;
        secondCard = null;
        revealedCount = 0;
        attempts = 0;

        setTitle("Juego de Memoria");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);

        JPanel cardsPanel = new JPanel();
        cardsPanel.setLayout(new GridLayout(4, 4)); // 4x4 para 16 cartas
        add(cardsPanel, BorderLayout.CENTER);

        attemptsLabel = new JLabel("Intentos: 0");
        add(attemptsLabel, BorderLayout.SOUTH);

        ArrayList<Card> cards = board.getCards();
        for (Card card : cards) {
            final Card finalCard = card; // Hacer la variable efectiva final
            card.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardClicked(finalCard);
                }
            });
            cardsPanel.add(card);
        }

        setVisible(true);
    }

    private void cardClicked(Card card) {
        if (revealedCount == 2 || card.isMatched() || card == firstCard) {
            return;
        }

        card.reveal();
        revealedCount++;

        if (revealedCount == 1) {
            firstCard = card;
        } else if (revealedCount == 2) {
            secondCard = card;
            attempts++;
            attemptsLabel.setText("Intentos: " + attempts);

            if (firstCard.getImage().equals(secondCard.getImage())) {
                firstCard.setMatched(true);
                secondCard.setMatched(true);
                revealedCount = 0;
                checkGameOver();
            } else {
                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        firstCard.hide();
                        secondCard.hide();
                        revealedCount = 0;
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        }
    }

    private void checkGameOver() {
        for (Card card : board.getCards()) {
            if (!card.isMatched()) {
                return;
            }
        }
        // Mostrar el frame de felicitaciones en lugar de solo el cuadro de diálogo
        new FelicitacionesFrame();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameFrame();
            }
        });
    }
}

class FelicitacionesFrame extends JFrame {

    public FelicitacionesFrame() {
        // Configura el JFrame
        setTitle("Felicitaciones");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Solo cierra esta ventana
        setLocationRelativeTo(null);

        // Carga la imagen
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("MONGODB (1).jpg"));

        // Crea un JLabel con la imagen
        JLabel label = new JLabel(imageIcon);

        // Añade el JLabel al JFrame
        add(label);

        // Haz visible el JFrame
        setVisible(true);
    }
}