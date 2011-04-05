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
		
		labelsReset();
	}
	
	public void labelsReset(){
		lbl1.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 50));
		lbl2.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 50));
		lbl3.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 50));
		lbl4.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 50));

		lbl1.setText("1 ");
		lbl1.setBounds(5, 120, 100, 25);
		lbl1.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				labelsMarket();
			}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {
			}
		});
		lbl2.setText(" ");
		lbl2.setBounds(5, 120, 100, 25);
		lbl2.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {
			}
		});
		lbl3.setText(" ");
		lbl3.setBounds(5, 120, 100, 25);
		lbl3.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {
			}
		});
		lbl4.setText(" ");
		lbl4.setBounds(5, 120, 100, 25);
		lbl4.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {
			}
		});
		add(lbl1);
		add(lbl2);
		add(lbl3);
		add(lbl4);
		add(exit);
	}
	
	public void labelsMarket(){
		lbl1.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 50));
		lbl2.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 50));
		lbl3.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 50));
		lbl4.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 50));

		lbl1.setText("<html> kjøp " +
				"<img src="+ Status.class.getResource("graphics/meat.gif") + " /> ");
		lbl1.setBounds(5, 120, 100, 25);
		lbl1.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				p.setGull(p.getGull() - 20);
				p.setSoldater(p.getSoldater() + 10);
			}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {
			}
		});
		lbl2.setText(" ");
		lbl2.setBounds(5, 120, 100, 25);
		lbl2.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {
			}
		});
		lbl3.setText(" ");
		lbl3.setBounds(5, 120, 100, 25);
		lbl3.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {
			}
		});
		lbl4.setText(" ");
		lbl4.setBounds(5, 120, 100, 25);
		lbl4.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {
			}
		});
		add(lbl1);
		add(lbl2);
		add(lbl3);
		add(lbl4);
		add(exit);
	}
}
