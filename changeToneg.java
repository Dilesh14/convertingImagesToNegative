import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.io.*;
import javax.imageio.*;
import java.lang.ClassLoader;
public class changeToneg extends Frame implements ActionListener{
	BufferedImage input;
	int width, height;
	look source,target;
	public changeToneg(String name) {
		try {
			input= ImageIO.read(new File (name));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		width= input.getWidth();
		height = input.getHeight();
		//preparing the GUIs
		Panel main = new Panel();
		source = new look(input);
		target=new look(input);
		main.setLayout(new GridLayout(1,2,10,10));
		main.add(source);
		main.add(target);
		//Guis buttons
		Panel control = new Panel();
		Button button = new Button("Negative");
		button.addActionListener(this);
		control.add(button);
		add("Center",main);
		add("South",control);
		addWindowListener(new ExitListener());
		setSize(width*2+200,height+100);
		setTitle("Convert to Negative");
		setVisible(true);
	}
	class ExitListener extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(((Button)e.getSource()).getLabel().equals("Negative")) {
			for(int y=0; y < height;y++)
				for (int x=0; x<width;x++) {
					Color clr = new Color (input.getRGB(x, y));
					int r = 255 - clr.getRed();
					int g = 255- clr.getGreen();
					int b = 255 - clr.getBlue();
					
					target.image.setRGB(x,y,r<<16|g<<8|b);
					target.repaint();
					
				}
		}
	}
	public static void main(String[] args) {
		
		//InputStream path = ClassLoader.getSystemResourceAsStream("./signal_hill.png");
		//System.out.println(path);
//		String l = path.toString();
	new changeToneg(args.length==1 ? args[0] : "");
	}
}
