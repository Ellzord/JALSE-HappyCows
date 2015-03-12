package happycows.listeners;

import happycows.attributes.Position;
import jalse.listeners.AttributeAdapter;
import jalse.listeners.AttributeEvent;

import java.awt.Point;

public class Moo extends AttributeAdapter<Position> {

    @Override
    public void attributeChanged(final AttributeEvent<Position> event) {
	final Point p = event.getAttribute().unwrap();
	System.out.println(String.format("Cow mooing [%d:%d]", p.x, p.y));
    }
}
