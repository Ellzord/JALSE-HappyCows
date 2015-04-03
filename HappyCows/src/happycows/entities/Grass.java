package happycows.entities;

import jalse.entities.Entity;
import jalse.entities.annotations.GetAttribute;
import jalse.entities.annotations.SetAttribute;

import java.awt.Point;

public interface Grass extends Entity {

    @GetAttribute("position")
    Point getPosition();

    @SetAttribute("position")
    void setPosition(Point p);
}
