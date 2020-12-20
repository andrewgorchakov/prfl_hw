
import ru.pflb.mq.dummy.exception.*;
import ru.pflb.mq.dummy.interfaces.*;
import ru.pflb.mq.dummy.implementation.*;
import java.io.IOException;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Connection connection = new ConnectionImpl();
        //connection.start();
        Session session = new SessionImpl();
        connection.createSession(true);

        if (args.length == 0) {
            System.out.println("Не задан аргумент! Необходимо ввести путь к файлу");

        } else {
            File file = new File(args[0]);
            FileReader fr = null;
            try {
                fr = new FileReader(file);
            } catch (FileNotFoundException e) {
                System.out.println("Файл не прочитан" + e);
            }

            BufferedReader br = new BufferedReader(fr);
            String line;
            Destination destination = new DestinationImpl("Test destination");
            Producer producer = new ProducerImpl(destination);

            try {
                while ((line = br.readLine()) != null) {
                    producer.send(line);
                    Thread.sleep(2000);
                }
                br.close();
            } catch (IOException e) {
                System.err.println("IOException\n" + e + "\n");
            }

            session.close();
            connection.close();
        }
    }
}