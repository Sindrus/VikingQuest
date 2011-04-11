package v1;

import java.awt.*;
import java.awt.Toolkit;

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
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		if(!starting){
			//g.drawString("Game over! \n(press space to restart)", 400, 320);
			g.drawImage(tk.getImage(getClass().getResource("graphics/defeat.gif")), 0, 0, 800, 640, this);
		}
/*		else if(starting){
			g.drawString("Starter..." , 500, 320);
		}*/
	}
	
	
}
