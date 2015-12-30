package com.toteemi.towerdefense;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.MoveModifier;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.math.MathUtils;

public class FactoryManager {
	
	private static final FactoryManager INSTANCE = new FactoryManager();
	
	static int CAMERA_WIDTH = 800;
	static int CAMERA_HEIGHT = 480; 
	static int tileSize = 32;
	static int framesForReloadArrow = 180;
	static int framesForReloadCannon = 300;
	static int framesForReloadLightning = 120;
	static int nextWave = 1;
	
	static Sprite sT; //sandtile
	static Sprite gT; //grasstile
	static Sprite pT; //spawntile
	static Sprite aTower;
	static Sprite cTower;
	static Sprite fTower;
	static Sprite lTower;
	static Sprite cannonball;
	static Sprite fireTip;
	static Sprite fireTail;
	static Sprite lightning;
	static Sprite lightningTail;
	static Sprite exitLevelScreen;
	static Sprite exitLevelScreenYes;
	static Sprite exitLevelScreenNo;
	static Sprite loadingBackground;
	static Sprite healthBar;
	static AnimatedSprite fireAnimation;
	
	static float arrowSpeed = 0.3f;
	static float cannonballSpeed = 0.5f;
	static float angle;
	static float range;
	static float arrowTowerRange = 250;
	static float cannonTowerRange = 150;
	static float fireTowerRange = 80;
	static float lightningTowerRange = 200;
	
	static boolean readyToStartWave = true;
	static boolean canBuildTowers = false;
	static boolean removeDeathAnimations = false;
	
	private FactoryManager(){
		
	}
	
	static Map<Integer, Boolean> containsTower = new HashMap<Integer, Boolean>();
	static Map<Sprite, Integer> reload = new HashMap<Sprite, Integer>();
	
	static ArrayList<Sprite> arrayArrowTower = new ArrayList<Sprite>();
	static ArrayList<Sprite> arrayCannonTower = new ArrayList<Sprite>();
	static ArrayList<Sprite> arrayFireTower = new ArrayList<Sprite>();
	static ArrayList<Sprite> arrayLightningTower = new ArrayList<Sprite>();
	static ArrayList<Sprite> creepsToKill = new ArrayList<Sprite>();
	static ArrayList<Sprite> ammoToKill = new ArrayList<Sprite>();
	static ArrayList<Sprite> deathAnimations = new ArrayList<Sprite>();
	static ArrayList<Sprite> arrayGrassTiles = new ArrayList<Sprite>();
	static ArrayList<Sprite> arraySandTiles = new ArrayList<Sprite>();
	static ArrayList<Sprite> arraySpawnTiles = new ArrayList<Sprite>();
	static ArrayList<Sprite> arrayHealthBar = new ArrayList<Sprite>();
	
	static MovementManager MM;
	static ArrayList<MovementManager> arrayMM = new ArrayList<MovementManager>();
	
