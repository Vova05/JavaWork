package prac_6.factory_method;

public class Ball_2FactoryMethod extends FactoryMethod {
    @Override
    public Ball createBall() {
        return new Ball_2();
    }
}
