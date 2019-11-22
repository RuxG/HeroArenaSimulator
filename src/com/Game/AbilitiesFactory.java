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

public class AbilitiesFactory {
    private static AbilitiesFactory instance = null;
    private AbilitiesFactory() {
    }
    public static AbilitiesFactory getInstance() {
        if(instance == null) {
            instance = new AbilitiesFactory();
        }
        return instance;
    }
    public IAbility getAbility(String ability) {
        if(ability.compareTo("Backstab") == 0) {
            return new Backstab();
        } else if (ability.compareTo("Paralysis") == 0) {
            return new Paralysis();
        }
        else if (ability.compareTo("Drain") == 0) {
            return new Drain();
        }
        else if (ability.compareTo("Deflect") == 0) {
            return new Deflect();
        }
        else if (ability.compareTo("Execute") == 0) {
            return new Execute();
        }
        else if (ability.compareTo("Slam") == 0) {
            return new Slam();
        }
        else if (ability.compareTo("Fireblast") == 0) {
            return new Fireblast();
        }
        else if (ability.compareTo("Ignite") == 0) {
            return new Ignite();
        }
        return null;
    }
    public Hashtable<String, IAbility> getAbilities() {
        Hashtable<String, IAbility> abilities = new Hashtable<>();
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
