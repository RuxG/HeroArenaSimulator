package com.Abilities.Rogue;

import com.Abilities.IAbility;
import com.Constants;
import com.Game.BattlesStatistics;
import com.Heroes.*;


public class Backstab implements IAbility {
    private float raceA = 1f;
    private float landA = 1f;

    public BattlesStatistics.AttackInfo computeDamage(Hero caster, Hero victim) {
        float dmg = 0f;
        landA = 1f;
        BattlesStatistics.AttackInfo info = new BattlesStatistics.AttackInfo();

        dmg = Constants.BACKSTAB_BASE_DMG + Constants.BACKSTAB_UP_DMG * caster.getLvl();
        if (caster.getPosition().getKey() == 'W') {
            landA = Constants.ROGUE_LAND_BONUS;
            BattlesStatistics.HeroInfo aux = BattlesStatistics.getInstance().getStatistics().get(caster.getId());
            if (aux.getTotalBattles() % Constants.BACKSTAB_CRIT_ROUND == 0) {
                dmg *= Constants.BACKSTAB_CRIT_PROC;
            }
        }
        dmg *= landA;

        info.setBruteDmg((float) Math.round(dmg));

        dmg *= raceA;
        dmg = Math.round(dmg);
        info.setTotalDmg(dmg);

        return info;
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Wizard victim) {
        raceA = Constants.BACKSTAB_WIZARD_A;
        return computeDamage(caster, victim);
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Rogue victim) {
        raceA = Constants.BACKSTAB_ROGUE_A;
        return computeDamage(caster, victim);
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Pyromancer victim) {
        raceA = Constants.BACKSTAB_PYROMANCER_A;
        return computeDamage(caster, victim);
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Knight victim) {
        raceA = Constants.BACKSTAB_KNIGHT_A;
        return computeDamage(caster, victim);
    }
}
