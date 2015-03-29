package happycows.actions;

import happycows.HappyCows;
import happycows.entities.Grass;
import jalse.JALSE;
import jalse.actions.Action;
import jalse.actions.ActionContext;

import java.awt.Point;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SproutGrass implements Action<JALSE> {

    public static Point randomPosition() {
	final Random rand = ThreadLocalRandom.current();
	return new Point(rand.nextInt(HappyCows.WIDTH), rand.nextInt(HappyCows.HEIGHT));
    }

    @Override
    public void perform(final ActionContext<JALSE> context) {
	final Grass grass = context.getOrNullActor().newEntity(Grass.class);
	grass.addAttributeOfType("position", Point.class, randomPosition());
	System.out.println(String.format("New grass has sprouted [%s]", grass.getID()));
    }
}
