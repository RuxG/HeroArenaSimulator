package com.Heroes;

import com.Abilities.IAbility;
import com.Abilities.OvertimeEffect;
import com.Game.MyPair;

import java.util.ArrayList;

public class Rogue extends Hero {
    public Rogue(int id, int hp, int upHP, MyPair<Character, MyPair<Integer, Integer>> position) {
        super.setId(id);
        super.setName("R");
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
    void acceptAttack(int lvl, IAbility ability) {
        ability.execute(lvl,this);
    }
}
