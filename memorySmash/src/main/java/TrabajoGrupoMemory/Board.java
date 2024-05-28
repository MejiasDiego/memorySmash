package TrabajoGrupoMemory;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
public class Board {
    private ArrayList<Card> cards;

    public Board() {
        cards = new ArrayList<>();
        ImageIcon defaultIcon = new ImageIcon(getClass().getResource
        		("/smash-logo.png"));
        String[] imagePaths = 
        	{"/Banjo&KazooieHeadSSBUWebsite.png", 
     			"/CloudHeadSSBUWebsite.png", "/HeroHeadSSBUWebsite.png", 
     			"/JokerHeadSSBUWebsite.png", 
                "/Pac-ManHeadSSBUWebsite.png", 
                "/SnakeHeadSSBUWebsite.png", "/SteveHeadSSBUWebsite.png", 
                "/YoshiHeadSSBUWebsite.png"};

        for (String path : imagePaths) {
            ImageIcon image = new ImageIcon(getClass().getResource(path));
            cards.add(new Card(image, defaultIcon));
            cards.add(new Card(image, defaultIcon)); // Duplicar para tener parejas
        }

        Collections.shuffle(cards);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
