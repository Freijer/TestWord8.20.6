package freijer.app.testword;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Dropwords extends AppCompatActivity {

        //AnimatorSet - для нескольких параметров в xml
       //ObjectAnimator - ждя 1 параметра в xml



    protected Button start, pr1, pr2, pr3, pr4, pr5, pr6, pr7, pr8, pr91, pr10, reset;
    protected TextView texx, score;
    protected ArrayList<String> ListWords = new ArrayList<String>();

    protected String[] Original;
    protected String[] OriginalWord; //бавзовое слово
    protected String[] MixedleWord; //смешение
    protected String[] ReadWords; //Массив из файла
    protected String Control;

    protected AnimatorSet set1;
    protected AnimatorSet set2;
    protected AnimatorSet set3;
    protected AnimatorSet set4;
    protected AnimatorSet set5;
    protected AnimatorSet set6;
    protected AnimatorSet set7;
    protected AnimatorSet set8;
    protected AnimatorSet set9;
    protected AnimatorSet set10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dropwords);

        texx = (TextView)findViewById(R.id.texx);
        start = (Button)findViewById(R.id.start);
        reset = (Button)findViewById(R.id.reset);
        pr1 = (Button)findViewById(R.id.pr1);
        pr2 = (Button)findViewById(R.id.pr2);
        pr3 = (Button)findViewById(R.id.pr3);
        pr4 = (Button)findViewById(R.id.pr4);
        pr5 = (Button)findViewById(R.id.pr5);
        pr6 = (Button)findViewById(R.id.pr6);
        pr7 = (Button)findViewById(R.id.pr7);
        pr8 = (Button)findViewById(R.id.pr8);
        pr91 = (Button)findViewById(R.id.pr91);
        pr10 = (Button)findViewById(R.id.pr10);

        reset.setVisibility(View.GONE);

        pr1.setVisibility(View.GONE);
        pr2.setVisibility(View.GONE);
        pr3.setVisibility(View.GONE);
        pr4.setVisibility(View.GONE);
        pr5.setVisibility(View.GONE);
        pr5.setVisibility(View.GONE);
        pr6.setVisibility(View.GONE);
        pr7.setVisibility(View.GONE);
        pr8.setVisibility(View.GONE);
        pr91.setVisibility(View.GONE);
        pr10.setVisibility(View.GONE);

    }


    public void Reset(View v){
        start.setVisibility(View.VISIBLE);
        reset.setVisibility(View.GONE);
        ListWords.clear();
        texx.setText("");

        //animator1.end();
        set1.end();
        set2.end();
        set3.end();
        set4.end();
        set5.end();
        set6.end();
        set7.end();
        set8.end();
        set9.end();
        set10.end();
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Verify() {

        String[] array = ListWords.toArray(new String[0]);
        String Key = (String.join("", array));
        if (Integer.valueOf(ListWords.size()) == 5) {
            if (Key.equals(Control)) {
                texx.setText("Молодец");
                //texx.setText("Нет");
                set1.end();
                set2.end();
                set3.end();
                set4.end();
                set5.end();
                set6.end();
                set7.end();
                set8.end();
                set9.end();
                set10.end();

            }
            else {
                texx.setText("НЭВЕРНО");
            }
        }
    }

    public void constr(View v){
       Gos();
       reset.setVisibility(View.VISIBLE);
       start.setVisibility(View.GONE);
        SetStart();
    }

    public void SetStart(){
       set1.start();
       set2.start();
       set3.start();
       set4.start();
       set5.start();
       set6.start();
       set7.start();
       set8.start();
       set9.start();
       set10.start();

    }

    public void RandomGen(){

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("dropwordlist.txt")));
            String str;
            ArrayList<String> list = new ArrayList<String>();
            while ((str = reader.readLine()) != null) {
                if (!str.isEmpty()) {
                    list.add(str);
                }
            }
            this.ReadWords = list.toArray(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] stringArr = ReadWords;
        int oneLength = stringArr.length;
        int rand1 = (int) (Math.random() * oneLength);
        String RandomWord = stringArr[rand1];
        this.Original = RandomWord.split("");//разбив по буквам
        List<String> list = new ArrayList<String>(Arrays.asList(Original));
        System.out.println(list);
        list.removeAll(Arrays.asList("", null));
        System.out.println(list);
        this.OriginalWord = list.toArray(new String[0]);
        String[] Literals = OriginalWord;
        List<String> shuffle = Arrays.asList(Literals);
        Collections.shuffle(shuffle);
        shuffle.toArray(Literals);
        this.MixedleWord = Literals;
        this.Control = RandomWord;
    }

    public void SetTextOnButtons(){
        pr1.setEnabled(true);
        pr2.setEnabled(true);
        pr3.setEnabled(true);
        pr4.setEnabled(true);
        pr5.setEnabled(true);
        pr5.setEnabled(true);
        pr6.setEnabled(true);
        pr7.setEnabled(true);
        pr8.setEnabled(true);
        pr91.setEnabled(true);
        pr10.setEnabled(true);

        pr1.setVisibility(View.VISIBLE);
        pr2.setVisibility(View.VISIBLE);
        pr3.setVisibility(View.VISIBLE);
        pr4.setVisibility(View.VISIBLE);
        pr5.setVisibility(View.VISIBLE);
        pr5.setVisibility(View.VISIBLE);
        pr6.setVisibility(View.VISIBLE);
        pr7.setVisibility(View.VISIBLE);
        pr8.setVisibility(View.VISIBLE);
        pr91.setVisibility(View.VISIBLE);
        pr10.setVisibility(View.VISIBLE);

        RandomGen();
        pr1.setText(String.valueOf(MixedleWord[0]));
        pr2.setText(String.valueOf(MixedleWord[1]));
        pr3.setText(String.valueOf(MixedleWord[2]));
        pr4.setText(String.valueOf(MixedleWord[3]));
        pr5.setText(String.valueOf(MixedleWord[4]));
        pr6.setText(String.valueOf(MixedleWord[0]));
        pr7.setText(String.valueOf(MixedleWord[1]));
        pr8.setText(String.valueOf(MixedleWord[2]));
        pr91.setText(String.valueOf(MixedleWord[3]));
        pr10.setText(String.valueOf(MixedleWord[4]));


    }

    public void Gos(){  // анимацимя основной модуль
        SetTextOnButtons();
//        pr1.animate().translationYBy(-5000).setDuration(13000);
//        ObjectAnimator moveAnimatorY = ObjectAnimator.ofFloat(pr1, "y", -5000);
//        moveAnimatorY.setDuration(13000);
//        moveAnimatorY.start();
//        animator1 = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.upper);
        set1 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper1); // диагональ, с 0
        set2 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper2); // лево У 100, с0
        set3 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper3); // верх, Х 30    с 1
        set4 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper4); // низ   Х 350      с 1
        set5 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper5); // право  У 150     с 2
        set6 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper6); // диавгональ, с 2
        set7 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper7); // лево У 300,  с3
        set8 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper8); //верх  Х 225        с3
        set9 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper9); // низ  Х 130     с4
        set10 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper10); // право У 400     с 4

        set9.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {}
            @Override
            public void onAnimationEnd(Animator animation) {
                pr1.setVisibility(View.GONE);
                pr2.setVisibility(View.GONE);
                pr3.setVisibility(View.GONE);
                pr4.setVisibility(View.GONE);
                pr5.setVisibility(View.GONE);
                //pr5.setVisibility(View.GONE);
                pr6.setVisibility(View.GONE);
                pr7.setVisibility(View.GONE);
                pr8.setVisibility(View.GONE);
                pr91.setVisibility(View.GONE);
                pr10.setVisibility(View.GONE);
            }
            @Override
            public void onAnimationCancel(Animator animation) {}
            @Override
            public void onAnimationRepeat(Animator animation) {}
        });


        //animator1.setTarget(pr1);
