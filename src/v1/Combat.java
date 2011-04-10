package v1;

import java.applet.Applet;
import java.applet.AudioClip;

import grensesnitt.Kampsystem;

public class Combat implements Kampsystem {
	
	public void normalCombat(Player player, Barbarian barbar) {
		playSound();
		
		while (player.getSoldater() > 0 && barbar.getSoldater() > 0){
			double random1 = Math.random();
			double random2 = Math.random();
			if (random1 > 0.5){
				player.addSoldater(-1);
			}
			if (random2 > 0.5){
				barbar.addSoldater(-1);
			}
		}
		if (player.getSoldater() == 0){
			player.setDead(true);
		} else if (barbar.getSoldater() == 0){
			player.addGull(barbar.getGull());
			player.addMat(barbar.getMat());
		}
	}
	
	public void playSound(){
		AudioClip fight = Applet.newAudioClip(getClass().getResource("graphics/fight.wav"));
		fight.play();
	}
	
	public void villageCombar(Player player, Village village) {
		playSound();
		
		while (player.getSoldater() > 0 && village.getSoldater() > 0){
			double random1 = Math.random();
			double random2 = Math.random();
			if (random1 > 0.5){
				player.addSoldater(-1);
			}
			if (random2 > 0.5){
				village.addSoldater(-1);
			}
		}
		if (player.getSoldater() == 0){
			player.setDead(true);
		} else if (village.getSoldater() == 0){
			player.addGull(village.getGull());
			player.addMat(village.getMat());
			village.setDestroyed(true);
		}
	}
}