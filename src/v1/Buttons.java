package v1;

import javax.swing.*;
import java.awt.event.*;


public class Buttons extends JPanel{
	
	private JLabel exit;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private Player p;
	private boolean enableMarked;
	private MouseListener ml1;
	private MouseListener ml2;
	
	public void setEnableMarked(boolean tf){
		enableMarked = tf;
	}
	public boolean getEnableMarked(){
		return enableMarked;
	}
	
	public Buttons(Player player){
		enableMarked = false;
		p=player;
		setBounds(700, 25, 100, 640);
		
		lbl1 = new JLabel(" ");
		lbl2 = new JLabel(" ");
		lbl3 = new JLabel(" ");
		lbl4 = new JLabel(" ");
		
		exit = new JLabel("Exit");
		exit.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		exit.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 50));
		
		ml1 = new MouseListener(){
			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {
				if(enableMarked){
					Market.buyFood(p);
				}
			}
		};
		ml2 = new MouseListener(){
			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {
				if(enableMarked){
					Market.buySoldiers(p);
				}
			}
		};
		lbl1.addMouseListener(ml1);
		lbl2.addMouseListener(ml2);

		lbl1.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 50));
		lbl2.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 50));
		lbl3.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 50));
		lbl4.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 50));
		
		add(lbl1);
		add(lbl2);
		add(lbl3);
		add(lbl4);
		add(exit);
	}
	
	public void updateButtons(){
		
		remove(lbl1);
		remove(lbl2);
		remove(lbl3);
		remove(lbl4);
		remove(exit);

		if(enableMarked){
			lbl1.setText("<html> kjøp " +
					"<img src="+ Status.class.getResource("graphics/meat.gif") + " /> ");
			
			lbl2.setText("<html> kjøp " +
					"<img src="+ Status.class.getResource("graphics/statusViking.gif") + " /> ");
		}
		else{
			lbl1.setText(" ");
			lbl2.setText(" ");
		}
		
		add(lbl1);
		add(lbl2);
		add(lbl3);
		add(lbl4);
		add(exit);
	}
}
