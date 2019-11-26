package com.Game;

import com.Heroes.Hero;
import com.Heroes.Wizard;

import java.util.ArrayList;

import static java.lang.Math.max;

public class Game {
    private static Game instance = null;
    GameInput input;
    Map map;
    ArrayList<Hero> heroes;
    private ArrayList<String> rounds;

    private Game(GameInput input) {
        this.input = input;
        map = Map.getInstance(input.getMapSize().getKey(), input.getMapSize().getValue(),
                input.getLands());
        rounds = input.getRounds();
        heroes = HeroesFactory.getInstance().getHeroes(input.getInitialPosition());
    }

    public static Game getInstance(GameInput input) {
        if (instance == null) {
            instance = new Game(input);
        }
        return instance;
    }

    public void move() {
        StringBuilder line = new StringBuilder(rounds.get(0));
        rounds.remove(0);
        for (Hero hero : heroes) {
            hero.getEffect().execute();
            Character c = line.charAt(0);
            line.delete(0, 1);
            if (hero.getEffect().isImobility() || hero.getHp() <= 0) {
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
            }

        }
    }

    public void executeRounds() {
        for (int i = 0; i < input.getNoRounds(); i++) {
            move();
            for (int j = 0; j < heroes.size(); j++) {
                for (int k = j + 1; k < heroes.size(); k++) {
                    if (heroes.get(j).getPosition().getValue().equals(heroes.get(k).getPosition().getValue())) {
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
        for (Hero hero : heroes) {
            System.out.print(hero.getName() + " ");
            if (hero.getHp() <= 0) System.out.print("dead");
            else System.out.print(hero.getLvl() + " " + (int) hero.getExp() + " " + (int) hero.getHp() +
                    " " + hero.getPosition().getValue().getKey() + " " +
                    hero.getPosition().getValue().getValue());
            System.out.println();
        }
        System.out.println();
    }

    private void fight(Hero hero, Hero hero1) {
        if (hero.getHp() <= 0 || hero1.getHp() <= 0) {
            return;
        }
        BattlesStatistics.AttackInfo info = hero1.acceptAttack(hero, hero.getAbilities());
        BattlesStatistics.AttackInfo info2 = hero.acceptAttack(hero1, hero1.getAbilities());

        BattlesStatistics.getInstance().getStatistics().get(hero.getId()).addBattles();
        BattlesStatistics.getInstance().getStatistics().get(hero1.getId()).addBattles();

        float dmg = info.getTotalDmg();
        float dmg2 = info2.getTotalDmg();

        hero.setHp(hero.getHp() - dmg2);
        hero1.setHp(hero1.getHp() - dmg);

        if (hero.getHp() <= 0) {
            battleResult(hero, hero1);
        }
        if (hero1.getHp() <= 0) {
            battleResult(hero1, hero);
        }
    }

    public void battleResult(Hero h1, Hero h2) {
        BattlesStatistics.getInstance().setStatus(h1.getId(), false);
        if (h2.getHp() > 0) {
            int xp = max(0, 200 - (h2.getLvl() - h1.getLvl()) * 40);
            h2.setExp(h2.getExp() + xp);
        }
        BattlesStatistics.getInstance().addBattle(h2.getId(), true);
        BattlesStatistics.getInstance().addBattle(h1.getId(), false);
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
