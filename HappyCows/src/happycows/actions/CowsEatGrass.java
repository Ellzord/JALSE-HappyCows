package happycows.actions;

import static jalse.attributes.Attributes.newTypeOf;
import happycows.entities.Cow;
import happycows.entities.Grass;
import jalse.JALSE;
import jalse.actions.Action;
import jalse.actions.ActionContext;
import jalse.attributes.AttributeType;
import jalse.entities.Entity;

import java.awt.Point;

public class CowsEatGrass implements Action<JALSE> {

    @Override
    public void perform(final ActionContext<JALSE> tick) {
	final JALSE actor = tick.getActor();
	actor.streamEntitiesOfType(Cow.class).forEach(
		cow -> {
		    final Point pos = cow.getPosition();
		    final AttributeType<Point> posType = newTypeOf(Point.class);
		    actor.streamEntitiesOfType(Grass.class)
			    .filter(a -> pos.equals(a.getAttributeOfType("position", posType))).forEach(Entity::kill);
		});
    }
}
