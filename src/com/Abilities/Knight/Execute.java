package com.Abilities.Knight;

import com.Abilities.IAbility;
import com.Constants;
import com.Game.BattlesStatistics;
import com.Heroes.*;

public class Execute implements IAbility {
    private float landA = 1f;
    private float raceA = 1f;

    public BattlesStatistics.AttackInfo computeDamage(Hero caster, Hero victim) {
        float dmg = 0f;
        float hpLimit = 0f;
        landA = 1f;
        BattlesStatistics.AttackInfo info = new BattlesStatistics.AttackInfo();

        hpLimit = Constants.EXECUTE_HP_LIMIT + Constants.EXECUTE_HP_UP_LIMIT * caster.getLvl();

        if (hpLimit > 0.4f) {
            hpLimit = 0.4f;
        }
        float hpProc = victim.getHp() / victim.getMaxHP();
        if (hpProc < hpLimit) {
            dmg = victim.getHp();
            info.setBruteDmg((float) Math.round(dmg));
            info.setTotalDmg((float) Math.round(dmg));
            return info;
        }
        if (caster.getPosition().getKey() == 'L') {
            landA = Constants.KNIGHT_LAND_BONUS;
        }
        dmg = Constants.EXECUTE_BASE_DMG + Constants.EXECUTE_UP_DMG * caster.getLvl();
        dmg *= landA;

        info.setBruteDmg((float) Math.round(dmg));

        dmg *= raceA;

        info.setTotalDmg((float) Math.round(dmg));

        return info;
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Wizard victim) {
        raceA = Constants.EXECUTE_WIZARD_A;
        return computeDamage(caster, victim);
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Rogue victim) {
        raceA = Constants.EXECUTE_ROGUE_A;
        return computeDamage(caster, victim);
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Pyromancer victim) {
        raceA = Constants.EXECUTE_PYROMANCER_A;
        return computeDamage(caster, victim);
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Knight victim) {
        raceA = Constants.EXECUTE_KNIGHT_A;
        return computeDamage(caster, victim);
    }


}
