## HappyCows

HappyCows is a [JALSE](https://github.com/Ellzord/JALSE) example project. It is a small simulation of cows in a field that randomly move and eat grass (which grows back over time).

### Simulation life-cycle
1. [Grass](https://github.com/Ellzord/JALSE-HappyCows/blob/master/HappyCows/src/happycows/entities/Grass.java) seeds are sown.
2. [Cow](https://github.com/Ellzord/JALSE-HappyCows/blob/master/HappyCows/src/happycows/entities/Cow.java)s are birthed.
3. An [Action](https://github.com/Ellzord/JALSE/blob/master/HappyCows/src/jalse/actions/Action.java) chain is built from [CowsEatGrass](https://github.com/Ellzord/JALSE-HappyCows/blob/master/HappyCows/src/happycows/actions/CowsEatGrass.java) and  [MoveCows](https://github.com/Ellzord/JALSE-HappyCows/blob/master/HappyCows/src/happycows/actions/MoveCows.java) causing the cows to eat any grass at their current position and then move (much as cows do in real life).
4. Eating Grass causes [GrowGrass](https://github.com/Ellzord/JALSE-HappyCows/blob/master/HappyCows/src/happycows/listeners/GrowGrass.java) to fire sowing another seed.
5. Repeat from 3.

### Model key
![GitHub Logo](/model-key.png)

### Model
![GitHub Logo](/happycows-model.png)

### More
See the [Wiki](https://github.com/Ellzord/JALSE/wiki) for more information.
