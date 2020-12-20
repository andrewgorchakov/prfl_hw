
import ru.pflb.mq.dummy.exception.*;
import ru.pflb.mq.dummy.interfaces.*;
import ru.pflb.mq.dummy.implementation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        List <String> list = new ArrayList<>();
        list.add("Раз");
        list.add("Два");
        list.add("Три");

        Connection connection = new ConnectionImpl();
        //connection.start();
        Session session = new SessionImpl();

        connection.createSession(true);
        Destination destination = new DestinationImpl("Test destination");

        Producer producer = new ProducerImpl(destination);

        for (String s : list) {
            Thread.sleep(2000);
            producer.send(s);
        }

        session.close();
        connection.close();

    }
}
