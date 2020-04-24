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
import java.util.Random;

public class Dropwords extends AppCompatActivity {

        //AnimatorSet - для нескольких параметров в xml
       //ObjectAnimator - ждя 1 параметра в xml


    protected Button start, reset, pr1, pr2, pr3, pr4, pr5;
    protected Button pr6, pr7, pr8, pr91, pr10;
    protected TextView  score;
    protected int flag1, flag2, flag3, flag4, flag5, flag6, flag7, flag8, flag91, flag10 = 0;
    protected ArrayList<String> ListWords = new ArrayList<String>();
    protected ArrayList<Integer> ListCoordinateX = new ArrayList<Integer>();

    private ArrayList<String> list;
    private int indexWord;
    private String word;
    private Random r = new Random();
    protected int counter;

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

        score = findViewById(R.id.score);
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

        RandomShuffleWord();
        ListXUpFull();
        ButtonsGome();
        pr6.setVisibility(View.GONE);
        pr7.setVisibility(View.GONE);
        pr8.setVisibility(View.GONE);
        pr91.setVisibility(View.GONE);
        pr10.setVisibility(View.GONE);


    }

    public void RandomShuffleWord(){

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("dropwordlist.txt")));
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

        }

    public void RandomGen(){

        if (!list.isEmpty()) {
            this.indexWord = r.nextInt(list.size());

            this.word = list.get(indexWord);
            list.remove(word);

        } else if (list.isEmpty()) {
            this.word = "конец";
            RandomGen();
        }

        this.Original = this.word.split("");//разбив по буквам
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
        this.Control = this.word;
    }

    public void ButtonsGome(){

        if (flag1==0){
            pr1.setVisibility(View.GONE);
        } else if(flag1==1){
            pr1.setVisibility(View.VISIBLE);
        }
        if (flag2==0){
            pr2.setVisibility(View.GONE);
        } else if(flag2==1){
            pr2.setVisibility(View.VISIBLE);
        }
        if (flag3==0){
            pr3.setVisibility(View.GONE);
        } else if(flag3==1){
            pr3.setVisibility(View.VISIBLE);
        }
        if (flag4==0){
            pr4.setVisibility(View.GONE);
        } else if(flag4==1){
            pr4.setVisibility(View.VISIBLE);
        }
        if (flag5==0){
            pr5.setVisibility(View.GONE);
        } else if(flag5==1){
            pr5.setVisibility(View.VISIBLE);
        }
//        if (flag6==0){
//            pr6.setVisibility(View.GONE);
//        } else if(flag6==1){
//            pr6.setVisibility(View.VISIBLE);
//        }
//        if (flag7==0){
//            pr7.setVisibility(View.GONE);
//        } else if(flag7==1){
//            pr7.setVisibility(View.VISIBLE);
//        }
//        if (flag8==0){
//            pr8.setVisibility(View.GONE);
//        } else if(flag8==1){
//            pr8.setVisibility(View.VISIBLE);
//        }
//        if (flag91==0){
//            pr91.setVisibility(View.GONE);
//        } else if(flag91==1){
//            pr91.setVisibility(View.VISIBLE);
//        }
//        if (flag10==0){
//            pr10.setVisibility(View.GONE);
//        } else if(flag10==1){
//            pr10.setVisibility(View.VISIBLE);
//        }
    }
    public void ListXUpFull(){
        ListCoordinateX.add(50);
        ListCoordinateX.add(220);
        ListCoordinateX.add(390);
        ListCoordinateX.add(560);
        ListCoordinateX.add(730);
        ListCoordinateX.add(900);
    }
    public void Reset(View v){
        start.setVisibility(View.VISIBLE);
        reset.setVisibility(View.GONE);
        ListWords.clear();
        //texx.setText("");
        //animator1.end();
        set1.end();
        set2.end();
        set3.end();
        set4.end();
        set5.end();
//        set6.end();
//        set7.end();
//        set8.end();
//        set9.end();
//        set10.end();
        ButtonsGome();

        ListCoordinateX.removeAll(ListCoordinateX);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Verify() {

        String[] array = ListWords.toArray(new String[0]);
        String Key = (String.join("", array));
        if (Integer.valueOf(ListWords.size()) == 5) {
            if (Key.equals(Control)) {
                set1.end();
                set2.end();
                set3.end();
                set4.end();
                set5.end();
//                set6.end();
//                set7.end();
//                set8.end();
//                set9.end();
//                set10.end();
                ButtonsGome();
                SetFlag();
                this.counter++;
                score.setText(""+this.counter);
                score.setTextColor(Color.BLUE);
            }
            else {
                this.counter--;
                score.setText(""+this.counter);
                score.setTextColor(Color.RED);
            }
        }
    }

    public void constr(View v){
       Gos();
       reset.setVisibility(View.VISIBLE);
       start.setVisibility(View.GONE);
        SetStart();
        ListXUpFull();
        SetFlag();
    }

    public void SetFlag(){
          flag1=0;
          flag2=0;
          flag3=0;
          flag4=0;
          flag5=0;
//          flag6=0;
//          flag7=0;
//          flag8=0;
//          flag91=0;
//          flag10 = 0;
    }

    public void SetStart(){
       set1.start();
       set2.start();
       set3.start();
       set4.start();
       set5.start();
//       set6.start();
//       set7.start();
//       set8.start();
//       set9.start();
//       set10.start();
    }

    public void SetTextOnButtons(){
        pr1.setEnabled(true);
        pr2.setEnabled(true);
        pr3.setEnabled(true);
        pr4.setEnabled(true);
        pr5.setEnabled(true);
        pr5.setEnabled(true);
//        pr6.setEnabled(true);
//        pr7.setEnabled(true);
//        pr8.setEnabled(true);
//        pr91.setEnabled(true);
//        pr10.setEnabled(true);

        pr1.setVisibility(View.VISIBLE);
        pr2.setVisibility(View.VISIBLE);
        pr3.setVisibility(View.VISIBLE);
        pr4.setVisibility(View.VISIBLE);
        pr5.setVisibility(View.VISIBLE);
        pr5.setVisibility(View.VISIBLE);
//        pr6.setVisibility(View.VISIBLE);
//        pr7.setVisibility(View.VISIBLE);
//        pr8.setVisibility(View.VISIBLE);
//        pr91.setVisibility(View.VISIBLE);
//        pr10.setVisibility(View.VISIBLE);

        RandomGen();
        pr1.setText(String.valueOf(MixedleWord[0]));
        pr2.setText(String.valueOf(MixedleWord[1]));
        pr3.setText(String.valueOf(MixedleWord[2]));
        pr4.setText(String.valueOf(MixedleWord[3]));
        pr5.setText(String.valueOf(MixedleWord[4]));
//        pr6.setText(String.valueOf(MixedleWord[0]));
//        pr7.setText(String.valueOf(MixedleWord[1]));
//        pr8.setText(String.valueOf(MixedleWord[2]));
//        pr91.setText(String.valueOf(MixedleWord[3]));
//        pr10.setText(String.valueOf(MixedleWord[4]));


    }

    public void Gos(){  // анимацимя основной модуль
        SetTextOnButtons();
        set1 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper1); // диагональ, с 0
        set2 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper2); // лево У 100, с0
        set3 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper3); // верх, Х 30    с 1
        set4 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper4); // низ   Х 350      с 1
        set5 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper5); // право  У 150     с 2
