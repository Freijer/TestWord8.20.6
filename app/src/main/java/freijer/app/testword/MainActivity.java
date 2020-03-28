package freijer.app.testword;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button anagrams, twogame, treegame;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anagrams = (Button) findViewById(R.id.anagrams);
        twogame = (Button) findViewById(R.id.twogame);
        treegame = (Button) findViewById(R.id.treegame);

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
