package happycows.actions;

import happycows.agents.Cow;
import happycows.agents.Grass;
import happycows.attributes.Position;
import jalse.Cluster;
import jalse.TickInfo;
import jalse.actions.Action;

public class CowsEatGrass implements Action<Cluster> {

    @Override
    public void perform(final Cluster actor, final TickInfo tick) {

	actor.filterAgents(isMarkedAs(Cow.class), Cow.class).forEach(
		cow -> {

		    final Position p = cow.getPosition().get();

		    actor.streamAgents().filter(isMarkedAs(Grass.class))
			    .filter(a -> p.equals(a.getOfType(Position.class).get())).findAny()
			    .ifPresent(a -> a.kill());
		});
    }
}
