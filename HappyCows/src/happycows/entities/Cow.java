package happycows.entities;

import happycows.attributes.Position;
import jalse.entities.Entity;

import java.util.Optional;

public interface Cow extends Entity {

    Optional<Position> getPosition();

    void setPosition(Position p);
}
