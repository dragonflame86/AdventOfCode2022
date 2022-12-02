package src;

import src.puzzles.Puzzle;
import src.puzzles.day_1.ElfCalories;

import java.util.*;

public class PuzzlesMain {

    public static boolean running = true;
    public static Map<String, ? extends Puzzle> Puzzles = Map.ofEntries(
            Map.entry("elf calories", new ElfCalories())
    );
    public static final Scanner READER = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println(
                """
                        ===========================================
                        Welcome to the advent of code puzzle solver\s
                        Made by: dragoncommands [https://github.com/dragonflame86]
                        To get a list of puzzlesolvers type [help]
                        To exit the puzzle solver type [exit]
                        ===========================================



                        """
        );

        while (running) {
            System.out.println("Which puzzle do you want to solve?");
            String input = READER.nextLine().strip();
            if(input.equalsIgnoreCase("help")) {
                System.out.println(Arrays.toString(Puzzles.keySet().toArray()));
            } else if (input.equalsIgnoreCase("exit")) {
                running = false;
            } else if (Puzzles.containsKey(input)) {
                System.out.println("fetching puzzle: " + input + "...\n");
                Puzzles.get(input).solve();
                System.out.println("\n");
            } else {
                System.out.println("Invalid puzzle solver, please try again. \n\n\n");
            }
        }
        READER.close();
    }

}
