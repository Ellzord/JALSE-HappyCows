package happycows.actions;

import happycows.agents.Grass;
import happycows.attributes.Position;
import jalse.JALSE;
import jalse.actions.Action;
import jalse.actions.TickInfo;

public class SproutGrass implements Action<JALSE> {

    @Override
    public void perform(final JALSE actor, final TickInfo tick) {

	final Grass grass = actor.newEntity(Grass.class);
	grass.addAttributeOfType(Position.randomPosition());

	System.out.println(String.format("New grass has sprouted [%s]", grass.getID()));
    }
}
