package prac_6.factory_method;

public class Ball_2 implements Ball{
    @Override
    public void takeBall(){
        System.out.println("Мяч 2 был взят");
    }

    @Override
    public void downBall() {
        System.out.println("Мяч 2 упал");
    }

    public static class Tester {
    }
}
