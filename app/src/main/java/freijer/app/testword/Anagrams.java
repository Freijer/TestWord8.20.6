package freijer.app.testword;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Anagrams extends AppCompatActivity {


    Button B1, B2, B3, B4, B5, B6, start, check, reset;
    TextView text, score;
    String[] Original;
    String[] OriginalWord; //бавзовое слово
    String[] MixedleWord; //смешение
    String Control;
    int count = 0;

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    ArrayList<String> WordList_1 = new ArrayList<String>(6); // то, что вводит пользователь нажимая на кнопки

    String[] ReadWords; //массив считанный
    public void RandomGen(){

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("anagramlist.txt")));
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


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anagrams);

        B1 = (Button)findViewById(R.id.B1);
        B2 = (Button)findViewById(R.id.B2);
        B3 = (Button)findViewById(R.id.B3);
        B4 = (Button)findViewById(R.id.B4);
        B5 = (Button)findViewById(R.id.B5);
        B6 = (Button)findViewById(R.id.B6);
        start = (Button)findViewById(R.id.start);
        check = (Button)findViewById(R.id.check);
        reset = (Button)findViewById(R.id.reset);
        text = (TextView)findViewById(R.id.text1);
        score = (TextView)findViewById(R.id.score);
            Next();
    }

    public void LetsStart(){
        Next();
    }

    public void Next(){
        text.setTextColor(Color.parseColor("#000000"));
        text.setText("Собери слово");
        WordList_1.clear();
        B1.setEnabled(true);
        B2.setEnabled(true);
        B3.setEnabled(true);
        B4.setEnabled(true);
        B5.setEnabled(true);
        B6.setEnabled(true);
        RandomGen();
        B1.setText(String.valueOf(MixedleWord[0]));
        B2.setText(String.valueOf(MixedleWord[1]));
        B3.setText(String.valueOf(MixedleWord[2]));
        B4.setText(String.valueOf(MixedleWord[3]));
        B5.setText(String.valueOf(MixedleWord[4]));
        B6.setText(String.valueOf(MixedleWord[5]));
        check.setEnabled(true);
        //text.setText(ReadWords[0]);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Verify(View v){
        String[] array = WordList_1.toArray(new String[0]);

        String Key = (String.join("", array));
        text.setText(Key + " " + Control);
        if (Key.equals(Control)){
            text.setTextColor(Color.parseColor("#000000"));
            score.setTextColor(Color.parseColor("#000000"));
            text.setText("Верно!");
            setCount(count +1);
            String sc = Integer.toString(getCount());
            //score.setText(Integer.toString(count));
            score.setText(sc);
            check.setEnabled(false);
            Animation a1 = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
            Animation a2 = AnimationUtils.loadAnimation(this, R.anim.anim_left);
            Animation a3 = AnimationUtils.loadAnimation(this, R.anim.anim_top);
            Animation a4 = AnimationUtils.loadAnimation(this, R.anim.anim_down);
            Animation a5 = AnimationUtils.loadAnimation(this, R.anim.cornerright);
            Animation a6 = AnimationUtils.loadAnimation(this, R.anim.conerleft);
            B1.startAnimation(a6);
            B2.startAnimation(a2);
            B3.startAnimation(a1);
            B4.startAnimation(a3);
            B5.startAnimation(a5);
            B6.startAnimation(a4);
            Next();
        }
        else {
            text.setTextColor(Color.parseColor("#e30b1a"));
            score.setTextColor(Color.parseColor("#e30b1a"));
            text.setText("Нэверно!");
            Toast toast = Toast.makeText(getApplicationContext(), "Нэверно!, -1 очко", Toast.LENGTH_SHORT); toast.show();
            setCount(count -1);
            String sc = Integer.toString(getCount());
            //score.setText(Integer.toString(count));
            score.setText(sc);
            check.setEnabled(false);
            Animation a1 = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
            Animation a2 = AnimationUtils.loadAnimation(this, R.anim.anim_left);
            Animation a3 = AnimationUtils.loadAnimation(this, R.anim.anim_top);
            Animation a4 = AnimationUtils.loadAnimation(this, R.anim.anim_down);
            Animation a5 = AnimationUtils.loadAnimation(this, R.anim.cornerright);
            Animation a6 = AnimationUtils.loadAnimation(this, R.anim.conerleft);
            B1.startAnimation(a6);
            B2.startAnimation(a2);
            B3.startAnimation(a1);
            B4.startAnimation(a3);
            B5.startAnimation(a5);
            B6.startAnimation(a4);
            Next();
        }
    }

    public void Reset(View v){
        text.setText("");
        WordList_1.clear();
        B1.setEnabled(true);
        B2.setEnabled(true);
        B3.setEnabled(true);
        B4.setEnabled(true);
        B5.setEnabled(true);
        B6.setEnabled(true);
        check.setEnabled(true);
        text.setTextColor(Color.parseColor("#000000"));
    }



    public void BT1(View view) {
        WordList_1.add(String.valueOf(MixedleWord[0]));
        text.setText(String.valueOf(WordList_1));
        B1.setEnabled(false);

    }


    public void BT2(View v) {
        WordList_1.add(String.valueOf(MixedleWord[1]));
        text.setText(String.valueOf(WordList_1));
        B2.setEnabled(false);

    }


    public void BT3(View v) {
        WordList_1.add(String.valueOf(MixedleWord[2]));
        text.setText(String.valueOf(WordList_1));
        B3.setEnabled(false);

    }

    public void BT4(View v) {
        WordList_1.add(String.valueOf(MixedleWord[3]));
        text.setText(String.valueOf(WordList_1));
        B4.setEnabled(false);

    }

    public void BT5(View v) {
        WordList_1.add(String.valueOf(MixedleWord[4]));
        text.setText(String.valueOf(WordList_1));
        B5.setEnabled(false);

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void BT6(View v) {
        WordList_1.add(String.valueOf(MixedleWord[5]));
        text.setText(String.valueOf(WordList_1));
        B6.setEnabled(false);


    }

}

