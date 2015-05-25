package happycows.entities;

import happycows.actions.SproutGrass;
import jalse.JALSE;
import jalse.entities.Entity;
import jalse.entities.EntityEvent;
import jalse.entities.EntityListener;

import java.util.concurrent.TimeUnit;

public class GrowGrass implements EntityListener {

    @Override
    public void entityKilled(final EntityEvent event) {
	// Get entity that was killed
	final Entity e = event.getEntity();

	// Check it was grass
	if (e.isMarkedAsType(Grass.class)) {
	    System.out.println(String.format("Grass has been eaten [%s]", e.getID()));
	    // Schedule another to be created
	    ((JALSE) event.getContainer()).scheduleForActor(new SproutGrass(), 300, TimeUnit.MILLISECONDS);
	}
    }
}
