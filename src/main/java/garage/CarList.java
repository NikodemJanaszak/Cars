package garage;

import java.util.LinkedList;
import java.util.List;

public class CarList {
    List<Car> list = new LinkedList<Car>();


    public void printCar(int num){
        Car c = list.get(num);
        System.out.println(c.getMake() + " " + c.getModel()+", moc: "+c.getPower()+"kW, masa: "+c.getWeight()+" t , przegląd przez rok od: "+c.getInspection());
    }
}
