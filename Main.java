import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        DBlogic db = new DBlogic();

        Scanner scan = new Scanner(System.in);

        System.out.println("MENU: 1) Create, 2) Select All, 3) Select By Id");

            int user_choice = scan.nextInt();
            scan.nextLine();

            switch (user_choice) {
            case 1:
                System.out.println("Enter e-mail:");
                String user_email = scan.nextLine();

                System.out.println("Enter password:");
                String user_password = scan.nextLine();

                db.create(user_email, user_password);

                break;

            case 2:
                db.readAll();

                break;

            case 3:

                System.out.println("Enter new e-mail:");
                String new_email = scan.nextLine();

                db.updateEmail(1, "");
                break;

            case 4:

                System.out.println("Enter new Password:");
                String new_password = scan.nextLine();

                db.updatePassword(1, "");

                break;
        }

    }
}