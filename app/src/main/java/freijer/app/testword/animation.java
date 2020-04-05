package freijer.app.testword;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static android.view.View.GONE;

public class animation extends AppCompatActivity {

//    Вылетают снизу слева справа кнопки с буквами, исчезают когда доходят до границы
//    надо на них нажимать и составлять слово
//    баллы даются за скорость и правильность

    ImageView bows, zombie, arrow;

    protected Button bu1, bu2, bu3;
    int cordX = 0, zombX = 0;

    ImageView IMV;

    int [] toX = {50, -60, 40, -10, 30, 20, - 25, -10};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        bu1 = (Button)findViewById(R.id.bu1);
        bu2 = (Button)findViewById(R.id.bu2);
        bu3 = (Button)findViewById(R.id.bu3);

        IMV = (ImageView) findViewById(R.id.IMV);
        bows = (ImageView) findViewById(R.id.bows);
        zombie = (ImageView) findViewById(R.id.zombie);
        arrow = (ImageView) findViewById(R.id.arrow);

        arrow.setVisibility(GONE);

        int first = toX.length;
        int rand1 = (int) (Math.random() * first);
        int RandomWord = toX[rand1];
        this.zombX = RandomWord;
        zombie.animate().translationXBy(zombX).setDuration(300);

        String filename = "country.png";
        InputStream inputStream = null;
        try {
            inputStream = getApplicationContext().getAssets().open(filename);
            Drawable d = Drawable.createFromStream(inputStream, null);
            IMV.setImageDrawable(d);
            IMV.setScaleType(ImageView.ScaleType.FIT_XY);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void BU1 (View v) {
        cordX = +100;
        GoForward(cordX);

    }


    public void GoForward(int distX){
        bows.animate().translationXBy(distX).setDuration(300);
    }


    public void GoBack(View v){
        bows.animate().translationXBy(-100).setDuration(300);
    }

    public void Fire(View v){
        arrow.setVisibility(View.VISIBLE);

        final Animation a4 = AnimationUtils.loadAnimation(this, R.anim.droper);
        
        arrow.startAnimation(a4);
        a4.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                zombie.animate().translationYBy(60).setDuration(300);
                zombie.animate().rotationBy(90).setDuration(700);
                arrow.animate().translationXBy(-650).setDuration(900);
                arrow.setVisibility(GONE);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

    }


}
