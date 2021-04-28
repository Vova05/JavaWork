package Work7;
import Work7.Registration;

import java.util.ArrayList;

public class Remove_User  {

    boolean Remove(Registration cl,String remove_pas,String remove_login){
        int index1=cl.returnLogin(remove_login);
        System.out.println(index1);
        int index2=cl.returnPasswords(remove_pas);
        System.out.println(index2);
        ArrayList<User> tmp=cl.returnUsers();
        if(index1==index2&&index1!=0){
            tmp.remove(index1);
            cl.updateUsers(tmp);
            return true;
        }else{
            return false;
        }
    }
}
