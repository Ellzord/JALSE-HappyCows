package happycows.listeners;

import jalse.listeners.AttributeAdapter;
import jalse.listeners.AttributeEvent;

import java.awt.Point;

public class Moo extends AttributeAdapter<Point> {

    @Override
    public void attributeChanged(final AttributeEvent<Point> event) {
	final Point p = event.getValue();
	System.out.println(String.format("Cow mooing [%d:%d]", p.x, p.y));
    }
}
