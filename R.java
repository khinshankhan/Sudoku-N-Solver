import java.awt.Graphics;

import javax.swing.JPanel;

public class R extends JPanel {
 
 private static final long serialVersionUID = 1L;
 
 protected void paintComponent(Graphics g) {
  super.paintComponent(g);
  Settings.Settings.repaint(g);
 }

}
