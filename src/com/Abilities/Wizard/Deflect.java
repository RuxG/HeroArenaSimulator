package com.Abilities.Wizard;

import com.Abilities.IAbility;
import com.Constants;
import com.Game.BattlesStatistics;
import com.Heroes.*;

public class Deflect implements IAbility {

    private float landA = 1f;
    private float raceA = 1f;

    public BattlesStatistics.AttackInfo computeDamage(Hero caster, Hero victim) {
        float proc = 0f;
        float dmg = 0f;
        landA = 1f;
        BattlesStatistics.AttackInfo info = caster.acceptAttack(victim, victim.getAbilities());
        if (caster.getPosition().getKey() == 'D') {
            landA = Constants.WIZARD_LAND_BONUS;
        }
        proc = Constants.DEFLECT_BASE_PROC + caster.getLvl() * Constants.DEFLECT_UP_PROC;
        if (proc > Constants.DEFLECT_LIMIT_PROC) {
            proc = 0.7f;
        }
        dmg = info.getBruteDmg();

        dmg *= proc;
        dmg *= landA;
        info.setBruteDmg((float) Math.round(dmg));

        dmg *= raceA;
        dmg = Math.round(dmg);

        info.setTotalDmg(dmg);
        return info;
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Wizard victim) {
        raceA = Constants.DEFLECT_WIZARD_A;
        return new BattlesStatistics.AttackInfo();
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Rogue victim) {
        raceA = Constants.DEFLECT_ROGUE_A;
        return computeDamage(caster, victim);
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Pyromancer victim) {
        raceA = Constants.DEFLECT_PYROMANCER_A;
        return computeDamage(caster, victim);
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Knight victim) {
        raceA = Constants.DEFLECT_KNIGHT_A;
        return computeDamage(caster, victim);
    }
}