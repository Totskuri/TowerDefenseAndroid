package com.toteemi.towerdefense;

public class WaveManager {
	
	public static void spawnWave(int level, int nextWave){
		if(level == 1){
			if(nextWave == 1){
				spawnLevelOneWaveOne();
			}else if(nextWave == 2){
				spawnLevelOneWaveTwo();
			}else if(nextWave == 3){
				spawnLevelOneWaveThree();
			}
		}else if(level == 2){
			
		}
		
	}
	
	public static void spawnLevelOneWaveOne(){
		FactoryManager.spawnCreepBigHuman(104, 72, 10);
		//FactoryManager.spawnCreepHumanLevelOne(104, 72, 10);
		//FactoryManager.spawnCreepHumanLevelOne(104, 104, 10);
	}
	
	public static void spawnLevelOneWaveTwo(){
		FactoryManager.spawnCreepHumanLevelOne(112, 80, 10);
		FactoryManager.spawnCreepHumanLevelOne(112, 112, 10);
		FactoryManager.spawnCreepHumanLevelOne(80, 80, 10);
		FactoryManager.spawnCreepHumanLevelOne(80, 112, 10);
	}
	
	public static void spawnLevelOneWaveThree(){
		FactoryManager.spawnCreepHumanLevelOne(112, 80, 10);
		FactoryManager.spawnCreepHumanLevelOne(112, 112, 10);
		FactoryManager.spawnCreepHumanLevelOne(80, 80, 10);
		FactoryManager.spawnCreepHumanLevelOne(80, 112, 10);
	}

}
