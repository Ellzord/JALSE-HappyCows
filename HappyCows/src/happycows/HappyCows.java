package happycows;

import static jalse.actions.ActionChain.newChain;
import happycows.actions.CowsEatGrass;
import happycows.actions.MoveCows;
import happycows.actions.SproutGrass;
import happycows.agents.Cow;
import happycows.attributes.Position;
import happycows.attributes.Size;
import happycows.listeners.GrowGrass;
import happycows.listeners.Moo;
import jalse.Cluster;
import jalse.JALSE;
import jalse.JALSEBuilder;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class HappyCows {

    public static final JALSE jalse = new JALSEBuilder(30).setTotalThreads(1).create();

    public static void main(final String[] args) throws InterruptedException {

	final Cluster field = jalse.newCluster(UUID.randomUUID());

	System.out.println(String.format("A field is made [%dx%d]", 4, 4));

	field.associate(new Size(4, 4));
	field.addAgentListener(new GrowGrass());
	field.addListenerSupplier(Position.class, () -> new Moo());
	field.schedule(newChain(new CowsEatGrass(), new MoveCows()), 100, 500, TimeUnit.MILLISECONDS);

	System.out.println("Planting seeds");

	for (int i = 0; i < 8; i++) {

	    field.schedule(new SproutGrass(), 10, TimeUnit.MILLISECONDS);
	}

	for (int i = 0; i < 4; i++) {

	    final Cow cow = field.newAgent(Cow.class);
	    cow.setPosition(Position.randomPosition(4, 4));

	    System.out.println(String.format("A cow is born [%s]", cow.getID()));
	}

	jalse.tick();

	Thread.sleep(TimeUnit.SECONDS.toMillis(30));

	jalse.stop();
    }
}
