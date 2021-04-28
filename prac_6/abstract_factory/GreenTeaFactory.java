package prac_6.abstract_factory;

public class GreenTeaFactory implements  TeaFactory{
    @Override
    public IndianTea createIndianTea() {
        return new GreenIndianTea();
    }

    @Override
    public TurkishTea createTurkishTea() {
        return new GreenTurkishTea();
    }
}
