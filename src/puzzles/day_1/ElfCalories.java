package src.puzzles.day_1;

import src.PuzzlesMain;
import src.puzzles.Puzzle;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ElfCalories implements Puzzle {

    @Override
    public void solve() {
        System.out.println("Please provide a file path:");

        String path = PuzzlesMain.READER.nextLine();
        String file = getWholeFile(path);
        List<Integer> sorted = splitSums(file);

        sorted.sort(Collections.reverseOrder());

        System.out.println("Sums sorted!, how many places would you like to see?");
        int places = PuzzlesMain.READER.nextInt();

        System.out.println("Now showing sums for places 1 -> " + places);
        int total = 0;
        for(int i = 0; i < places; i++) {
            total += sorted.get(i);
            System.out.println(i + ". " + sorted.get(i));
        }
        System.out.println("These elves are carrying a total of: " + total);
    }

    // Convert entire file into a singular string value
    public String getWholeFile(String path) {
        File calorieFile = new File(path);
        StringBuilder builder = new StringBuilder();

        try(Scanner fileReader  = new Scanner(calorieFile)) {
            while (fileReader.hasNext()) {
                builder.append(fileReader.nextLine());
                builder.append("\n");
            }
            return builder.toString();
        } catch (IOException exception) {
            exception.printStackTrace();
            System.out.println("Your file may be invalid. Check if the path listed exists.");
        }
        return "";
    }

    public List<Integer> splitSums(String file) {
        List<Integer> finalSums = new ArrayList<>();

        List<String> groups = Arrays.stream(file.split("(?m)^\\s*$")).toList();

        for(String strings : groups) {
            int num = 0;
            for (String string : strings.split("\n")) {
                if(!Objects.equals(string, "")) {
                    num += Integer.parseInt(string);
                }
            }
            finalSums.add(num);
        }
        return finalSums;
    }
}
