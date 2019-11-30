package com.poly.hungnqph07434_duan1.presenter;

import com.poly.hungnqph07434_duan1.model.CauHoi;
import com.poly.hungnqph07434_duan1.modelview.QuizView;

import java.util.ArrayList;
import java.util.List;

public class QuizPresenter {
    private QuizView quizView;
    private List<CauHoi> cauHois;

    public QuizPresenter(QuizView quizView) {
        this.quizView = quizView;
    }

    public void clickDapAn(String DapAn, int position, int Scores){
         cauHois= new ArrayList<>();
        if (DapAn.equals( cauHois.get(position).getDapAnDung())){
            Scores++;
            quizView.chuyencau();
        }
    }

}
