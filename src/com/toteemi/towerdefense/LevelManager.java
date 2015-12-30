package com.toteemi.towerdefense;

public class LevelManager {
	
	/*
	 * GNT = grass normal tile
	 * SNT = sand normal tile
	 * SUL = sand upper left
	 * SUR = sand upper right
	 * SDL = sand down left
	 * SDR = sand down right
	 * SC1 = sand corner up right
	 * SC2 = sand corner up left
	 * SC3 = sand corner down right
	 * SC4 = sand corner down left
	 * SVN = sand vertical normal
	 * SVL = sand vertical left
	 * SVR = sand vertical right
	 * SHN = sand horizontal normal
	 * SHU = sand horizontal up
	 * SHD = sand horizontal down
	 * SPW = spawn tile
	 */
	
	public static int currentLevel;
	static int CAMERA_WIDTH = 800;
	static int CAMERA_HEIGHT = 480; 
	static int tileSize = 32;
	
	public static void levelGenerator(String[] level){
		//Calls the spawn function according to the given string of letters
		int x = 0, y = 0;
		
		for(int i = 0; i < level.length; i++){
			if(level[i] == "GNT"){
				FactoryManager.createGrassTile(x,y);
			}else if(level[i] == "SNT"){
				FactoryManager.createSandTile(x,y,"SNT");
			}else if(level[i] == "SPW"){
				FactoryManager.createSpawnTile(x,y);
			}else if(level[i] == "SUL"){
				FactoryManager.createSandTile(x,y,"SUL");
			}else if(level[i] == "SUR"){
				FactoryManager.createSandTile(x,y,"SUR");
			}else if(level[i] == "SDL"){
				FactoryManager.createSandTile(x,y,"SDL");
			}else if(level[i] == "SDR"){
				FactoryManager.createSandTile(x,y,"SDR");
			}else if(level[i] == "SC1"){
				FactoryManager.createSandTile(x,y,"SC1");
			}else if(level[i] == "SC2"){
				FactoryManager.createSandTile(x,y,"SC2");
			}else if(level[i] == "SC3"){
				FactoryManager.createSandTile(x,y,"SC3");
			}else if(level[i] == "SC4"){
				FactoryManager.createSandTile(x,y,"SC4");
			}else if(level[i] == "SVN"){
				FactoryManager.createSandTile(x,y,"SVN");
			}else if(level[i] == "SVL"){
				FactoryManager.createSandTile(x,y,"SVL");
			}else if(level[i] == "SVR"){
				FactoryManager.createSandTile(x,y,"SVR");
			}else if(level[i] == "SHN"){
				FactoryManager.createSandTile(x,y,"SHN");
			}else if(level[i] == "SHU"){
				FactoryManager.createSandTile(x,y,"SHU");
			}else if(level[i] == "SHD"){
				FactoryManager.createSandTile(x,y,"SHD");
			}
			
			
			if(x == (CAMERA_WIDTH - tileSize)){
				x = 0;
				y = y + tileSize;
			}else{
				x = x + tileSize;
			}
		}
		
	}
	
	static String[] levelOne = new String[] {
			"GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT",
			"GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT",
			"GNT","GNT","SPW","SPW","SHU","SHU","SHU","SHU","SHU","SHU","SHU","SHU","SHU","SHU","SHU","SHU","SHU","SHU","SHU","SHU","SHU","SHU","SUR","GNT","GNT",
			"GNT","GNT","SPW","SPW","SHD","SHD","SHD","SHD","SHD","SHD","SHD","SHD","SHD","SHD","SHD","SHD","SHD","SHD","SHD","SHD","SHD","SC4","SVR","GNT","GNT",
			"GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","SVL","SVR","GNT","GNT",
			"GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","SVL","SVR","GNT","GNT",
			"GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","SVL","SVR","GNT","GNT",
			"GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","SVL","SVR","GNT","GNT",
			"GNT","GNT","SUL","SHU","SHU","SHU","SHU","SHU","SHU","SHU","SHU","SHU","SHU","SHU","SHU","SHU","SHU","SHU","SHU","SHU","SHU","SC2","SVR","GNT","GNT",
			"GNT","GNT","SDL","SHD","SHD","SHD","SHD","SHD","SHD","SHD","SHD","SHD","SHD","SHD","SHD","SHD","SHD","SHD","SHD","SHD","SHD","SHD","SDR","GNT","GNT",
			"GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT",
			"GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT",
			"GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT"
	};
	
	//Need level specific information. Waves, gold, units and their paths etc.
	
	static String[] levelTwo = new String[] {
			"GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT",
			"GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT",
			"GNT","GNT","SNT","SNT","GNT","GNT","SNT","SNT","SNT","SNT","SNT","SNT","GNT","GNT","SNT","SNT","SNT","SNT","SNT","SNT","SNT","SNT","SNT","GNT","GNT",
			"GNT","GNT","SNT","SNT","GNT","GNT","SNT","SNT","SNT","SNT","SNT","SNT","GNT","GNT","SNT","SNT","SNT","SNT","SNT","SNT","SNT","SNT","SNT","GNT","GNT",
			"GNT","GNT","SNT","SNT","GNT","GNT","SNT","SNT","GNT","GNT","SNT","SNT","GNT","GNT","SNT","SNT","GNT","GNT","GNT","GNT","GNT","SNT","SNT","GNT","GNT",
			"GNT","GNT","SNT","SNT","GNT","GNT","SNT","SNT","GNT","GNT","SNT","SNT","GNT","GNT","SNT","SNT","GNT","GNT","GNT","GNT","GNT","SNT","SNT","GNT","GNT",
			"GNT","GNT","SNT","SNT","GNT","GNT","SNT","SNT","GNT","GNT","SNT","SNT","GNT","GNT","SNT","SNT","GNT","GNT","GNT","GNT","GNT","SNT","SNT","GNT","GNT",
			"GNT","GNT","SNT","SNT","GNT","GNT","SNT","SNT","GNT","GNT","SNT","SNT","GNT","GNT","SNT","SNT","GNT","GNT","GNT","GNT","GNT","SNT","SNT","GNT","GNT",
			"GNT","GNT","SNT","SNT","SNT","SNT","SNT","SNT","GNT","GNT","SNT","SNT","SNT","SNT","SNT","SNT","GNT","GNT","SNT","SNT","SNT","SNT","SNT","GNT","GNT",
			"GNT","GNT","SNT","SNT","SNT","SNT","SNT","SNT","GNT","GNT","SNT","SNT","SNT","SNT","SNT","SNT","GNT","GNT","SNT","SNT","SNT","SNT","SNT","GNT","GNT",
			"GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT",
			"GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT",
			"GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT","GNT"
	};
	
	public static String[] getLevelOne(){
		return levelOne;
	}
	
	public static String[] getLevelTwo(){
		return levelTwo;
	}
	
	public static int getCurrentLevel(){
		return currentLevel;
	}
	
	public static void setCurrentLevel(int level){
		currentLevel = level;
	}

}
