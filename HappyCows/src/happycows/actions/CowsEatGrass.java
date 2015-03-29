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
	final JALSE actor = tick.getOrNullActor();
	actor.streamEntitiesOfType(Cow.class).forEach(
		cow -> {
		    final Point pos = cow.getPosition();
		    actor.streamEntitiesOfType(Grass.class)
			    .filter(a -> pos.equals(a.getOrNullAttributeOfType("position"))).forEach(Entity::kill);
		});
    }
}
