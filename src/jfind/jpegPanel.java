/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jfind;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author tophe
 */
public class jpegPanel extends JPanel {

    private BufferedImage image = null;

    public jpegPanel() {
    }

    public jpegPanel(BufferedImage i) {
        image = i;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        int h = this.getSize().height;
        int w = this.getSize().width;
        if (null != this.image) {
            g.drawImage(this.image, 0, 0, w, h, this);
            g.dispose();
            //revalidate();
            //repaint();
        }
    }

    public void setImage(BufferedImage image) {
        this.image = image;
//        Graphics g = this.getGraphics();
//        if (null != g) {
//            g.drawImage(this.image, 2, 2, this.getWidth() - 4, this.getHeight() - 4, this);
//            revalidate();
//            repaint();
//    }
}
//
//    @Override
//    public void updateUI() {
//        super.updateUI(); //To change body of generated methods, choose Tools | Templates.
//        Graphics g = this.getGraphics();
//        if (null != g) {
//            g.drawImage(this.image, 2, 2, this.getWidth() - 4, this.getHeight() - 4, this);
//        }
//        revalidate();
//        repaint();
//    }

}
