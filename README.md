## HappyCows

HappyCows is a [JALSE](https://github.com/Ellzord/JALSE) example project. It is a small simulation of cows in a field that randomly move and eat grass (which grows back over time). Below there are details about each of the classes and their function within the example (see the [Wiki](https://github.com/Ellzord/JALSE/wiki) for more information).

### [Agent](https://github.com/Ellzord/JALSE/blob/master/JALSE/src/jalse/agents/Agent.java)s

| Class | Function |
| ------------- | ------|
| [Cow](https://github.com/Ellzord/JALSE-HappyCows/blob/master/HappyCows/src/happycows/agents/Cow.java) | Used to identify the cows. |
| [Grass](https://github.com/Ellzord/JALSE-HappyCows/blob/master/HappyCows/src/happycows/agents/Grass.java) | Used to identify the grass. |

### [Attribute](https://github.com/Ellzord/JALSE/blob/master/JALSE/src/jalse/attributes/Attribute.java)s

| Class | Function |
| ------------- | ------|
| [Position](https://github.com/Ellzord/JALSE-HappyCows/blob/master/HappyCows/src/happycows/attributes/Position.java) | A [NonAttributeWrapper](https://github.com/Ellzord/JALSE/blob/master/JALSE/src/jalse/attributes/NonAttributeWrapper.java) for [Point](http://docs.oracle.com/javase/8/docs/api/java/awt/Point.html) used as a position within the field. |
| [Size](https://github.com/Ellzord/JALSE-HappyCows/blob/master/HappyCows/src/happycows/attributes/Size.java) | Used to determine the dimensions of the field. |

### [Listeners](https://github.com/Ellzord/JALSE/tree/master/JALSE/src/jalse/listeners)

| Class | Function |
| ------------- | ------|
| [GrowGrass](https://github.com/Ellzord/JALSE-HappyCows/blob/master/HappyCows/src/happycows/listeners/GrowGrass.java) | Schedules Grass to be grown (created) when Grass has been eaten (killed). |
| [Moo](https://github.com/Ellzord/JALSE-HappyCows/blob/master/HappyCows/src/happycows/listeners/Moo.java) | Outputs the cows Position after it moves. |

### [Action](https://github.com/Ellzord/JALSE/blob/master/JALSE/src/jalse/actions/Action.java)s

| Class | Function |
| ------------- | ------|
| [CowsEatGrass](https://github.com/Ellzord/JALSE-HappyCows/blob/master/HappyCows/src/happycows/actions/CowsEatGrass.java) | Eats (kills) the Grass at the same Position of each Cow. |
| [MoveCows](https://github.com/Ellzord/JALSE-HappyCows/blob/master/HappyCows/src/happycows/actions/MoveCows.java) | Moves the Position of all Cows in random directions. |
| [SproutGrass](https://github.com/Ellzord/JALSE-HappyCows/blob/master/HappyCows/src/happycows/actions/SproutGrass.java) | Grows (creates) Grass at a random Position. |
