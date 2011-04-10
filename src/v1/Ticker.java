package v1;

import javax.swing.JFrame;

public class Ticker extends Thread{
	private int i;
	private Player p;
	private JFrame jf;
	private Status stat;
	private boolean start = false;
	
	public Ticker(){
		
	}
	
	public void initialiser(Player player,JFrame frame,Status status){
		p=player;
		jf = frame;
		stat = status;
		i=0;
	}
	
	public void kjor(boolean tf){
		start = tf;
		System.out.println("Start: " + start);
	}
	
	public void run(){
		while(true){
			while(start){
		//		try{
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
						
						System.out.println("Tellertest!!!!!");
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					if(p.getSoldater()<=0)
						p.setDead(true);
			
					stat.updateStatus();
					stat.repaint();
					jf.repaint();
					jf.setVisible(true);
	//			}catch(NullPointerException e){}
			}
		}
	}
		
}
