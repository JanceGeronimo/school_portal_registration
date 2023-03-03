import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.Year;
import java.time.LocalDate;
import java.util.Scanner;

public class Main{

    public static final Scanner scan = new Scanner(System.in);
    public static String firstName, lastName, birthday, course, email, day;

    public static void main(String[] args) {

        getName();
        getBirthday();
        getCourse();
        getEmail();

        int year = Year.now().getValue();
        System.out.println(year + "-" + day + "01" + "-" + lastName.charAt(0));
    }

    static void getName(){

        System.out.print("Enter your first name: ");
        firstName = scan.next();
        RegularExpression reg_firstName = new RegularExpression("^[a-zA-Z]{0,49}$", firstName);

        System.out.print("Enter your last name: ");
        lastName = scan.next();
        RegularExpression reg_lastName = new RegularExpression("^[a-zA-Z]{0,49}$", lastName);
    }

    static void getBirthday(){

        System.out.print("Enter birthday (yyyy/mm/dd): ");
        birthday = scan.next();

        RegularExpression reg_birthday = new RegularExpression("^[0-9/]+$", birthday);

        computeAge();

    }

    static void computeAge(){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate DoB = LocalDate.parse(birthday, df);
        LocalDate now = LocalDate.now();

        int getDay = DoB.getDayOfMonth();
        day = String.format("%02d", getDay);  //get month for final output

        int age = Period.between(DoB, now).getYears();
        if(age < 17){
            System.out.println("Age not for college yet.");
            System.exit(0);
        }
    }

    static void getCourse(){

        System.out.print("Enter course: ");
        course = scan.next();

        RegularExpression reg_course = new RegularExpression("^[a-zA-Z][^0-9]{0,49}$", course);

    }

    static void getEmail() {

        System.out.print("Enter email address: ");
        email = scan.next();

        RegularExpression reg_email = new RegularExpression("^[A-Za-z0-9+_.-]+@(.+)$", email);
    }
}
