package game_data.states;

public class Visible implements State{

	private boolean isVisible;
	
	public Visible(){
		this.isVisible = true;
	}
	
	public Visible(boolean visible){
		this.isVisible = visible;
	}
	
	public void setVisibility(boolean visible){
		isVisible = visible;
	}
	
	public boolean isVisibile(){
		return isVisible;
	}
	
	@Override
	public State copy() {
		return new Visible();
	}

	@Override
	public void updateState(double pain) {
		// TODO Auto-generated method stub
	}

}
