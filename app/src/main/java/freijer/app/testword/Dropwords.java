package freijer.app.testword;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Dropwords extends AppCompatActivity {

    protected Button start, pr1, pr2, pr3, pr4, pr5, pr6, pr7, pr8, pr9, pr10;
    protected TextView texx, score;
    ArrayList<String> ListWords = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dropwords);

        texx = (TextView)findViewById(R.id.texx);
        start = (Button)findViewById(R.id.start);
        pr1 = (Button)findViewById(R.id.pr1);
        pr2 = (Button)findViewById(R.id.pr2);
        pr3 = (Button)findViewById(R.id.pr3);
        pr4 = (Button)findViewById(R.id.pr4);
        pr5 = (Button)findViewById(R.id.pr5);
        pr6 = (Button)findViewById(R.id.pr6);
        pr7 = (Button)findViewById(R.id.pr7);
        pr8 = (Button)findViewById(R.id.pr8);
        pr9 = (Button)findViewById(R.id.pr9);
        pr10 = (Button)findViewById(R.id.pr10);





    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Verify(){

        String[] array = ListWords.toArray(new String[0]);
        String Key = (String.join("", array));
        if (Key.equals("бизон")){
            texx.setText("Молодец");
        }
        else {
            //texx.setText("Нет");
        }
    }
    public void constr(View v){
       Gos();
    }


    public void Gos(){

//         pr1.animate().translationYBy(-5000).setDuration(13000);
//        ObjectAnimator moveAnimatorY = ObjectAnimator.ofFloat(pr1, "y", -5000);
//        moveAnimatorY.setDuration(13000);
//        moveAnimatorY.start();


        ObjectAnimator animator1 = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.upper);
        animator1.setTarget(pr1);
            ObjectAnimator animator2 = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.upper2);
            animator2.setTarget(pr2);
        ObjectAnimator animator3 = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.upper3);
        animator3.setTarget(pr3);
            ObjectAnimator animator4 = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.upper4);
            animator4.setTarget(pr4);
        ObjectAnimator animator5 = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.upper5);
        animator5.setTarget(pr5);
            ObjectAnimator animator6 = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.upper);
            animator6.setTarget(pr6);
        ObjectAnimator animator7 = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.upper2);
        animator7.setTarget(pr7);
            ObjectAnimator animator8 = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.upper3);
            animator8.setTarget(pr8);
        ObjectAnimator animator9 = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.upper4);
        animator9.setTarget(pr9);
            ObjectAnimator animator10 = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.upper5);
            animator10.setTarget(pr10);

        animator1.start();
        animator2.start();
        animator3.start();
        animator4.start();
        animator5.start();
        animator6.start();
        animator7.start();
        animator8.start();
        animator9.start();
        animator10.start();
    }






    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Catch1(View v){
       ListWords.add(pr1.getText().toString());
       texx.setText(String.valueOf(ListWords));
        Verify();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Catch2(View v){
        ListWords.add(pr2.getText().toString());
        texx.setText(String.valueOf(ListWords));
        Verify();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Catch3(View v){
        ListWords.add(pr3.getText().toString());
        texx.setText(String.valueOf(ListWords));
        Verify();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Catch4(View v){
        ListWords.add(pr4.getText().toString());
        texx.setText(String.valueOf(ListWords));
        Verify();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Catch5(View v){
        ListWords.add(pr5.getText().toString());
        texx.setText(String.valueOf(ListWords));
        Verify();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Catch6(View v){
        ListWords.add(pr6.getText().toString());
        texx.setText(String.valueOf(ListWords));
        Verify();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Catch7(View v){
        ListWords.add(pr7.getText().toString());
        texx.setText(String.valueOf(ListWords));
        Verify();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Catch8(View v){
        ListWords.add(pr8.getText().toString());
        texx.setText(String.valueOf(ListWords));
        Verify();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Catch9(View v){
        ListWords.add(pr9.getText().toString());
        texx.setText(String.valueOf(ListWords));
        Verify();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Catch10(View v){
        ListWords.add(pr10.getText().toString());
        texx.setText(String.valueOf(ListWords));
        Verify();
    }

}
