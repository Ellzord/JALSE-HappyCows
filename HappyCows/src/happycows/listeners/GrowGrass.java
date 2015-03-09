package happycows.listeners;

import happycows.actions.SproutGrass;
import happycows.agents.Grass;
import jalse.JALSE;
import jalse.entities.Entity;
import jalse.listeners.EntityAdapter;
import jalse.listeners.EntityEvent;

import java.util.concurrent.TimeUnit;

public class GrowGrass extends EntityAdapter {

    @Override
    public void entityKilled(final EntityEvent event) {
	final Entity e = event.getEntity();
	if (e.isMarkedAsType(Grass.class)) {
	    System.out.println(String.format("Grass has been eaten [%s]", e.getID()));
	    ((JALSE) event.getContainer()).scheduleAction(new SproutGrass(), 300, TimeUnit.MILLISECONDS);
	}
    }

}
