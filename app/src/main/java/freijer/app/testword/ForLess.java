package freijer.app.testword;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ForLess extends AppCompatActivity {

     protected Button next, reset, bt1, bt2, bt3, bt4;
     protected TextView text, score;

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
        next = (Button)findViewById(R.id.next);
        reset = (Button)findViewById(R.id.reset);
        text = (TextView)findViewById(R.id.text);
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

    public void TextOnButtons(View v){
        LetsGo();

    }
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

    public void Validate() {
        if (lister.contains(fromButton)) {
            setCount(count -1);
            String sc = Integer.toString(getCount());
            text.setText("Пробуй еще раз");
            score.setText(sc);
        } else {
            setCount(count +1);
            String sc = Integer.toString(getCount());
            text.setText("Молодец!");
            score.setText(sc);
        }
    }
    public void Reset(View v) {
        text.setText("Выбери лишнее");
        bt1.setEnabled(true);
        bt2.setEnabled(true);
        bt3.setEnabled(true);
        bt4.setEnabled(true);
    }


    public void BT1(View view) {
        bt1.setEnabled(false);
        bt2.setEnabled(false);
        bt3.setEnabled(false);
        bt4.setEnabled(false);
        fromButton = (String) bt1.getText();
        Validate();
    }

    public void BT2(View v) {
        bt1.setEnabled(false);
        bt2.setEnabled(false);
        bt3.setEnabled(false);
        bt4.setEnabled(false);
        fromButton = (String) bt2.getText();
        Validate();
    }

    public void BT3(View v) {
        bt1.setEnabled(false);
        bt2.setEnabled(false);
        bt3.setEnabled(false);
        bt4.setEnabled(false);
        fromButton = (String) bt3.getText();
        Validate();
    }
    public void BT4(View v) {
        bt1.setEnabled(false);
        bt2.setEnabled(false);
        bt3.setEnabled(false);
        bt4.setEnabled(false);
        fromButton = (String) bt4.getText();
        Validate();
    }






}
