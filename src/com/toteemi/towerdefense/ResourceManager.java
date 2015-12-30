package com.toteemi.towerdefense;

import java.io.IOException;

import org.andengine.audio.music.Music;
import org.andengine.audio.music.MusicFactory;
import org.andengine.audio.sound.Sound;
import org.andengine.audio.sound.SoundFactory;
import org.andengine.engine.Engine;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.util.color.Color;

import android.content.Context;
import android.graphics.Typeface;

public class ResourceManager{
	
	private static final ResourceManager INSTANCE = new ResourceManager();
	
	public MainActivity activity;
	public Context context;
	
	//Always needed
	static BitmapTextureAtlas loadingBackgroundTexture;
	static BitmapTextureAtlas quitGameScreenTexture;
	static BitmapTextureAtlas quitGameScreenYesTexture;
	static BitmapTextureAtlas quitGameScreenNoTexture;
	
	static ITextureRegion loadingBackgroundTextureRegion;
	static ITextureRegion quitGameScreenTextureRegion;
	static ITextureRegion quitGameScreenYesTextureRegion;
	static ITextureRegion quitGameScreenNoTextureRegion;
	
	//Main Menu
	static BitmapTextureAtlas mainMenuBackgroundTexture;
	static BitmapTextureAtlas startGameTexture;
	static BitmapTextureAtlas quitGameTexture;
	static BitmapTextureAtlas levelSelectionBackgroundTexture;
	static BitmapTextureAtlas levelOneButtonTexture;
	static BitmapTextureAtlas levelTwoButtonTexture;
	
	static ITextureRegion mainMenuBackgroundTextureRegion;
	static ITextureRegion startGameTextureRegion;
	static ITextureRegion quitGameTextureRegion;
	static ITextureRegion levelSelectionBackgroundTextureRegion;
	static ITextureRegion levelOneButtonTextureRegion;
	static ITextureRegion levelTwoButtonTextureRegion;
	
	//Game
		//tiles
		static BitmapTextureAtlas grassTileTexture;
		static BitmapTextureAtlas sandTileTexture;
		static BitmapTextureAtlas sandTileDownLeftTexture;
		static BitmapTextureAtlas sandTileDownRightTexture;
		static BitmapTextureAtlas sandTileUpperLeftTexture;
		static BitmapTextureAtlas sandTileUpperRightTexture;
		static BitmapTextureAtlas sandTileVerticalTexture;
		static BitmapTextureAtlas sandTileVerticalLeftTexture;
		static BitmapTextureAtlas sandTileVerticalRightTexture;
		static BitmapTextureAtlas sandTileHorizontalTexture;
		static BitmapTextureAtlas sandTileHorizontalUpTexture;
		static BitmapTextureAtlas sandTileHorizontalDownTexture;
		static BitmapTextureAtlas sandTileUpperRightCornerTexture;
		static BitmapTextureAtlas sandTileUpperLeftCornerTexture;
		static BitmapTextureAtlas sandTileDownRightCornerTexture;
		static BitmapTextureAtlas sandTileDownLeftCornerTexture;
		static BitmapTextureAtlas spawnTileTexture;
		static ITextureRegion grassTileTextureRegion;
		static ITextureRegion sandTileTextureRegion;
		static ITextureRegion sandTileDownLeftTextureRegion;
		static ITextureRegion sandTileDownRightTextureRegion;
		static ITextureRegion sandTileUpperLeftTextureRegion;
		static ITextureRegion sandTileUpperRightTextureRegion;
		static ITextureRegion sandTileVerticalTextureRegion;
		static ITextureRegion sandTileVerticalLeftTextureRegion;
		static ITextureRegion sandTileVerticalRightTextureRegion;
		static ITextureRegion sandTileHorizontalTextureRegion;
		static ITextureRegion sandTileHorizontalUpTextureRegion;
		static ITextureRegion sandTileHorizontalDownTextureRegion;
		static ITextureRegion sandTileUpperRightCornerTextureRegion;
		static ITextureRegion sandTileUpperLeftCornerTextureRegion;
		static ITextureRegion sandTileDownRightCornerTextureRegion;
		static ITextureRegion sandTileDownLeftCornerTextureRegion;
		static ITextureRegion spawnTileTextureRegion;
		
		//towers
		static BitmapTextureAtlas arrowTowerTexture;
		static BitmapTextureAtlas cannonTowerTexture;
		static BitmapTextureAtlas fireTowerTexture;
		static BitmapTextureAtlas lightningTowerTexture;
		static ITextureRegion arrowTowerTextureRegion;
		static ITextureRegion cannonTowerTextureRegion;
		static ITextureRegion fireTowerTextureRegion;
		static ITextureRegion lightningTowerTextureRegion;
		
		//creeps
		static BitmapTextureAtlas creepHumanTexture;
		static BitmapTextureAtlas creepHumanDeathTexture;
		static BitmapTextureAtlas creepBigHumanNormalTexture;
		static ITextureRegion creepHumanTextureRegion;
		static ITextureRegion creepHumanDeathTextureRegion;
		static TiledTextureRegion creepBigHumanNormalTiledTextureRegion;
		
		//UI
		static BitmapTextureAtlas arrowTowerButtonTexture;
		static BitmapTextureAtlas cannonTowerButtonTexture;
		static BitmapTextureAtlas fireTowerButtonTexture;
		static BitmapTextureAtlas lightningTowerButtonTexture;
		static BitmapTextureAtlas startWaveTexture;
		static BitmapTextureAtlas exitLevelScreenTexture;
		static BitmapTextureAtlas textBoxTexture;
		static ITextureRegion arrowTowerButtonTextureRegion;
		static ITextureRegion cannonTowerButtonTextureRegion;
		static ITextureRegion fireTowerButtonTextureRegion;
		static ITextureRegion lightningTowerButtonTextureRegion;
		static ITextureRegion startWaveTextureRegion;
		static ITextureRegion exitLevelScreenTextureRegion;
		static ITextureRegion textBoxTextureRegion;
		
