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
	
/*	public void input(char c){
		if(c=='a' || c=='s' || c=='d' || c=='w'){
			Move.executeMove(this.p, c);
		}
		else 
			System.out.println(c);
	}*/
	
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
			combat.villageCombar(p, new Village());
			System.out.println("Da var det krig ja!");
		}

		knapper.repaint();
		graphicMap.repaint();
		
		Integer[] pos = p.getPlayerPos().coord;
		for(int i=pos[0]-2;i<pos[0]+2;i++){
			for(int j=pos[1]-2;j<pos[1]+2;j++){
				System.out.print(m.charMap.get(i).get(j));
			}
			System.out.println();
		}
	}
	public void keyTyped(KeyEvent e) {}
}
