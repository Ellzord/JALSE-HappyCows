package happycows.actions;

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

    @Override
    public void perform(final Cluster actor, final TickInfo tick) {

	final Size s = actor.getOfTypeOrNull(Size.class);

	actor.streamAgentsOfType(Cow.class).forEach(c -> {

	    final Point p = c.getOfTypeAndUnwrap(Position.class);
	    final Point newP = new Point();

	    switch (Direction.random()) {

	    case UP:

		newP.setLocation(p.getX(), Math.max(0, p.getY() - 1));
		break;

	    case DOWN:

		newP.setLocation(p.getX(), Math.min(s.getHeight(), p.getY() + 1));
		break;

	    case RIGHT:

		newP.setLocation(Math.min(s.getWidth(), p.getY() + 1), p.getY());
		break;

	    case LEFT:

		newP.setLocation(Math.max(0, p.getX() - 1), p.getY());
		break;
	    }

	    if (!p.equals(newP)) {

		p.setLocation(newP);

		c.fireAttributeChanged(Position.class);
	    }
	});
    }
}
