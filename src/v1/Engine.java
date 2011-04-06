package v1;

import javax.swing.*;

public class Engine extends JFrame implements grensesnitt.Motor {
	
	static boolean stop=false;
	Player p;
	
	public static void stopp(){
		stop = true;
	}
	public static void start(){
		stop = false;
	}
	
	
	
	public static void main(String[] args){
		Engine en = new Engine();
	}
	
	public Engine(){
		
		Map m = new Map(35,35);
		Player p = new Player(m, 35, 35);
		
		
		
		JPanel stat = new Status(p);
		
		
		JFrame jf = new JFrame("VikingQuest");
		jf.setVisible(true);
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setSize(800,640);
		jf.setResizable(false);

		JPanel jpn = new Graphic(m);
		JPanel knapper = new Buttons(p);
		
		jf.add(stat);
		jf.add(knapper);
		jf.add(jpn);
		
		
		int i=0;
		while(true){
			while(!stop){
				
	//			((Graphic)jpn).drawMap();
				
	//			jf.repaint();
				
//				if(i>=6){
//					p.addGull(-10);
//					i=0;
//				}
//				i++;
				

				((Status) stat).updateStatus();
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
