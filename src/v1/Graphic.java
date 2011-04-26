package v1;

import java.awt.*;
import javax.swing.*;

public class Graphic extends JPanel implements grensesnitt.Grafikk {
	
	private int height,width;
	private Toolkit tk;
	
	private Image gress;
	private Image viking;
	private Image village;
	private Image marked;
	private Image bridge;
	private Image vikingOnBridge;
	private Image tree;
	private Image stone;
	private Image destroyedVillage;
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
				if(map.charMap.get(i).get(j)=='p' || map.charMap.get(i).get(j)=='k'){
					coords[0] = i;
					coords[1] = j;
				}
			}
		}
		
		int antx = coords[0]-14;
		int anty = coords[1]-17;
		
		System.out.println("(width/35) = " + (width/35) + " (height/29) = " + (height/29));
		
		gress = tk.getImage(getClass().getResource("graphics/gress.jpg"));
		viking = tk.getImage(getClass().getResource("graphics/vikings.jpg"));
		village = tk.getImage(getClass().getResource("graphics/village.gif"));
		marked = tk.getImage(getClass().getResource("graphics/marked.gif"));
		bridge = tk.getImage(getClass().getResource("graphics/bridge.gif"));
		vikingOnBridge = tk.getImage(getClass().getResource("graphics/vikingOnBridge.gif"));
		tree = tk.getImage(getClass().getResource("graphics/tree.gif"));
		stone = tk.getImage(getClass().getResource("graphics/stone.gif"));
		destroyedVillage = tk.getImage(getClass().getResource("graphics/destroyedVillage.gif"));
		
		for(int i=25, x=antx;i<height;i+=20, x++){
			for(int j=0, y=anty;j<width;j+=20, y++){
				if(map.charMap.get(x).get(y)=='p')
					g.drawImage(viking, j, i, this);
				else if(map.charMap.get(x).get(y)=='k')
					g.drawImage(vikingOnBridge, j, i, this);
				else if(map.charMap.get(x).get(y)=='g')
					g.drawImage(gress, j, i, this);
				else if(map.charMap.get(x).get(y)=='l')
					g.drawImage(village,j ,i, this);
				else if(map.charMap.get(x).get(y)=='m')
					g.drawImage(marked, j, i, this);
				else if(map.charMap.get(x).get(y)=='t')
					g.drawImage(tree, j, i, this);
				else if(map.charMap.get(x).get(y)=='s')
					g.drawImage(stone, j, i, this);
				else if(map.charMap.get(x).get(y)=='c')
					g.drawImage(bridge, j, i, this);
				else if(map.charMap.get(x).get(y)=='0')
					g.drawImage(destroyedVillage, j, i, this);
				else if(map.charMap.get(x).get(y)=='v'){
					g.setColor(Color.blue);
					g.fillRect(j, i, 20, 20);
					g.setColor(Color.WHITE);
				}
			}
		}
	}
}
