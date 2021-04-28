package prac_6.builder;

public class AppleLaptop {
    private String model;
    private int price;
    private boolean seldom;

    public AppleLaptop(String model, int price, boolean seldom){
        this.model=model;
        this.price=price;
        this.seldom=seldom;
    }

    @Override
    public String toString() {
        return "Apple Laptop:" +model+", "+ price+", "+seldom;
    }
}
