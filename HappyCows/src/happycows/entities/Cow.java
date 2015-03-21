package happycows.entities;

import happycows.attributes.Position;
import jalse.entities.Entity;

public interface Cow extends Entity {

    Position getPosition();

    void setPosition(Position p);
}
