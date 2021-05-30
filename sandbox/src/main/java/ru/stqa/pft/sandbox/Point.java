package ru.stqa.pft.sandbox;

public class Point {
    public double p11;
    public double p12;
    public double p21;
    public double p22;

    public Point(double p11, double p12, double p21, double p22){
        this.p11=p11;
        this.p12=p12;
        this.p21=p21;
        this.p22=p22;
    }
    public double distance(){
        return Math.sqrt((p22 - p12) * (p22 - p12) + (p21 - p11) * (p21 - p11));
    }
}
