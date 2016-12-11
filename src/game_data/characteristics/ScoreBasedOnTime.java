/*
 * Authors: Alex + Austin
 * 
 */

package game_data.characteristics;

import java.util.Map;

import game_data.Sprite;
import game_data.characteristics.characteristic_annotations.NameAnnotation;
import game_data.characteristics.characteristic_annotations.ParameterAnnotation;
import game_data.sprites.Player;
import game_engine.GameResources;
import game_engine.actions.Action;
import game_engine.actions.Break;
import game_engine.actions.ScoreAdder;
import game_engine.Side;

@NameAnnotation(name = "Score Based On Position")
public class ScoreBasedOnTime implements Characteristic {

	private Sprite mySprite;
	private double scorePerSecond;

	@ParameterAnnotation(parameters = { "Sprite", "Score Per Second" })
	public ScoreBasedOnTime(Sprite aSprite, double scorePerSecond) {
		mySprite = aSprite;
		this.scorePerSecond = scorePerSecond;
	}

	@Override
	public void execute(Map<Sprite, Side> myCollisionMap) {
		Action myAction = new ScoreAdder(scorePerSecond/GameResources.TIME_FRAME.getDoubleResource(), mySprite);
//		System.out.println("HELLO")
		myAction.act();
	}

	@Override
	public Characteristic copy() {
		return new ScoreBasedOnTime(mySprite, scorePerSecond);
	}

}