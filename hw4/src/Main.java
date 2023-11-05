import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Adventure> adventures = new HashMap<>();
        ArrayList<CombatLog> record = new ArrayList<>();
        ArrayList<ArrayList<String>> input = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        while (scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            String[] strings = nextLine.trim().split(" +");
            input.add(new ArrayList<>(Arrays.asList(strings)));
        }
        Switch sw = new Switch();
        sw.swOpera(input, input.size(), adventures, record);
        scanner.close();
    }
}