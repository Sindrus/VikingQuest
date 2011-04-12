package v1;

import java.awt.*;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Menu extends JPanel{
	
	private boolean loading;
	private boolean gameOver;
	
	public Menu(){
		loading = false;
		gameOver = false;
	}
	
	public void loading(boolean tf){
		loading = tf;
	}
	public void gameOver(boolean tf){
		gameOver = tf;
	}
	
	public void paint(Graphics g){
		g.clearRect(0, 0, 800, 640);
		Toolkit tk = Toolkit.getDefaultToolkit();

		System.out.println("Loading: " + loading);
		System.out.println("GameOver:" + gameOver);
		if(gameOver){
			//g.drawString("Game over! \n(press space to restart)", 400, 320);
			g.drawImage(tk.getImage(getClass().getResource("graphics/defeat.gif")), 0, 0, 800, 640, this);
		}
		else if(loading){
			System.out.println("Skulle tegnet loadingscreen nå");
			g.drawImage(tk.getImage(getClass().getResource("graphics/loading.gif")), 0, 0, 800, 640, this);
		}
/*		else if(starting){
			g.drawString("Starter..." , 500, 320);
		}*/
	}
	
	
}
