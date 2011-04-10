package v1;

import java.awt.Component;
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
		System.out.println("Is dead? " + p.isDead());
		
		
	//	runGame();
	}
	
	public Engine(){
		
		jf = new JFrame("VikingQuest");
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setSize(800,640);
		jf.setResizable(false);
		jf.addKeyListener(this);
		
		runGame();
	}
	
	public void runGame(){
		init();
		
		int i=0;
		
		while(true){
			
			i++;
			
			if(i>=30){
				if(p.getGull()>0)
					p.addGull((int)(-p.getSoldater()*0.25));
				if(p.getGull()<=0)
					p.addSoldater(-5);
				
				if(p.getMat()>0)
					p.addMat((int)(-p.getSoldater()*0.1));
				if(p.getMat()<=0)
					p.addSoldater(-5);
				
				i=0;
			}
			
			
			stat.updateStatus();
			stat.repaint();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(p.getSoldater()<=0)
				p.setDead(true);
		}
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==27)
			System.exit(0);
		else if(e.getKeyCode()==32 && p.isDead()){
			menu.starting();
			menu.repaint();
			System.out.println("Restarting...");
			init();
//			runGame();
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
			System.out.println(knapper.getEnableMarked());
			
			if(Move.isVillageNearby(p, e.getKeyChar())){
				Combat combat = new Combat();
				Village village = new Village();
				combat.villageCombar(p, village);
			}
			
			if(!p.isDead()){
				knapper.repaint();
				graphicMap.repaint();
				stat.repaint();
			}
		}

		if(p.isDead()){
			stat.repaint();
			graphicMap.repaint();
			knapper.repaint();
			stat.repaint();
			
			menu = new Menu(p);
			
			jf.remove(knapper);
			jf.remove(graphicMap);
			jf.remove(stat);
			jf.add(menu);
		}
		jf.repaint();
		jf.setVisible(true);
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}