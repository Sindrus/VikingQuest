package v1;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Menu extends JPanel{
	
	private boolean starting;
	
	public static void main(String[] args){
		new Menu();
	}
	
	public Menu(){
		new Engine();
		starting = false;
	}
	
	public Menu(Player p){
		starting = false;
	}
	
	public void starting(){
		starting = true;
	}
	
	public void paint(Graphics g){
//		g.clearRect(0, 0, 800, 640);
		
		if(!starting){
			g.drawString("Game over! \n(press space to restart)", 400, 320);
		}
/*		else if(starting){
			g.drawString("Starter..." , 500, 320);
		}*/
	}
	
	
}
