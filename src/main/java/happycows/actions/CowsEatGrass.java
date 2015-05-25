package happycows.actions;

import happycows.entities.Cow;
import happycows.entities.Grass;
import jalse.JALSE;
import jalse.actions.Action;
import jalse.actions.ActionContext;
import jalse.entities.Entity;

import java.awt.Point;

public class CowsEatGrass implements Action<JALSE> {

    @Override
    public void perform(final ActionContext<JALSE> tick) {
	// The actor for this action
	final JALSE jalse = tick.getActor();

	// Only process cows
	jalse.streamEntitiesOfType(Cow.class).forEach(c -> {
	    // Eat grass at the same position
	    final Point pos = c.getPosition();
	    jalse.streamEntitiesOfType(Grass.class).filter(g -> pos.equals(g.getPosition())).forEach(Entity::kill);
	});
    }
}
