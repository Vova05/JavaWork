package prac_6.factory_method;

public abstract class FactoryMethod {
    public void start(){
        Ball ball = createBall();
        ball.takeBall();
        ball.downBall();
    }
    public abstract Ball createBall();
}