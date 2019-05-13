package form.component;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelJaw extends JPanel {

    private BufferedImage bifferedImage;
    private Image image;
    public PanelJaw() {
        try {
            bifferedImage = ImageIO.read(new File("src/img/teeth.png"));
            image = bifferedImage.getScaledInstance(400, 600, Image.SCALE_DEFAULT);
        } catch (IOException ex) {
            Logger.getLogger(PanelJaw.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, (this.getWidth()-image.getWidth(this))/2,(this.getHeight()-image.getHeight(this))/2, this);
    }

}
