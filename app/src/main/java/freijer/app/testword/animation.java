package freijer.app.testword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static android.view.View.GONE;

public class animation extends AppCompatActivity {

    Button  btn1, btn2, btn3, btn4;

     TextView qwr;

    String Control;
    String[] KeyWord;
    String[] Buffer;
    String[] Extract; //Использовать для распредление слов на кнопки, итоговый массив
    List<String> list;
    String from;
    List<String> lister;
    int count = 0;
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }


    String[] Word1 = {"Гусь", "Кошка", "Пальма"};
    String[] Word2 = {"Каша", "Дверь", "Банан"};
    String[] Word3 = {"Слон", "Гусь", "Ведро"};
    String[] Word4 = {"Роза", "Тюльпан", "Заяц"};
    String[] Word5 = {"Машина", "Жук", "Самолет"};
    String[] Word6 = {"Гвоздь", "Шуруп", "Гайка"};
    String[] Word7 = {"Ужин", "Яйцо", "Свинья"};
    String[] Word8 = {"Магнит", "Виктория", "Лента"};

    String[][] RandomMas = {Word1, Word2, Word3, Word4, Word5, Word6, Word7 , Word8};
    String[] stringArr = {"Бег","Полет","Разбор","Заплыв","Собрание","Заплыв" ,"Поджег","Победа"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        Lets();

    }

    public void Generate() {
        int first = stringArr.length;
        int rand1 = (int) (Math.random() * first);
        String RandomWord = stringArr[rand1];
        this.Control = RandomWord;
        int two = RandomMas.length;
        int rands = (int) (Math.random() * two);
        this.KeyWord = RandomMas[rands];
        this.Buffer = new String[]{KeyWord[0], KeyWord[1], KeyWord[2], Control};
        this.list = Arrays.asList(Buffer);
        String[] Literals = Buffer;
        List<String> shuffle = Arrays.asList(Literals);
        Collections.shuffle(shuffle);
        shuffle.toArray(Literals);
        this.Extract = Literals;
        this.lister = Arrays.asList(KeyWord);
    }

    public void Lets(){
        Generate();
        btn1.setText(String.valueOf(Extract[0]));
        btn2.setText(String.valueOf(Extract[1]));
        btn3.setText(String.valueOf(Extract[2]));
        btn4.setText(String.valueOf(Extract[3]));


//        bt1.setEnabled(true);
//        bt2.setEnabled(true);
//        bt3.setEnabled(true);
//        bt4.setEnabled(true);
    }

    public void Validate() {
        if (lister.contains(from)) {
           qwr.setText("Верно");
        } else {

        }
    }





    public void ActBT1 (View view) {
        Animation a = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
        Animation a2 = AnimationUtils.loadAnimation(this, R.anim.anim_left);
        final Animation a3 = AnimationUtils.loadAnimation(this, R.anim.visibleright);
        btn1.startAnimation(a);
        btn2.startAnimation(a2);
        btn3.startAnimation(a);
        btn4.startAnimation(a2);

        Validate();
        from = (String) btn1.getText();
        a.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Lets();

            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void ActBT2 (View view) {
        Animation a = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
        Animation a2 = AnimationUtils.loadAnimation(this, R.anim.anim_left);
        final Animation a3 = AnimationUtils.loadAnimation(this, R.anim.visibleright);
        btn1.startAnimation(a);
        btn2.startAnimation(a2);
        btn3.startAnimation(a);
        btn4.startAnimation(a2);
        Validate();
        from = (String) btn2.getText();

        a.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Lets();

            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void ActBT3 (View view) {
        Animation a = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
        Animation a2 = AnimationUtils.loadAnimation(this, R.anim.anim_left);
        final Animation a3 = AnimationUtils.loadAnimation(this, R.anim.visibleright);
        btn1.startAnimation(a);
        btn2.startAnimation(a2);
        btn3.startAnimation(a);
        btn4.startAnimation(a2);

        Validate();
        from = (String) btn3.getText();
        a.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Lets();

            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }
    public void ActBT4 (View view) {
        Animation a = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
        Animation a2 = AnimationUtils.loadAnimation(this, R.anim.anim_left);
        final Animation a3 = AnimationUtils.loadAnimation(this, R.anim.visibleright);
        btn1.startAnimation(a);
        btn2.startAnimation(a2);
        btn3.startAnimation(a);
        btn4.startAnimation(a2);

        Validate();
        from = (String) btn4.getText();
        a.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Lets();

            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }









//    public void BT1(){
//        final Animation animONE = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
//        btnTrans.setOnClickListener(new Button.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                view.startAnimation(animONE);
//            }
//        });
//    }
//
//    public void BT2(){
//        final Animation animTWO = AnimationUtils.loadAnimation(this, R.anim.anim_left);
//        btnAns.setOnClickListener(new Button.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                view.startAnimation(animTWO);
//            }
//        });
//    }



}
