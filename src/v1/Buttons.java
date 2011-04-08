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
	MouseListener ml1Reset;
	MouseListener ml1Marked;
	MouseListener ml2Reset;
	MouseListener ml2Marked;
	MouseListener ml3Reset;
	MouseListener ml3Marked;
	MouseListener ml4Reset;
	MouseListener ml4Marked;
	
	public Buttons(Player player){
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
		
/*
 * ==Initialiserer de forskjellige mouseListener måtene==		
 */
	//	Nullstiller
		ml1Reset = new MouseListener(){
			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		};
		ml2Reset = new MouseListener(){
			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		};
		ml3Reset = new MouseListener(){
			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		};
		ml4Reset = new MouseListener(){
			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		};
	//	For Markeder
		ml1Marked = new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				p.addGull(-20);
				p.addMat(10);
			}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		};
		ml2Marked = new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				p.addGull(-20);
				p.addSoldater(10);
			}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		};
		
		lbl1.addMouseListener(ml1Reset);
		lbl2.addMouseListener(ml2Reset);
		lbl3.addMouseListener(ml3Reset);
		lbl4.addMouseListener(ml4Reset);
		

		lbl1.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 50));
		lbl2.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 50));
		lbl3.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 50));
		lbl4.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 50));
		
		labelsReset();
		add(exit);
	}
	
	public void labelsReset(){
		
		lbl1.setText(" ");
		lbl1.setBounds(5, 120, 100, 25);
		lbl1.removeMouseListener(lbl1.getMouseListeners()[0]);
		lbl1.addMouseListener(ml1Reset);
		
		lbl2.setText(" ");
		lbl2.setBounds(5, 120, 100, 25);
		lbl2.removeMouseListener(lbl2.getMouseListeners()[0]);
		lbl2.addMouseListener(ml2Reset);
		
		lbl3.setText(" ");
		lbl3.setBounds(5, 120, 100, 25);
		lbl3.removeMouseListener(lbl3.getMouseListeners()[0]);
		lbl3.addMouseListener(ml3Reset);
		
		lbl4.setText(" ");
		lbl4.setBounds(5, 120, 100, 25);
		lbl4.removeMouseListener(lbl4.getMouseListeners()[0]);
		lbl4.addMouseListener(ml4Reset);
		
		add(lbl1);
		add(lbl2);
		add(lbl3);
		add(lbl4);
		add(exit);
	}
	
	public void labelsMarket(){
		
		lbl1.setText("<html> kjøp " +
				"<img src="+ Status.class.getResource("graphics/meat.gif") + " /> ");
		lbl1.setBounds(5, 120, 100, 25);
		lbl1.removeMouseListener(lbl1.getMouseListeners()[0]);
		lbl1.addMouseListener(ml1Marked);
		
		lbl2.setText("<html> kjøp " +
				"<img src="+ Status.class.getResource("graphics/statusViking.gif") + " /> ");
		lbl2.setBounds(5, 120, 100, 25);
		lbl2.removeMouseListener(lbl2.getMouseListeners()[0]);
		lbl2.addMouseListener(ml2Marked);
		
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
