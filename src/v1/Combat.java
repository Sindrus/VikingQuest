package v1;

import grensesnitt.Kampsystem;

public class Combat implements Kampsystem {

	public void normalCombat(Player player, Barbarian barbar) {
		while (player.getSoldater() > 0 && barbar.getSoldater() > 0){
			double random1 = Math.random();
			double random2 = Math.random();
			if (random1 > 0.5){
				player.addSoldater(player.getSoldater() - 1);
			}
			if (random2 > 0.5){
				barbar.addSoldater(player.getSoldater() - 1);
			}
		}
		if (player.getSoldater() == 0){
			player.setDead(true);
		} else if (barbar.getSoldater() == 0){
			player.addGull(barbar.getGull());
			player.addMat(barbar.getMat());
		}
	}

	public void villageCombar(Player player, Village village) {
		while (player.getSoldater() > 0 && village.getSoldater() > 0){
			double random1 = Math.random();
			double random2 = Math.random();
			if (random1 > 0.5){
				player.addSoldater(player.getSoldater() - 1);
			}
			if (random2 > 0.5){
				village.addSoldater(player.getSoldater() - 1);
			}
		}
		if (player.getSoldater() == 0){
			player.setDead(true);
		} else if (village.getSoldater() == 0){
			player.addGull(village.getGull());
			player.addMat(village.getMat());
		}
	}
}