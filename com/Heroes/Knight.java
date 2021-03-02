package com.Heroes;

import com.Abilities.IAbility;
import com.Angels.AAngel;
import com.Game.BattlesStatistics;
import com.Game.MyPair;

import java.util.Observer;

public class Knight extends AHero {
    public Knight(final int id, final int hp, final int upHP,
                  final MyPair<Character, MyPair<Integer, Integer>> position,
                  final Observer observer) {
        super(id, "K", "Knight", hp, upHP, position, observer);
    }



    /**
     * @see AHero#acceptAttack(AHero)
     */
    public BattlesStatistics.AttackInfo acceptAttack(final AHero caster) {
        BattlesStatistics.AttackInfo info = new BattlesStatistics.AttackInfo();
        for (IAbility ability : caster.getAbilities()) {
            BattlesStatistics.AttackInfo aux = ability.execute(caster, this);
            info.setBruteDmg(info.getBruteDmg() + aux.getBruteDmg());
            info.setTotalDmg(info.getTotalDmg() + aux.getTotalDmg());
        }
        return info;
    }

    /**
     * @see AHero#acceptAngel(AAngel)
     */
    @Override
    public void acceptAngel(final AAngel angel) {
        angel.execute(this);
    }


}
