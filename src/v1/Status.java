package v1;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Status extends JPanel{
	
	JLabel food;
	JLabel gold;
	JLabel soldiers;
	Player play;
	
	public Status(Player p){
		play = p;
		food = new JLabel();
		gold = new JLabel();
		soldiers = new JLabel();
		
		setBounds(0, 0, 800, 25);
		food.setSize(200, 25);
		
	/*	food.setText("<html><img src=" + Status.class.getResource("graphics/test.gif") +" /> " + 
				"Food: " + Integer.toString(play.getFood())+" </html>" +
				"");*/
		
		food.setText("<html><img src=\"graphics/test.gif\" /> " + 
				"Food: " + Integer.toString(play.getMat())+" </html>" +
				"");
		
		food.setText("Food: " + Integer.toString(play.getMat()));
		food.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
		gold.setSize(200, 25);
		gold.setText("Gold: " + Integer.toString(play.getGull()));
		gold.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
		soldiers.setSize(200, 25);
		soldiers.setText("Soldiers: " + Integer.toString(play.getSoldater()));
		soldiers.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
		
		add(food);
		add(gold);
		add(soldiers);
	}
	
	

}
