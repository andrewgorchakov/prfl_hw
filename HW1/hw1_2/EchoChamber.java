import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EchoChamber {

    public static void main(String[] args) {
        List <String> list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("")) break;
            list.add(line);
        }

        for (String str: list) {
            System.out.println(str);
        }
    }
}