//        set6 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper6); // диавгональ, с 2
//        set7 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper7); // лево У 300,  с3
//        set8 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper8); //верх  Х 225        с3
//        set9 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper9); // низ  Х 130     с4
//        set10 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.upper10); // право У 400     с 4
//
//        set9.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {}
//            @Override
//            public void onAnimationEnd(Animator animation) {
//              //  ButtonsGome();
//            } // окончсание и пропадание кнопок
//            @Override
//            public void onAnimationCancel(Animator animation) {}
//            @Override
//            public void onAnimationRepeat(Animator animation) {}
//        });

        set1.setTarget(pr1);
        set2.setTarget(pr2);
        set3.setTarget(pr3);
        set4.setTarget(pr4);
        set5.setTarget(pr5);
//        set6.setTarget(pr6);
//        set7.setTarget(pr7);
//        set8.setTarget(pr8);
//        set9.setTarget(pr91);
//        set10.setTarget(pr10);
        SetStart();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Catch1(View v){
       ListWords.add(pr1.getText().toString());
        pr1.setEnabled(false);
        set1.end();
        ObjectAnimator moveX = ObjectAnimator.ofFloat(pr1, "x", ListCoordinateX.get(0) );
        ObjectAnimator moveY = ObjectAnimator.ofFloat(pr1, "y", 60 );
        AnimatorSet as1 = new AnimatorSet();
        as1.playTogether(moveX, moveY);
        as1.setDuration(4000);
        as1.start();
        ListCoordinateX.remove(0);
        flag1 = 1;

        Verify();
    }
        @RequiresApi(api = Build.VERSION_CODES.O)
        public void Catch2(View v){
            ListWords.add(pr2.getText().toString());
           // texx.setText(String.valueOf(ListWords));
            pr2.setEnabled(false);
            //Startsh2();
            //AnimBut2();
            set2.end();
            ObjectAnimator moveX = ObjectAnimator.ofFloat(pr2, "x", ListCoordinateX.get(0) );
            ObjectAnimator moveY = ObjectAnimator.ofFloat(pr2, "y", 60 );
            AnimatorSet as2 = new AnimatorSet();
            as2.playTogether(moveX, moveY);
            as2.setDuration(4000);
            as2.start();
            ListCoordinateX.remove(0);
            flag2 = 1;
            Verify();
        }
            @RequiresApi(api = Build.VERSION_CODES.O)
            public void Catch3(View v){
                ListWords.add(pr3.getText().toString());
               // texx.setText(String.valueOf(ListWords));
                pr3.setEnabled(false);
                set3.end();
                ObjectAnimator moveX = ObjectAnimator.ofFloat(pr3, "x", ListCoordinateX.get(0) );
                ObjectAnimator moveY = ObjectAnimator.ofFloat(pr3, "y", 60 );
                AnimatorSet as3 = new AnimatorSet();
                as3.playTogether(moveX, moveY);
                as3.setDuration(4000);
                as3.start();
                ListCoordinateX.remove(0);
                flag3 = 1;

                Verify();
            }
                @RequiresApi(api = Build.VERSION_CODES.O)
                public void Catch4(View v){
                    ListWords.add(pr4.getText().toString());
                    //texx.setText(String.valueOf(ListWords));
                    pr4.setEnabled(false);
                    set4.end();
                    ObjectAnimator moveX = ObjectAnimator.ofFloat(pr4, "x", ListCoordinateX.get(0) );
                    ObjectAnimator moveY = ObjectAnimator.ofFloat(pr4, "y", 60 );
                    AnimatorSet as4 = new AnimatorSet();
                    as4.playTogether(moveX, moveY);
                    as4.setDuration(4000);
                    as4.start();
                    ListCoordinateX.remove(0);
                    flag4 = 1;

                    Verify();
                }
                @RequiresApi(api = Build.VERSION_CODES.O)
                public void Catch5(View v){
                    ListWords.add(pr5.getText().toString());
                   // texx.setText(String.valueOf(ListWords));
                    pr5.setEnabled(false);
                    set5.end();
                    ObjectAnimator moveX = ObjectAnimator.ofFloat(pr5, "x", ListCoordinateX.get(0) );
                    ObjectAnimator moveY = ObjectAnimator.ofFloat(pr5, "y", 60 );
                    AnimatorSet as5 = new AnimatorSet();
                    as5.playTogether(moveX, moveY);
                    as5.setDuration(4000);
                    as5.start();
                    ListCoordinateX.remove(0);
                    flag5 = 1;

                    Verify();
                }
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    public void Catch6(View v){
                ListWords.add(pr6.getText().toString());
                //texx.setText(String.valueOf(ListWords));
                pr6.setEnabled(false);
                set6.end();
                ObjectAnimator moveX = ObjectAnimator.ofFloat(pr6, "x", ListCoordinateX.get(0) );
                ObjectAnimator moveY = ObjectAnimator.ofFloat(pr6, "y", 60 );
                AnimatorSet as6 = new AnimatorSet();
                as6.playTogether(moveX, moveY);
                as6.setDuration(4000);
                as6.start();
                ListCoordinateX.remove(0);
                flag6 = 1;

                Verify();
            }
                @RequiresApi(api = Build.VERSION_CODES.O)
                public void Catch7(View v){
                    ListWords.add(pr7.getText().toString());
                    //texx.setText(String.valueOf(ListWords));
                    pr7.setEnabled(false);
                    set7.end();
                    ObjectAnimator moveX = ObjectAnimator.ofFloat(pr7, "x", ListCoordinateX.get(0) );
                    ObjectAnimator moveY = ObjectAnimator.ofFloat(pr7, "y", 60 );
                    AnimatorSet as7 = new AnimatorSet();
                    as7.playTogether(moveX, moveY);
                    as7.setDuration(4000);
                    as7.start();
                    ListCoordinateX.remove(0);
                    flag7 = 1;
                    Verify();
                }
            @RequiresApi(api = Build.VERSION_CODES.O)
            public void Catch8(View v){
                ListWords.add(pr8.getText().toString());
                pr8.setEnabled(false);
                set8.end();
                ObjectAnimator moveX = ObjectAnimator.ofFloat(pr8, "x", ListCoordinateX.get(0) );
                ObjectAnimator moveY = ObjectAnimator.ofFloat(pr8, "y", 60 );
                AnimatorSet as8 = new AnimatorSet();
                as8.playTogether(moveX, moveY);
                as8.setDuration(4000);
                as8.start();
                ListCoordinateX.remove(0);
                flag8 = 1;

                Verify();
            }
        @RequiresApi(api = Build.VERSION_CODES.O)
        public void Catch91(View v){
            ListWords.add(pr91.getText().toString());
            pr91.setEnabled(false);
            set9.end();
            ObjectAnimator moveX = ObjectAnimator.ofFloat(pr91, "x", ListCoordinateX.get(0) );
            ObjectAnimator moveY = ObjectAnimator.ofFloat(pr91, "y", 60 );
            AnimatorSet as91 = new AnimatorSet();
            as91.playTogether(moveX, moveY);
            as91.setDuration(4000);
            as91.start();
            ListCoordinateX.remove(0);
            flag91 = 1;

            Verify();
        }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Catch10(View v){
        ListWords.add(pr10.getText().toString());
        pr10.setEnabled(false);
        set10.end();
        ObjectAnimator moveX = ObjectAnimator.ofFloat(pr10, "x", ListCoordinateX.get(0) );
        ObjectAnimator moveY = ObjectAnimator.ofFloat(pr10, "y", 60 );
        AnimatorSet as10 = new AnimatorSet();
        as10.playTogether(moveX, moveY);
        as10.setDuration(4000);
        as10.start();
        ListCoordinateX.remove(0);
        flag10 = 1;

        Verify();
    }
}
