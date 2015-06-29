package happycows.actions;

import static jalse.attributes.Attributes.newTypeOf;

import java.awt.Point;
import java.util.concurrent.ThreadLocalRandom;

import happycows.HappyCows;
import happycows.entities.Cow;
import jalse.JALSE;
import jalse.actions.Action;
import jalse.actions.ActionContext;

public class MoveCows implements Action<JALSE> {

    public enum Direction {

	DOWN, LEFT, RIGHT, UP;

	public static Direction random() {
	    final Direction[] dirs = values();
	    return dirs[ThreadLocalRandom.current().nextInt(dirs.length)];
	}
    }

    @Override
    public void perform(final ActionContext<JALSE> context) {
	// Get the actor this action is for
	final JALSE jalse = context.getActor();

	// Only process cows
	jalse.streamEntitiesOfType(Cow.class).forEach(c -> {
	    final Point oldPos = c.getPosition();
	    final Point newPos = new Point();

	    // Calculate the new position for a random direction
	    switch (Direction.random()) {
	    case UP:
		newPos.setLocation(oldPos.getX(), Math.max(0, oldPos.getY() - 1));
		break;
	    case DOWN:
		newPos.setLocation(oldPos.getX(), Math.min(HappyCows.HEIGHT, oldPos.getY() + 1));
		break;
	    case RIGHT:
		newPos.setLocation(Math.min(HappyCows.WIDTH, oldPos.getY() + 1), oldPos.getY());
		break;
	    case LEFT:
		newPos.setLocation(Math.max(0, oldPos.getX() - 1), oldPos.getY());
		break;
	    }

	    // If the position could be moved
	    if (!oldPos.equals(newPos)) {
		oldPos.setLocation(newPos);
		// Signal the internal state of the position has changed
		c.fireAttributeChanged("position", newTypeOf(Point.class));
	    }
	});
    }
}
