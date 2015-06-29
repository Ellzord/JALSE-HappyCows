package happycows.entities;

import java.awt.Point;

import jalse.entities.Entity;
import jalse.entities.annotations.GetAttribute;
import jalse.entities.annotations.SetAttribute;

public interface Cow extends Entity {

    @GetAttribute
    Point getPosition();

    @SetAttribute
    void setPosition(Point p);
}
