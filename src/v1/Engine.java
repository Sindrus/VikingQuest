package v1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Engine extends JFrame implements grensesnitt.Motor, KeyListener {
	
	Player p;
	Map m;
	Status stat;
	Buttons knapper;
	Graphic graphicMap;
	
	public static void main(String[] args){
		Engine en = new Engine();
	}
	
	public void input(char c){
		if(c=='a' || c=='s' || c=='d' || c=='w'){
			Move.executeMove(this.p, c);
		}
		else 
			System.out.println(c);
	}
	
	public Engine(){
		
		m = new Map(50, 50);
		p = new Player(m, 50, 50);
		
		JFrame jf = new JFrame("VikingQuest");
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setSize(800,640);
		jf.setResizable(false);
		
		graphicMap = new Graphic(m);
		knapper = new Buttons(p);
		stat = new Status(p);
		
		jf.addKeyListener(this);
		jf.add(stat);
		jf.add(knapper);
		jf.add(graphicMap);
		jf.setVisible(true);
		
		int i=0;

		while(true){
			
			if(i>=6){
				p.addGull(-10);
				i=0;
			}
			i++;
			
			stat.updateStatus();
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==27)
			System.exit(0);
		

		p.getcMap().increaseColoumns(p);
		p.getcMap().increaseRows(p);
		
		
		
		Move.executeMove(p, e.getKeyChar());
		
		if(Move.isMarketNearby(p, e.getKeyChar())){
			knapper.labelsMarket();
		}
		else
			knapper.labelsReset();
		
		graphicMap.repaint();
	}
	public void keyTyped(KeyEvent e) {}
}
