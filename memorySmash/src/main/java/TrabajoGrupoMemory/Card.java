package TrabajoGrupoMemory;

import javax.swing.*;

public class Card extends JToggleButton {
    private ImageIcon image;
    private boolean matched;
    private ImageIcon defaultIcon;

    public Card(ImageIcon image, ImageIcon defaultIcon) {
        this.image = image;
        this.defaultIcon = defaultIcon;
        this.matched = false;
        this.setIcon(defaultIcon); // Imagen por defecto cuando la carta está volteada
    }

    public ImageIcon getImage() {
        return image;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public void reveal() {
        this.setIcon(image);
    }

    public void hide() {
        if (!matched) {
            this.setIcon(defaultIcon);
        }
    }
}
