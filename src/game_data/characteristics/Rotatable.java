package game_data.characteristics;

import java.util.Map;

import game_data.Sprite;
import game_data.characteristics.characteristic_annotations.CharacteristicAnnotation;
import game_data.characteristics.characteristic_annotations.ParameterAnnotation;
import javafx.geometry.Side;

/**
 * @author austingartside
 *
 */

@CharacteristicAnnotation(name = "Rotatable")
public class Rotatable implements Characteristic{

	private double mySpeed;
	private Sprite mySprite;
	
	public Rotatable(double speed, Sprite aSprite){
		mySpeed = speed;
		mySprite = aSprite;
	}
	
	public double getSpeed(){
		return mySpeed;
	}

	@Override
	public Characteristic copy() {
		return new Rotatable(mySpeed, mySprite.clone());
	}

	@Override
	public void execute(Map<Sprite, Side> myCollisionMap) {		
		//TODO: make and execute rotate action
		//myAction = new Bounce();
		//myAction.act();
	}

}
