package Work7;
import Work7.Registration;
import Work7.Remove_User;
import java.util.Scanner;

public class Logik {
    public Logik(){


        Scanner scanner_log=new Scanner(System.in);
        Registration registration = new Registration();
        Remove_User remove_user=new Remove_User();
        registration.addUser(1,"Vova","GL");
        registration.addUser(2,"Nama","ML");
        while (true) {
            System.out.println("Добавить пользователя 1. \n Удалить пользователя 2. \n Информация о пользователе 3.\n");
            switch (scanner_log.nextInt()) {
                case 1:
                    System.out.println("Вы хотите ввести свой ID? \n Если не хотите введите 0.\n");
                    Scanner scanner_1 = new Scanner(System.in);
                    int id = scanner_1.nextInt();
                    System.out.println("\n Введите имя: ");
                    Scanner scanner_2 = new Scanner(System.in);
                    String name = scanner_2.nextLine();
                    System.out.println("\n Введите фамилию: ");
                    Scanner scanner_3 = new Scanner(System.in);
                    String lastName = scanner_3.nextLine();
                    registration.addUser(id, name, lastName).info();
                case 2:
                    System.out.println("\n Введите логин и пароль: ");
                    Scanner login_in = new Scanner(System.in);
                    Scanner pass_in = new Scanner(System.in);
                    if (remove_user.Remove(registration, pass_in.nextLine(), login_in.nextLine())) {
                        System.out.println("\n ------------------\n Пользователь удален \n");
                    } else {
                        System.out.println("\n ------------------\n Ошибка \n");
                    }
                case 3:
                    System.out.println("Для получения информации введите id: ");
                    Scanner id_in = new Scanner(System.in);
                    registration.Information(id_in.nextInt());
            }
        }
    }
}
