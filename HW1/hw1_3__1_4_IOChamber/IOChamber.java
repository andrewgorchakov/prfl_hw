import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOChamber {

    public static void main(String[] args) {
        if (args.length != 0)
            if (readFile(args[0])) return;

        List <String> list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("")) break;
            list.add(line);
        }

        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) System.out.println(list.get(i));
        }
    }

    private static boolean readFile(String arg) {
        File file = new File(arg);
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не распознан. Введите ваши сообщения");
            return false;
        }
        BufferedReader br = new BufferedReader(fr);
        String line;

        try {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.err.println("IOException\n" + e + "\n");
        }
        return true;
    }
}