package happycows.listeners;

import happycows.attributes.Position;
import jalse.listeners.AttributeAdapter;

import java.awt.Point;

public class Moo extends AttributeAdapter<Position> {

    @Override
    public void attributeChanged(final Position attr) {

	final Point p = attr.unwrap();

	System.out.println(String.format("Cow mooing [%d:%d]", p.x, p.y));
    }
}
