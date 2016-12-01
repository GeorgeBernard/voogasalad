package game_data.characteristics;

import java.util.Map;

import game_data.Sprite;
import game_engine.actions.Action;
import game_engine.actions.Hit;
import javafx.geometry.Side;

/**
 * @author Alex & James
 *
 */
public class Impassable implements Characteristic{
	
	private Sprite mySprite;
	private Action myAction;
	
	public Impassable(Sprite aSprite){
		mySprite = aSprite;
	}
	
	
	@Override
	public void execute(Map<Sprite, Side> myCollisionMap){
		for(Sprite collidedSprite:myCollisionMap.keySet()){
			myAction = new Hit(collidedSprite, myCollisionMap.get(collidedSprite));
			myAction.act();
		}
	}

	@Override
	public Characteristic copy() {
		return new Impassable(mySprite);
	}

}