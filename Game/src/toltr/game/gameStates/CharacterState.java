package toltr.game.gameStates;

import java.util.List;

import org.lwjgl.util.vector.Vector2f;

import toltr.engine.entities.Entity;
import toltr.engine.gameStates.GameState;
import toltr.engine.graphics.guis.GuiComponent;
import toltr.engine.graphics.text.Text;
import toltr.game.entities.Player;
import toltr.game.entities.PlayerStats;
import toltr.game.map.Map;

public class CharacterState extends GameState{
	
	private Text healthText, goldText, levelText, expText;

	public CharacterState(Player player, Map map, List<GuiComponent> guis, List<Entity> entities,
			List<Text> strings) {
		super(player, map, guis, entities, strings);
		healthText = new Text(new Vector2f(-1.8f, 0.1f), -0.4f, 0.03f, "");
		levelText = new Text(new Vector2f(-1.8f, 0.3f), -0.4f, 0.03f, "");
		expText = new Text(new Vector2f(-1.8f, 0.2f), -0.4f, 0.03f, "");
		goldText = new Text(new Vector2f(-1.8f, 0f), -0.4f, 0.03f, "");
		strings.add(healthText);
		strings.add(levelText);
		strings.add(expText);
		strings.add(goldText);
	}

	@Override
	protected void update() {
	}

	@Override
	public void cleanUp() {
	}

	@Override
	public void init() {
		GameStates.resetLevels();
		healthText.changeText("Health  " + PlayerStats.getHealth() + "HP");
		levelText.changeText("Level  " + PlayerStats.getLevel());
		expText.changeText("Exp  " + PlayerStats.getExp());
		goldText.changeText(PlayerStats.getGold() + " gold");
	}

}
