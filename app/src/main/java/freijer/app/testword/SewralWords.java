package freijer.app.testword;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
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
    // слова до 3 букв: -1 оск
    // от 3 до 4 букв +1 очко
    // от 4 бкв +2 очка

    // точно такую же, но буквы можно использовать множество раз

    // при нажатии копия кнопки с буквой уходит на новое место - каждое слово, новая строка

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
        textSee = findViewById(R.id.textSee);

        ControlWordsfinFail();
        ReadWords();
        Randomizator();
        GoneButnnons();
        ShowButtons();

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
                pr5.setVisibility(View.VISIBLE);
                pr6.setVisibility(View.VISIBLE);
                pr7.setVisibility(View.VISIBLE);
                pr8.setVisibility(View.VISIBLE);
                pr9.setVisibility(View.VISIBLE);
                pr10.setVisibility(View.VISIBLE);
                pr11.setVisibility(View.VISIBLE);
                break;
            case 14:
                pr1.setVisibility(View.VISIBLE);
                pr2.setVisibility(View.VISIBLE);
                pr3.setVisibility(View.VISIBLE);
                pr4.setVisibility(View.VISIBLE);
                pr5.setVisibility(View.VISIBLE);
                pr6.setVisibility(View.VISIBLE);
                pr7.setVisibility(View.VISIBLE);
                pr8.setVisibility(View.VISIBLE);
                pr9.setVisibility(View.VISIBLE);
                pr10.setVisibility(View.VISIBLE);
                pr11.setVisibility(View.VISIBLE);
                pr12.setVisibility(View.VISIBLE);
                pr13.setVisibility(View.VISIBLE);
                pr14.setVisibility(View.VISIBLE);
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

    }// Читаем ключевые слова из файлика


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



}
