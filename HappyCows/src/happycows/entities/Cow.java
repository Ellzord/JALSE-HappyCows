package happycows.entities;

import happycows.attributes.Position;
import jalse.entities.Entity;
import jalse.entities.annotations.GetAttribute;
import jalse.entities.annotations.SetAttribute;

public interface Cow extends Entity {

    @GetAttribute
    Position getPosition();

    @SetAttribute
    void setPosition(Position p);
}
