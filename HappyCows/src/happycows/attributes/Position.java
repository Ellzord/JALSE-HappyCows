package happycows.attributes;

import happycows.HappyCows;
import jalse.attributes.NonAttributeWrapper;

import java.awt.Point;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Position extends NonAttributeWrapper<Point> {

    public Position(final int x, final int y) {

	this(new Point(x, y));
    }

    public Position(final Point position) {

	super(position);
    }

    public static Position randomPosition() {

	final Random rand = ThreadLocalRandom.current();

	return new Position(rand.nextInt(HappyCows.WIDTH), rand.nextInt(HappyCows.HEIGHT));
    }
}
