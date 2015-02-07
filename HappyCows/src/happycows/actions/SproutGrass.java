package happycows.actions;

import happycows.agents.Grass;
import happycows.attributes.Position;
import happycows.attributes.Size;
import jalse.Cluster;
import jalse.TickInfo;
import jalse.actions.Action;

public class SproutGrass implements Action<Cluster> {

    @Override
    public void perform(final Cluster actor, final TickInfo tick) {

	final Size s = actor.getOfTypeOrNull(Size.class);

	final Grass grass = actor.newAgent(Grass.class);
	grass.associate(Position.randomPosition(s.getWidth(), s.getHeight()));

	System.out.println(String.format("New grass has sprouted [%s]", grass.getID()));
    }
}
