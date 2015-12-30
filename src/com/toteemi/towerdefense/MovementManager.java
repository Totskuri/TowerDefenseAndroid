package com.toteemi.towerdefense;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.MoveModifier;
import org.andengine.entity.sprite.Sprite;

public class MovementManager {
	
	float speed;
	Sprite creep;
	float x,y,gX1,gY1,gX2,gY2,gX3,gY3;
	int hitPoints, totalHitPoints;
	
	public MovementManager(float x, float y, float speed, final Sprite creep, int hitPoints){
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.creep = creep;
		this.hitPoints = hitPoints;
		this.totalHitPoints = hitPoints;
		calculateCoordinates();
	}
	
	public MovementManager(){
		
	}
	
	public void calculateCoordinates(){
		gX1 = x + (MainActivity.tileSize * 19);
		gY1 = y;
		gX2 = gX1;
		gY2 = y + (MainActivity.tileSize * 6);
		gX3 = gX2 - (MainActivity.tileSize * 19);
		gY3 = gY2;
	}
	
	
	public void creepMovement(){
		creep.registerEntityModifier(new MoveModifier(speed,x,gX1,y,gY1));
	}
	
	public void creepMovementCheck(final MovementManager MC){
		//health bars added here for now
		healthBars();
		if((creep.getX() == gX1) && (creep.getY() == gY1)){
    		creep.registerEntityModifier(new MoveModifier(speed,gX1,gX2,gY1,gY2));
    	}else if((creep.getX() == gX2) && (creep.getY() == gY2)){
    		creep.registerEntityModifier(new MoveModifier(speed,gX2,gX3,gY2,gY3){
    			
    			@Override
    			protected void onModifierFinished(IEntity pItem) {
    				UIManager.playerLives--;
    				FactoryManager.creepsToKill.add(creep);
    			super.onModifierFinished(pItem);
    			}
    			
    		});
    	}
	}
	
	public void healthBars(){
		//calculates which health bar to show and then creates it, happens every frame
		float healthBarX, healthBarY;
		int health = 0;
		healthBarX = creep.getX() + 3;
		healthBarY = creep.getY() - 3;
		if(hitPoints >= ((totalHitPoints/20)*19)){
			health = 10;
		}else if((hitPoints >= ((totalHitPoints/20)*17)) && (hitPoints < ((totalHitPoints/20)*19))){
			health = 9;
		}else if((hitPoints >= ((totalHitPoints/20)*15)) && (hitPoints < ((totalHitPoints/20)*17))){
			health = 8;
		}else if((hitPoints >= ((totalHitPoints/20)*13)) && (hitPoints < ((totalHitPoints/20)*15))){
			health = 7;
		}else if((hitPoints >= ((totalHitPoints/20)*11)) && (hitPoints < ((totalHitPoints/20)*13))){
			health = 6;
		}else if((hitPoints >= ((totalHitPoints/20)*9)) && (hitPoints < ((totalHitPoints/20)*11))){
			health = 5;
		}else if((hitPoints >= ((totalHitPoints/20)*7)) && (hitPoints < ((totalHitPoints/20)*9))){
			health = 4;
		}else if((hitPoints >= ((totalHitPoints/20)*5)) && (hitPoints < ((totalHitPoints/20)*7))){
			health = 3;
		}else if((hitPoints >= ((totalHitPoints/20)*3)) && (hitPoints < ((totalHitPoints/20)*5))){
			health = 2;
		}else if(hitPoints < ((totalHitPoints/20)*3)){
			health = 1;
		}
		FactoryManager.createHealthBar(healthBarX, healthBarY, health);
	}
	
	public Sprite getSprite(){
		return creep;
	}
	
	public void setSpriteNull(){
		creep = null;
	}
	
	public int getHitPoints(){
		return hitPoints;
	}
	
	public void setHitPoints(int decreaseHitPoints){
		this.hitPoints = hitPoints - decreaseHitPoints;
	}
	
}
