package v1;

import javax.swing.*;
import java.awt.event.*;


public class Buttons extends JPanel implements ActionListener{
	
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JLabel exit;
	JLabel lbl1;
	int i=0;
	
	
	
	public Buttons(){
		button1 = new JButton("Knapp 1");
		button2 = new JButton("Knapp 2");
		button3 = new JButton("Knapp 3");
		button4 = new JButton("Knapp 4");
		exit = new JLabel("Exit");
		button1.setSize(100, 25);
		button2.setSize(100, 25);
		button3.setSize(100, 25);
		button4.setSize(100, 25);
		setBounds(700, 25, 100, 640);
		
		

		lbl1 = new JLabel("Hei hei");
		lbl1.setBounds(5, 120, 100, 25);
		
//	Trallalla: " + i + "
		
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
		
		
		
		lbl1.setText(" ");
		
		lbl1.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
		exit.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
		
		add(button1);
		add(lbl1);
		add(button2);
		add(button3);
		add(button4);
		add(exit);
		
		button1.setActionCommand("KnappEn");
		button1.addActionListener(this);
		
		button2.setActionCommand("stop");
		button2.addActionListener(this);
		button3.setActionCommand("start");
		button3.addActionListener(this);
		button4.setActionCommand("navn");
		button4.addActionListener(this);
		
		
		this.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String event = ((JButton)e.getSource()).getActionCommand();
		if("KnappEn".equals(event)){
			lbl1.setText("Hallo ja");
		}
		else if ("stop".equals(event)){
			Engine.stopp();
			System.out.println("Stoppet");
		}
		else if("start".equals(event)){
			Engine.start();
			System.out.println("Startet");
		}else if("navn".equals(event)){
			button4.setText("Trykket");
		}
	}
}
