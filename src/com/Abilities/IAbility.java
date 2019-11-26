package com.Abilities;

import com.Game.BattlesStatistics;
import com.Heroes.*;

public interface IAbility {
    BattlesStatistics.AttackInfo computeDamage(Hero caster, Hero victim);

    BattlesStatistics.AttackInfo execute(Hero caster, Wizard victim);

    BattlesStatistics.AttackInfo execute(Hero caster, Rogue victim);

    BattlesStatistics.AttackInfo execute(Hero caster, Pyromancer victim);

    BattlesStatistics.AttackInfo execute(Hero caster, Knight victim);
}

