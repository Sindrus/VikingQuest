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
		height = 615;
		width =  700;
		map = m;
	}
	public void reset(){
		x=100;
		y=100;
	}
	
	public void paint(Graphics g){
		g.clearRect(0, 25, width, height);
		
		int[] coords = new int[2];
		
		for(int i=0;i<map.charMap.size();i++){
			for(int j=0;j<map.charMap.get(i).size();j++){
				if(map.charMap.get(i).get(j)=='p'){
					coords[0] = i;
					coords[1] = j;
				}
			}
		}
		System.out.println("["+coords[0]+"],["+coords[1]+"]");
		int antx=(width/20);
		int anty=(height/20);
		System.out.println("Start: ["+antx+"],["+anty+"]");
		
		gress = tk.getImage(getClass().getResource("graphics/gress.jpg"));
		viking = tk.getImage(getClass().getResource("graphics/vikings.jpg"));
		
		for(int i=25, x=anty;i<height;i+=20, x++){
			for(int j=0, y=antx;j<width;j+=20, y++){
				if(map.charMap.get(x).get(y)=='p')
					g.drawImage(viking,j,i,this);
				else
					g.drawImage(gress, j, i, this);
			}
		}
	}
}
