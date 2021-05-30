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
        Point p = new Point(1,3,4,7);
        System.out.println("Расстояние между точками "+"("+p.p11+","+p.p12+")"+" и "+"("+p.p21+","+p.p22+")"+" = "+p.distance());
    }

    public static void hello(String somebody) {
        System.out.println("Hello," + somebody + "!");
    }

}
