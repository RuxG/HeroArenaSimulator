package com.Abilities;

import com.Heroes.AHero;
/**
     This class represents the strategy of a hero.
 */
public class Strategy {
    private float attackStrategyLowHp;
    private float attackStrategyHighHp;
    private float attackStrategyDrainHp;
    private float attackStrategyAddCoeff;
    private float defenseStrategyLowHp;
    private float defenseStrategyDrainCoeff;
    private float defenseStrategyAddHp;

    public Strategy(final float attackStrategyLowHp, final float attackStrategyHighHp,
                    final float attackStrategyDrainHp, final float attackStrategyAddCoeff,
                    final float defenseStrategyLowHp, final float defenseStrategyDrainCoeff,
                    final float defenseStrategyAddHp) {
        this.attackStrategyLowHp = attackStrategyLowHp;
        this.attackStrategyHighHp = attackStrategyHighHp;
        this.attackStrategyDrainHp = attackStrategyDrainHp;
        this.attackStrategyAddCoeff = attackStrategyAddCoeff;
        this.defenseStrategyLowHp = defenseStrategyLowHp;
        this.defenseStrategyDrainCoeff = defenseStrategyDrainCoeff;
        this.defenseStrategyAddHp = defenseStrategyAddHp;
    }

    /**
     * This method chooses the appropriate strategy for a hero.
     * @param hero is the hero which chooses his strategy
     */
    public void chooseStrategy(final AHero hero) {
        if (Math.round(attackStrategyLowHp * hero.getMaxHP())
                < hero.getHp() && hero.getHp()
                < Math.round(attackStrategyHighHp * hero.getMaxHP())) {
            hero.setHp(hero.getHp() - Math.round((hero.getHp() / attackStrategyDrainHp)));
            hero.setBonusDmgA(hero.getBonusDmgA() + attackStrategyAddCoeff);
        } else if (hero.getHp() < Math.round(defenseStrategyLowHp * hero.getMaxHP())) {
            hero.setBonusDmgA(hero.getBonusDmgA() - defenseStrategyDrainCoeff);
            hero.setHp(hero.getHp() + Math.round(defenseStrategyAddHp * hero.getHp()));
        }
    }

}
