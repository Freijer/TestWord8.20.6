package freijer.app.testword;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ForLess extends AppCompatActivity {

     protected Button reset, bt1, bt2, bt3, bt4;
     protected TextView text, score;

//    при вепрном ответе кнопки уезжают
//    и приезжают новые
//    с новым текстом

    String Control;
    String[] KeyWord;
    String[] Buffer;
    String[] Extract; //Использовать для распредление слов на кнопки, итоговый массив
    List<String> list;
    String fromButton;
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
        setContentView(R.layout.activity_for_less);

        bt1 = (Button)findViewById(R.id.bt1);
        bt2 = (Button)findViewById(R.id.bt2);
        bt3 = (Button)findViewById(R.id.bt3);
        bt4 = (Button)findViewById(R.id.bt4);
        reset = (Button)findViewById(R.id.reset);
        text = (TextView)findViewById(R.id.text1);
        score = (TextView)findViewById(R.id.score);
        LetsGo();

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

//    public void TextOnButtons(View v){
//        LetsGo();
//
//    }
    public void LetsGo(){
        Generate();
        bt1.setText(String.valueOf(Extract[0]));
        bt2.setText(String.valueOf(Extract[1]));
        bt3.setText(String.valueOf(Extract[2]));
        bt4.setText(String.valueOf(Extract[3]));

        text.setText("Выбери лишнее");


        bt1.setEnabled(true);
        bt2.setEnabled(true);
        bt3.setEnabled(true);
        bt4.setEnabled(true);
    }

    public void Colorize(){
        if (getCount()<=0){
            score.setTextColor(Color.parseColor("#e30b1a"));
        }
        else if(getCount()>=-1){
            score.setTextColor(Color.parseColor("#e8e409"));
        }
    }


    public void Validate() {
        Colorize();
        if (lister.contains(fromButton)) {
            setCount(count -1);
            String sc = Integer.toString(getCount());
            LetsGo();
            score.setText(sc);
            text.setText("Пробуй еще раз");
            text.setTextColor(Color.parseColor("#e30b1a"));
            fromButton = "";
        } else {
            setCount(count +1);
            String sc = Integer.toString(getCount());
            score.setText(sc);
            LetsGo();
            text.setTextColor(Color.parseColor("#e8e409"));
            text.setText("Молодец!");
            fromButton = "";
        }
    }
    public void Reset(View v) {
        text.setTextColor(Color.parseColor("#e8e409"));
        text.setText("Выбери лишнее");
        bt1.setEnabled(true);
        bt2.setEnabled(true);
        bt3.setEnabled(true);
        bt4.setEnabled(true);
    }


    public void BT1(View view) {
        Animation a = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
        Animation a2 = AnimationUtils.loadAnimation(this, R.anim.anim_left);
        Animation a3 = AnimationUtils.loadAnimation(this, R.anim.anim_top);
        Animation a4 = AnimationUtils.loadAnimation(this, R.anim.anim_down);
        bt1.startAnimation(a4);
        bt2.startAnimation(a2);
        bt3.startAnimation(a);
        bt4.startAnimation(a3);
        fromButton = (String) bt1.getText();
        Validate();

        a.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {

            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void BT2(View view) {
        Animation a = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
        Animation a2 = AnimationUtils.loadAnimation(this, R.anim.anim_left);
        Animation a3 = AnimationUtils.loadAnimation(this, R.anim.anim_top);
        Animation a4 = AnimationUtils.loadAnimation(this, R.anim.anim_down);
        bt1.startAnimation(a4);
        bt2.startAnimation(a2);
        bt3.startAnimation(a);
        bt4.startAnimation(a3);
        fromButton = (String) bt2.getText();
        Validate();

        a.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void BT3(View view) {
        Animation a = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
        Animation a2 = AnimationUtils.loadAnimation(this, R.anim.anim_left);
        Animation a3 = AnimationUtils.loadAnimation(this, R.anim.anim_top);
        Animation a4 = AnimationUtils.loadAnimation(this, R.anim.anim_down);
        bt1.startAnimation(a4);
        bt2.startAnimation(a2);
        bt3.startAnimation(a);
        bt4.startAnimation(a3);;
        fromButton = (String) bt3.getText();
        Validate();

        a.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {

            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }
    public void BT4(View view) {
        Animation a = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
        Animation a2 = AnimationUtils.loadAnimation(this, R.anim.anim_left);
        Animation a3 = AnimationUtils.loadAnimation(this, R.anim.anim_top);
        Animation a4 = AnimationUtils.loadAnimation(this, R.anim.anim_down);
        bt1.startAnimation(a4);
        bt2.startAnimation(a2);
        bt3.startAnimation(a);
        bt4.startAnimation(a3);
        fromButton = (String) bt4.getText();
        Validate();

        a.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }






}
