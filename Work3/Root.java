package Work3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class Root {

    private static final Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {
        try {
            // создаем объект List <String>
            List<String> list = new ArrayList<String>();

            // заполнить список
            list.add("A");
            list.add("B");
            list.add("C");
            list.add("D");
            list.add("E");
            // печать коллекции
            System.out.println("List : " + list);

            // создаем синхронизированный список
            List<String> synlist = Collections
                    .synchronizedList(list);
            // печать коллекции
            System.out.println("Synchronized list is : " + synlist);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();

        }
    }
}
