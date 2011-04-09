package v1;

import javax.swing.*;
import java.awt.event.*;


public class Buttons extends JPanel{
	
	JLabel exit;
	JLabel lbl1;
	JLabel lbl2;
	JLabel lbl3;
	JLabel lbl4;
	Player p;
	boolean enableMarked;
	MouseListener ml1;
	MouseListener ml2;
	
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
					p.addGull(-20);
					p.addMat(10);
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
					p.addGull(-20);
					p.addSoldater(10);
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
/*
 * ==Initialiserer de forskjellige mouseListener måtene==		
 */
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
		
/*		lbl3.setText(" ");
		lbl3.setBounds(5, 120, 100, 25);
		lbl3.removeMouseListener(lbl3.getMouseListeners()[0]);
		lbl3.addMouseListener(ml3Marked);
		
		lbl4.setText(" ");
		lbl4.setBounds(5, 120, 100, 25);
		lbl4.removeMouseListener(lbl4.getMouseListeners()[0]);
		lbl4.addMouseListener(ml4Marked);*/
		
		add(lbl1);
		add(lbl2);
		add(lbl3);
		add(lbl4);
		add(exit);
	}
}
