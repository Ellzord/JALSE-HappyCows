package happycows.actions;

import happycows.agents.Cow;
import happycows.agents.Grass;
import happycows.attributes.Position;
import jalse.JALSE;
import jalse.actions.Action;
import jalse.actions.TickInfo;
import jalse.entities.Entity;

public class CowsEatGrass implements Action<JALSE> {

    @Override
    public void perform(final JALSE actor, final TickInfo tick) {
	actor.streamEntitiesOfType(Cow.class).forEach(
		cow -> {
		    final Position pos = cow.getOrNullAttributeOfType(Position.class);
		    actor.streamEntitiesOfType(Grass.class)
			    .filter(a -> pos.equals(a.getOrNullAttributeOfType(Position.class))).forEach(Entity::kill);
		});
    }

}
