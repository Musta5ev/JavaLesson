import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //Task A
    static List<Train> trains = new ArrayList<>();
    static List<String> destination = new ArrayList<>();
    static int  counter = 0;
    static int MAX = 10;
    static int index = 0;
    public static Train CreatTrain()
    {
        counter++;
        index = (int) (Math.random() * destination.size());
        return
        new Train(destination.get(index),
                counter,
                new Date(
                        2024,
                        (int) (Math.random() * 12),
                        (int) (Math.random() * 30),
                        (int) (Math.random() * 24),
                        (int) (Math.random() * 59)
                ),

                new Seats(
                        (int) (Math.random() * 12),
                        (int) (Math.random() * 12),
                        (int) (Math.random() * 12),
                        (int) (Math.random() * 12))
        );
    }
    //Task B
    public static void main(String[] args) {
        destination.add("Тамбов");
        destination.add("Ростов-на-Дону");
        destination.add("Казань");
        destination.add("Мурманск");
        for (int i = 0; i < MAX; i++) {
            trains.add(CreatTrain());
            System.out.println(trains.get(i).toString());
        }
    }
}