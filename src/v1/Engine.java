package v1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Engine extends JFrame implements grensesnitt.Motor {
	
	Player p;
	
	public static void main(String[] args){
		Engine en = new Engine();
	}
	
	public void input(char c){
		if(c=='a' || c=='s' || c=='d' || c=='w'){
			Move flytt = new Move();
			flytt.executeMove(p, c);
		}
		else 
			System.out.println(c);
	}
	
	public Engine(){
		
		Map m = new Map(40,40);
		Player p = new Player(m, 40, 40);
		
		JPanel stat = new Status(p);
		
		JFrame jf = new JFrame("VikingQuest");
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setSize(800,640);
		jf.setResizable(false);
		
		jf.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==27)
					System.exit(0);
				input(e.getKeyChar());
			}
			public void keyPressed(KeyEvent e) {}
		});
		
		JPanel jpn = new Graphic(m);
		JPanel knapper = new Buttons(p);

		jf.setVisible(true);
		
		jf.add(stat);
		jf.add(knapper);
		jf.add(jpn);

		
		int i=0;

		while(true){
			
			if(i>=6){
				p.addGull(-10);
				i=0;
			}
			i++;
			
			((Status) stat).updateStatus();
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
/*	public void keyPressed(KeyEvent arg0) {
		System.out.println("Print");
	}
	public void keyReleased(KeyEvent arg0) {
		System.out.println("Print");
	}
	public void keyTyped(KeyEvent key) {
		System.out.println("Print");
	}*/
}
