package garage;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Interface {

    public static void main(String[] arg){

        CarList myList = new CarList();
        boolean loop = true;
        while(loop==true) {
            Integer choice;
            System.out.println("Co chcesz zrobić?");
            System.out.println("1. Dodaj auto");
            System.out.println("2. Pokaż auto");
            System.out.println("3. Zamknij program");
            Scanner scanChoice = new Scanner(System.in);
            choice = scanChoice.nextInt();
            switch (choice) {
                case 1:
                    caseAddCar(myList);
                    break;
                case 2:
                    caseShowCar(myList);
                    break;
                default:
                    System.out.println("Zły wybór");
                    break;
            }
        }

    }

    public static void caseAddCar(CarList myList){
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
        myList.list.add(car_1);
    }

    public static void caseShowCar(CarList myList){
        System.out.println("O którym samochodzie chcesz się czegoś dowiedzieć?");
        int i=1;
        for(Car c : myList.list) {
            System.out.println(i+"."+c.getMake() + " " + c.getModel());
            i++;
        }
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        myList.printCar(num-1);
    }
}
