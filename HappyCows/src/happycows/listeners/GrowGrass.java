package happycows.listeners;

import happycows.HappyCows;
import happycows.actions.SproutGrass;
import happycows.agents.Grass;
import jalse.agents.Agent;
import jalse.listeners.AgentAdapter;

import java.util.concurrent.TimeUnit;

public class GrowGrass extends AgentAdapter {

    @Override
    public void agentKilled(final Agent a) {

	if (a.isMarkedAsType(Grass.class)) {

	    System.out.println(String.format("Grass has been eaten [%s]", a.getID()));

	    HappyCows.jalse.streamClusters().findAny()
		    .ifPresent(field -> field.schedule(new SproutGrass(), 300, TimeUnit.MILLISECONDS));
	}
    }
}
