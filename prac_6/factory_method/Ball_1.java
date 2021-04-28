package prac_6.factory_method;

public class Ball_1 implements Ball{
    @Override
    public void takeBall() {
        System.out.println("Первый мяч был взят");
    }

    @Override
    public void downBall() {
        System.out.println("Первый мяч упал");
    }
}
