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
	
	public static void main(String[] args){
		new Engine();
	}
	
	public void StartGame(){
	}
	
	public void init(){
		m=null;
		p=null;
		
		try {
			jf.remove(graphicMap);
			jf.remove(knapper);
			jf.remove(stat);
		} catch (Exception nullPointerException) {}
		
		m = new Map(50, 50);
		p = new Player(m, 50, 50);
		graphicMap = new Graphic(m, p);
		knapper = new Buttons(p);
		stat = new Status(p);
		
		jf.add(stat);
		jf.add(knapper);
		jf.add(graphicMap);
		jf.setVisible(true);
		
	}
	
	public Engine(){
		
		
		jf = new JFrame("VikingQuest");
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setSize(800,640);
		jf.setResizable(false);
		jf.addKeyListener(this);
		
		init();
		
		
		int i=0;
		
		while(true){
			
			if(i>=30){
			//	p.addGull(-10);
				i=0;
			}
			i++;
			
			stat.updateStatus();
			stat.repaint();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==27)
			System.exit(0);
		
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
		else{
			stat.repaint();
			init();
			graphicMap.repaint();
			knapper.repaint();
			stat.repaint();

		}

	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}