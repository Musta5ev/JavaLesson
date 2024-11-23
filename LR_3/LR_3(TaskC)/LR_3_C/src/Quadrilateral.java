class Point {
    double x, y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double distanceTo(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}

class Quadrilateral {
    Point[] points;
    String type; // "square", "rectangle", "rhombus", "arbitrary"

    Quadrilateral(Point[] points) {
        this.points = points;
        this.type = determineType();
    }

    double perimeter() {
        double perimeter = 0;
        for (int i = 0; i < 4; i++) {
            perimeter += points[i].distanceTo(points[(i + 1) % 4]);
        }
        return perimeter;
    }

    double area() {
        // Используем формулу площади четырехугольника по координатам вершин
        double area = 0.5 * Math.abs(
                points[0].x * points[1].y + points[1].x * points[2].y + points[2].x * points[3].y + points[3].x * points[0].y -
                        points[1].x * points[0].y - points[2].x * points[1].y - points[3].x * points[2].y - points[0].x * points[3].y
        );
        return area;

    }


    private String determineType() {
        double[] sides = new double[4];
        for (int i = 0; i < 4; i++) {
            sides[i] = points[i].distanceTo(points[(i + 1) % 4]);
        }

        boolean isSquare = true;
        boolean isRectangle = true;
        boolean isRhombus = true;


        for (int i = 1; i < 4; i++) {
            if (Math.abs(sides[i] - sides[0]) > 0.001) { //Учитываем погрешность вычислений с плавающей точкой
                isSquare = false;
                isRhombus = false;
            }
        }
        if (isSquare) return "square";

        for(int i = 0; i < 4; i++){
            double dotProduct = (points[(i+1)%4].x - points[i].x) * (points[(i+2)%4].x - points[(i+1)%4].x) + (points[(i+1)%4].y - points[i].y) * (points[(i+2)%4].y - points[(i+1)%4].y);
            if(Math.abs(dotProduct) > 0.001) isRectangle = false;
        }

        if (isRectangle) return "rectangle";

        for (int i = 1; i < 4; i++) {
            if (Math.abs(sides[i] - sides[0]) > 0.001) isRhombus = false;
        }
        if (isRhombus) return "rhombus";


        return "arbitrary";
    }
}