import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Draw_byDDALine extends JFrame {
	public Draw_byDDALine() {
		setSize(700,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Draw_byDDALine frame = new Draw_byDDALine();
		DDAlinePanel panel = new DDAlinePanel();
		frame.setTitle("DDA Line");
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
class DDAlinePanel extends JPanel implements MouseListener{
	int x1,y1,x2,y2;
	public DDAlinePanel() {
		setSize(700,700);
		setLayout(null);
		addMouseListener(this);
	}
	public void paint(Graphics g) {
		double dx,dy,step,xinc,yinc,x,y;
		dx = x2 - x1;
        dy = y2 - y1;
        if (Math.abs(dx) > Math.abs(dy)) step = Math.abs(dx);
        else step = Math.abs(dy);
        xinc = dx / step;
        yinc = dy / step;
        x = x1;
        y = y1;

        g.setColor(Color.red);
        g.fillOval((int) x, (int) y, 2, 2);

        for (float i = 1; i <= step; i++) {
            x = x + xinc;
            y = y + yinc;
            g.fillOval((int) x, (int) y, 2, 2);
        }
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("X= "+ e.getX() + " Y="+ e.getY());
		if(x1==0) {
			this.x1 = e.getX();
			this.y1 = e.getY();
			this.x2 = e.getX();
			this.y2 = e.getY();
		}else {
			this.x1=x2;
			this.y1=y2;
			
			this.x2 = e.getX();
			this.y2 = e.getY();
		}
		repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}