package game_data.characteristics;

import java.util.Map;

import game_data.Sprite;
import game_data.characteristics.characteristic_annotations.CharacteristicAnnotation;
import game_data.sprites.Player;
import game_engine.actions.WinLevel;
import javafx.geometry.Side;

/**
 * @author austingartside
 *
 */
@CharacteristicAnnotation(name = "Winnable")
public class Winnable implements Characteristic{
	
	private Sprite mySprite;
	
	public Winnable(Sprite aSprite){
		mySprite = aSprite;
	}

	@Override
	public Characteristic copy() {
		return new Winnable(mySprite.clone());
	}

	@Override
	public void execute(Map<Sprite, Side> myCollisionMap) {
		//TODO: make and execute win action
		for(Sprite collidedSprite:myCollisionMap.keySet()){
			if(collidedSprite instanceof Player){
				WinLevel winlevel=new WinLevel(collidedSprite);
				winlevel.act();
			}
		}
	}


}