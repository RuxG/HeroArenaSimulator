package com.Abilities;

import com.Heroes.*;

public interface IAbility {
    public void applyDamage(int lvl, Hero victim);
    public void execute(int lvl, Wizard victim);
    public void execute(int lvl, Rogue victim);
    public void execute(int lvl, Pyromancer victim);
    public void execute(int lvl, Knight victim);
}
