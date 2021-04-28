package prac_6.factory_method;

public class Ball_1FactoryMethod extends FactoryMethod {
    @Override
    public Ball createBall() {
        return new Ball_1();
    }
}
