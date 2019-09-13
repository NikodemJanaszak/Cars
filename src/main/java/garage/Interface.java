package garage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Interface {

    public static void main(String[] arg){
        Car car_1 = new Car();
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj markę: ");
        String make = sc.nextLine();
        System.out.print("Podaj model: ");
        String model = sc.nextLine();
        System.out.print("Podaj moc: ");
        int power = sc.nextInt();

        SimpleDateFormat sdf = new SimpleDateFormat ("dd.MM.yyyy");
        Scanner scan = new Scanner(System.in);  //i don't know why, but i had to create new Scanner object
        Date date=null;
        do {
            System.out.print("Podaj datę przeglądu [dd.MM.yyyy]: ");
            try {
                String dateStr = scan.nextLine();
                date = sdf.parse(dateStr);
            } catch (ParseException e) {
                System.err.println("Zły format daty");
            }
        }while (date==null);

        double weight=0;
        String myWeight = "[0-5]\\.[0-9]{1}";

        do {
                System.out.print("Podaj masę pojazdu [t]: ");
                weight = scan.nextDouble();
            try{
                if(Pattern.matches(myWeight,Double.toString(weight))){
                    break;
                }
                else {
                    System.out.println("Zły format mój throw");
                    weight =0;
                }
            }
            catch (NumberFormatException e){
                System.err.println("Zły format liczby");
            }
        } while(weight <=0);


        car_1.setMake(make);
        car_1.setModel(model);
        car_1.setPower(power);
        car_1.setInspection(date);
        car_1.setWeight(weight);

        System.out.println("Podaję dane:");
        System.out.print(car_1.carData());
    }
}