	public static void createGrassTile(final int x, final int y){
		gT = new Sprite(x,y,ResourceManager.getGrassTileTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager())
		{
		    @Override
		    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y) 
		    {
		        if (pSceneTouchEvent.isActionDown())
		        {
		        	int placement = (x/32) + ((y/32)*25);
		        	//check if tile already contains a tower
		        	if(containsTower.containsKey(placement)){
		        		if(!containsTower.get(placement)){
		        			if(MainActivity.chosenTower == "arrow"){
		        				if(UIManager.playerGold >= 100){
		        					INSTANCE.createArrowTower(x,y);
						        	containsTower.put(placement, true);
						        	UIManager.playerGold = UIManager.playerGold - 100;
		        				}else{
		        					//not enough gold huuto
		        				}
				        	}else if(MainActivity.chosenTower == "cannon"){
				        		if(UIManager.playerGold >= 120){
				        			INSTANCE.createCannonTower(x,y);
					        		containsTower.put(placement, true);
						        	UIManager.playerGold = UIManager.playerGold - 120;
		        				}else{
		        					//not enough gold huuto
		        				}
				        	}else if(MainActivity.chosenTower == "fire"){
				        		if(UIManager.playerGold >= 150){
				        			INSTANCE.createFireTower(x,y);
					        		containsTower.put(placement, true);
						        	UIManager.playerGold = UIManager.playerGold - 150;
		        				}else{
		        					//not enough gold huuto
		        				}
				        	}else if(MainActivity.chosenTower == "lightning"){
				        		if(UIManager.playerGold >= 180){
				        			INSTANCE.createLightningTower(x,y);
					        		containsTower.put(placement, true);
						        	UIManager.playerGold = UIManager.playerGold - 180;
		        				}else{
		        					//not enough gold huuto
		        				}
				        	}
		        		}else{
		        			for(int jes = 5;jes<5;jes++){
		        				
		        			}
		        		}
		        	}else{
		        		if(MainActivity.chosenTower == "arrow"){
	        				if(UIManager.playerGold >= 100){
	        					INSTANCE.createArrowTower(x,y);
					        	containsTower.put(placement, true);
					        	UIManager.playerGold = UIManager.playerGold - 100;
	        				}else{
	        					//not enough gold huuto
	        				}
			        	}else if(MainActivity.chosenTower == "cannon"){
			        		if(UIManager.playerGold >= 120){
			        			INSTANCE.createCannonTower(x,y);
				        		containsTower.put(placement, true);
					        	UIManager.playerGold = UIManager.playerGold - 120;
	        				}else{
	        					//not enough gold huuto
	        				}
			        	}else if(MainActivity.chosenTower == "fire"){
			        		if(UIManager.playerGold >= 150){
			        			INSTANCE.createFireTower(x,y);
				        		containsTower.put(placement, true);
					        	UIManager.playerGold = UIManager.playerGold - 150;
	        				}else{
	        					//not enough gold huuto
	        				}
			        	}else if(MainActivity.chosenTower == "lightning"){
			        		if(UIManager.playerGold >= 180){
			        			INSTANCE.createLightningTower(x,y);
				        		containsTower.put(placement, true);
					        	UIManager.playerGold = UIManager.playerGold - 180;
	        				}else{
	        					//not enough gold huuto
	        				}
			        	}
		        	}
		        	
		        }
		        return true;
		    };
		};
		MainActivity.getScene().registerTouchArea(gT);
		MainActivity.getScene().attachChild(gT);
		arrayGrassTiles.add(gT);
	}
	
	public static void startNextWave(){
		WaveManager.spawnWave(LevelManager.getCurrentLevel(), nextWave);
		nextWave++;
		readyToStartWave = false;
		MainActivity.getScene().detachChild(UIManager.startWaveSprite);
	}
	
	public static void generateExitLevelScreen(){
		for(int i = 0;i<arrayGrassTiles.size();i++){
			MainActivity.getScene().unregisterTouchArea(arrayGrassTiles.get(i));
		}
		exitLevelScreen = new Sprite(200,120,ResourceManager.getExitLevelScreenTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		
		exitLevelScreenYes = new Sprite(248,256,ResourceManager.getQuitGameScreenYesTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager())
		{
		    @Override
		    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y) 
		    {
		        if (pSceneTouchEvent.isActionDown())
		        {
		        	//Exits to main menu
		        	loadingScreenToMainMenu();
		        }
		        return true;
		    };
		};
		
		exitLevelScreenNo = new Sprite(424,256,ResourceManager.getQuitGameScreenNoTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager())
		{
		    @Override
		    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y) 
		    {
		        if (pSceneTouchEvent.isActionDown())
		        {
		        	//goes back to game
		        	killExitLevelScreen();
		        }
		        return true;
		    };
		};
		
		MainActivity.getScene().attachChild(exitLevelScreen);
		MainActivity.getScene().registerTouchArea(exitLevelScreenYes);
		MainActivity.getScene().attachChild(exitLevelScreenYes);
		MainActivity.getScene().registerTouchArea(exitLevelScreenNo);
		MainActivity.getScene().attachChild(exitLevelScreenNo);
	}
	
	public static void killExitLevelScreen(){
		MainActivity.getScene().detachChild(exitLevelScreen);
		MainActivity.getScene().unregisterTouchArea(exitLevelScreenYes);
		MainActivity.getScene().detachChild(exitLevelScreenYes);
		MainActivity.getScene().unregisterTouchArea(exitLevelScreenNo);
		MainActivity.getScene().detachChild(exitLevelScreenNo);
		
		for(int i = 0;i<arrayGrassTiles.size();i++){
			MainActivity.getScene().registerTouchArea(arrayGrassTiles.get(i));
		}
	}
	
	public static void killGame(){
		//kill tiles
		for(int i = 0;i<arrayGrassTiles.size();i++){
			MainActivity.getScene().unregisterTouchArea(arrayGrassTiles.get(i));
			MainActivity.getScene().detachChild(arrayGrassTiles.get(i));
		}
		for(int i = 0;i<arraySandTiles.size();i++){
			MainActivity.getScene().unregisterTouchArea(arraySandTiles.get(i));
			MainActivity.getScene().detachChild(arraySandTiles.get(i));
		}
		for(int i = 0;i<arraySpawnTiles.size();i++){
			MainActivity.getScene().unregisterTouchArea(arraySpawnTiles.get(i));
			MainActivity.getScene().detachChild(arraySpawnTiles.get(i));
		}
		
		//kill towers
		for(int i = 0;i<arrayArrowTower.size();i++){
			MainActivity.getScene().unregisterTouchArea(arrayArrowTower.get(i));
			MainActivity.getScene().detachChild(arrayArrowTower.get(i));
		}
		for(int i = 0;i<arrayCannonTower.size();i++){
			MainActivity.getScene().unregisterTouchArea(arrayCannonTower.get(i));
			MainActivity.getScene().detachChild(arrayCannonTower.get(i));
		}
		
		//kill creeps
		for(int i = 0;i<creepsToKill.size();i++){
			MainActivity.getScene().detachChild(creepsToKill.get(i));
		}
		
		//kill ammo
		for(int i = 0;i<ammoToKill.size();i++){
			MainActivity.getScene().detachChild(ammoToKill.get(i));
		}
		
		//kill death animations
		for(int i = 0;i<deathAnimations.size();i++){
			MainActivity.getScene().detachChild(deathAnimations.get(i));
		}
		
		//kill buttons
		UIManager.killUI();
		
		//empty arrays
		clearArrays();
		
		//reset values
		readyToStartWave = true;
		canBuildTowers = false;
		removeDeathAnimations = false;
		nextWave = 1;
		UIManager.playerLives = 30;
		
		//kill main loop
		MainActivity.getScene().unregisterUpdateHandler(ResourceManager.getInstance().getActivity().getMainLoop());
	}
	
	public static void loadingScreenToMainMenu(){
		/* 1)display loading screen for at least one frame
		 * 2)unload game resources
		 * 3)load menu resources wooh
		 */
		killExitLevelScreen();
		loadingBackground = new Sprite(0,0,ResourceManager.getLoadingBackgroundTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		MainActivity.getScene().attachChild(loadingBackground);
		
		killGame();
		ResourceManager.unloadGame();
		
		ResourceManager.getInstance().loadMainMenu();
		MainMenu.generateMainMenu();
		
		MainMenu.sceneGame = false;
		MainMenu.sceneMainMenu = true;
		MainActivity.getScene().detachChild(loadingBackground);
	}
	
	public static void createSandTile(int x, int y, String kuvio){
		sT = new Sprite(x, y,ResourceManager.getSandTileTextureRegion(kuvio),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		MainActivity.getScene().attachChild(sT);
		arraySandTiles.add(sT);
	}
	
	public static void createSpawnTile(int x, int y){
		pT = new Sprite(x, y,ResourceManager.getSpawnTileTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		MainActivity.getScene().attachChild(pT);
		arraySpawnTiles.add(pT);
	}
	
	private void createArrowTower(int x, int y){
		aTower = new Sprite(x,y,ResourceManager.getArrowTowerTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		MainActivity.getScene().attachChild(aTower);
		ResourceManager.placeTowerSound.play();
		arrayArrowTower.add(aTower);
	}
	
	private void createCannonTower(int x, int y){
		cTower = new Sprite(x,y,ResourceManager.getCannonTowerTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		MainActivity.getScene().attachChild(cTower);
		ResourceManager.placeTowerSound.play();
		arrayCannonTower.add(cTower);
	}
	
	private void createFireTower(int x, int y){
		fTower = new Sprite(x,y,ResourceManager.getFireTowerTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		MainActivity.getScene().attachChild(fTower);
		ResourceManager.placeTowerSound.play();
		arrayFireTower.add(fTower);
	}
	
	private void createLightningTower(int x, int y){
		lTower = new Sprite(x,y,ResourceManager.getLightningTowerTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		MainActivity.getScene().attachChild(lTower);
		ResourceManager.placeTowerSound.play();
		arrayLightningTower.add(lTower);
	}
	
	public static void spawnCreepHumanLevelOne(float x, float y, float speed){
		Sprite cH = new Sprite(x,y,ResourceManager.getCreepHumanTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		MainActivity.getScene().attachChild(cH);
		MM = new MovementManager(x,y,speed,cH, 100);
		MM.creepMovement();
		arrayMM.add(MM);
	}
	
	public static void spawnCreepBigHuman(float x, float y, float speed){
		AnimatedSprite bigHuman = new AnimatedSprite(x, y, ResourceManager.getCreepBigHumanNormalTiledTextureRegion(), ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		MainActivity.getScene().attachChild(bigHuman);
		bigHuman.animate(240);
		MM = new MovementManager(x,y,speed,bigHuman, 100);
		MM.creepMovement();
		arrayMM.add(MM);
	}
	
	public static void createHealthBar(float x, float y, int health){
		if(health == 10){
			healthBar = new Sprite(x,y,ResourceManager.getHealthBarTextureRegion(10),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		}else if(health == 9){
			healthBar = new Sprite(x,y,ResourceManager.getHealthBarTextureRegion(9),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		}else if(health == 8){
			healthBar = new Sprite(x,y,ResourceManager.getHealthBarTextureRegion(8),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		}else if(health == 7){
			healthBar = new Sprite(x,y,ResourceManager.getHealthBarTextureRegion(7),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		}else if(health == 6){
			healthBar = new Sprite(x,y,ResourceManager.getHealthBarTextureRegion(6),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		}else if(health == 5){
			healthBar = new Sprite(x,y,ResourceManager.getHealthBarTextureRegion(5),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		}else if(health == 4){
			healthBar = new Sprite(x,y,ResourceManager.getHealthBarTextureRegion(4),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		}else if(health == 3){
			healthBar = new Sprite(x,y,ResourceManager.getHealthBarTextureRegion(3),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		}else if(health == 2){
			healthBar = new Sprite(x,y,ResourceManager.getHealthBarTextureRegion(2),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		}else if(health == 1){
			healthBar = new Sprite(x,y,ResourceManager.getHealthBarTextureRegion(1),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		}
		MainActivity.getScene().attachChild(healthBar);
		arrayHealthBar.add(healthBar);
	}
	
	public static void killHealthBar(){
		for(int i = 0; i<arrayHealthBar.size();i++){
			MainActivity.getScene().detachChild(arrayHealthBar.get(i));
		}
		arrayHealthBar.clear();
	}
	
	public static void findTargetAndFire(){
		//Will only run if there are creeps in play
		if(arrayMM.size() > 0){
		
		//Arrow tower
		for(int i = 0; i<arrayArrowTower.size();i++){
			Sprite closest = findClosestCreep(arrayArrowTower.get(i));
				if(reload.containsKey(arrayArrowTower.get(i))){
					if(reload.get(arrayArrowTower.get(i)) == framesForReloadArrow){
						if (range < arrowTowerRange){
							fireArrowTower(arrayArrowTower.get(i), closest);
							reload.put(arrayArrowTower.get(i),0);
						}
					}else{
						int value = reload.get(arrayArrowTower.get(i));
						value++;
						reload.put(arrayArrowTower.get(i), value);
					}
				}else{
					if (range < arrowTowerRange){
						fireArrowTower(arrayArrowTower.get(i), closest);
						reload.put(arrayArrowTower.get(i),0);
					}
				}
		}
			//Cannon tower
			for(int j = 0; j<arrayCannonTower.size();j++){
					Sprite closest = findClosestCreep(arrayCannonTower.get(j));
						if(reload.containsKey(arrayCannonTower.get(j))){
							if(reload.get(arrayCannonTower.get(j)) == framesForReloadCannon){
								if (range < cannonTowerRange){
									fireCannonTower(arrayCannonTower.get(j), closest);
									reload.put(arrayCannonTower.get(j),0);
								}
							}else{
								int value = reload.get(arrayCannonTower.get(j));
								value++;
								reload.put(arrayCannonTower.get(j), value);
							}
						}else{
							if (range < cannonTowerRange){
								fireCannonTower(arrayCannonTower.get(j), closest);
								reload.put(arrayCannonTower.get(j),0);
							}
						}
				}
			
			//Fire Tower
			for(int i = 0; i<arrayFireTower.size();i++){
				Sprite closest = findClosestCreep(arrayFireTower.get(i));
					if (range < fireTowerRange){
						//needs to remove old fire when drawing new
						fireFireTower(arrayFireTower.get(i), closest);
					}
			}
			
			//Lightning Tower
			for(int i = 0; i<arrayLightningTower.size();i++){
				Sprite closest = findClosestCreep(arrayLightningTower.get(i));
					if(reload.containsKey(arrayLightningTower.get(i))){
						if(reload.get(arrayLightningTower.get(i)) == framesForReloadLightning){
							if (range < lightningTowerRange){
								fireLightningTower(arrayLightningTower.get(i), closest);
								reload.put(arrayLightningTower.get(i),0);
							}
						}else{
							int value = reload.get(arrayLightningTower.get(i));
							value++;
							reload.put(arrayLightningTower.get(i), value);
						}
					}else{
						if (range < lightningTowerRange){
							fireLightningTower(arrayLightningTower.get(i), closest);
							reload.put(arrayLightningTower.get(i),0);
						}
					}
			}
			}
	}
	
	public static Sprite findClosestCreep(Sprite tower){
		//declare arrays
		Map<Float, Sprite> differences = new HashMap<Float, Sprite>();
		ArrayList<Sprite> arraySprites = new ArrayList<Sprite>();
		ArrayList<Float> arrayTX = new ArrayList<Float>();
		ArrayList<Float> arrayTY = new ArrayList<Float>();
		//calculate sprite positions
		float towerX = tower.getX() + 16;
		float towerY = tower.getY() + 16;
		for(int i = 0;i<arrayMM.size();i++){
			arraySprites.add(arrayMM.get(i).getSprite());
			arrayTX.add(arrayMM.get(i).getSprite().getX() + 16);
			arrayTY.add(arrayMM.get(i).getSprite().getY() + 16);
		}
		//add differences to array
		float[] sortValues = new float[arrayTX.size()];
		for(int j = 0;j<arrayTX.size();j++){
			 Sprite s = arraySprites.get(j);
			 float cX = (arrayTX.get(j) - towerX);
			 float cY = (arrayTY.get(j) - towerY);
			 //pythagorean theorem
			 float pythagora = (float) Math.sqrt((Math.pow(cX, 2f))+(Math.pow(cY, 2f)));
			 sortValues[j] = pythagora;
			 differences.put(pythagora, s);
		}
		//Return closest creep
		Arrays.sort(sortValues);
		range = sortValues[0];
		Sprite closestCreep = differences.get(range);
		//tower rotation
		updateTowerRotation(closestCreep, tower);
			//Empty arrays before return
			differences.clear();
			arraySprites.clear();
			arrayTX.clear();
			arrayTY.clear();
		
		return closestCreep;
	}
	
	public static void updateTowerRotation(Sprite closest, Sprite tower){
		//calculated every loop
		float towerX = tower.getX();
		float towerY = CAMERA_HEIGHT - tower.getY();
		float cX = closest.getX();
		float cY = closest.getY();
		float closestCreepX = cX - towerX;
		float closestCreepY = (CAMERA_HEIGHT - cY) - towerY;
		float tanAngle = (float)Math.atan2(closestCreepX,closestCreepY);
		angle = MathUtils.radToDeg((float) (tanAngle - Math.PI));
		tower.setRotation(angle);
	}
	
	public static void fireArrowTower(final Sprite tower, final Sprite target){
			final Sprite arrow = new Sprite(tower.getX(),tower.getY(),ResourceManager.getArrowTowerAmmoTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
			MainActivity.getScene().attachChild(arrow);
			arrow.setRotation(angle);
			arrow.registerEntityModifier(new MoveModifier(arrowSpeed,tower.getX(),target.getX(),tower.getY(),target.getY()){
				
				@Override
				protected void onModifierFinished(IEntity pItem) {
					ammoToKill.add(arrow);
					creepHit(target, 40);
				super.onModifierFinished(pItem);
				}

			});
	}
	
	public static void fireCannonTower(final Sprite tower, final Sprite target){
		cannonball = new Sprite(tower.getX(),tower.getY(),ResourceManager.getCannonTowerAmmoTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		MainActivity.getScene().attachChild(cannonball);
		cannonball.setRotation(angle);
		cannonball.registerEntityModifier(new MoveModifier(cannonballSpeed,tower.getX(),target.getX(),tower.getY(),target.getY()){
			
			@Override
			protected void onModifierFinished(IEntity pItem) {
				ammoToKill.add(cannonball);
				creepHit(target, 40);
				inflictSplashDamage(target, 100, 20);
			super.onModifierFinished(pItem);
			}
			
		});
	}
	
	public static void inflictSplashDamage(final Sprite target, float splashRange, int splashDamage){
		float targetX = target.getX();
		float targetY = target.getY();
		
		for(int i = 0; i < arrayMM.size();i++){
			float differenceX = targetX - arrayMM.get(i).getSprite().getX();
			float differenceY = targetY - arrayMM.get(i).getSprite().getY();
			float pythagora = (float) Math.sqrt((Math.pow(differenceX, 2f))+(Math.pow(differenceY, 2f)));
			if(pythagora <= splashRange){
				creepHit(arrayMM.get(i).getSprite(), splashDamage);
			}
		}
	}
	
	public static void fireFireTower(final Sprite tower, final Sprite target){
		fireAnimation = new AnimatedSprite(tower.getX(),tower.getY(), ResourceManager.getFireAnimationTiledTextureRegion(), ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		MainActivity.getScene().attachChild(fireAnimation);
		fireAnimation.setRotation(angle);
		fireAnimation.animate(20);
	}
	
	public static void createFireTip(final Sprite tower, int difference){
		fireTip = new Sprite(tower.getX(),tower.getY(),ResourceManager.getFireTipTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		MainActivity.getScene().attachChild(fireTip);
		fireTip.setRotation(angle);
	}
	
	public static void createFireTail(final Sprite tower, int choice){
		fireTail = new Sprite(tower.getX(),tower.getY(),ResourceManager.getFireTailTextureRegion(choice),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		MainActivity.getScene().attachChild(fireTail);
		fireTail.setRotation(angle);
	}
	
	public static void fireLightningTower(final Sprite tower, final Sprite target){
		//calculate difference between tower and target
		float cX = (target.getX() - tower.getX());
		float cY = (target.getY() - tower.getY());
		int length = (int) Math.sqrt((Math.pow(cX, 2f))+(Math.pow(cY, 2f)));
		
		//need to spawn the lightning sprite that is corresponding the length in pixels
		//if over 32 --> add shorter one to make it longer
		if(length <= 32){
			lightning = new Sprite(tower.getX(),tower.getY(),ResourceManager.getLightningTowerAmmoTextureRegion(32),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
			MainActivity.getScene().attachChild(lightning);
			lightning.setRotation(angle);
		}else if((length > 32) && (length <= 64)){
			lightning = new Sprite(tower.getX(),tower.getY(),ResourceManager.getLightningTowerAmmoTextureRegion(32),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
			MainActivity.getScene().attachChild(lightning);
			lightning.setRotation(angle);
			lightningTail = new Sprite(tower.getX() + 32,tower.getY() + 32,ResourceManager.getLightningTowerAmmoTextureRegion(length - 32),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
			MainActivity.getScene().attachChild(lightningTail);
			lightningTail.setRotation(angle);
		}
		
	}
	
	public static void lightningJumps(final Sprite target){
		
	}
	
	public static void creepHit(Sprite target, int damage){
		//decreases creep hp
		for(int i = 0; i<arrayMM.size();i++){
			if(arrayMM.get(i).getSprite() == target){
				arrayMM.get(i).setHitPoints(damage);
			}
		}
	}
	
	public static void checkForCreepDeaths(){
		//kills any creeps that have hp 0 or under
		for(int i = 0; i<arrayMM.size();i++){
			if(arrayMM.get(i).getHitPoints() <= 0){
				UIManager.addPlayerGold(20);
				UIManager.setPlayerScore(100);
				creepsToKill.add(arrayMM.get(i).getSprite());
			}
		}
	}
	
	public static void creepKill(){
		//kills creep = detach sprite and remove from arrayMM
		int number = 0;
		float deathX, deathY;
		for(int i = 0; i<creepsToKill.size();i++){
			deathX = creepsToKill.get(i).getX();
			deathY = creepsToKill.get(i).getY();
			MainActivity.getScene().detachChild(creepsToKill.get(i));
			creepHumanDeath(deathX, deathY);
			number = i;
			for(int j = 0; j<arrayMM.size();j++){
				if(arrayMM.get(j).getSprite() == creepsToKill.get(number)){
					arrayMM.remove(j);
				}
			}
		}
		arrayMM.removeAll(creepsToKill);
		creepsToKill.clear();
	}
	
	public static void ammoKill(){
		for(int i = 0; i<ammoToKill.size();i++){
			MainActivity.getScene().detachChild(ammoToKill.get(i));
		}
		ammoToKill.clear();
	}
	
	public static void deathAnimationsKill(){
		//not working
		for(int i = 0; i<deathAnimations.size();i++){
			MainActivity.getScene().detachChild(deathAnimations.get(i));
		}
		deathAnimations.clear();
		removeDeathAnimations = false;
	}
	
	public static void creepHumanDeath(float x, float y){
		Sprite creepHumanDeathSprite = new Sprite(x, y,ResourceManager.getCreepHumanDeathTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		MainActivity.getScene().attachChild(creepHumanDeathSprite);
		deathAnimations.add(creepHumanDeathSprite);
	}
	
	public static void clearArrays(){
		containsTower.clear();
		reload.clear();
		
		arrayArrowTower.clear();
		arrayCannonTower.clear();
		arrayFireTower.clear();
		arrayLightningTower.clear();
		creepsToKill.clear();
		ammoToKill.clear();
		deathAnimations.clear();
		arrayGrassTiles.clear();
		arraySandTiles.clear();
		arraySpawnTiles.clear();
		arrayHealthBar.clear();
		
		arrayMM.clear();
	}
	
}
