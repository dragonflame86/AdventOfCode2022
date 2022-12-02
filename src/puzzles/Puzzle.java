package src.puzzles;

public interface Puzzle {

    default void solve() {
        System.out.println("Puzzle not yet implemented.");
    }

}
