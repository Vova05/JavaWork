package prac_6.builder;

public class Tester {
    public static void main(String[] args) {
        Director director = new Director();

        LenovoLaptopBuilder apple = new LenovoLaptopBuilder();
        director.AddLenovoLaptop(apple);
        System.out.println(apple.Shop());

        AppleLaptopBuilder lenovo = new AppleLaptopBuilder();
        director.AddAppleLaptop(lenovo);
        System.out.println(lenovo.Shop());
    }
}
