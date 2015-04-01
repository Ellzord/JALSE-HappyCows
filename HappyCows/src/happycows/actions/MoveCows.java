package happycows.actions;

import static jalse.attributes.Attributes.newTypeOf;
import happycows.HappyCows;
import happycows.entities.Cow;
import jalse.JALSE;
import jalse.actions.Action;
import jalse.actions.ActionContext;

import java.awt.Point;
import java.util.concurrent.ThreadLocalRandom;

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
	final JALSE actor = context.getActor();
	actor.streamEntitiesOfType(Cow.class).forEach(c -> {
	    final Point p = c.getPosition();
	    final Point newP = new Point();

	    switch (Direction.random()) {
	    case UP:
		newP.setLocation(p.getX(), Math.max(0, p.getY() - 1));
		break;
	    case DOWN:
		newP.setLocation(p.getX(), Math.min(HappyCows.HEIGHT, p.getY() + 1));
		break;
	    case RIGHT:
		newP.setLocation(Math.min(HappyCows.WIDTH, p.getY() + 1), p.getY());
		break;
	    case LEFT:
		newP.setLocation(Math.max(0, p.getX() - 1), p.getY());
		break;
	    }

	    if (!p.equals(newP)) {
		p.setLocation(newP);
		c.fireAttributeChanged("position", newTypeOf(Point.class));
	    }
	});
    }
}
