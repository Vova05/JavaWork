package prac_6.builder;

public class LenovoLaptopBuilder implements Builder{
    private String model;
    private int price;
    private boolean seldom;

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSeldom(boolean seldom) {
        this.seldom = seldom;
    }

    public LenovoLaptop Shop(){
        return new LenovoLaptop(model, price, seldom);
    }
}
