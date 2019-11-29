package com.Game;

import com.Constants;
import com.Heroes.Hero;
import com.Heroes.Wizard;

import java.util.ArrayList;

import static java.lang.Math.max;

public final class Game {
    private static Game instance = null;
    private GameInput input;
    private Map map;
    private ArrayList<Hero> heroes;
    private ArrayList<String> rounds;

    private Game(final GameInput input) {
        this.input = input;
        map = Map.getInstance(input.getMapSize().getKey(), input.getMapSize().getValue(),
                input.getLands());
        rounds = input.getRounds();
        heroes = HeroesFactory.getInstance().getHeroes(input.getInitialPosition());
    }

    public static Game getInstance(final GameInput input) {
        if (instance == null) {
            instance = new Game(input);
        }
        return instance;
    }

    /*
        This function executes the moves of the heroes on the map.
        Firstly, a line describing a round is read.
        Secondly, the overtime effects are applied on each hero.
        Thirdly, the heroes are moved to the required location.
    */
    public void move() {
        StringBuilder line = new StringBuilder(rounds.get(0));
        rounds.remove(0);
        for (Hero hero : heroes) {
            hero.getEffect().execute();
            Character c = line.charAt(0);
            line.delete(0, 1);
            if (hero.getEffect().isImmobility() || hero.getHp() <= 0) {
                continue;
            }
            MyPair<Integer, Integer> pos;
            Character land;
            int x = hero.getPosition().getValue().getKey();
            int y = hero.getPosition().getValue().getValue();
            switch (c) {
                case 'U':
                    pos = new MyPair<>(x - 1, y);
                    land = map.getLands().get(pos);
                    hero.setPosition(new MyPair<Character, MyPair<Integer, Integer>>(land,
                            new MyPair<Integer, Integer>(x - 1, y)));
                    break;
                case 'D':
                    pos = new MyPair<>(x + 1, y);
                    land = map.getLands().get(pos);
                    hero.setPosition(new MyPair<Character, MyPair<Integer, Integer>>(land,
                            new MyPair<Integer, Integer>(x + 1, y)));
                    break;
                case 'L':
                    pos = new MyPair<>(x, y - 1);
                    land = map.getLands().get(pos);
                    hero.setPosition(new MyPair<Character, MyPair<Integer, Integer>>(land,
                            new MyPair<Integer, Integer>(x, y - 1)));
                    break;
                case 'R':
                    pos = new MyPair<>(x, y + 1);
                    land = map.getLands().get(pos);
                    hero.setPosition(new MyPair<Character, MyPair<Integer, Integer>>(land,
                            new MyPair<Integer, Integer>(x, y + 1)));
                    break;
                case '_':
                    break;
                default:
                    break;
            }

        }
    }

    /*
       This method sequentially executes the rounds's operations, by
       firstly moving the heroes on the map and then invoking the
       fight method each time two heroes should battle.
   */
    public void executeRounds() {
        for (int i = 0; i < input.getNoRounds(); i++) {
            move();
            for (int j = 0; j < heroes.size(); j++) {
                for (int k = j + 1; k < heroes.size(); k++) {
                    if (heroes.get(j).getPosition().getValue().equals(
                            heroes.get(k).getPosition().getValue())) {
                        if (heroes.get(j) instanceof Wizard) {
                            fight(heroes.get(k), heroes.get(j));
                        } else {
                            fight(heroes.get(j), heroes.get(k));
                        }
                    }
                }
            }
            for (Hero hero : heroes) {
                hero.checkLvlUp();
            }
        }
    }

    /*
        This method conducts a fight between two heroes.
        Each hero casts his abilities towards the other. The attacks's
        outcome (damage with and without modifiers) are computed, and
        applied on each combatant.
        Then, the statistics of the battle are updated.
     */
    private void fight(final Hero combatant1, final Hero combatant2) {
        if (combatant1.getHp() <= 0 || combatant2.getHp() <= 0) {
            return;
        }
        BattlesStatistics.AttackInfo info = combatant2.acceptAttack(combatant1);
        BattlesStatistics.AttackInfo info2 = combatant1.acceptAttack(combatant2);

        BattlesStatistics.getInstance().getStatistics().get(combatant1.getId()).addBattles();
        BattlesStatistics.getInstance().getStatistics().get(combatant2.getId()).addBattles();

        float dmg = info.getTotalDmg();
        float dmg2 = info2.getTotalDmg();

        combatant1.setHp(combatant1.getHp() - dmg2);
        combatant2.setHp(combatant2.getHp() - dmg);

        if (combatant1.getHp() <= 0) {
            battleOutcome(combatant1, combatant2);
        }
        if (combatant2.getHp() <= 0) {
            battleOutcome(combatant2, combatant1);
        }
    }

    /*
        This method updates the statistics of the battle and
        computes the winner's experience.
     */
    public void battleOutcome(final Hero h1, final Hero h2) {
        BattlesStatistics.getInstance().setStatus(h1.getId(), false);
        if (h2.getHp() > 0) {
            int xp = max(0, Constants.EXP - (h2.getLvl() - h1.getLvl())
                    * Constants.EXP_SCALE);
            h2.setExp(h2.getExp() + xp);
        }
        BattlesStatistics.getInstance().addBattle(h2.getId(), true);
        BattlesStatistics.getInstance().addBattle(h1.getId(), false);
    }

    // This method prints the game's result
    public void results() {
        for (Hero hero : heroes) {
            System.out.print(hero.getName() + " ");
            if (hero.getHp() <= 0) {
                System.out.print("dead");
            } else {
                System.out.print(hero.getLvl() + " " + (int) hero.getExp() + " "
                        + (int) hero.getHp() + " " + hero.getPosition().getValue().getKey()
                        + " " + hero.getPosition().getValue().getValue());
            }
            System.out.println();
        }
        System.out.println();
    }

    public Map getMap() {
        return map;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public ArrayList<String> getRounds() {
        return rounds;
    }

}
