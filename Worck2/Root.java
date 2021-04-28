package Worck2;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Stream;


public class Root {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2000, 4, 25);
        LocalDate date2 = LocalDate.now();

        Human a = new Human(21, "Nama", "M", date2, 13);
        Collection<Human> collection = Arrays.asList(new Human(20, "Nama", "M", date, 50), new Human(34, "GG", "HH", date2, 67), new Human(23, "Alex", "P", date.minusDays(100), 45));
        double res = collection.stream().mapToInt(Human::getWeight).average().getAsDouble();
        collection.stream().sorted(new HumanComparator()).forEach(p->System.out.printf(" %s -- %s %s -- %s\n",
                        p.getAge(), p.firstName, p.lastName,p.getBirthDate()));
        System.out.println("---------------------------------------------");
        collection.stream().sorted(new HumanComparatorAge()).forEach(p->System.out.printf(" %s -- %s %s -- %s\n",
                p.getAge(), p.firstName, p.lastName,p.getBirthDate()));
        System.out.println(res);
    }

    static class HumanComparator implements Comparator<Human> {

        @Override
        public int compare(Human o1, Human o2) {
            return o1.getFirstName().toUpperCase().compareTo(o2.getFirstName().toUpperCase());
        }
    }
    static class HumanComparatorAge implements Comparator<Human> {

        @Override
        public int compare(Human o1, Human o2) {
            return o1.getBirthDate().compareTo(o2.getBirthDate());
        }
    }
}
