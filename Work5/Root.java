package Work5;

public class Root {
    public static void main(String[] args) {

    }
}
class Singleton {         //Способ №1
    private static Singleton instance;
    private Singleton(){}
    public static synchronized Singleton getInstance(){
        if(instance==null) {
            instance = new Singleton();
        }
        return instance;
    }
}
class Singleton2 {         //Способ №2
    private static Singleton2 instance = new Singleton2();
    private Singleton2(){}
    public static Singleton2 getInstance(){
        return instance;
    }
}

class Singleton3 {          //Способ №3
    private Singleton3(){}
    private static class SingletonHolder{
        private final static Singleton3 incstance = new Singleton3();
    }
    public static Singleton3 getInstance(){
        return  SingletonHolder.incstance;
    }
}

class Singleton4 {          //Способ №4
    private static Singleton4 instance;
    private Singleton4(){}
    public static synchronized Singleton4 getInstance(){
        if (instance==null){
            instance=new Singleton4();
        }
        return instance;
    }
}

class Singleton5 {              //Способ №5
    private static volatile Singleton5 instance;
    private Singleton5(){}
    public static Singleton5 getInstance(){
        if(instance==null)
            synchronized (Singleton5.class){
                if(instance==null)
                    instance=new Singleton5();
            }
        return instance;
    }
}