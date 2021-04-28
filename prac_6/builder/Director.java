package prac_6.builder;

public class Director {
    public void AddAppleLaptop(Builder laptop){
        laptop.setModel("Imac");
        laptop.setPrice(100000);
        laptop.setSeldom(false);
    }
    public void AddLenovoLaptop(Builder laptop){
        laptop.setModel("Lenovo GT");
        laptop.setPrice(45795);
        laptop.setSeldom(true);
    }
}
