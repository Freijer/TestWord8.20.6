package freijer.app.testword;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import android.os.Bundle;

public class TestAct extends AppCompatActivity {

    private Button button, button2;
    private ConstraintLayout Colo;


    private final int USERID = 6000;
    private int countID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        button =  findViewById(R.id.button);
        button2 =  findViewById(R.id.button2);

        button.setBackgroundResource(R.drawable.newchangebutton);
        button2.setBackgroundResource(R.drawable.newchangebutton);
        Colo = findViewById(R.id.Colo);


    }

    public void Cheekl(View v){
        Button b = new Button(getApplicationContext());
        b.setBackgroundResource(R.drawable.newpate);
        b.setText(b.getText().toString() + Integer.toString(countID + 1));

        b.setId(USERID + countID);

        Colo.addView(b);
        countID++;

        ObjectAnimator button1 = ObjectAnimator.ofPropertyValuesHolder(b,
                PropertyValuesHolder.ofFloat("x", -100, 150),
                PropertyValuesHolder.ofFloat("y", 600, 600));
        button1.setDuration(1500);
        button1.start();
    }
    public void Cheek2(View v){
        Button b = new Button(getApplicationContext());
        b.setBackgroundResource(R.drawable.newpate);
        b.setText(b.getText().toString() + Integer.toString(countID + 1));

        b.setId(USERID + countID);

        Colo.addView(b);
        countID++;

        ObjectAnimator button1 = ObjectAnimator.ofPropertyValuesHolder(b,
                PropertyValuesHolder.ofFloat("x", -100, 260),
                PropertyValuesHolder.ofFloat("y", 600, 600));
        button1.setDuration(1500);
        button1.start();
    }

}