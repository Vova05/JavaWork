package Work7;
import Work7.User;
import java.util.ArrayList;
import java.util.Scanner;

public class Registration {
    private ArrayList<Integer> arr_id = new ArrayList<>();
    private ArrayList<String> password = new ArrayList<>();
    private ArrayList<String> userLogin=new ArrayList<>();
    private ArrayList<User> user_arr=new ArrayList<>();
    private int last_id=1;

    User addUser(int special_id, String name, String lastName){
        special_id=generateID(special_id);
        String password=generatePassword(name,lastName,special_id);
        String login=lastName+" "+special_id;
        userLogin.add(login);
        User user=new User(special_id,name,lastName,login,password);
        user_arr.add(user);
        return user;
    }
    public void Information(int id){
            int index = arr_id.indexOf(id);
            System.out.println(index);
            user_arr.get(index).info();
    }
    public int returnPasswords(String pass_chek){
        for(String i:password){
            if(!pass_chek.equals(i)){
                continue;
            }else{
                return password.indexOf(pass_chek);
            }
        }
        return 0;
    }
    public int returnIDindex(int id){
        return arr_id.indexOf(id);
    }
    public int returnLogin(String login_chek){
                return userLogin.indexOf(login_chek);
    }
    public ArrayList<User> returnUsers(){
        return user_arr;
    }
    public boolean updateUsers(ArrayList<User> user_arr){
        this.user_arr=user_arr;
        return true;
    }
    private int generateID(int special_id){
        for (int i=0;i < arr_id.size();i++ ) {
            if (special_id != arr_id.get(i)&& special_id!=0) {
                continue;
            } else {
                last_id=user_arr.get(user_arr.size()-1).getId_user();
                last_id=chekID(last_id);
                arr_id.add(last_id);
                return last_id;
            }
        }
        arr_id.add(special_id);
        return special_id;
    }
    private String generatePassword(String name, String lastName, int id){
       password.add(name+lastName+id);
        return name+lastName+id;
    }
    private int chekID(int chek_ID){
        for(int i=0;i<arr_id.size();i++){
            if(chek_ID!=arr_id.get(i)&&i==arr_id.size()){
                return chek_ID;
            }else{
                chek_ID++;
            }
        }
        return chek_ID;
    }
}
