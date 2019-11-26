package com.Abilities.Knight;

import com.Abilities.IAbility;
import com.Abilities.OvertimeEffect;
import com.Constants;
import com.Game.BattlesStatistics;
import com.Heroes.*;

public class Slam implements IAbility {
    private float raceA = 1f;
    private float landA = 1f;

    public BattlesStatistics.AttackInfo computeDamage(Hero caster, Hero victim) {
        float dmg = 0f;
        landA = 1f;
        OvertimeEffect effect;
        int effectRounds = Constants.SLAM_EFFECT_DUR;

        BattlesStatistics.AttackInfo info = new BattlesStatistics.AttackInfo();

        dmg = Constants.SLAM_BASE_DMG + caster.getLvl() * Constants.SLAM_UP_DMG;

        if (caster.getPosition().getKey() == 'L') {
            landA = Constants.KNIGHT_LAND_BONUS;
        }

        dmg *= landA;

        info.setBruteDmg(dmg);

        dmg *= raceA;
        dmg = Math.round(dmg);

        info.setTotalDmg(dmg);
        effect = new OvertimeEffect(effectRounds, 0, true, victim);
        victim.setEffect(effect);

        return info;
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Wizard victim) {
        raceA = Constants.SLAM_WIZARD_A;
        return computeDamage(caster, victim);
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Rogue victim) {
        raceA = Constants.SLAM_ROGUE_A;
        return computeDamage(caster, victim);
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Pyromancer victim) {
        raceA = Constants.SLAM_PYROMANCER_A;
        return computeDamage(caster, victim);
    }

    public BattlesStatistics.AttackInfo execute(Hero caster, Knight victim) {
        raceA = Constants.SLAM_KNIGHT_A;
        return computeDamage(caster, victim);
    }
}
