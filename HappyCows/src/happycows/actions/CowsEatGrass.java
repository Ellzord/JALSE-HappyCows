package happycows.actions;

import happycows.attributes.Position;
import happycows.entities.Cow;
import happycows.entities.Grass;
import jalse.JALSE;
import jalse.actions.Action;
import jalse.entities.Entity;
import jalse.misc.Engine.TickInfo;

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
