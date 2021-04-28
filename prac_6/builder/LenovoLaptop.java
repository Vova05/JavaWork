package prac_6.builder;

public class LenovoLaptop {
    private String model;
    private int price;
    private boolean seldom;

    public LenovoLaptop(String model, int price, boolean seldom){
        this.model=model;
        this.price=price;
        this.seldom=seldom;
    }

    @Override
    public String toString() {
        return "Lenovo Laptop:" +model+", "+ price+", "+seldom;
    }
}
