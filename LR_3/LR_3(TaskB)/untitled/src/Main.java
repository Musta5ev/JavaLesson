import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Line l1 = new Line(1, 2, -3);
        Line l2 = new Line(2, -1, 1);
        Line l3 = new Line(1, 2, -6); //Parallel to l1


        Line l4 = new Line(1,0,-2); // параллельна оси Оу
        Line l5 = new Line(1,0,-5); // параллельна оси Оу

        Line l6 = new Line(0,1,-3); //параллельна оси Ох
        Line l7 = new Line(0,1, -7); //параллельна оси Ох

        System.out.println("Intersection of l1 with X axis: " + l1.intersectionWithX()); // null - прямые параллельны
        System.out.println("Intersection of l1 with Y axis: " + l1.intersectionWithY());
        System.out.println("Intersection of l1 and l2: " + l1.intersection(l2));
        System.out.println("Intersection of l1 and l3: " + l1.intersection(l3));
        System.out.println("Intersection of l4 and l5: " + l4.intersection(l5));
        System.out.println("Intersection of l6 and l7: " + l6.intersection(l7));

        List<Line> lines = new ArrayList<>();
        lines.add(l1);
        lines.add(l2);
        lines.add(l3);
        lines.add(l4);
        lines.add(l5);
        lines.add(l6);
        lines.add(l7);
        lines.add(new Line(3, 4, -5));
        lines.add(new Line(1, 2, -9));


        Map<Line, List<Line>> parallelGroups = new HashMap<>();
        for (Line line : lines) {
            boolean foundGroup = false;
            for (Map.Entry<Line, List<Line>> entry : parallelGroups.entrySet()) {
                if (line.intersection(entry.getKey()) == null) {
                    entry.getValue().add(line);
                    foundGroup = true;
                    break;
                }
            }
            if (!foundGroup) {
                parallelGroups.put(line, new ArrayList<>(List.of(line)));
            }
        }

        System.out.println("\nParallel line groups:");
        for (Map.Entry<Line, List<Line>> entry : parallelGroups.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}