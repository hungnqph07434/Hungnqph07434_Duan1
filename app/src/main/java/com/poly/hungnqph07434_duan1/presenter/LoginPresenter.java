package com.poly.hungnqph07434_duan1.presenter;

import com.poly.hungnqph07434_duan1.model.User;
import com.poly.hungnqph07434_duan1.modelview.LoginView;

import java.util.ArrayList;
import java.util.List;

public class LoginPresenter {
    private LoginView loginView;
    private List<User> userList;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public void login(String username, String password){

        loginView.navigate();
        userList= new ArrayList<>();
        String userlist;
        String passlist;
        for (int i=0; i<userList.size();i++) {

            userlist = userList.get(i).getName();
            passlist = userList.get(i).getPassword();

            if (!username.equals(userlist)&&!password.equals(passlist)) {
                loginView.seterrorUsernamw();
            }
            else if (username.equals(userlist)&&!password.equals(passlist)){
                loginView.seterrorUsernamw();
            }else if (!username.equals(userlist)&&password.equals(passlist)){
                loginView.setErrorPassword();
            }
            else {
                loginView.navigate();
            }
        }

    }
}
