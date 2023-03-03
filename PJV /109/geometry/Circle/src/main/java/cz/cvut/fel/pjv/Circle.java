package cz.cvut.fel.pjv;

//import static java.lang.Math.PI;

public class Circle extends Shape2d implements Positionable{
    private double radius;

    private Point centrem;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }
    public double getRadius() {
        return radius;
    }
    @Override
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    @Override
    public void setPosition(double x, double y) {
        this.centrem.setX(x);
        this.centrem.setY(y);
    }

    @Override
    public void setX(double x) {
        this.centrem.setX(x);
    }

    @Override
    public void setY(double y) {
        this.centrem.setX(y);
    }
}
