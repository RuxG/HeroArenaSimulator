package com.Heroes;

import com.Abilities.IAbility;
import com.Game.BattlesStatistics;
import com.Game.MyPair;

public class Wizard extends AHero {
    public Wizard(final int id, final int hp, final int upHP,
                  final MyPair<Character, MyPair<Integer, Integer>> position) {
        super(id, "W", hp, upHP, position);
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
}
