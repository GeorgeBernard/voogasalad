package game_data.characteristics;

import game_data.Sprite;
import game_data.characteristics.characteristic_annotations.CharacteristicAnnotation;
import game_data.characteristics.characteristic_annotations.ParameterAnnotation;

/**
 * @author austingartside
 *
 */

@CharacteristicAnnotation(name = "Power Up")
public abstract class PowerUpper implements Characteristic{
	
	protected Sprite mySprite;
	
	@ParameterAnnotation(parameters = {"Sprite"})
	public PowerUpper(Sprite aSprite){
		mySprite = aSprite;
	}
	
	public Sprite getSprite(){
		return mySprite;
	}
	

}