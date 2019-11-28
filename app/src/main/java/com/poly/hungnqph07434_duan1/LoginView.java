package com.poly.hungnqph07434_duan1;

public interface LoginView {
    void login();
    void showloading();


    //hiển thị lỗi với username
    void seterrorUsernamw();


    //hiện thị lỗi với password
    void    setErrorPassword();



    //chuyển màn hình
    void    navigate();
}
