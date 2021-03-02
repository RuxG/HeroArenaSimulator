package main;

import com.Game.Game;
import com.Game.GameInput;
import com.Game.GameInputLoader;

public class Main {
    public static void main(final String[] args) {
        GameInputLoader loader = new GameInputLoader(args[0], args[1]);
        GameInput input = loader.load();
        Game game = Game.getInstance(input);
        game.executeRounds();
        game.results();
    }
}
