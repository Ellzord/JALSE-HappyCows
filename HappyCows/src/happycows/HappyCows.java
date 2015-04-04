package happycows;

import static jalse.actions.MultiActionBuilder.buildChain;
import static jalse.attributes.Attributes.newNamedTypeOf;
import happycows.actions.CowsEatGrass;
import happycows.actions.MoveCows;
import happycows.actions.SproutGrass;
import happycows.entities.Cow;
import happycows.listeners.GrowGrass;
import happycows.listeners.Moo;
import jalse.JALSE;
import jalse.JALSEBuilder;
import jalse.attributes.NamedAttributeType;

import java.awt.Point;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class HappyCows {

    public static final int WIDTH = 4;

    public static final int HEIGHT = 4;

    public static final int COWS = 4;

    public static final int GRASS = 8;

    public static void main(final String[] args) throws InterruptedException {
	// Create a single threaded parent container.
	final JALSE jalse = JALSEBuilder.buildSingleThreadedJALSE();

	System.out.println(String.format("Creating a field [%dx%d]", WIDTH, HEIGHT));

	// Listen for grass being eaten
	jalse.addEntityListener(new GrowGrass());
	// Schedule grass to be eaten and cows to be moved.
	jalse.scheduleForActor(buildChain(new CowsEatGrass(), new MoveCows()), 200, 500, TimeUnit.MILLISECONDS);

	System.out.println(String.format("Planting %d seeds..", GRASS));

	for (int i = 0; i < GRASS; i++) {
	    // Schedule grass to be created
	    jalse.scheduleForActor(new SproutGrass());
	}

	System.out.println(String.format("Birthing %d cows..", COWS));

	// Create the type.
	final NamedAttributeType<Point> posType = newNamedTypeOf("position", Point.class);

	for (int i = 0; i < COWS; i++) {
	    // Create a new entity marked as a cow
	    final Cow cow = jalse.newEntity(Cow.class);
	    // Place randomly in the field
	    cow.setPosition(randomPosition());
	    // Moo when it moves
	    cow.addAttributeListener(posType, new Moo());

	    System.out.println(String.format("A cow is born [%s]", cow.getID()));
	}

	// Sleep for 10 seconds to allow life to exist
	Thread.sleep(TimeUnit.SECONDS.toMillis(10));
	// Cancel all actions.
	jalse.stop();

	System.out.println("All the cows have gone to sleep");
    }

    public static Point randomPosition() {
	final Random rand = ThreadLocalRandom.current();
	return new Point(rand.nextInt(HappyCows.WIDTH), rand.nextInt(HappyCows.HEIGHT));
    }
}
