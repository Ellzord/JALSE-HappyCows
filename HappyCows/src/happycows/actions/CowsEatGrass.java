package happycows.actions;

import static jalse.attributes.NonAttributeWrapper.unwrap;
import happycows.agents.Cow;
import happycows.agents.Grass;
import happycows.attributes.Position;
import jalse.Cluster;
import jalse.TickInfo;
import jalse.actions.Action;

import java.awt.Point;

public class CowsEatGrass implements Action<Cluster> {

    @Override
    public void perform(final Cluster actor, final TickInfo tick) {

	actor.streamAgentsOfType(Cow.class).forEach(
		cow -> {

		    final Point pos = unwrap(cow.getPosition());

		    actor.streamAgentsOfType(Grass.class).filter(a -> pos.equals(a.getOfTypeAndUnwrap(Position.class)))
			    .findAny().ifPresent(a -> a.kill());
		});
    }
}
