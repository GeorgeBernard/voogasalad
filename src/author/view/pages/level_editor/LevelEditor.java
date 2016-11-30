package author.view.pages.level_editor;


import author.controller.IAuthorController;
import author.view.pages.level_editor.windows.AbstractLevelEditorWindow;
import author.view.pages.level_editor.windows.LevelWindowFactory;
import author.view.pages.level_editor.windows.level_edit_window.ILevelEditWindowExternal;
import author.view.pages.level_editor.windows.level_edit_window.LevelEditWindowFactory;
import game_data.Level;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * This Class serves as a view for the level editor page
 * 
 * @author George Bernard
 * @author Jordan Frazier
 */
class LevelEditor implements ILevelEditorExternal, ILevelEditorInternal{
	private BorderPane myPane;

	private AbstractLevelEditorWindow myLevelWindow;
	private AbstractLevelEditorWindow myEntityWindow;
	private AbstractLevelEditorWindow mySelectionWindow;
	private AbstractLevelEditorWindow myProgressionWindow;
	private IAuthorController authorController;

	LevelEditor(IAuthorController authorController) {
		this.authorController = authorController;
		myPane = new BorderPane();
		myPane.setCenter(buildLevelWindow());
		myPane.setRight(buildEntityWindow());
		myPane.setLeft(buildLevelSelectionWindow());
		myPane.setBottom(buildLevelProgressionWindow());
	}

	private Pane buildLevelWindow() {
		myLevelWindow = new LevelWindowFactory().createInstance("LevelWindow", this.authorController);
		return myLevelWindow.getWindow();
	}

	private Pane buildEntityWindow() {
		myEntityWindow = new LevelWindowFactory().createInstance("EntityWindow", this.authorController);
		return myEntityWindow.getWindow();
	}

	private Pane buildLevelProgressionWindow() {
		myProgressionWindow = new LevelWindowFactory().createInstance("LevelProgressionWindow", this.authorController);
		return myProgressionWindow.getWindow();
	}

	private Pane buildLevelSelectionWindow() {
		mySelectionWindow = new LevelWindowFactory().createInstance("LevelSelectionWindow", this.authorController);
		return mySelectionWindow.getWindow();
	}

	public Pane getPane() {
		return myPane;
	}

	public AbstractLevelEditorWindow getMyLevelWindow() {
		return myLevelWindow;
	}

	public AbstractLevelEditorWindow getMyEntityWindow() {
		return myEntityWindow;
	}

	public AbstractLevelEditorWindow getMySelectionWindow() {
		return mySelectionWindow;
	}

	public AbstractLevelEditorWindow getMyProgressionWindow() {
		return myProgressionWindow;
	}
	
	public Level createLevel(){
		ILevelEditWindowExternal levelEditWindow = new LevelEditWindowFactory().create();
		Level createdLevel = levelEditWindow.getLevel();
		return createdLevel;
	}

	@Override
	public String toString() {
		return "Level Editor";
	}

}