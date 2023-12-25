import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Draw_BresenhamLine extends JFrame {
    public Draw_BresenhamLine() {
        setSize(700, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
    }

    public static void main(String[] args) {
    	
        Draw_BresenhamLine frame = new Draw_BresenhamLine();
        BresenhamePanel panel = new BresenhamePanel();
        frame.setTitle("");
        frame.add(panel);
        frame.setVisible(true);
    }
}

class BresenhamePanel extends JPanel implements MouseListener {
    int x1, x2, y1, y2, x, y, dx, dy, p;
    boolean firstClick = true; // Flag to check if it's the first click

    public BresenhamePanel() {
        setSize(700, 700);
        setLayout(null);
        addMouseListener(this);
    }

    public void paint(Graphics g) {
//        dx = Math.abs(x2 - x1);
//        dy = Math.abs(y2 - y1);
		dx=x2-x1;
		dy=y2-y1;

        x = x1;
        y = y1;
        g.setColor(Color.red);

        p = (2 * dy) - dx;
        while (x <= x2) {
            x++;
            if (p < 0) p = p + 2 * dy;
            else {
                y++;
                p = p + 2 * dy - 2 * dx;
            }
            g.drawOval(x, y, 2, 2);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("x=" + e.getX() + "  Y=" + e.getY());

        if (firstClick) {
            x1 = e.getX();
            y1 = e.getY();
            firstClick = false;
        } else {
            x1 = x2; // Set x1 to the previous x2
            y1 = y2; // Set y1 to the previous y2
        }

        x2 = e.getX();
        y2 = e.getY();
        repaint(); // Trigger repaint to draw the new line
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Do nothing
    	
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Do nothing
    	
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Do nothing
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Do nothing
    }
}
