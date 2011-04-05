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
		
		updateStatus();
	}
	
	public void updateStatus(){
		food.setSize(200, 25);
		
		food.setText("<html>" +
				"<img src="+ Status.class.getResource("graphics/meat.gif") + " /> " + 
				"&nbsp;Food: " + Integer.toString(play.getMat())+" </html>" +
				"");
		food.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
		
		gold.setSize(200, 25);
		gold.setText("<html>" +
				"<img src="+ Status.class.getResource("graphics/gold.gif") + " /> " + 
				"&nbsp;Gull: " + Integer.toString(play.getGull())+" </html>" +
				"");
		gold.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
		
		soldiers.setSize(200, 25);
		soldiers.setText("<html>" +
				"<img src="+ Status.class.getResource("graphics/statusViking.gif") + " /> " + 
				"&nbsp;Soldater: " + Integer.toString(play.getSoldater())+" </html>" +
				"");
		soldiers.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
		
		add(food);
		add(gold);
		add(soldiers);
	}

}
