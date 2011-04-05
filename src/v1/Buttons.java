package v1;

import javax.swing.*;
import java.awt.event.*;


public class Buttons extends JPanel implements ActionListener{
	
	JLabel exit;
	JLabel lbl1;
	JLabel lbl2;
	JLabel lbl3;
	JLabel lbl4;
	int i=0;
	
	public Buttons(){
		exit = new JLabel("Exit");
		setBounds(700, 25, 100, 640);
		
		

		lbl1 = new JLabel("1 ");
		lbl2 = new JLabel("2 ");
		lbl3 = new JLabel("3 ");
		lbl4 = new JLabel("4 ");
		
		lbl1.setBounds(5, 120, 100, 25);
		
		lbl1.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				lbl1.setText("<html>" +
						"<img src=" + Buttons.class.getResource("graphics/meat.gif") +" />" +
						"&nbsp;Trallalla :)  "+ i +" </html>" +
						"");
				i++;
			}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {
			}
		});
		
		exit.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});

		lbl1.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 50));
		lbl2.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 50));
		lbl3.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 50));
		lbl4.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 50));
		exit.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 50));

		add(lbl1);
		add(lbl2);
		add(lbl3);
		add(lbl4);
		add(exit);
		
//		button2.setActionCommand("stop");
//		button2.addActionListener(this);
		
		this.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
	}
	
	public void actionPerformed(ActionEvent e) {
		String event = ((JButton)e.getSource()).getActionCommand();
//		if("KnappEn".equals(event)){
//			lbl1.setText("Hallo ja");
//		}
	}
}
