import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.border.Border;


public class RoundBorder implements Border{
	private Color color;

	public RoundBorder(Color color) {
		this.color = color;
	}

	public RoundBorder() {
		this.color = Color.BLACK;
	}

	public Insets getBorderInsets(Component c) {
		return new Insets(0, 6, 0, 0);
	}

	@Override
	public void paintBorder(Component c,Graphics g,int x,int y,int w,int h) {
		
		Graphics2D g2d = (Graphics2D)g;
		BasicStroke bs = new BasicStroke(6);
		
		g2d.setColor(color);
		g2d.setStroke(bs);

		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawRoundRect(0, 0, c.getWidth(), c.getHeight(), 10, 10);		
	}

	@Override
	public boolean isBorderOpaque() {
		// TODO Auto-generated method stub
		return false;
	}
}