		//ammo
		static BitmapTextureAtlas arrowTowerAmmoTexture;
		static BitmapTextureAtlas cannonTowerAmmoTexture;
		static ITextureRegion arrowTowerAmmoTextureRegion;
		static ITextureRegion cannonTowerAmmoTextureRegion;
			//fire
			static BitmapTextureAtlas fire1pTexture;
			static BitmapTextureAtlas fire2pTexture;
			static BitmapTextureAtlas fire3pTexture;
			static BitmapTextureAtlas fire4pTexture;
			static BitmapTextureAtlas fire5pTexture;
			static BitmapTextureAtlas fire6pTexture;
			static BitmapTextureAtlas fire7pTexture;
			static BitmapTextureAtlas fire8pTexture;
			static BitmapTextureAtlas fire9pTexture;
			static BitmapTextureAtlas fire10pTexture;
			static BitmapTextureAtlas fire11pTexture;
			static BitmapTextureAtlas fire12pTexture;
			static BitmapTextureAtlas fire13pTexture;
			static BitmapTextureAtlas fire14pTexture;
			static BitmapTextureAtlas fire15pTexture;
			static BitmapTextureAtlas fire16pTexture;
			static BitmapTextureAtlas fireTipTexture;
			static ITextureRegion fire1pTextureRegion;
			static ITextureRegion fire2pTextureRegion;
			static ITextureRegion fire3pTextureRegion;
			static ITextureRegion fire4pTextureRegion;
			static ITextureRegion fire5pTextureRegion;
			static ITextureRegion fire6pTextureRegion;
			static ITextureRegion fire7pTextureRegion;
			static ITextureRegion fire8pTextureRegion;
			static ITextureRegion fire9pTextureRegion;
			static ITextureRegion fire10pTextureRegion;
			static ITextureRegion fire11pTextureRegion;
			static ITextureRegion fire12pTextureRegion;
			static ITextureRegion fire13pTextureRegion;
			static ITextureRegion fire14pTextureRegion;
			static ITextureRegion fire15pTextureRegion;
			static ITextureRegion fire16pTextureRegion;
			static ITextureRegion fireTipTextureRegion;
			static BitmapTextureAtlas fireAnimationTexture;
			static TiledTextureRegion fireAnimationTiledTextureRegion;
			
			//Lightning
			static BitmapTextureAtlas lightning1pTexture;
			static BitmapTextureAtlas lightning2pTexture;
			static BitmapTextureAtlas lightning3pTexture;
			static BitmapTextureAtlas lightning4pTexture;
			static BitmapTextureAtlas lightning5pTexture;
			static BitmapTextureAtlas lightning6pTexture;
			static BitmapTextureAtlas lightning7pTexture;
			static BitmapTextureAtlas lightning8pTexture;
			static BitmapTextureAtlas lightning9pTexture;
			static BitmapTextureAtlas lightning10pTexture;
			static BitmapTextureAtlas lightning11pTexture;
			static BitmapTextureAtlas lightning12pTexture;
			static BitmapTextureAtlas lightning13pTexture;
			static BitmapTextureAtlas lightning14pTexture;
			static BitmapTextureAtlas lightning15pTexture;
			static BitmapTextureAtlas lightning16pTexture;
			static BitmapTextureAtlas lightning17pTexture;
			static BitmapTextureAtlas lightning18pTexture;
			static BitmapTextureAtlas lightning19pTexture;
			static BitmapTextureAtlas lightning20pTexture;
			static BitmapTextureAtlas lightning21pTexture;
			static BitmapTextureAtlas lightning22pTexture;
			static BitmapTextureAtlas lightning23pTexture;
			static BitmapTextureAtlas lightning24pTexture;
			static BitmapTextureAtlas lightning25pTexture;
			static BitmapTextureAtlas lightning26pTexture;
			static BitmapTextureAtlas lightning27pTexture;
			static BitmapTextureAtlas lightning28pTexture;
			static BitmapTextureAtlas lightning29pTexture;
			static BitmapTextureAtlas lightning30pTexture;
			static BitmapTextureAtlas lightning31pTexture;
			static BitmapTextureAtlas lightning32pTexture;
			static ITextureRegion lightning1pTextureRegion;
			static ITextureRegion lightning2pTextureRegion;
			static ITextureRegion lightning3pTextureRegion;
			static ITextureRegion lightning4pTextureRegion;
			static ITextureRegion lightning5pTextureRegion;
			static ITextureRegion lightning6pTextureRegion;
			static ITextureRegion lightning7pTextureRegion;
			static ITextureRegion lightning8pTextureRegion;
			static ITextureRegion lightning9pTextureRegion;
			static ITextureRegion lightning10pTextureRegion;
			static ITextureRegion lightning11pTextureRegion;
			static ITextureRegion lightning12pTextureRegion;
			static ITextureRegion lightning13pTextureRegion;
			static ITextureRegion lightning14pTextureRegion;
			static ITextureRegion lightning15pTextureRegion;
			static ITextureRegion lightning16pTextureRegion;
			static ITextureRegion lightning17pTextureRegion;
			static ITextureRegion lightning18pTextureRegion;
			static ITextureRegion lightning19pTextureRegion;
			static ITextureRegion lightning20pTextureRegion;
			static ITextureRegion lightning21pTextureRegion;
			static ITextureRegion lightning22pTextureRegion;
			static ITextureRegion lightning23pTextureRegion;
			static ITextureRegion lightning24pTextureRegion;
			static ITextureRegion lightning25pTextureRegion;
			static ITextureRegion lightning26pTextureRegion;
			static ITextureRegion lightning27pTextureRegion;
			static ITextureRegion lightning28pTextureRegion;
			static ITextureRegion lightning29pTextureRegion;
			static ITextureRegion lightning30pTextureRegion;
			static ITextureRegion lightning31pTextureRegion;
			static ITextureRegion lightning32pTextureRegion;
			
		//health bars
		static BitmapTextureAtlas heatlhBarTenTexture;
		static BitmapTextureAtlas heatlhBarNineTexture;
		static BitmapTextureAtlas heatlhBarEightTexture;
		static BitmapTextureAtlas heatlhBarSevenTexture;
		static BitmapTextureAtlas heatlhBarSixTexture;
		static BitmapTextureAtlas heatlhBarFiveTexture;
		static BitmapTextureAtlas heatlhBarFourTexture;
		static BitmapTextureAtlas heatlhBarThreeTexture;
		static BitmapTextureAtlas heatlhBarTwoTexture;
		static BitmapTextureAtlas heatlhBarOneTexture;
		static ITextureRegion heatlhBarTenTextureRegion;
		static ITextureRegion heatlhBarNineTextureRegion;
		static ITextureRegion heatlhBarEightTextureRegion;
		static ITextureRegion heatlhBarSevenTextureRegion;
		static ITextureRegion heatlhBarSixTextureRegion;
		static ITextureRegion heatlhBarFiveTextureRegion;
		static ITextureRegion heatlhBarFourTextureRegion;
		static ITextureRegion heatlhBarThreeTextureRegion;
		static ITextureRegion heatlhBarTwoTextureRegion;
		static ITextureRegion heatlhBarOneTextureRegion;
	
	public static Font fontDefault32Bold;
	public static Font fontDefault24Bold;
	
	static Sound placeTowerSound;
	
	private ResourceManager(){
	}
	
	public static ResourceManager getInstance(){
		return INSTANCE;
	}
	
	public static void setup(final MainActivity pActivity, final Context pContext){
		getInstance().activity = pActivity;
		getInstance().context = pContext;
	}
	
	public MainActivity getActivity()
	{
		return getInstance().activity;
	}
	
