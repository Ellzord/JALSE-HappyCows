package happycows.actions;

import happycows.attributes.Position;
import happycows.entities.Cow;
import happycows.entities.Grass;
import jalse.JALSE;
import jalse.engine.actions.Action;
import jalse.engine.actions.ActionContext;
import jalse.entities.Entity;

public class CowsEatGrass implements Action<JALSE> {

    @Override
    public void perform(final ActionContext<JALSE> tick) {
	final JALSE actor = tick.getActor();
	actor.streamEntitiesOfType(Cow.class).forEach(
		cow -> {
		    final Position pos = cow.getPosition().get();
		    actor.streamEntitiesOfType(Grass.class)
			    .filter(a -> pos.equals(a.getOrNullAttributeOfType(Position.class))).forEach(Entity::kill);
		});
    }
}
