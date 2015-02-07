package happycows.agents;

import happycows.attributes.Position;
import jalse.agents.Agent;

import java.util.Optional;

public interface Cow extends Agent {

    Optional<Position> getPosition();

    void setPosition(Position p);
}
