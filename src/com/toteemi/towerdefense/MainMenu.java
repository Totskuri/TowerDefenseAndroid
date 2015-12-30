package com.toteemi.towerdefense;

import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;

public class MainMenu {
	
	int CAMERA_WIDTH = 800, CAMERA_HEIGHT = 480;
	
	static Sprite mainMenuBackground;
	static Sprite startGame;
	static Sprite quitGame;
	static Sprite levelSelectionBackground;
	static Sprite levelOneButton;
	static Sprite levelTwoButton;
	static Sprite loadingBackground;
	static Sprite quitGameScreen;
	static Sprite quitGameScreenYes;
	static Sprite quitGameScreenNo;
	
	static boolean sceneMainMenu = true;
	static boolean sceneLevelSelection = false;
	static boolean sceneGame = false;
	static boolean sceneQuitGame = false;
	
	public static void generateMainMenu(){
		mainMenuBackground = new Sprite(0,0,ResourceManager.getMainMenuBackgroundTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		
		startGame = new Sprite(272,128,ResourceManager.getStartGameTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager())
		{
		    @Override
		    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y) 
		    {
		        if (pSceneTouchEvent.isActionDown())
		        {
		        	//Goes to level selection
		        	killMainMenu();
		        	generateLevelSelection();
		        	sceneMainMenu = false;
		        	sceneLevelSelection = true;
		        }
		        return true;
		    };
		};
		
		quitGame = new Sprite(272,224,ResourceManager.getQuitGameTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager())
		{
		    @Override
		    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y) 
		    {
		        if (pSceneTouchEvent.isActionDown())
		        {
		        	//Asks if sure
		        	generateQuitGameScreen();
		        }
		        return true;
		    };
		};
		
		MainActivity.getScene().attachChild(mainMenuBackground);
		MainActivity.getScene().registerTouchArea(startGame);
		MainActivity.getScene().attachChild(startGame);
		MainActivity.getScene().registerTouchArea(quitGame);
		MainActivity.getScene().attachChild(quitGame);
	}
	
	public static void killMainMenu(){
		MainActivity.getScene().detachChild(mainMenuBackground);
		MainActivity.getScene().unregisterTouchArea(startGame);
		MainActivity.getScene().detachChild(startGame);
		MainActivity.getScene().unregisterTouchArea(quitGame);
		MainActivity.getScene().detachChild(quitGame);
	}
	
	public static void generateLevelSelection(){
		levelSelectionBackground = new Sprite(0,0,ResourceManager.getLevelSelectionBackgroundTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		
		levelOneButton = new Sprite(96,96,ResourceManager.getLevelOneButtonTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager())
		{
		    @Override
		    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y) 
		    {
		        if (pSceneTouchEvent.isActionDown())
		        {
		        	//Enters game level one
		        	LevelManager.setCurrentLevel(1);
		        	UIManager.setPlayerGold(500);
		        	killLevelSelection();
		        	loadingScreenToGame(LevelManager.getCurrentLevel());
		        	sceneLevelSelection = false;
		        	sceneGame = true;
		        }
		        return true;
		    };
		};
		
		levelTwoButton = new Sprite(96,224,ResourceManager.getLevelTwoButtonTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager())
		{
		    @Override
		    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y) 
		    {
		        if (pSceneTouchEvent.isActionDown())
		        {
		        	//Enters game level two
		        	LevelManager.setCurrentLevel(2);
		        	UIManager.setPlayerGold(600);
		        	killLevelSelection();
		        	loadingScreenToGame(LevelManager.getCurrentLevel());
		        	sceneLevelSelection = false;
		        	sceneGame = true;
		        }
		        return true;
		    };
		};
		
		MainActivity.getScene().attachChild(levelSelectionBackground);
		MainActivity.getScene().registerTouchArea(levelOneButton);
		MainActivity.getScene().attachChild(levelOneButton);
		MainActivity.getScene().registerTouchArea(levelTwoButton);
		MainActivity.getScene().attachChild(levelTwoButton);
	}
	
	public static void generateQuitGameScreen(){
		sceneMainMenu = false;
    	sceneQuitGame = true;
		MainActivity.getScene().unregisterTouchArea(startGame);
		MainActivity.getScene().unregisterTouchArea(quitGame);
		quitGameScreen = new Sprite(200,120,ResourceManager.getQuitGameScreenTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		
		quitGameScreenYes = new Sprite(248,256,ResourceManager.getQuitGameScreenYesTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager())
		{
		    @Override
		    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y) 
		    {
		        if (pSceneTouchEvent.isActionDown())
		        {
		        	//Quits Game
		        	ResourceManager.getInstance().getActivity().finish();
		        }
		        return true;
		    };
		};
		
		quitGameScreenNo = new Sprite(424,256,ResourceManager.getQuitGameScreenNoTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager())
		{
		    @Override
		    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y) 
		    {
		        if (pSceneTouchEvent.isActionDown())
		        {
		        	//goes back to main menu
		        	sceneMainMenu = true;
		        	sceneQuitGame = false;
		        	killQuitGameScreen();
		        	MainActivity.getScene().registerTouchArea(startGame);
		    		MainActivity.getScene().registerTouchArea(quitGame);
		        }
		        return true;
		    };
		};
		
		MainActivity.getScene().attachChild(quitGameScreen);
		MainActivity.getScene().registerTouchArea(quitGameScreenYes);
		MainActivity.getScene().attachChild(quitGameScreenYes);
		MainActivity.getScene().registerTouchArea(quitGameScreenNo);
		MainActivity.getScene().attachChild(quitGameScreenNo);
	}
	
	public static void killQuitGameScreen(){
		MainActivity.getScene().detachChild(quitGameScreen);
		MainActivity.getScene().unregisterTouchArea(quitGameScreenYes);
		MainActivity.getScene().detachChild(quitGameScreenYes);
		MainActivity.getScene().unregisterTouchArea(quitGameScreenNo);
		MainActivity.getScene().detachChild(quitGameScreenNo);
	}
	
	public static void loadingScreenToGame(int level){
		/* 1)display loading screen
		 * 2)unload menu resources
		 * 3)load game resources
		 */
		loadingBackground = new Sprite(0,0,ResourceManager.getLoadingBackgroundTextureRegion(),ResourceManager.getInstance().getActivity().getVertexBufferObjectManager());
		MainActivity.getScene().attachChild(loadingBackground);
		ResourceManager.unloadMainMenu();
		ResourceManager.getInstance().loadGame();
    	ResourceManager.getInstance().loadGameSfx();
    	ResourceManager.getInstance().loadFonts();
    	
    	//generate level according to given number
    	if(level == 1){
    		LevelManager.levelGenerator(LevelManager.getLevelOne());
    	}else if(level == 2){
    		LevelManager.levelGenerator(LevelManager.getLevelTwo());
    	}else if(level == 3){
    		
    	}
    	
		UIManager.generateUI(level);
		MainActivity.getScene().registerUpdateHandler(ResourceManager.getInstance().getActivity().getMainLoop());
		MainActivity.getScene().detachChild(loadingBackground);
	}
	
	public static void killLevelSelection(){
		MainActivity.getScene().detachChild(levelSelectionBackground);
		MainActivity.getScene().unregisterTouchArea(levelOneButton);
		MainActivity.getScene().detachChild(levelOneButton);
		MainActivity.getScene().unregisterTouchArea(levelTwoButton);
		MainActivity.getScene().detachChild(levelTwoButton);
	}
	
}