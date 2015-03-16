package happycows;

import static jalse.engine.actions.ActionChain.newChain;
import happycows.actions.CowsEatGrass;
import happycows.actions.MoveCows;
import happycows.actions.SproutGrass;
import happycows.attributes.Position;
import happycows.entities.Cow;
import happycows.listeners.GrowGrass;
import happycows.listeners.Moo;
import jalse.JALSE;
import jalse.JALSEBuilder;
import jalse.listeners.Listeners;

import java.util.concurrent.TimeUnit;

public class HappyCows {

    public static final int WIDTH = 4;

    public static final int HEIGHT = 4;

    public static void main(final String[] args) throws InterruptedException {
	final JALSE jalse = JALSEBuilder.buildSingleThreadedJALSE(5);

	jalse.addEntityListener(new GrowGrass());
	jalse.scheduleAction(newChain(new CowsEatGrass(), new MoveCows()), 100, 500, TimeUnit.MILLISECONDS);
	jalse.addEntityListener(Listeners.createAttributeListenerSupplier(Moo::new));

	System.out.println(String.format("A field is made [%dx%d]", WIDTH, HEIGHT));

	for (int i = 0; i < 8; i++) {
	    System.out.println("Planting seeds..");
	    jalse.scheduleAction(new SproutGrass(), 10, TimeUnit.MILLISECONDS);
	}

	for (int i = 0; i < 4; i++) {
	    final Cow cow = jalse.newEntity(Cow.class);
	    cow.setPosition(Position.randomPosition());
	    System.out.println(String.format("A cow is born [%s]", cow.getID()));
	}

	jalse.tick();
	Thread.sleep(TimeUnit.SECONDS.toMillis(10));
	jalse.stop();

	System.out.println("All the cows have gone to sleep");
    }
}
