package com.Heroes;

import com.Abilities.IAbility;
import com.Game.BattlesStatistics;
import com.Game.MyPair;

public class Knight extends Hero {
    public Knight(final int id, final int hp, final int upHP,
                  final MyPair<Character, MyPair<Integer, Integer>> position) {
        super(id, "K", hp, upHP, position);
    }

    /**
     * @see Hero#acceptAttack(Hero)
     */
    public BattlesStatistics.AttackInfo acceptAttack(final Hero caster) {
        BattlesStatistics.AttackInfo info = new BattlesStatistics.AttackInfo();
        for (IAbility ability : caster.getAbilities()) {
            BattlesStatistics.AttackInfo aux = ability.execute(caster, this);
            info.setBruteDmg(info.getBruteDmg() + aux.getBruteDmg());
            info.setTotalDmg(info.getTotalDmg() + aux.getTotalDmg());
        }
        return info;
    }
}
