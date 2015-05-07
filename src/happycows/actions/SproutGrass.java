package happycows.actions;

import happycows.HappyCows;
import happycows.entities.Grass;
import jalse.JALSE;
import jalse.actions.Action;
import jalse.actions.ActionContext;

public class SproutGrass implements Action<JALSE> {

    @Override
    public void perform(final ActionContext<JALSE> context) {
	// Get the actor this action was scheduled for
	final JALSE jalse = context.getActor();

	// Created entity marked as grass
	final Grass grass = jalse.newEntity(Grass.class);
	// Place in random position
	grass.setPosition(HappyCows.randomPosition());

	System.out.println(String.format("New grass has sprouted [%s]", grass.getID()));
    }
}