//        set1.setTarget(pr1);
//        set2.setTarget(pr2);
//        set3.setTarget(pr3);
//        set4.setTarget(pr4);
        set5.setTarget(pr5);
//        set6.setTarget(pr6);
//        set7.setTarget(pr7);
//        set8.setTarget(pr8);
//        set9.setTarget(pr91);
        set10.setTarget(pr10);

        SetStart();


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Catch1(View v){
       ListWords.add(pr1.getText().toString());
       texx.setText(String.valueOf(ListWords));
        pr1.setEnabled(false);
        Verify();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Catch2(View v){
        ListWords.add(pr2.getText().toString());
        texx.setText(String.valueOf(ListWords));
        pr2.setEnabled(false);
        Verify();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Catch3(View v){
        ListWords.add(pr3.getText().toString());
        texx.setText(String.valueOf(ListWords));
        pr3.setEnabled(false);
        Verify();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Catch4(View v){
        ListWords.add(pr4.getText().toString());
        texx.setText(String.valueOf(ListWords));
        pr4.setEnabled(false);
        Verify();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Catch5(View v){
        ListWords.add(pr5.getText().toString());
        texx.setText(String.valueOf(ListWords));
        pr5.setEnabled(false);
        Verify();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Catch6(View v){
        ListWords.add(pr6.getText().toString());
        texx.setText(String.valueOf(ListWords));
        pr6.setEnabled(false);
        Verify();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Catch7(View v){
        ListWords.add(pr7.getText().toString());
        texx.setText(String.valueOf(ListWords));
        pr7.setEnabled(false);
        Verify();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Catch8(View v){
        ListWords.add(pr8.getText().toString());
        texx.setText(String.valueOf(ListWords));
        pr8.setEnabled(false);
        Verify();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Catch91(View v){
        ListWords.add(pr91.getText().toString());
        texx.setText(String.valueOf(ListWords));
        pr91.setEnabled(false);
        Verify();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Catch10(View v){
        ListWords.add(pr10.getText().toString());
        texx.setText(String.valueOf(ListWords));
        pr10.setEnabled(false);
        Verify();
    }
}
