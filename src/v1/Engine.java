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
		new Engine();
	}
	
	public Engine(){
		
		m = new Map(50, 50);
		p = new Player(m, 50, 50);
		
		JFrame jf = new JFrame("VikingQuest");
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setSize(800,640);
		jf.setResizable(false);
		
		graphicMap = new Graphic(m, p);
		knapper = new Buttons(p);
		stat = new Status(p);
		
		jf.addKeyListener(this);
		jf.add(stat);
		jf.add(knapper);
		jf.add(graphicMap);
		jf.setVisible(true);
		
		int i=0;

		while(true){
			
			if(i>=30){
				p.addGull(-10);
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
	
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {
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
		
		if(Move.isVillageNearby(p, e.getKeyChar())){
			Combat combat = new Combat();
			Village village = new Village();
			combat.villageCombar(p, village);
			
		/*	Coordinate retning = new Coordinate(e.getKeyChar());
			Coordinate player = new Coordinate(p.getPlayerPos());
			if(village.isDestroyed())
				p.getcMap().charMap.get(Coordinate.plus(player, retning).coord[0]).set(Coordinate.plus(player, retning).coord[1],'0');
		*/
		}
		
		knapper.repaint();
		graphicMap.repaint();
	}
	public void keyTyped(KeyEvent e) {}
}