	public void loadAlwaysNeeded(){
		loadingBackgroundTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(),800,480);
		quitGameScreenYesTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(),128,64);
		quitGameScreenNoTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(),128,64);
		
		loadingBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(loadingBackgroundTexture,INSTANCE.getActivity(),"loadingBackground.png",0,0);
		quitGameScreenYesTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(quitGameScreenYesTexture,INSTANCE.getActivity(),"quitGameScreenYes.png",0,0);
		quitGameScreenNoTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(quitGameScreenNoTexture,INSTANCE.getActivity(),"quitGameScreenNo.png",0,0);
		
		loadingBackgroundTexture.load();
		quitGameScreenYesTexture.load();
		quitGameScreenNoTexture.load();
	}
	
	public void loadMainMenu(){
		mainMenuBackgroundTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(),800,480);
		startGameTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(),256,64);
		quitGameTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(),256,64);
		levelSelectionBackgroundTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(),800,480);
		levelOneButtonTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(),96,96);
		levelTwoButtonTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(),96,96);
		quitGameScreenTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(),400,240);
		
		mainMenuBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(mainMenuBackgroundTexture,INSTANCE.getActivity(),"mainMenuBackground.png",0,0);
		startGameTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(startGameTexture,INSTANCE.getActivity(),"startGame.png",0,0);
		quitGameTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(quitGameTexture,INSTANCE.getActivity(),"quitGame.png",0,0);
		levelSelectionBackgroundTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(levelSelectionBackgroundTexture,INSTANCE.getActivity(),"levelSelectionBackground.png",0,0);
		levelOneButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(levelOneButtonTexture,INSTANCE.getActivity(),"levelOneButton.png",0,0);
		levelTwoButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(levelTwoButtonTexture,INSTANCE.getActivity(),"levelTwoButton.png",0,0);
		quitGameScreenTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(quitGameScreenTexture,INSTANCE.getActivity(),"quitGameScreen.png",0,0);
		
		mainMenuBackgroundTexture.load();
		startGameTexture.load();
		quitGameTexture.load();
		levelSelectionBackgroundTexture.load();
		levelOneButtonTexture.load();
		levelTwoButtonTexture.load();
		quitGameScreenTexture.load();
	}
	
	public static void unloadMainMenu(){
		mainMenuBackgroundTextureRegion.getTexture().unload();
		mainMenuBackgroundTextureRegion = null;
		startGameTextureRegion.getTexture().unload();
		startGameTextureRegion = null;
		quitGameTextureRegion.getTexture().unload();
		quitGameTextureRegion = null;
		levelSelectionBackgroundTextureRegion.getTexture().unload();
		levelSelectionBackgroundTextureRegion = null;
		levelOneButtonTextureRegion.getTexture().unload();
		levelOneButtonTextureRegion = null;
		levelTwoButtonTextureRegion.getTexture().unload();
		levelTwoButtonTextureRegion = null;
		quitGameScreenTextureRegion.getTexture().unload();
		quitGameScreenTextureRegion = null;
	}
	
	public void loadGame(){
		//tiles
		grassTileTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 32, 32);
		sandTileTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 32, 32);
		sandTileDownLeftTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 32, 32);
		sandTileDownRightTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 32, 32);
		sandTileUpperLeftTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 32, 32);
		sandTileUpperRightTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 32, 32);
		sandTileVerticalTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 32, 32);
		sandTileVerticalLeftTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 32, 32);
		sandTileVerticalRightTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 32, 32);
		sandTileHorizontalTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 32, 32);
		sandTileHorizontalUpTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 32, 32);
		sandTileHorizontalDownTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 32, 32);
		sandTileUpperRightCornerTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 32, 32);
		sandTileUpperLeftCornerTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 32, 32);
		sandTileDownRightCornerTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 32, 32);
		sandTileDownLeftCornerTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 32, 32);
		spawnTileTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 32, 32);
		
		grassTileTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(grassTileTexture, INSTANCE.getActivity(), "grassTile.png", 0, 0);
		sandTileTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(sandTileTexture, INSTANCE.getActivity(), "sandTile.png", 0, 0);
		sandTileDownLeftTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(sandTileDownLeftTexture, INSTANCE.getActivity(), "tiles/sandTileDownLeft.png", 0, 0);
		sandTileDownRightTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(sandTileDownRightTexture, INSTANCE.getActivity(), "tiles/sandTileDownRight.png", 0, 0);
		sandTileUpperLeftTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(sandTileUpperLeftTexture, INSTANCE.getActivity(), "tiles/sandTileUpperLeft.png", 0, 0);
		sandTileUpperRightTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(sandTileUpperRightTexture, INSTANCE.getActivity(), "tiles/sandTileUpperRight.png", 0, 0);
		sandTileVerticalTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(sandTileVerticalTexture, INSTANCE.getActivity(), "tiles/sandTileVertical.png", 0, 0);
		sandTileVerticalLeftTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(sandTileVerticalLeftTexture, INSTANCE.getActivity(), "tiles/sandTileVerticalLeft.png", 0, 0);
		sandTileVerticalRightTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(sandTileVerticalRightTexture, INSTANCE.getActivity(), "tiles/sandTileVerticalRight.png", 0, 0);
		sandTileHorizontalTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(sandTileHorizontalTexture, INSTANCE.getActivity(), "tiles/sandTileHorizontal.png", 0, 0);
		sandTileHorizontalUpTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(sandTileHorizontalUpTexture, INSTANCE.getActivity(), "tiles/sandTileHorizontalUp.png", 0, 0);
		sandTileHorizontalDownTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(sandTileHorizontalDownTexture, INSTANCE.getActivity(), "tiles/sandTileHorizontalDown.png", 0, 0);
		sandTileUpperRightCornerTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(sandTileUpperRightCornerTexture, INSTANCE.getActivity(), "tiles/sandTileUpperRightCorner.png", 0, 0);
		sandTileUpperLeftCornerTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(sandTileUpperLeftCornerTexture, INSTANCE.getActivity(), "tiles/sandTileUpperLeftCorner.png", 0, 0);
		sandTileDownRightCornerTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(sandTileDownRightCornerTexture, INSTANCE.getActivity(), "tiles/sandTileDownRightCorner.png", 0, 0);
		sandTileDownLeftCornerTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(sandTileDownLeftCornerTexture, INSTANCE.getActivity(), "tiles/sandTileDownLeftCorner.png", 0, 0);
		spawnTileTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(spawnTileTexture, INSTANCE.getActivity(), "spawnTile.png", 0, 0);
		
		grassTileTexture.load();
		sandTileTexture.load();
		sandTileDownLeftTexture.load();
		sandTileDownRightTexture.load();
		sandTileUpperLeftTexture.load();
		sandTileUpperRightTexture.load();
		sandTileVerticalTexture.load();
		sandTileVerticalLeftTexture.load();
		sandTileVerticalRightTexture.load();
		sandTileHorizontalTexture.load();
		sandTileHorizontalUpTexture.load();
		sandTileHorizontalDownTexture.load();
		sandTileUpperRightCornerTexture.load();
		sandTileUpperLeftCornerTexture.load();
		sandTileDownRightCornerTexture.load();
		sandTileDownLeftCornerTexture.load();
		spawnTileTexture.load();
		
		//towers
		arrowTowerTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 32, 32);
		cannonTowerTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 32, 32);
		fireTowerTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 32, 32);
		lightningTowerTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 32, 32);
		
		arrowTowerTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(arrowTowerTexture, INSTANCE.getActivity(), "arrowTowerShooting.png", 0, 0);
		cannonTowerTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(cannonTowerTexture, INSTANCE.getActivity(), "cannonTower.png", 0, 0);
		fireTowerTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(fireTowerTexture, INSTANCE.getActivity(), "fireTower.png", 0, 0);
		lightningTowerTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightningTowerTexture, INSTANCE.getActivity(), "lightningTowerLightning1.png", 0, 0);
		
		arrowTowerTexture.load();
		cannonTowerTexture.load();
		fireTowerTexture.load();
		lightningTowerTexture.load();
		
		//creeps
		creepHumanTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 16);
		creepHumanDeathTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 16);
		creepBigHumanNormalTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 256, 32);
		
		creepHumanTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(creepHumanTexture, INSTANCE.getActivity(), "creepHuman.png", 0, 0);
		creepHumanDeathTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(creepHumanDeathTexture, INSTANCE.getActivity(), "creepHumanDeath.png", 0, 0);
		creepBigHumanNormalTiledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(creepBigHumanNormalTexture, INSTANCE.getActivity(), "creep/bigHuman/bigHumanNormalSpriteSheet.png", 0, 0, 8, 1);
		
		creepHumanTexture.load();
		creepHumanDeathTexture.load();
		creepBigHumanNormalTexture.load();
		
		//UI
		arrowTowerButtonTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 64, 64);
		cannonTowerButtonTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 64, 64);
		fireTowerButtonTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 64, 64);
		lightningTowerButtonTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 64, 64);
		startWaveTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 64, 18);
		exitLevelScreenTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 400, 240);
		textBoxTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 600, 200);
		
		arrowTowerButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(arrowTowerButtonTexture, INSTANCE.getActivity(), "arrowTowerButton.png", 0, 0);
		cannonTowerButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(cannonTowerButtonTexture, INSTANCE.getActivity(), "cannonTowerButton.png", 0, 0);
		fireTowerButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(fireTowerButtonTexture, INSTANCE.getActivity(), "fireTowerButton.png", 0, 0);
		lightningTowerButtonTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightningTowerButtonTexture, INSTANCE.getActivity(), "lightningTowerButton.png", 0, 0);
		startWaveTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(startWaveTexture, INSTANCE.getActivity(), "startWave.png", 0, 0);
		exitLevelScreenTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(exitLevelScreenTexture, INSTANCE.getActivity(), "exitLevelScreen.png", 0, 0);
		textBoxTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(textBoxTexture, INSTANCE.getActivity(), "textBox.png", 0, 0);
		
		arrowTowerButtonTexture.load();
		cannonTowerButtonTexture.load();
		fireTowerButtonTexture.load();
		lightningTowerButtonTexture.load();
		startWaveTexture.load();
		exitLevelScreenTexture.load();
		textBoxTexture.load();
		
		//ammo
		arrowTowerAmmoTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 6, 25);
		cannonTowerAmmoTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 8, 8);
		
		arrowTowerAmmoTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(arrowTowerAmmoTexture, INSTANCE.getActivity(), "arrow.png", 0, 0);
		cannonTowerAmmoTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(cannonTowerAmmoTexture, INSTANCE.getActivity(), "cannonball.png", 0, 0);
		
		arrowTowerAmmoTexture.load();
		cannonTowerAmmoTexture.load();
			//fire
		fireAnimationTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 48, 64);
		fireAnimationTiledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(fireAnimationTexture, INSTANCE.getActivity(), "ammo/fire/FireAnimationSpriteSheet.png", 0, 0, 3, 1);
		fireAnimationTexture.load();
		
			fire1pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 1);
			fire2pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 2);
			fire3pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 3);
			fire4pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 4);
			fire5pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 5);
			fire6pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 6);
			fire7pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 7);
			fire8pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 8);
			fire9pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 9);
			fire10pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 10);
			fire11pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 11);
			fire12pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 12);
			fire13pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 13);
			fire14pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 14);
			fire15pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 15);
			fire16pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 16);
			fireTipTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 16);
			
			fire1pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(fire1pTexture, INSTANCE.getActivity(), "ammo/fire/fire1p.png", 0, 0);
			fire2pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(fire2pTexture, INSTANCE.getActivity(), "ammo/fire/fire2p.png", 0, 0);
			fire3pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(fire3pTexture, INSTANCE.getActivity(), "ammo/fire/fire3p.png", 0, 0);
			fire4pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(fire4pTexture, INSTANCE.getActivity(), "ammo/fire/fire4p.png", 0, 0);
			fire5pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(fire5pTexture, INSTANCE.getActivity(), "ammo/fire/fire5p.png", 0, 0);
			fire6pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(fire6pTexture, INSTANCE.getActivity(), "ammo/fire/fire6p.png", 0, 0);
			fire7pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(fire7pTexture, INSTANCE.getActivity(), "ammo/fire/fire7p.png", 0, 0);
			fire8pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(fire8pTexture, INSTANCE.getActivity(), "ammo/fire/fire8p.png", 0, 0);
			fire9pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(fire9pTexture, INSTANCE.getActivity(), "ammo/fire/fire9p.png", 0, 0);
			fire10pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(fire10pTexture, INSTANCE.getActivity(), "ammo/fire/fire10p.png", 0, 0);
			fire11pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(fire11pTexture, INSTANCE.getActivity(), "ammo/fire/fire11p.png", 0, 0);
			fire12pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(fire12pTexture, INSTANCE.getActivity(), "ammo/fire/fire12p.png", 0, 0);
			fire13pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(fire13pTexture, INSTANCE.getActivity(), "ammo/fire/fire13p.png", 0, 0);
			fire14pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(fire14pTexture, INSTANCE.getActivity(), "ammo/fire/fire14p.png", 0, 0);
			fire15pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(fire15pTexture, INSTANCE.getActivity(), "ammo/fire/fire15p.png", 0, 0);
			fire16pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(fire16pTexture, INSTANCE.getActivity(), "ammo/fire/fire16p.png", 0, 0);
			fireTipTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(fireTipTexture, INSTANCE.getActivity(), "ammo/fire/fireTip.png", 0, 0);
			
			fire1pTexture.load();
			fire2pTexture.load();
			fire3pTexture.load();
			fire4pTexture.load();
			fire5pTexture.load();
			fire6pTexture.load();
			fire7pTexture.load();
			fire8pTexture.load();
			fire9pTexture.load();
			fire10pTexture.load();
			fire11pTexture.load();
			fire12pTexture.load();
			fire13pTexture.load();
			fire14pTexture.load();
			fire15pTexture.load();
			fire16pTexture.load();
			fireTipTexture.load();
			//lightning
			lightning1pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 1);
			lightning2pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 2);
			lightning3pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 3);
			lightning4pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 4);
			lightning5pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 5);
			lightning6pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 6);
			lightning7pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 7);
			lightning8pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 8);
			lightning9pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 9);
			lightning10pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 10);
			lightning11pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 11);
			lightning12pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 12);
			lightning13pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 13);
			lightning14pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 14);
			lightning15pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 15);
			lightning16pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 16);
			lightning17pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 17);
			lightning18pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 18);
			lightning19pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 19);
			lightning20pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 20);
			lightning21pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 21);
			lightning22pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 22);
			lightning23pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 23);
			lightning24pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 24);
			lightning25pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 25);
			lightning26pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 26);
			lightning27pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 27);
			lightning28pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 28);
			lightning29pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 29);
			lightning30pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 30);
			lightning31pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 31);
			lightning32pTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 16, 32);
			
			lightning1pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning1pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning1p.png", 0, 0);
			lightning2pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning2pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning2p.png", 0, 0);
			lightning3pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning3pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning3p.png", 0, 0);
			lightning4pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning4pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning4p.png", 0, 0);
			lightning5pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning5pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning5p.png", 0, 0);
			lightning6pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning6pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning6p.png", 0, 0);
			lightning7pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning7pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning7p.png", 0, 0);
			lightning8pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning8pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning8p.png", 0, 0);
			lightning9pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning9pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning9p.png", 0, 0);
			lightning10pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning10pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning10p.png", 0, 0);
			lightning11pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning11pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning11p.png", 0, 0);
			lightning12pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning12pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning12p.png", 0, 0);
			lightning13pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning13pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning13p.png", 0, 0);
			lightning14pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning14pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning14p.png", 0, 0);
			lightning15pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning15pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning15p.png", 0, 0);
			lightning16pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning16pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning16p.png", 0, 0);
			lightning17pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning17pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning17p.png", 0, 0);
			lightning18pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning18pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning18p.png", 0, 0);
			lightning19pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning19pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning19p.png", 0, 0);
			lightning20pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning20pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning20p.png", 0, 0);
			lightning21pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning21pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning21p.png", 0, 0);
			lightning22pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning22pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning22p.png", 0, 0);
			lightning23pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning23pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning23p.png", 0, 0);
			lightning24pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning24pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning24p.png", 0, 0);
			lightning25pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning25pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning25p.png", 0, 0);
			lightning26pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning26pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning26p.png", 0, 0);
			lightning27pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning27pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning27p.png", 0, 0);
			lightning28pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning28pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning28p.png", 0, 0);
			lightning29pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning29pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning29p.png", 0, 0);
			lightning30pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning30pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning30p.png", 0, 0);
			lightning31pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning31pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning31p.png", 0, 0);
			lightning32pTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(lightning32pTexture, INSTANCE.getActivity(), "ammo/lightning/lightning32p.png", 0, 0);
			
			lightning1pTexture.load();
			lightning2pTexture.load();
			lightning3pTexture.load();
			lightning4pTexture.load();
			lightning5pTexture.load();
			lightning6pTexture.load();
			lightning7pTexture.load();
			lightning8pTexture.load();
			lightning9pTexture.load();
			lightning10pTexture.load();
			lightning11pTexture.load();
			lightning12pTexture.load();
			lightning13pTexture.load();
			lightning14pTexture.load();
			lightning15pTexture.load();
			lightning16pTexture.load();
			lightning17pTexture.load();
			lightning18pTexture.load();
			lightning19pTexture.load();
			lightning20pTexture.load();
			lightning21pTexture.load();
			lightning22pTexture.load();
			lightning23pTexture.load();
			lightning24pTexture.load();
			lightning25pTexture.load();
			lightning26pTexture.load();
			lightning27pTexture.load();
			lightning28pTexture.load();
			lightning29pTexture.load();
			lightning30pTexture.load();
			lightning31pTexture.load();
			lightning32pTexture.load();
			
		//health bars
		heatlhBarTenTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 10, 2);
		heatlhBarNineTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 10, 2);
		heatlhBarEightTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 10, 2);
		heatlhBarSevenTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 10, 2);
		heatlhBarSixTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 10, 2);
		heatlhBarFiveTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 10, 2);
		heatlhBarFourTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 10, 2);
		heatlhBarThreeTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 10, 2);
		heatlhBarTwoTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 10, 2);
		heatlhBarOneTexture = new BitmapTextureAtlas(INSTANCE.getActivity().getTextureManager(), 10, 2);
		
		heatlhBarTenTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(heatlhBarTenTexture, INSTANCE.getActivity(), "hp/10_2.png", 0, 0);
		heatlhBarNineTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(heatlhBarNineTexture, INSTANCE.getActivity(), "hp/9_2.png", 0, 0);
		heatlhBarEightTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(heatlhBarEightTexture, INSTANCE.getActivity(), "hp/8_2.png", 0, 0);
		heatlhBarSevenTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(heatlhBarSevenTexture, INSTANCE.getActivity(), "hp/7_2.png", 0, 0);
		heatlhBarSixTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(heatlhBarSixTexture, INSTANCE.getActivity(), "hp/6_2.png", 0, 0);
		heatlhBarFiveTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(heatlhBarFiveTexture, INSTANCE.getActivity(), "hp/5_2.png", 0, 0);
		heatlhBarFourTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(heatlhBarFourTexture, INSTANCE.getActivity(), "hp/4_2.png", 0, 0);
		heatlhBarThreeTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(heatlhBarThreeTexture, INSTANCE.getActivity(), "hp/3_2.png", 0, 0);
		heatlhBarTwoTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(heatlhBarTwoTexture, INSTANCE.getActivity(), "hp/2_2.png", 0, 0);
		heatlhBarOneTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(heatlhBarOneTexture, INSTANCE.getActivity(), "hp/1_2.png", 0, 0);
		
		heatlhBarTenTexture.load();
		heatlhBarNineTexture.load();
		heatlhBarEightTexture.load();
		heatlhBarSevenTexture.load();
		heatlhBarSixTexture.load();
		heatlhBarFiveTexture.load();
		heatlhBarFourTexture.load();
		heatlhBarThreeTexture.load();
		heatlhBarTwoTexture.load();
		heatlhBarOneTexture.load();
	}
	
	public static void unloadGame(){
		//tiles
		grassTileTextureRegion.getTexture().unload();
		grassTileTextureRegion = null;
		sandTileTextureRegion.getTexture().unload();
		sandTileTextureRegion = null;
		sandTileDownLeftTextureRegion.getTexture().unload();
		sandTileDownLeftTextureRegion = null;
		sandTileDownRightTextureRegion.getTexture().unload();
		sandTileDownRightTextureRegion = null;
		sandTileUpperLeftTextureRegion.getTexture().unload();
		sandTileUpperLeftTextureRegion = null;
		sandTileUpperRightTextureRegion.getTexture().unload();
		sandTileUpperRightTextureRegion = null;
		sandTileVerticalTextureRegion.getTexture().unload();
		sandTileVerticalTextureRegion = null;
		sandTileVerticalLeftTextureRegion.getTexture().unload();
		sandTileVerticalLeftTextureRegion = null;
		sandTileVerticalRightTextureRegion.getTexture().unload();
		sandTileVerticalRightTextureRegion = null;
		sandTileHorizontalTextureRegion.getTexture().unload();
		sandTileHorizontalTextureRegion = null;
		sandTileHorizontalUpTextureRegion.getTexture().unload();
		sandTileHorizontalUpTextureRegion = null;
		sandTileHorizontalDownTextureRegion.getTexture().unload();
		sandTileHorizontalDownTextureRegion = null;
		sandTileUpperRightCornerTextureRegion.getTexture().unload();
		sandTileUpperRightCornerTextureRegion = null;
		sandTileUpperLeftCornerTextureRegion.getTexture().unload();
		sandTileUpperLeftCornerTextureRegion = null;
		sandTileDownRightCornerTextureRegion.getTexture().unload();
		sandTileDownRightCornerTextureRegion = null;
		sandTileDownLeftCornerTextureRegion.getTexture().unload();
		sandTileDownLeftCornerTextureRegion = null;
		spawnTileTextureRegion.getTexture().unload();
		spawnTileTextureRegion = null;
		//towers
		arrowTowerTextureRegion.getTexture().unload();
		arrowTowerTextureRegion = null;
		cannonTowerTextureRegion.getTexture().unload();
		cannonTowerTextureRegion = null;
		fireTowerTextureRegion.getTexture().unload();
		fireTowerTextureRegion = null;
		lightningTowerTextureRegion.getTexture().unload();
		lightningTowerTextureRegion = null;
		//creeps
		creepHumanTextureRegion.getTexture().unload();
		creepHumanTextureRegion = null;
		creepHumanDeathTextureRegion.getTexture().unload();
		creepHumanDeathTextureRegion = null;
		creepBigHumanNormalTiledTextureRegion.getTexture().unload();
		creepBigHumanNormalTiledTextureRegion = null;
		//UI
		startWaveTextureRegion.getTexture().unload();
		startWaveTextureRegion = null;
		exitLevelScreenTextureRegion.getTexture().unload();
		exitLevelScreenTextureRegion = null;
		arrowTowerButtonTextureRegion.getTexture().unload();
		arrowTowerButtonTextureRegion = null;
		cannonTowerButtonTextureRegion.getTexture().unload();
		cannonTowerButtonTextureRegion = null;
		fireTowerButtonTextureRegion.getTexture().unload();
		fireTowerButtonTextureRegion = null;
		lightningTowerButtonTextureRegion.getTexture().unload();
		lightningTowerButtonTextureRegion = null;
		textBoxTextureRegion.getTexture().unload();
		textBoxTextureRegion = null;
		//ammo
		arrowTowerAmmoTextureRegion.getTexture().unload();
		arrowTowerAmmoTextureRegion = null;
		cannonTowerAmmoTextureRegion.getTexture().unload();
		cannonTowerAmmoTextureRegion = null;
			//fire
			fireAnimationTiledTextureRegion.getTexture().unload();
			fireAnimationTiledTextureRegion = null;
			fire1pTextureRegion.getTexture().unload();
			fire1pTextureRegion = null;
			fire2pTextureRegion.getTexture().unload();
			fire2pTextureRegion = null;
			fire3pTextureRegion.getTexture().unload();
			fire3pTextureRegion = null;
			fire4pTextureRegion.getTexture().unload();
			fire4pTextureRegion = null;
			fire5pTextureRegion.getTexture().unload();
			fire5pTextureRegion = null;
			fire6pTextureRegion.getTexture().unload();
			fire6pTextureRegion = null;
			fire7pTextureRegion.getTexture().unload();
			fire7pTextureRegion = null;
			fire8pTextureRegion.getTexture().unload();
			fire8pTextureRegion = null;
			fire9pTextureRegion.getTexture().unload();
			fire9pTextureRegion = null;
			fire10pTextureRegion.getTexture().unload();
			fire10pTextureRegion = null;
			fire11pTextureRegion.getTexture().unload();
			fire11pTextureRegion = null;
			fire12pTextureRegion.getTexture().unload();
			fire12pTextureRegion = null;
			fire13pTextureRegion.getTexture().unload();
			fire13pTextureRegion = null;
			fire14pTextureRegion.getTexture().unload();
			fire14pTextureRegion = null;
			fire15pTextureRegion.getTexture().unload();
			fire15pTextureRegion = null;
			fire16pTextureRegion.getTexture().unload();
			fire16pTextureRegion = null;
			//lightning
			lightning1pTextureRegion.getTexture().unload();
			lightning1pTextureRegion = null;
			lightning2pTextureRegion.getTexture().unload();
			lightning2pTextureRegion = null;
			lightning3pTextureRegion.getTexture().unload();
			lightning3pTextureRegion = null;
			lightning4pTextureRegion.getTexture().unload();
			lightning4pTextureRegion = null;
			lightning5pTextureRegion.getTexture().unload();
			lightning5pTextureRegion = null;
			lightning6pTextureRegion.getTexture().unload();
			lightning6pTextureRegion = null;
			lightning7pTextureRegion.getTexture().unload();
			lightning7pTextureRegion = null;
			lightning8pTextureRegion.getTexture().unload();
			lightning8pTextureRegion = null;
			lightning9pTextureRegion.getTexture().unload();
			lightning9pTextureRegion = null;
			lightning10pTextureRegion.getTexture().unload();
			lightning10pTextureRegion = null;
			lightning11pTextureRegion.getTexture().unload();
			lightning11pTextureRegion = null;
			lightning12pTextureRegion.getTexture().unload();
			lightning12pTextureRegion = null;
			lightning13pTextureRegion.getTexture().unload();
			lightning13pTextureRegion = null;
			lightning14pTextureRegion.getTexture().unload();
			lightning14pTextureRegion = null;
			lightning15pTextureRegion.getTexture().unload();
			lightning15pTextureRegion = null;
			lightning16pTextureRegion.getTexture().unload();
			lightning16pTextureRegion = null;
			lightning17pTextureRegion.getTexture().unload();
			lightning17pTextureRegion = null;
			lightning18pTextureRegion.getTexture().unload();
			lightning18pTextureRegion = null;
			lightning19pTextureRegion.getTexture().unload();
			lightning19pTextureRegion = null;
			lightning20pTextureRegion.getTexture().unload();
			lightning20pTextureRegion = null;
			lightning21pTextureRegion.getTexture().unload();
			lightning21pTextureRegion = null;
			lightning22pTextureRegion.getTexture().unload();
			lightning22pTextureRegion = null;
			lightning23pTextureRegion.getTexture().unload();
			lightning23pTextureRegion = null;
			lightning24pTextureRegion.getTexture().unload();
			lightning24pTextureRegion = null;
			lightning25pTextureRegion.getTexture().unload();
			lightning25pTextureRegion = null;
			lightning26pTextureRegion.getTexture().unload();
			lightning26pTextureRegion = null;
			lightning27pTextureRegion.getTexture().unload();
			lightning27pTextureRegion = null;
			lightning28pTextureRegion.getTexture().unload();
			lightning28pTextureRegion = null;
			lightning29pTextureRegion.getTexture().unload();
			lightning29pTextureRegion = null;
			lightning30pTextureRegion.getTexture().unload();
			lightning30pTextureRegion = null;
			lightning31pTextureRegion.getTexture().unload();
			lightning31pTextureRegion = null;
			lightning32pTextureRegion.getTexture().unload();
			lightning32pTextureRegion = null;
			
		//health bars
		heatlhBarTenTextureRegion.getTexture().unload();
		heatlhBarTenTextureRegion = null;
		heatlhBarNineTextureRegion.getTexture().unload();
		heatlhBarNineTextureRegion = null;
		heatlhBarEightTextureRegion.getTexture().unload();
		heatlhBarEightTextureRegion = null;
		heatlhBarSevenTextureRegion.getTexture().unload();
		heatlhBarSevenTextureRegion = null;
		heatlhBarSixTextureRegion.getTexture().unload();
		heatlhBarSixTextureRegion = null;
		heatlhBarFiveTextureRegion.getTexture().unload();
		heatlhBarFiveTextureRegion = null;
		heatlhBarFourTextureRegion.getTexture().unload();
		heatlhBarFourTextureRegion = null;
		heatlhBarThreeTextureRegion.getTexture().unload();
		heatlhBarThreeTextureRegion = null;
		heatlhBarTwoTextureRegion.getTexture().unload();
		heatlhBarTwoTextureRegion = null;
		heatlhBarOneTextureRegion.getTexture().unload();
		heatlhBarOneTextureRegion = null;
	}
	
	public void loadFonts(){
        fontDefault32Bold = FontFactory.create(INSTANCE.getActivity().getFontManager(), INSTANCE.getActivity().getTextureManager(), 256, 256, Typeface.create(Typeface.DEFAULT, Typeface.BOLD),  16f, true, Color.WHITE_ARGB_PACKED_INT);
		fontDefault32Bold.load();
		fontDefault24Bold = FontFactory.create(INSTANCE.getActivity().getFontManager(), INSTANCE.getActivity().getTextureManager(), 256, 256, Typeface.create(Typeface.DEFAULT, Typeface.BOLD),  24f, true, Color.YELLOW_ARGB_PACKED_INT);
		fontDefault24Bold.load();
	}
	
	public void loadMainMenuSfx(){
		
	}
	
	public void loadGameSfx(){
		try{
		placeTowerSound = SoundFactory.createSoundFromAsset(INSTANCE.getActivity().getSoundManager(),INSTANCE.getActivity(),"soundPlaceTower.mp3");
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static Font getFont(){
		return fontDefault32Bold;
	}
	
	public static Font getTextBoxFont(){
		return fontDefault24Bold;
	}
	
	public static ITextureRegion getGrassTileTextureRegion(){
		return grassTileTextureRegion;
	}
	
	public static ITextureRegion getSandTileTextureRegion(String kuvio){
		ITextureRegion valittu = null;
		if(kuvio=="SNT"){
			valittu = sandTileTextureRegion;
		}else if(kuvio=="SUL"){
			valittu = sandTileUpperLeftTextureRegion;
		}else if(kuvio=="SUR"){
			valittu = sandTileUpperRightTextureRegion;
		}else if(kuvio=="SDL"){
			valittu = sandTileDownLeftTextureRegion;
		}else if(kuvio=="SDR"){
			valittu = sandTileDownRightTextureRegion;
		}else if(kuvio=="SC1"){
			valittu = sandTileUpperRightCornerTextureRegion;
		}else if(kuvio=="SC2"){
			valittu = sandTileUpperLeftCornerTextureRegion;
		}else if(kuvio=="SC3"){
			valittu = sandTileDownRightCornerTextureRegion;
		}else if(kuvio=="SC4"){
			valittu = sandTileDownLeftCornerTextureRegion;
		}else if(kuvio=="SVN"){
			valittu = sandTileVerticalTextureRegion;
		}else if(kuvio=="SVL"){
			valittu = sandTileVerticalLeftTextureRegion;
		}else if(kuvio=="SVR"){
			valittu = sandTileVerticalRightTextureRegion;
		}else if(kuvio=="SHN"){
			valittu = sandTileHorizontalTextureRegion;
		}else if(kuvio=="SHU"){
			valittu = sandTileHorizontalUpTextureRegion;
		}else if(kuvio=="SHD"){
			valittu = sandTileHorizontalDownTextureRegion;
		}
		
		return valittu;
	}
	
	public static ITextureRegion getSpawnTileTextureRegion(){
		return spawnTileTextureRegion;
	}
	
	public static ITextureRegion getArrowTowerTextureRegion(){
		return arrowTowerTextureRegion;
	}
	
	public static ITextureRegion getCannonTowerTextureRegion(){
		return cannonTowerTextureRegion;
	}
	
	public static ITextureRegion getFireTowerTextureRegion(){
		return fireTowerTextureRegion;
	}
	
	public static ITextureRegion getLightningTowerTextureRegion(){
		return lightningTowerTextureRegion;
	}
	
	public static ITextureRegion getCreepHumanTextureRegion(){
		return creepHumanTextureRegion;
	}
	
	public static TiledTextureRegion getCreepBigHumanNormalTiledTextureRegion(){
		return creepBigHumanNormalTiledTextureRegion;
	}
	
	public static ITextureRegion getArrowTowerAmmoTextureRegion(){
		return arrowTowerAmmoTextureRegion;
	}
	
	public static ITextureRegion getCannonTowerAmmoTextureRegion(){
		return cannonTowerAmmoTextureRegion;
	}
	
	public static ITextureRegion getCreepHumanDeathTextureRegion(){
		return creepHumanDeathTextureRegion;
	}
	
	public static ITextureRegion getStartWaveTextureRegion(){
		return startWaveTextureRegion;
	}
	
	public static ITextureRegion getMainMenuBackgroundTextureRegion(){
		return mainMenuBackgroundTextureRegion;
	}
	
	public static ITextureRegion getStartGameTextureRegion(){
		return startGameTextureRegion;
	}
	
	public static ITextureRegion getQuitGameTextureRegion(){
		return quitGameTextureRegion;
	}
	
	public static ITextureRegion getLevelSelectionBackgroundTextureRegion(){
		return levelSelectionBackgroundTextureRegion;
	}
	
	public static ITextureRegion getLevelOneButtonTextureRegion(){
		return levelOneButtonTextureRegion;
	}
	
	public static ITextureRegion getLevelTwoButtonTextureRegion(){
		return levelTwoButtonTextureRegion;
	}
	
	public static ITextureRegion getLoadingBackgroundTextureRegion(){
		return loadingBackgroundTextureRegion;
	}
	
	public static ITextureRegion getQuitGameScreenTextureRegion(){
		return quitGameScreenTextureRegion;
	}
	
	public static ITextureRegion getQuitGameScreenYesTextureRegion(){
		return quitGameScreenYesTextureRegion;
	}
	
	public static ITextureRegion getQuitGameScreenNoTextureRegion(){
		return quitGameScreenNoTextureRegion;
	}
	
	public static ITextureRegion getExitLevelScreenTextureRegion(){
		return exitLevelScreenTextureRegion;
	}
	
	public static ITextureRegion getHealthBarTextureRegion(int health){
		ITextureRegion returnThis = null;
		if(health == 10){
			returnThis =  heatlhBarTenTextureRegion;
		}else if(health == 9){
			returnThis =  heatlhBarNineTextureRegion;
		}else if(health == 8){
			returnThis =  heatlhBarEightTextureRegion;
		}else if(health == 7){
			returnThis =  heatlhBarSevenTextureRegion;
		}else if(health == 6){
			returnThis =  heatlhBarSixTextureRegion;
		}else if(health == 5){
			returnThis =  heatlhBarFiveTextureRegion;
		}else if(health == 4){
			returnThis =  heatlhBarFourTextureRegion;
		}else if(health == 3){
			returnThis =  heatlhBarThreeTextureRegion;
		}else if(health == 2){
			returnThis =  heatlhBarTwoTextureRegion;
		}else if(health == 1){
			returnThis =  heatlhBarOneTextureRegion;
		}
		return returnThis;
	}
	
	public static TiledTextureRegion getFireAnimationTiledTextureRegion(){
		return fireAnimationTiledTextureRegion;
	}
	
	public static ITextureRegion getFireTipTextureRegion(){
		return fireTipTextureRegion;
	}
	
	public static ITextureRegion getFireTailTextureRegion(int choice){
		ITextureRegion returnThis = null;
		if(choice == 1){
			returnThis =  fire1pTextureRegion;
		}else if(choice == 2){
			returnThis =  fire2pTextureRegion;
		}else if(choice == 3){
			returnThis =  fire3pTextureRegion;
		}else if(choice == 4){
			returnThis =  fire4pTextureRegion;
		}else if(choice == 5){
			returnThis =  fire5pTextureRegion;
		}else if(choice == 6){
			returnThis =  fire6pTextureRegion;
		}else if(choice == 7){
			returnThis =  fire7pTextureRegion;
		}else if(choice == 8){
			returnThis =  fire8pTextureRegion;
		}else if(choice == 9){
			returnThis =  fire9pTextureRegion;
		}else if(choice == 10){
			returnThis =  fire10pTextureRegion;
		}else if(choice == 11){
			returnThis =  fire11pTextureRegion;
		}else if(choice == 12){
			returnThis =  fire12pTextureRegion;
		}else if(choice == 13){
			returnThis =  fire13pTextureRegion;
		}else if(choice == 14){
			returnThis =  fire14pTextureRegion;
		}else if(choice == 15){
			returnThis =  fire15pTextureRegion;
		}else if(choice == 16){
			returnThis =  fire16pTextureRegion;
		}
		return returnThis;
	}
	
	public static ITextureRegion getLightningTowerAmmoTextureRegion(int length){
		ITextureRegion returnThis = null;
		if(length == 1){
			returnThis = lightning1pTextureRegion;
		}else if(length == 2){
			returnThis = lightning2pTextureRegion;
		}else if(length == 3){
			returnThis = lightning3pTextureRegion;
		}else if(length == 4){
			returnThis = lightning4pTextureRegion;
		}else if(length == 5){
			returnThis = lightning5pTextureRegion;
		}else if(length == 6){
			returnThis = lightning6pTextureRegion;
		}else if(length == 7){
			returnThis = lightning7pTextureRegion;
		}else if(length == 8){
			returnThis = lightning8pTextureRegion;
		}else if(length == 9){
			returnThis = lightning9pTextureRegion;
		}else if(length == 10){
			returnThis = lightning10pTextureRegion;
		}else if(length == 11){
			returnThis = lightning11pTextureRegion;
		}else if(length == 12){
			returnThis = lightning12pTextureRegion;
		}else if(length == 13){
			returnThis = lightning13pTextureRegion;
		}else if(length == 14){
			returnThis = lightning14pTextureRegion;
		}else if(length == 15){
			returnThis = lightning15pTextureRegion;
		}else if(length == 16){
			returnThis = lightning16pTextureRegion;
		}else if(length == 17){
			returnThis = lightning17pTextureRegion;
		}else if(length == 18){
			returnThis = lightning18pTextureRegion;
		}else if(length == 19){
			returnThis = lightning19pTextureRegion;
		}else if(length == 20){
			returnThis = lightning20pTextureRegion;
		}else if(length == 21){
			returnThis = lightning21pTextureRegion;
		}else if(length == 22){
			returnThis = lightning22pTextureRegion;
		}else if(length == 23){
			returnThis = lightning23pTextureRegion;
		}else if(length == 24){
			returnThis = lightning24pTextureRegion;
		}else if(length == 25){
			returnThis = lightning25pTextureRegion;
		}else if(length == 26){
			returnThis = lightning26pTextureRegion;
		}else if(length == 27){
			returnThis = lightning27pTextureRegion;
		}else if(length == 28){
			returnThis = lightning28pTextureRegion;
		}else if(length == 29){
			returnThis = lightning29pTextureRegion;
		}else if(length == 30){
			returnThis = lightning30pTextureRegion;
		}else if(length == 31){
			returnThis = lightning31pTextureRegion;
		}else if(length == 32){
			returnThis = lightning32pTextureRegion;
		}
		return returnThis;
	}
	
	public static ITextureRegion getTextBoxTextureRegion(){
		return textBoxTextureRegion;
	}

}
