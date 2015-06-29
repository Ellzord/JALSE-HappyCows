package happycows.attributes;

import java.awt.Point;

import jalse.attributes.AttributeEvent;
import jalse.attributes.AttributeListener;

public class Moo implements AttributeListener<Point> {

    @Override
    public void attributeChanged(final AttributeEvent<Point> event) {
	// Get the new position
	final Point p = event.getValue();
	System.out.println(String.format("Cow mooing [%d:%d]", p.x, p.y));
    }
}
