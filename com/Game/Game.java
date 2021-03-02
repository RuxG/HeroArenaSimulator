package com.Game;

import com.Abilities.Strategy;
import com.Angels.AAngel;
import com.Angels.AngelsFactory;
import com.Constants;
import com.Heroes.AHero;
import com.Heroes.StrategiesFactory;
import com.Heroes.Wizard;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import static java.lang.Math.max;

public final class Game {
    private static Game instance = null;
    private static Writer writer;
    private static Hashtable<String, Strategy> strategies;
    private GameInput input;
    private Map map;
    private ArrayList<AHero> heroes;
    private Hashtable<String, AAngel> angels;
    private ArrayList<String> rounds;
    private ArrayList<String> angelsRounds;
    private GreatMagician magician;

    private Game(final GameInput input) {
        this.input = input;
        map = Map.getInstance(input.getMapSize().getKey(), input.getMapSize().getValue(),
                input.getLands());
        rounds = input.getRounds();
        heroes = HeroesFactory.getInstance().getHeroes(input.getInitialPosition());
        angels = AngelsFactory.getInstance().getAngels();
        magician = GreatMagician.getInstance();
        for (AHero hero : heroes) {
            magician.addSubjects(hero);
        }
        Set<String> keys = angels.keySet();
        for (String key : keys) {
            magician.addSubjects(angels.get(key));
        }
        magician.setOutputPath(input.getOutputPath());
        angelsRounds = input.getAngelsRounds();
        writer = new Writer(input.getOutputPath());
        strategies = StrategiesFactory.getInstance().getStrategies();
    }

    public static Writer getWriter() {
        return writer;
    }

    public static Game getInstance(final GameInput input) {
        if (instance == null) {
            instance = new Game(input);
        }
        return instance;
    }

    public static Hashtable<String, Strategy> getStrategies() {
        return strategies;
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
        for (AHero hero : heroes) {
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
            int l = i + 1;
            writer.print("~~ Round " + l + " ~~\n");

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
            for (AHero hero : heroes) {
                hero.checkLvlUp();
            }
            executeAngelMoves();
            for (AHero hero : heroes) {
                hero.checkLvlUp();
            }
            writer.print("\n");
        }
    }

    public void executeAngelMoves() {
        String line = angelsRounds.get(0);
        angelsRounds.remove(0);
        String[] words = line.split(" ");
        for (String word : words) {
            String[] moves = word.split(",", GameConstants.LIMIT);
            if (moves.length < 2) {
                return;
            }
            AAngel angel = angels.get(moves[0]);
            MyPair<Integer, Integer> position =
                    new MyPair<Integer, Integer>(Integer.valueOf(moves[1]),
                            Integer.valueOf(moves[2]));
            angel.setPosition(new MyPair<Character, MyPair<Integer, Integer>>(
                    Map.getInstance().getLands().get(position), position));
            for (AHero hero : heroes) {
                if (hero.getPosition().getValue().equals(position)) {
                    hero.acceptAngel(angel);
                }
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
    private void fight(final AHero combatant1, final AHero combatant2) {
        if (combatant1.getHp() <= 0 || combatant2.getHp() <= 0) {
            return;
        }
        if (!combatant1.getEffect().isImmobility()) {
            strategies.get(combatant1.getFullName()).chooseStrategy(combatant1);
        }
        if (!combatant2.getEffect().isImmobility()) {
            strategies.get(combatant2.getFullName()).chooseStrategy(combatant2);
        }
        BattlesStatistics.AttackInfo info = combatant2.acceptAttack(combatant1);
        BattlesStatistics.AttackInfo info2 = combatant1.acceptAttack(combatant2);

        BattlesStatistics.getInstance().getStatistics().get(combatant1.getId()).addBattles();
        BattlesStatistics.getInstance().getStatistics().get(combatant2.getId()).addBattles();

        float dmg = info.getTotalDmg();
        float dmg2 = info2.getTotalDmg();

        combatant1.setHp(combatant1.getHp() - dmg2);
        combatant2.setHp(combatant2.getHp() - dmg);
        System.out.println(combatant1.getId() + " " + combatant1.getHp() + "\n");
        System.out.println(combatant2.getId() + " " + combatant2.getHp() + "\n");
        if (combatant2.getHp() <= 0) {
            battleOutcome(combatant2, combatant1);
        }

        if (combatant1.getHp() <= 0) {
            battleOutcome(combatant1, combatant2);
        }
    }

    /*
        This method updates the statistics of the battle and
        computes the winner's experience.
     */
    public void battleOutcome(final AHero h1, final AHero h2) {
        BattlesStatistics.getInstance().setStatus(h1.getId(), false);
        if (h2.getHp() > 0) {
            int xp = max(0, Constants.EXP - (h2.getLvl() - h1.getLvl())
                    * Constants.EXP_SCALE);
            h2.setExp(h2.getExp() + xp);
        }
        BattlesStatistics.getInstance().addBattle(h2.getId(), true);
        BattlesStatistics.getInstance().addBattle(h1.getId(), false);
        h1.notifyObservers(h2);
    }

    // This method prints the game's result
    public void results() {
        writer.print("~~ Results ~~\n");
        for (AHero hero : heroes) {
            writer.print(hero.getName() + " ");
            if (hero.getHp() <= 0) {
                writer.print("dead");
            } else {
                writer.print(hero.getLvl() + " " + (int) hero.getExp() + " "
                        + (int) hero.getHp() + " " + hero.getPosition().getValue().getKey()
                        + " " + hero.getPosition().getValue().getValue());
            }
            writer.print("\n");
        }
        writer.print("\n");
        writer.getPrintWriter().close();

    }

    public Map getMap() {
        return map;
    }

    public ArrayList<AHero> getHeroes() {
        return heroes;
    }

    public ArrayList<String> getRounds() {
        return rounds;
    }

    class GameConstants {
        private static final int LIMIT = 3;
    }

}
