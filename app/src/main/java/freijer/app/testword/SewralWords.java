package freijer.app.testword;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;


import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SewralWords extends AppCompatActivity {

    // двигаются по экрану набор букв (3-4 слова разбитых на буквы)
    // каждую букву можно использовать один раз
    // при нажатиии на букву она идет на свой ряд
    //у каждого слова свой ряд
    // из них надо собрать чем больше слов тем лучше
    // каждое слово +1 очко.
    // слова из 2 букв: -1 очко
    // от 3 до 4 букв +1 очко
    // от 4 бкв +2 очка

    // точно такую же, но буквы можно использовать множество раз

// при нажатии копия кнопки с буквой уходит на новое место - каждое слово, новая строка
//    protected AnimatorSet set1;
//    protected AnimatorSet set2;
//    protected AnimatorSet set3;
//    protected AnimatorSet set4;
//    protected AnimatorSet set5;
//    protected AnimatorSet set6;
//    protected AnimatorSet set7;
//    protected AnimatorSet set8;
//    protected AnimatorSet set9;
//    protected AnimatorSet set10;
//    protected AnimatorSet set11;
//    protected AnimatorSet set12;
//    protected AnimatorSet set13;
//    protected AnimatorSet set14;

    ObjectAnimator  button1;
    ObjectAnimator  button2;
    ObjectAnimator  button3;
    ObjectAnimator  button4;
    ObjectAnimator  button5;
    ObjectAnimator  button6;
    ObjectAnimator  button7;
    ObjectAnimator  button8;
    ObjectAnimator  button9;
    ObjectAnimator  button10;
    ObjectAnimator  button11;
    ObjectAnimator  button12;
    ObjectAnimator  button13;
    ObjectAnimator  button14;

    protected TextView textSee;
    protected Button start, reset, pr1, pr2, pr3, pr4, pr5, pr6, pr7, pr8, pr9, pr10, pr11, pr12, pr13, pr14;
    protected ArrayList<String> ListWords = new ArrayList<String>();
    protected ArrayList<Integer> ListCoordinateX = new ArrayList<Integer>();

    private ArrayList<String> list;
    private ArrayList<String> listControl;

    private int indexWord;
    private String word;
    private Random r = new Random();

    protected String[] Original;
    protected String[] OriginalWord; //бавзовое слово
    protected String[] MixedleWord; //смешение
    protected String Control;
    protected int numsofliteralsinword;
    protected int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sewral_words);



        pr1 = findViewById(R.id.pr1);
        pr2 = findViewById(R.id.pr2);
        pr3 = findViewById(R.id.pr3);
        pr4 = findViewById(R.id.pr4);
        pr5 = findViewById(R.id.pr5);
        pr6 = findViewById(R.id.pr6);
        pr7 = findViewById(R.id.pr7);
        pr8 = findViewById(R.id.pr8);
        pr9 = findViewById(R.id.pr9);
        pr10 = findViewById(R.id.pr10);
        pr11 = findViewById(R.id.pr11);
        pr12 = findViewById(R.id.pr12);
        pr13 = findViewById(R.id.pr13);
        pr14 = findViewById(R.id.pr14);
        start = findViewById(R.id.start);
        textSee = findViewById(R.id.textSee);

        ControlWordsfinFail(); // читаем проверочные слова
        ReadWords(); // читаем ключевык
        Randomizator(); // разиваем на буквы
        GoneButnnons(); //все кнопки изначально не видимы
        ShowButtons(); // услвие появление кнопок зависитот кол-ва букв в слове
        SetLiteralsonButtons(); //установка букв на слова
        Creates(); //активация и движеение кнопок

        String gg = Integer.toString(numsofliteralsinword);
        textSee.setText(gg + word);


    }

    public void GoneButnnons(){
        pr1.setVisibility(View.GONE);
        pr2.setVisibility(View.GONE);
        pr3.setVisibility(View.GONE);
        pr4.setVisibility(View.GONE);
        pr5.setVisibility(View.GONE);
        pr6.setVisibility(View.GONE);
        pr7.setVisibility(View.GONE);
        pr8.setVisibility(View.GONE);
        pr9.setVisibility(View.GONE);
        pr10.setVisibility(View.GONE);
        pr11.setVisibility(View.GONE);
        pr12.setVisibility(View.GONE);
        pr13.setVisibility(View.GONE);
        pr14.setVisibility(View.GONE);
    }
    public void ShowButtons(){
        switch (numsofliteralsinword){
            case 11:
                pr1.setVisibility(View.VISIBLE);
                pr2.setVisibility(View.VISIBLE);
                pr3.setVisibility(View.VISIBLE);
                pr4.setVisibility(View.VISIBLE);
//                pr5.setVisibility(View.VISIBLE);
//                pr6.setVisibility(View.VISIBLE);
//                pr7.setVisibility(View.VISIBLE);
//                pr8.setVisibility(View.VISIBLE);
//                pr9.setVisibility(View.VISIBLE);
//                pr10.setVisibility(View.VISIBLE);
//                pr11.setVisibility(View.VISIBLE);
                break;
            case 14:
                pr1.setVisibility(View.VISIBLE);
                pr2.setVisibility(View.VISIBLE);
                pr3.setVisibility(View.VISIBLE);
                pr4.setVisibility(View.VISIBLE);
//                pr5.setVisibility(View.VISIBLE);
//                pr6.setVisibility(View.VISIBLE);
//                pr7.setVisibility(View.VISIBLE);
//                pr8.setVisibility(View.VISIBLE);
//                pr9.setVisibility(View.VISIBLE);
//                pr10.setVisibility(View.VISIBLE);
//                pr11.setVisibility(View.VISIBLE);
//                pr12.setVisibility(View.VISIBLE);
//                pr13.setVisibility(View.VISIBLE);
//                pr14.setVisibility(View.VISIBLE);
                break;
        }

    }
    public void ReadWords(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("sevrallwords.txt")));
            String str;
            this.list = new ArrayList<String>();
            while ((str = reader.readLine()) != null) {
                if (!str.isEmpty()) {
                    list.add(str);
                }
            }
