package prac_6.builder;

public class AppleLaptopBuilder implements Builder{
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

    public AppleLaptop Shop(){
        return new AppleLaptop(model, price, seldom);
    }
}
