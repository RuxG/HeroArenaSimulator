package com.Heroes;

import com.Abilities.IAbility;
import com.Abilities.OvertimeEffect;
import com.Game.BattlesStatistics;
import com.Game.MyPair;

import java.util.ArrayList;

public class Wizard extends Hero {
    public Wizard(int id, int hp, int upHP, MyPair<Character, MyPair<Integer, Integer>> position) {
        super.setId(id);
        super.setName("W");
        super.setHp(hp);
        super.setExp(0);
        super.setLvl(0);
        super.setMaxHP(hp);
        super.setBaseHP(hp);
        super.setUpHP(upHP);
        super.setPosition(position);
        super.setAbilities(new ArrayList<>());
        super.setEffect(new OvertimeEffect(0, 0, false, this));
    }

    public BattlesStatistics.AttackInfo acceptAttack(Hero caster, final ArrayList<IAbility> abilities) {
        BattlesStatistics.AttackInfo info = new BattlesStatistics.AttackInfo();
        for (IAbility ability : abilities) {
            BattlesStatistics.AttackInfo aux = ability.execute(caster, this);
            info.setBruteDmg(info.getBruteDmg() + aux.getBruteDmg());
            info.setTotalDmg(info.getTotalDmg() + aux.getTotalDmg());
        }
        return info;
    }
}
