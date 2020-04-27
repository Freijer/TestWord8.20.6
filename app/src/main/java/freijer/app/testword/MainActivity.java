package freijer.app.testword;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class MainActivity extends AppCompatActivity {

    Button anagrams, twogame, treegame, wordDown;
    TextView TER;
    String[] stringArr;
    String[] addresses = new String[]{"skydreamfest@mail.ru"};
    String subject;
    String emailText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anagrams = (Button) findViewById(R.id.anagrams);
        twogame = (Button) findViewById(R.id.twogame);
        treegame = (Button) findViewById(R.id.treegame);
        wordDown = (Button) findViewById(R.id.wordDown);

        this.subject = "Тестовое письмо";
        this.emailText = "Привет, Виктор! Число 300";


    }
//    public void Ani(View view){
//        final Animation animTranslate = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
//        view.startAnimation(animTranslate);
//    }


    public void Sec(View v) {
        Intent intent = new Intent(".Wordscollect");
        startActivity(intent);

    }

    public void Two(View v) {
        Intent intent = new Intent(".ForLess");
        startActivity(intent);
    }

    public void Tree(View v) {
//        Intent intent = new Intent(".Wordscollect");
//        startActivity(intent);
        Toast toast = Toast.makeText(getApplicationContext(), "В разработке. Подождите =)", Toast.LENGTH_SHORT); toast.show();
    }


    public void For(View v) {
        Intent intent = new Intent(".SewralWords");
        startActivity(intent);
    }

    public void EmailSend(View v){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, emailText);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void Test(View v) {
        Intent intent = new Intent(".TestAct");
        startActivity(intent);
    }


}
