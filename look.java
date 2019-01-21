import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
public class look extends Canvas {
	BufferedImage image;
	//initialize image 
	public look(BufferedImage input) {
		image = input;
	}
	public look(int width, int height) {
		image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	}
	//redraws the canvas
	public void paint(Graphics g) {
		g.setColor(Color.CYAN);
		//g.drawRect(0,0, getWidth()-1, getHeight()-1);
		g.drawImage(image, 50, 0, this);
		// compute the offset of the image.
//		int xoffset = (getWidth() - image.getWidth()) / 2;
//		int yoffset = (getHeight() - image.getHeight()) / 2;
//		g.drawImage(image, xoffset, yoffset, this);
	}
}
