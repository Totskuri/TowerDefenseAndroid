package com.toteemi.towerdefense;

import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.input.touch.TouchEvent;

public class UIManager {
	
	public static Sprite arrowTowerButton;
	public static Sprite cannonTowerButton;
	public static Sprite fireTowerButton;
	public static Sprite lightningTowerButton;
	public static Sprite startWaveSprite;
	public static Sprite textBoxSprite;
	
	public static int playerLives = 30;
	public static int playerGold;
	public static int playerScore;
	
	static Text lives;
	static Text gold;
	static Text score;
	static Text textBoxText;
	static Text tapTextBoxReminder;
	
	static boolean removeTextBox = false;
	
	public static void generateUI(int level){
		createArrowTowerButton();
		createCannonTowerButton();
		createFireTowerButton();
		createLightningTowerButton();
		printLives();
		printGold();
		printScore();
		
		if(level == 1){
			spawnTextBox(100, 180, "Welcome to the first level. This is a test test \ntest test.");
		}else if(level == 2){
			
		}
	}
	
	public static void createStartWaveButton(){
		int buttonX = 432, buttonY = 432;
		startWaveSprite = new Sprite(buttonX,buttonY,ResourceManager.getStartWaveTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager())
		{
		    @Override
		    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y) 
		    {
		        if (pSceneTouchEvent.isActionDown() && FactoryManager.readyToStartWave == true)
		        {
		        	FactoryManager.startNextWave();
		        }
		        return true;
		    };
		};
		MainActivity.getScene().registerTouchArea(startWaveSprite);
		MainActivity.getScene().attachChild(startWaveSprite);
	}
	
	public static void createArrowTowerButton(){
		arrowTowerButton = new Sprite(0,416,ResourceManager.arrowTowerButtonTextureRegion,ResourceManager.getInstance().getActivity().getVertexBufferObjectManager())
		{
		    @Override
		    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y) 
		    {
		        if (pSceneTouchEvent.isActionUp())
		        {
		        	MainActivity.chosenTower = "arrow";
		        }
		        return true;
		    };
		};
		MainActivity.getScene().registerTouchArea(arrowTowerButton);
		MainActivity.getScene().attachChild(arrowTowerButton);
	}
	
	public static void createCannonTowerButton(){
		cannonTowerButton = new Sprite(64,416,ResourceManager.cannonTowerButtonTextureRegion,ResourceManager.getInstance().getActivity().getVertexBufferObjectManager())
		{
		    @Override
		    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y) 
		    {
		        if (pSceneTouchEvent.isActionUp())
		        {
		        	MainActivity.chosenTower = "cannon";
		        }
		        return true;
		    };
		};
		MainActivity.getScene().registerTouchArea(cannonTowerButton);
		MainActivity.getScene().attachChild(cannonTowerButton);
	}
	
	public static void createFireTowerButton(){
		fireTowerButton = new Sprite(128,416,ResourceManager.fireTowerButtonTextureRegion,ResourceManager.getInstance().getActivity().getVertexBufferObjectManager())
		{
		    @Override
		    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y) 
		    {
		        if (pSceneTouchEvent.isActionUp())
		        {
		        	MainActivity.chosenTower = "fire";
		        }
		        return true;
		    };
		};
		MainActivity.getScene().registerTouchArea(fireTowerButton);
		MainActivity.getScene().attachChild(fireTowerButton);
	}
	
	public static void createLightningTowerButton(){
		lightningTowerButton = new Sprite(192,416,ResourceManager.lightningTowerButtonTextureRegion,ResourceManager.getInstance().getActivity().getVertexBufferObjectManager())
		{
		    @Override
		    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y) 
		    {
		        if (pSceneTouchEvent.isActionUp())
		        {
		        	MainActivity.chosenTower = "lightning";
		        }
		        return true;
		    };
		};
		MainActivity.getScene().registerTouchArea(lightningTowerButton);
		MainActivity.getScene().attachChild(lightningTowerButton);
	}
	
	public static void spawnTextBox(int x, int y, String teksti){
		//Make textbox with touchevents and text
		textBoxSprite = new Sprite(x,y,ResourceManager.getTextBoxTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager())
		{
		    @Override
		    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y) 
		    {
		        if (pSceneTouchEvent.isActionUp())
		        {
		        	//scroll text or close box
		        	removeTextBox = true;
		        }
		        return true;
		    };
		};
		
		textBoxText = new Text(x + 32, y + 32, ResourceManager.getTextBoxFont(), "0", 1024, ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		tapTextBoxReminder = new Text(x + 400, y + 170, ResourceManager.getFont(), "0", 1024, ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		
		MainActivity.getScene().attachChild(textBoxSprite);
		
		MainActivity.getScene().attachChild(textBoxText);
		textBoxText.setText(teksti);
		MainActivity.getScene().attachChild(tapTextBoxReminder);
		tapTextBoxReminder.setText("Tap box to continue...");
		
		MainActivity.getScene().registerTouchArea(textBoxSprite);
	}
	
	public static void killTextBox(){
		MainActivity.getScene().unregisterTouchArea(textBoxSprite);
		MainActivity.getScene().detachChild(textBoxSprite);
		MainActivity.getScene().detachChild(textBoxText);
		MainActivity.getScene().detachChild(tapTextBoxReminder);
		removeTextBox = false;
	}
	
	public static void printLives(){
		lives = new Text(512, 432, ResourceManager.getFont(), "0", 10, ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		MainActivity.getScene().attachChild(lives);
	}
	
	public static void printGold(){
		gold = new Text(512, 448, ResourceManager.getFont(), "0", 10, ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		MainActivity.getScene().attachChild(gold);
	}
	
	public static void printScore(){
		score = new Text(512, 464, ResourceManager.getFont(), "0", 10, ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		MainActivity.getScene().attachChild(score);
	}
	
	public static void updateLives(){
		lives.setText("Lives: " + String.valueOf(playerLives));
	}
	
	public static void updateGold(){
		gold.setText("Gold: " + String.valueOf(playerGold));
	}
	
	public static void updateScore(){
		score.setText("Score: " + String.valueOf(playerScore));
	}
	
	public static void killUI(){
		MainActivity.getScene().unregisterTouchArea(arrowTowerButton);
		MainActivity.getScene().detachChild(arrowTowerButton);
		MainActivity.getScene().unregisterTouchArea(cannonTowerButton);
		MainActivity.getScene().detachChild(cannonTowerButton);
		MainActivity.getScene().unregisterTouchArea(fireTowerButton);
		MainActivity.getScene().detachChild(fireTowerButton);
		MainActivity.getScene().unregisterTouchArea(lightningTowerButton);
		MainActivity.getScene().detachChild(lightningTowerButton);
		MainActivity.getScene().detachChild(lives);
		MainActivity.getScene().detachChild(gold);
		MainActivity.getScene().detachChild(score);
		MainActivity.getScene().unregisterTouchArea(startWaveSprite);
		MainActivity.getScene().detachChild(startWaveSprite);
		killTextBox();
	}
	
	public static int getPlayerLives(){
		return playerLives;
	}
	
	public static void setPlayerLives(int lives){
		playerLives = playerLives + lives;
	}
	
	public static int getPlayerGold(){
		return playerGold;
	}
	
	public static void setPlayerGold(int gold){
		playerGold = gold;
	}
	
	public static void addPlayerGold(int gold){
		playerGold = playerGold + gold;
	}
	
	public static int getPlayerScore(){
		return playerScore;
	}
	
	public static void setPlayerScore(int score){
		playerScore = playerScore + score;
	}

}
