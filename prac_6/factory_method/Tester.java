package prac_6.factory_method;

public class Tester {
    public static void main(String[] args) {
    FactoryMethod ball2 = new Ball_2FactoryMethod();
    FactoryMethod ball = new Ball_1FactoryMethod();
    ball2.start();
    ball.start();
}
}