//            this.ReadWords = list.toArray(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }// Читаем ключевые слова из файлика
    public void ControlWordsfinFail(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("sevrallmanywords.txt")));
            String str1;
            this.listControl = new ArrayList<String>();
            while ((str1 = reader.readLine()) != null) {
                if (!str1.isEmpty()) {
                    listControl.add(str1);
                }
            }
//            this.ReadWords = list.toArray(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }// Читаем проверочные слова из файлика
    public void Randomizator(){
        if (!list.isEmpty()) {
            this.indexWord = r.nextInt(list.size());
            this.word = list.get(indexWord);
            list.remove(word);
        } else if (list.isEmpty()) {
            this.word = "конец";
            Randomizator();
        }
        this.Original = this.word.split("");//разбив по буквам
        List<String> list = new ArrayList<String>(Arrays.asList(Original));
        list.removeAll(Arrays.asList("", null));
        this.OriginalWord = list.toArray(new String[0]);
        String[] Literals = OriginalWord;
        List<String> shuffle = Arrays.asList(Literals);
        Collections.shuffle(shuffle);
        shuffle.toArray(Literals);
        this.MixedleWord = Literals;
        this.Control = this.word;
        this.numsofliteralsinword = MixedleWord.length;
    } //  Разбиваем слово на буквы

    protected void SetLiteralsonButtons(){
        switch (numsofliteralsinword) {
            case 11:
            pr1.setText(String.valueOf(MixedleWord[0]));
            pr2.setText(String.valueOf(MixedleWord[1]));
            pr3.setText(String.valueOf(MixedleWord[2]));
            pr4.setText(String.valueOf(MixedleWord[3]));
            pr5.setText(String.valueOf(MixedleWord[4]));
            pr6.setText(String.valueOf(MixedleWord[5]));
            pr7.setText(String.valueOf(MixedleWord[6]));
            pr8.setText(String.valueOf(MixedleWord[7]));
            pr9.setText(String.valueOf(MixedleWord[8]));
            pr10.setText(String.valueOf(MixedleWord[9]));
            pr11.setText(String.valueOf(MixedleWord[10]));
         break;
            case 14:
                pr1.setText(String.valueOf(MixedleWord[0]));
                pr2.setText(String.valueOf(MixedleWord[1]));
                pr3.setText(String.valueOf(MixedleWord[2]));
                pr4.setText(String.valueOf(MixedleWord[3]));
                pr5.setText(String.valueOf(MixedleWord[4]));
                pr6.setText(String.valueOf(MixedleWord[5]));
                pr7.setText(String.valueOf(MixedleWord[6]));
                pr8.setText(String.valueOf(MixedleWord[7]));
                pr9.setText(String.valueOf(MixedleWord[8]));
                pr10.setText(String.valueOf(MixedleWord[9]));
                pr11.setText(String.valueOf(MixedleWord[10]));
                pr12.setText(String.valueOf(MixedleWord[11]));
                pr13.setText(String.valueOf(MixedleWord[12]));
                pr14.setText(String.valueOf(MixedleWord[13]));
                break;
        }

    }

    //а таким образом можно давать рандомные коордлинаты что бы всегда с разных точек начиналось старт кнгопок движение
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Creates(){
        button1 = ObjectAnimator.ofPropertyValuesHolder(pr1,
                PropertyValuesHolder.ofFloat("x", 0, 850),
                PropertyValuesHolder.ofFloat("y", 0, 1100));
        button1.setDuration(9000);
        button1.setRepeatCount(ObjectAnimator.INFINITE);
        button1.setRepeatMode(ObjectAnimator.REVERSE);
        button1.start();

//2 кнопка
        button2 = ObjectAnimator.ofPropertyValuesHolder(pr2,
                PropertyValuesHolder.ofFloat("x", 200, 400),
                PropertyValuesHolder.ofFloat("y", 0, 1100));
        button2.setDuration(4400 +  getSpeed());
        button2.setRepeatCount(ObjectAnimator.INFINITE);
        button2.setRepeatMode(ObjectAnimator.REVERSE);
        button2.start();
//3 кнопка
        button3 = ObjectAnimator.ofPropertyValuesHolder(pr3,
                PropertyValuesHolder.ofFloat("x", 0, 910),
                PropertyValuesHolder.ofFloat("y", 100, 100));
        button3.setDuration(5000 +  getSpeed());
        button3.setRepeatCount(ObjectAnimator.INFINITE);
        button3.setRepeatMode(ObjectAnimator.REVERSE);
        button3.start();
//4 кнопка
        button4 = ObjectAnimator.ofPropertyValuesHolder(pr4,
                PropertyValuesHolder.ofFloat("x", 0, 910),
                PropertyValuesHolder.ofFloat("y", 500, 500));
        button4.setDuration(4600 +  getSpeed());
        button4.setRepeatCount(ObjectAnimator.INFINITE);
        button4.setRepeatMode(ObjectAnimator.REVERSE);
        button4.start();
//5 кнопка
        button5 = ObjectAnimator.ofPropertyValuesHolder(pr5,
                PropertyValuesHolder.ofFloat("x", 0, 910),
                PropertyValuesHolder.ofFloat("y", 900, 900));
        button5.setDuration(5300 +  getSpeed());
        button5.setRepeatCount(ObjectAnimator.INFINITE);
        button5.setRepeatMode(ObjectAnimator.REVERSE);
        button5.start();
//6 кнопка
        button6 = ObjectAnimator.ofPropertyValuesHolder(pr6,
                PropertyValuesHolder.ofFloat("x", 910, 0),
                PropertyValuesHolder.ofFloat("y", 300, 300));
        button6.setDuration(5600 +  getSpeed());
        button6.setRepeatCount(ObjectAnimator.INFINITE);
        button6.setRepeatMode(ObjectAnimator.REVERSE);
        button6.start();
//7 кнопка
        button7 = ObjectAnimator.ofPropertyValuesHolder(pr7,
                PropertyValuesHolder.ofFloat("x", 910, 0),
                PropertyValuesHolder.ofFloat("y", 700, 700));
        button7.setDuration(4400 +  getSpeed());
        button7.setRepeatCount(ObjectAnimator.INFINITE);
        button7.setRepeatMode(ObjectAnimator.REVERSE);
        button7.start();
//8 кнопка
        button8 = ObjectAnimator.ofPropertyValuesHolder(pr8,
                PropertyValuesHolder.ofFloat("x", 200, 650),
                PropertyValuesHolder.ofFloat("y", 1100, 100));
        button8.setDuration(3900 +  getSpeed());
        button8.setRepeatCount(ObjectAnimator.INFINITE);
        button8.setRepeatMode(ObjectAnimator.REVERSE);
        button8.start();
//9 кнопка не настроил
        button9 = ObjectAnimator.ofPropertyValuesHolder(pr9,
                PropertyValuesHolder.ofFloat("x", 800, 800),
                PropertyValuesHolder.ofFloat("y", 1100, 0));
        button9.setDuration(4100 +  getSpeed());
        button9.setRepeatCount(ObjectAnimator.INFINITE);
        button9.setRepeatMode(ObjectAnimator.REVERSE);
        button9.start();
//10 кнопка
        button10 = ObjectAnimator.ofPropertyValuesHolder(pr10,
                PropertyValuesHolder.ofFloat("x", 0, 250),
                PropertyValuesHolder.ofFloat("y", 1100, 0));
        button10.setDuration(4500 +  getSpeed());
        button10.setRepeatCount(ObjectAnimator.INFINITE);
        button10.setRepeatMode(ObjectAnimator.REVERSE);
        button10.start();
//11 кнопка
        button11 = ObjectAnimator.ofPropertyValuesHolder(pr11,
                PropertyValuesHolder.ofFloat("x", 910, 100),
                PropertyValuesHolder.ofFloat("y", 100, 950));
        button11.setDuration(5700 +  getSpeed());
        button11.setRepeatCount(ObjectAnimator.INFINITE);
        button11.setRepeatMode(ObjectAnimator.REVERSE);
        button11.start();
//12 кнопка
        button12 = ObjectAnimator.ofPropertyValuesHolder(pr12,
                PropertyValuesHolder.ofFloat("x", 700, 400),
                PropertyValuesHolder.ofFloat("y", 0, 1100));
        button12.setDuration(3600 +  getSpeed());
        button12.setRepeatCount(ObjectAnimator.INFINITE);
        button12.setRepeatMode(ObjectAnimator.REVERSE);
        button12.start();

//13 кнопка
        button13 = ObjectAnimator.ofPropertyValuesHolder(pr13,
                PropertyValuesHolder.ofFloat("x", 910, 0),
                PropertyValuesHolder.ofFloat("y", 1100, 1100));
        button13.setDuration(5100 +  getSpeed());
        button13.setRepeatCount(ObjectAnimator.INFINITE);
        button13.setRepeatMode(ObjectAnimator.REVERSE);
        button13.start();
//14 кнопка
        button14 = ObjectAnimator.ofPropertyValuesHolder(pr14,
                PropertyValuesHolder.ofFloat("x", 500, 500),
                PropertyValuesHolder.ofFloat("y", 0, 1100));
        button14.setDuration(4800 +  getSpeed());
        button14.setRepeatCount(ObjectAnimator.INFINITE);
        button14.setRepeatMode(ObjectAnimator.REVERSE);
        button14.start();

//рерзевное создание через XML
//        set1 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper1); // диагональ, с 0
//        set2 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper2); // лево У 100, с0
//        set3 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper3); // верх, Х 30    с 1
//        set4 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper4); // низ   Х 350      с 1
//        set5 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper5); // прав
//        set6 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper1); // диагональ, с 0
//        set7 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper2); // лево У 100, с0
//        set8 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper3); // верх, Х 30    с 1
//        set9 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper4); // низ   Х 350      с 1
//        set10 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper5); // прав
//        set11 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper11); // диагональ, с 0
//        set12 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper2); // лево У 100, с0
//        set13 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper3); // верх, Х 30    с 1
//        set14 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper4); // низ   Х 350      с 1
//        //set1.setTarget(pr1);
//        set2.setTarget(pr2);
//        set3.setTarget(pr3);
//        set4.setTarget(pr4);
//        set5.setTarget(pr5);
//        set6.setTarget(pr6);
//        set7.setTarget(pr7);
//        set8.setTarget(pr8);
//        set9.setTarget(pr9);
//        set10.setTarget(pr10);
//        set11.setTarget(pr11);
//        set12.setTarget(pr12);
//        set13.setTarget(pr13);
//        set14.setTarget(pr14);
//        //set1.start();
//        set2.start();
//        set3.start();
////        set4.start();
////        set5.start();
////       set6.start();
////       set7.start();
////       set8.start();
////       set9.start();
////       set10.start();
//        set11.start();
////        set12.start();
////        set13.start();
////        set14.start();   ht




    } //движение кнопок

    public void ClickButton1(View v){
        button1.end();
        // какже ты меня задрал FastOutLinearInInterpolator
        button1 = ObjectAnimator.ofPropertyValuesHolder(pr1,
                PropertyValuesHolder.ofFloat("x", 20),
                PropertyValuesHolder.ofFloat("y", 1400));
        button1.setDuration(3000);




        button1.start();

    }

    public void ClickButton2(View v){
                 button2.end();
                 button2 = ObjectAnimator.ofPropertyValuesHolder(pr2,
                PropertyValuesHolder.ofFloat("x", 200),
                PropertyValuesHolder.ofFloat("y", 1400));
        button2.setDuration(3000);
        button2.start();
    }

    public void ClickButton3(View v){
        button3.end();
        button3 = ObjectAnimator.ofPropertyValuesHolder(pr3,
                PropertyValuesHolder.ofFloat("x", 380),
                PropertyValuesHolder.ofFloat("y", 1400));
        button3.setDuration(3000);
        button3.start();
    }

    public void ClickButton4(View v){
        button4.end();
        button4 = ObjectAnimator.ofPropertyValuesHolder(pr4,
                PropertyValuesHolder.ofFloat("x", 560),
                PropertyValuesHolder.ofFloat("y", 1400));
        button4.setDuration(3000);
        button4.start();
    }


}
