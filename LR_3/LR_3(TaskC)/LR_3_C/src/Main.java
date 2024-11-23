import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Quadrilateral> quadrilaterals = new ArrayList<>();
        quadrilaterals.add(new Quadrilateral(new Point[]{new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(0, 1)})); //Square
        quadrilaterals.add(new Quadrilateral(new Point[]{new Point(0, 0), new Point(2, 0), new Point(2, 1), new Point(0, 1)})); //Rectangle
        quadrilaterals.add(new Quadrilateral(new Point[]{new Point(0, 0), new Point(1, 1), new Point(2, 0), new Point(1, -1)})); //Rhombus
        quadrilaterals.add(new Quadrilateral(new Point[]{new Point(0, 0), new Point(1, 2), new Point(3, 1), new Point(2, -1)})); //Arbitrary
        quadrilaterals.add(new Quadrilateral(new Point[]{new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(0.5, 1)})); //Arbitrary

        Map<String, List<Quadrilateral>> quadrilateralsByType = new HashMap<>();
        for (Quadrilateral quad : quadrilaterals) {
            quadrilateralsByType.computeIfAbsent(quad.type, k -> new ArrayList<>()).add(quad);
        }

        for (Map.Entry<String, List<Quadrilateral>> entry : quadrilateralsByType.entrySet()) {
            String type = entry.getKey();
            List<Quadrilateral> quadsOfType = entry.getValue();
            System.out.println("Type: " + type);
            quadsOfType.sort(Comparator.comparingDouble(Quadrilateral::area));
            System.out.println("Min area: " + quadsOfType.get(0).area());
            System.out.println("Max area: " + quadsOfType.get(quadsOfType.size() - 1).area());
            quadsOfType.sort(Comparator.comparingDouble(Quadrilateral::perimeter));
            System.out.println("Min perimeter: " + quadsOfType.get(0).perimeter());
            System.out.println("Max perimeter: " + quadsOfType.get(quadsOfType.size() - 1).perimeter());
            System.out.println();
        }
    }
}