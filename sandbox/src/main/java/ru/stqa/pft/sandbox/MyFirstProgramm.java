package ru.stqa.pft.sandbox;

public class MyFirstProgramm {
    public static void main(String[] args) {
        hello("World");
        hello("Ismail");
        hello("Alexei");
        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());
        Rectangle r = new Rectangle(5, 7);
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
        Point p1 = new Point(1,3);
        Point p2 = new Point (4,7);
        System.out.println("Расстояние между точками "+"("+p1.x+","+p1.y+")"+" и "+"("+p2.x+","+p2.y+")"+" = "+p1.distance(p2));
    }

    public static void hello(String somebody) {
        System.out.println("Hello," + somebody + "!");
    }

}
