package hexaround.creatures;

import hexaround.config.CreatureDefinition;

import java.util.*;

public class CreatureManager {

    private Map<CreatureName, CreatureDefinition> creatureMap;

    public CreatureManager(Collection<CreatureDefinition> creatures) {
        this.creatureMap = new HashMap<>();
        for (CreatureDefinition creature : creatures) {
            this.creatureMap.put(creature.name(), creature);
        }
    }

    public Collection<CreatureProperty> getCreatureProperties(CreatureName creature) {
        return this.creatureMap.get(creature).properties();
    }

    public int getCreatureMaxDistance(CreatureName creature) {
        return this.creatureMap.get(creature).maxDistance();
    }

}
