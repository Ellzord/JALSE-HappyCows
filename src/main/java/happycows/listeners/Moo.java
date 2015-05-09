package happycows.listeners;

import jalse.listeners.AttributeListener;
import jalse.listeners.AttributeEvent;

import java.awt.Point;

public class Moo implements AttributeListener<Point> {

    @Override
    public void attributeChanged(final AttributeEvent<Point> event) {
	// Get the new position
	final Point p = event.getValue();
	System.out.println(String.format("Cow mooing [%d:%d]", p.x, p.y));
    }
}
