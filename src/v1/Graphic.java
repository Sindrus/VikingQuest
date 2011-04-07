package v1;

import java.awt.*;

import javax.swing.*;

public class Graphic extends JPanel implements grensesnitt.Grafikk {
	
	private int height,width;
	private Toolkit tk;
	
	private Image gress;
	private Image viking;
	private Map map;
	
	public Graphic(Map m){
		tk = Toolkit.getDefaultToolkit();
		height = 615;
		width =  700;
		map = m;
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
		System.out.println("Width/40: " + (width/40) + " Height/40: " + (height/40));
		int antx=coords[0]-(width/40);
		int anty=coords[1]-(height/40);
		System.out.println("Start: ["+antx+"],["+anty+"]");
		
		gress = tk.getImage(getClass().getResource("graphics/gress.jpg"));
		viking = tk.getImage(getClass().getResource("graphics/vikings.jpg"));
		
		for(int i=25, x=antx;i<height;i+=20, x++){
			for(int j=0, y=anty;j<width;j+=20, y++){
				if(map.charMap.get(x).get(y)=='p')
					g.drawImage(viking,j,i,this);
				else if(map.charMap.get(x).get(y)=='g')
					g.drawImage(gress, j, i, this);
				else if(map.charMap.get(x).get(y)=='v'){
					g.setColor(Color.blue);
					g.fillRect(j, i, 20, 20);
					g.setColor(Color.WHITE);
				}
			}
		}
	}
}
