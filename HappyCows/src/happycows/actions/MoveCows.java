package happycows.actions;

import static jalse.attributes.NonAttributeWrapper.unwrap;
import happycows.agents.Cow;
import happycows.attributes.Position;
import happycows.attributes.Size;
import jalse.Cluster;
import jalse.TickInfo;
import jalse.actions.Action;

import java.awt.Point;
import java.util.concurrent.ThreadLocalRandom;

public class MoveCows implements Action<Cluster> {

    public enum Direction {

	DOWN, LEFT, RIGHT, UP;

	public static Direction random() {

	    final Direction[] dirs = values();

	    return dirs[ThreadLocalRandom.current().nextInt(dirs.length)];
	}
    }

    private static boolean setInBounds(final Size s, final Point p, double x, double y) {

	if (x > s.getWidth()) {

	    x = s.getWidth();
	}

	if (x < 0) {

	    x = 0;
	}

	if (y > s.getHeight()) {

	    y = s.getHeight();
	}

	if (y < 0) {

	    y = 0;
	}

	boolean changed;

	if (changed = p.getX() != x || p.getY() != y) {

	    p.setLocation(x, y);
	}

	return changed;
    }

    @Override
    public void perform(final Cluster actor, final TickInfo tick) {

	final Size s = actor.getOfType(Size.class).get();

	actor.streamAgents().filter(isMarkedAs(Cow.class)).forEach(c -> {

	    final Point p = unwrap(c.getOfType(Position.class));
	    boolean changed = false;

	    switch (Direction.random()) {

	    case UP:

		changed = setInBounds(s, p, p.getX(), p.getY() - 1);
		break;

	    case DOWN:

		changed = setInBounds(s, p, p.getX(), p.getY() + 1);
		break;

	    case RIGHT:

		changed = setInBounds(s, p, p.getX() + 1, p.getY());
		break;

	    case LEFT:

		changed = setInBounds(s, p, p.getX() - 1, p.getY());
		break;
	    }

	    if (changed) {

		c.fireAttributeChanged(Position.class);
	    }
	});
    }
}
