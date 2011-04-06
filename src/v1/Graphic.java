package v1;

import java.awt.*;
import javax.swing.*;

public class Graphic extends JPanel implements grensesnitt.Grafikk {
	
	private int x=100,y=100,radius=50;
	private int dx=2,dy=2;
	private int height,width;
	private Toolkit tk;
	
	private Image gress;
	private Image viking;
	private Map map;
	
	public Graphic(Map m){
		tk = Toolkit.getDefaultToolkit();
		Dimension d=tk.getScreenSize();
		height = 630;
		width =  700;
		map = m;
	}
	public void reset(){
		x=100;
		y=100;
	}
	
	public void paint(Graphics g){
		g.clearRect(0, 25, width, height);
		
		gress = tk.getImage(getClass().getResource("graphics/gress.jpg"));
		viking = tk.getImage(getClass().getResource("graphics/vikings.jpg"));
		
		for(int i=25, x=0;i<615;i+=20, x++){
			for(int j=0, y=0;j<700;j+=20, y++){
				if(map.charMap.get(x).get(y)=='p')
					g.drawImage(viking,j,i,this);
				else
					g.drawImage(gress, j, i, this);
			}
		}
	}
}
