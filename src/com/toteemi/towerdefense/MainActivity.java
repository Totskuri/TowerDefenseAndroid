package com.toteemi.towerdefense;

import org.andengine.audio.music.MusicFactory;
import org.andengine.audio.sound.SoundFactory;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.WakeLockOptions;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.ui.activity.BaseGameActivity;

import android.content.pm.ActivityInfo;
import android.view.KeyEvent;

public class MainActivity extends BaseGameActivity {
	
	public static final int CAMERA_WIDTH = 800;
	public static final int CAMERA_HEIGHT = 480;
	public static final int tileSize = 32;
	
	public static Camera mCamera;
	public static Scene mScene;
	
	public static String chosenTower = null;

	@Override
	public EngineOptions onCreateEngineOptions() {
		mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		
		EngineOptions engineOptions = new EngineOptions(true,ScreenOrientation.LANDSCAPE_FIXED, new FillResolutionPolicy(),mCamera);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		engineOptions.getAudioOptions().setNeedsMusic(true);
		engineOptions.getAudioOptions().setNeedsSound(true);
		
		engineOptions.setWakeLockOptions(WakeLockOptions.SCREEN_ON);
		return engineOptions;
	}

	@Override
	public void onCreateResources(
			OnCreateResourcesCallback pOnCreateResourcesCallback)
			throws Exception {
		ResourceManager.setup(this, this.getApplicationContext());
		SoundFactory.setAssetBasePath("sfx/");
		MusicFactory.setAssetBasePath("sfx/");
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		
		ResourceManager.getInstance().loadAlwaysNeeded();
		ResourceManager.getInstance().loadMainMenu();
		
		pOnCreateResourcesCallback.onCreateResourcesFinished();
	}

	@Override
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback)
			throws Exception {
		mScene = new Scene();
		
		//mScene.setBackground(new Background(0,0,0));
		//mScene.setTouchAreaBindingOnActionDownEnabled(true);
		mScene.setOnAreaTouchTraversalFrontToBack(); //Makes the touch areas register from front to back
		
		pOnCreateSceneCallback.onCreateSceneFinished(mScene);
	}

	@Override
	public void onPopulateScene(Scene pScene,
			OnPopulateSceneCallback pOnPopulateSceneCallback) throws Exception {
		MainMenu.generateMainMenu();
		
		pOnPopulateSceneCallback.onPopulateSceneFinished();
	}
	
	public static Scene getScene(){
		return mScene;
	}
	
	IUpdateHandler main = new IUpdateHandler() {
        @Override
        public void reset() {
        }

        @Override
        public void onUpdate(float pSecondsElapsed) {
        	//Spawn waves
        	if(FactoryManager.readyToStartWave == true){
        		UIManager.createStartWaveButton();
        	}
        	//check if creeps dead
        	if(FactoryManager.arrayMM.size() == 0){
        		FactoryManager.readyToStartWave = true;
        		FactoryManager.removeDeathAnimations = true;
        	}
        	//update player info
        	UIManager.updateLives();
        	UIManager.updateGold();
        	UIManager.updateScore();
        	FactoryManager.killHealthBar();
           
            //Loop for checking all creeps movement
        	for(int movement = 0; movement < FactoryManager.arrayMM.size(); movement++){
        		FactoryManager.arrayMM.get(movement).creepMovementCheck(FactoryManager.arrayMM.get(movement));
        	}
        	
        	//tower shooting
        	FactoryManager.findTargetAndFire();
        	
        	//check for deaths
        	FactoryManager.checkForCreepDeaths();
        	
        	//Runnable for removing sprites
        	if(FactoryManager.creepsToKill.size() > 0 || FactoryManager.ammoToKill.size() > 0 || FactoryManager.removeDeathAnimations == true){
        		runOnUpdateThread(new Runnable(){
            		@Override
            		public void run(){
            			if(FactoryManager.creepsToKill.size() > 0){
            				FactoryManager.creepKill();
            			}
            			if(FactoryManager.ammoToKill.size() > 0){
            				FactoryManager.ammoKill();
            			}
            			if(FactoryManager.removeDeathAnimations == true){
            				FactoryManager.deathAnimationsKill();
            			}
            			if(UIManager.removeTextBox == true){
            				UIManager.killTextBox();
            			}
            	}});
        	}

        }
    };
    
    public IUpdateHandler getMainLoop(){
    	return main;
    }
    
    @Override
	public boolean onKeyDown(final int keyCode, final KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) {
			if(MainMenu.sceneMainMenu == true){
				MainMenu.generateQuitGameScreen();
			}else if(MainMenu.sceneLevelSelection == true){
				MainMenu.killLevelSelection();
	        	MainMenu.generateMainMenu();
	        	MainMenu.sceneLevelSelection = false;
	        	MainMenu.sceneMainMenu = true;
			}else if(MainMenu.sceneGame == true){
				//ask if you want to exit level
				FactoryManager.generateExitLevelScreen();
			}else if(MainMenu.sceneQuitGame == true){
				//exit game
				ResourceManager.getInstance().getActivity().finish();
			}
			return true;
		} else {
			return super.onKeyDown(keyCode, event);
		}
	}
    
    @Override
    protected void onDestroy()
    {
    	FactoryManager.clearArrays();
        super.onDestroy();
        System.exit(0);
        
        //implement later
        /*if (this.isGameLoaded())
        {
        	
            System.exit(0);
        }*/
    }

}
