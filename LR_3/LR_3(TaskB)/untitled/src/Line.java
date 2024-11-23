import java.util.*;

class Point {
    double x, y; // Координаты точки

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")"; // Преобразование точки в строковое представление
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Сравнение ссылок
        if (obj == null || getClass() != obj.getClass()) return false; // Проверка типа объекта
        Point point = (Point) obj; // Приведение объекта к типу Point
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0; // Сравнение координат с учетом возможных погрешностей в double
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y); // Хеш-код для точки, основанный на координатах
    }
}

class Line {
    double a, b, c; // Коэффициенты уравнения прямой ax + by + c = 0

    Line(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    Line(Point p1, Point p2) { // Конструктор, создающий прямую по двум точкам
        a = p2.y - p1.y;
        b = p1.x - p2.x;
        c = -a * p1.x - b * p1.y;

        // Нормализация коэффициентов для упрощения дальнейших вычислений
        double gcd = gcd(gcd(Math.abs(a), Math.abs(b)), Math.abs(c));
        a /= gcd;
        b /= gcd;
        c /= gcd;

        // Устранение неоднозначности знаков коэффициентов, приведение к каноническому виду
        if(a < 0 || (a == 0 && b < 0)){
            a = -a;
            b = -b;
            c = -c;
        }

    }

    Point intersectionWithX() { // Точка пересечения с осью X
        if (b == 0) return null; // Прямая параллельна оси X
        return new Point(-c / a, 0);
    }

    Point intersectionWithY() { // Точка пересечения с осью Y
        if (a == 0) return null; // Прямая параллельна оси Y
        return new Point(0, -c / b);
    }

    Point intersection(Line other) { // Точка пересечения с другой прямой
        double det = a * other.b - other.a * b; // Определитель системы уравнений
        if (det == 0) return null; // Прямые параллельны
        double x = (b * other.c - other.b * c) / det; // Координата x точки пересечения
        double y = (other.a * c - a * other.c) / det; // Координата y точки пересечения
        return new Point(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Сравнение ссылок
        if (obj == null || getClass() != obj.getClass()) return false; // Проверка типа объекта
        Line line = (Line) obj; // Приведение объекта к типу Line
        return Double.compare(line.a / line.a, a / a) == 0 && Double.compare(line.b / line.a, b / a) == 0; // Сравнение направляющих векторов прямых с учетом возможных погрешностей в double
    }
    @Override
    public String toString() {// Привидение к текстовому формату
        return a + "x + " + b + "y + " + c + " = 0";
    }
        @Override
    public int hashCode() {
        return Objects.hash(a/a, b/a); // Хеш-код для прямой, основанный на направляющем векторе.  Должен быть согласован с методом equals.
    }

    private double gcd(double a, double b) { // Сокращение значений для приведения к нормальной форме
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}