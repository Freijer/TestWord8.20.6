package freijer.app.testword;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import android.os.Bundle;

import java.util.ArrayList;

public class TestAct extends AppCompatActivity {

    protected ArrayList<Integer> ListCoordinateX_1 = new ArrayList<Integer>();
    private Button b1;
    ObjectAnimator anim;
    protected AnimatorSet set1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        b1 = findViewById(R.id.b1);
//        b1.setX(100);
//        b1.setY(300);

        ListCoordinateX_1.add(R.anim.spot_one);

        float scale = b1.getResources().getDisplayMetrics().density;
        float C = 0 * scale;
        float C1 = 280 * scale;
        float V = 0 * scale;
        float V1 = 630 * scale;

//        Animation a4 = AnimationUtils.loadAnimation(this, ListCoordinateX_1.get(0));
//        b1.startAnimation(a4);


        //задать движение через xml общимие ккоориднаты


        ObjectAnimator button10 = ObjectAnimator.ofPropertyValuesHolder(b1,
                PropertyValuesHolder.ofFloat("x", C, C1),
                PropertyValuesHolder.ofFloat("y", V, V1));
        button10.setDuration(7000);
        button10.setRepeatCount(ObjectAnimator.INFINITE);
        button10.setRepeatMode(ObjectAnimator.REVERSE);
        button10.start();



    }


}