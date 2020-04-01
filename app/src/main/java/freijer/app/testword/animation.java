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

    protected Button bu1, bu2;
    String fromButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        bu1 = (Button)findViewById(R.id.bu1);
        bu2 = (Button)findViewById(R.id.bu2);
    }






}
