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
	JFrame jf;
	Menu menu;
	Ticker teller;
	
	public static void main(String[] args){
		new Engine();
	}
	
	public void init(){
		m=null;
		p=null;
		
		try {
			jf.remove(menu);
			jf.remove(graphicMap);
			jf.remove(knapper);
			jf.remove(stat);
		} catch (NullPointerException e) {}
		
		
		m = new Map(50, 50);
		p = new Player(m, 50, 50);
		
		graphicMap = new Graphic(m, p);
		knapper = new Buttons(p);
		stat = new Status(p);
		menu = new Menu(p);
		
		jf.add(stat);
		jf.add(knapper);
		jf.add(graphicMap);
		jf.setVisible(true);
		teller.initialiser(p, jf, stat);
		teller.kjor(true);
	}
	
	public Engine(){
		
		jf = new JFrame("VikingQuest");
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setSize(800,640);
		jf.setResizable(false);
		jf.addKeyListener(this);
		
		teller = new Ticker();
		teller.start();
		
		init();
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==27)
			System.exit(0);
		else if(e.getKeyCode()==32 && p.isDead()){
			menu.starting();
			menu.repaint();
			System.out.println("Restarting...");
			init();
		}
		else if(!p.isDead()){
			p.getcMap().increaseColoumns(p);
			p.getcMap().increaseRows(p);
			
			Move.executeMove(p, e.getKeyChar());
			
			if(Move.isMarketNearby(p, e.getKeyChar())){
				knapper.setEnableMarked(true);
				knapper.updateButtons();
			}
			else{
				knapper.setEnableMarked(false);
				knapper.updateButtons();
			}
			
			if(Move.isVillageNearby(p, e.getKeyChar())){
				Combat combat = new Combat();
				Village village = new Village();
				combat.villageCombar(p, village, m, e.getKeyChar());
			}
			
			if(!p.isDead()){
				knapper.repaint();
				graphicMap.repaint();
				stat.repaint();
			}
		}
		
		if(p.isDead()){
			
			teller.kjor(false);
			
			menu = new Menu(p);
			
			jf.remove(knapper);
			jf.remove(graphicMap);
			jf.remove(stat);
			jf.add(menu);
		}
		
		stat.updateStatus();
		stat.repaint();
		jf.repaint();
		jf.setVisible(true);
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}