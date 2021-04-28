package Work7;

public class User {
    private int id_user=0;
    private String name="User";
    private String lastName="User_lastName";
    private String userLogin="Login";
    private String password="password";
    public int getId_user(){
        return id_user;
    }
    public String getUserLogin(){
        return userLogin;
    }
    public User(int id_user,String name,String lastName, String userLogin,String password){
        this.id_user=id_user;
        this.name=name;
        this.lastName=lastName;
        this.userLogin=userLogin;
        this.password=password;
    }
    public void info(){
        System.out.println("Name = "+ name
        +"\n User lastname = " + lastName
        +"\n Login = " + userLogin
        + "\n Password = "+ password +"\n");
    }
}
