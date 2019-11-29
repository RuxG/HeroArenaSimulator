package com.Game;

import com.Abilities.IAbility;
import com.Abilities.Knight.Execute;
import com.Abilities.Knight.Slam;
import com.Abilities.Pyromancer.Fireblast;
import com.Abilities.Pyromancer.Ignite;
import com.Abilities.Rogue.Backstab;
import com.Abilities.Rogue.Paralysis;
import com.Abilities.Wizard.Deflect;
import com.Abilities.Wizard.Drain;

import java.util.Hashtable;


/**
 * This class is a factory for the heroes's abilities.
 */
public class AbilitiesFactory {
    private static AbilitiesFactory instance = null;
    private static Hashtable<String, IAbility> abilities;

    private AbilitiesFactory() {
    }

    public static AbilitiesFactory getInstance() {
        if (instance == null) {
            instance = new AbilitiesFactory();
        }
        return instance;
    }

    /**
     * @param ability names the ability to be returned
     */
    public IAbility getAbility(final String ability) {
        if (ability.compareTo("Backstab") == 0) {
            return abilities.get("Backstab");
        } else if (ability.compareTo("Paralysis") == 0) {
            return abilities.get("Paralysis");
        } else if (ability.compareTo("Drain") == 0) {
            return abilities.get("Drain");
        } else if (ability.compareTo("Deflect") == 0) {
            return abilities.get("Deflect");
        } else if (ability.compareTo("Execute") == 0) {
            return abilities.get("Execute");
        } else if (ability.compareTo("Slam") == 0) {
            return abilities.get("Slam");
        } else if (ability.compareTo("Fireblast") == 0) {
            return abilities.get("Fireblast");
        } else if (ability.compareTo("Ignite") == 0) {
            return abilities.get("Ignite");
        }
        return null;
    }

    /**
     * This method instantiates the abilities of the game and stores them in 'abilities' field
     */
    public Hashtable<String, IAbility> getAbilities() {
        abilities = new Hashtable<>();
        abilities.put("Deflect", new Deflect());
        abilities.put("Drain", new Drain());
        abilities.put("Slam", new Slam());
        abilities.put("Execute", new Execute());
        abilities.put("Ignite", new Ignite());
        abilities.put("Fireblast", new Fireblast());
        abilities.put("Backstab", new Backstab());
        abilities.put("Paralysis", new Paralysis());
        return abilities;
    }
}
