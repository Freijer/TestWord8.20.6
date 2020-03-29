package freijer.app.testword;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
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

    Button anagrams, twogame, treegame;
    TextView TER;
    String[] stringArr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anagrams = (Button) findViewById(R.id.anagrams);
        twogame = (Button) findViewById(R.id.twogame);
        treegame = (Button) findViewById(R.id.treegame);


    }


    public void GenerateWord() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Android\\app\\TestWord\\app\\src\\main\\assets\\anagramlist.txt"));
        String str;
        ArrayList<String> list = new ArrayList<String>();
        while ((str = reader.readLine()) != null) {
            if (!str.isEmpty()) {
                list.add(str);
            }
        }
        this.stringArr = list.toArray(new String[0]);
    }



    public void Sec(View v){
        Intent intent = new Intent(".Anagrams");
        startActivity(intent);
    }

    public void Two(View v){
        Intent intent = new Intent(".ForLess");
        startActivity(intent);
    }
    public void Tree(View v){
        Toast toast = Toast.makeText(getApplicationContext(), "В разработке. Подождите =)", Toast.LENGTH_SHORT);toast.show();
    }









}
