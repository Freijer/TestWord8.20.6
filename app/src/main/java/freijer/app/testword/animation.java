package freijer.app.testword;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class animation extends AppCompatActivity {

    private ImageView img1, img2;
    private boolean img1Visible = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);

    }


    public void press(View v){  //первый рисунок исчезает, Второй появляется и наоборот c кручением

        if (img1Visible) {
            img1.animate().alpha(0).scaleX(0f).scaleY(0f).rotation(img1.getRotation()+ 3600).setDuration(2000);
            img2.animate().alpha(1).scaleX(1f).scaleY(1f).rotation(img2.getRotation()+3600).setDuration(2000);
            //img2.animate().alpha(1).scaleX(img2.getWidth()).scaleY(img2.getHeight()).rotation(img2.getRotation()+3600).setDuration(2000);  запрос коориднат положения
            img1Visible = false;
        } else {
            img1.animate().alpha(1).scaleX(1f).scaleY(1f).rotation(img1.getRotation()+3600).setDuration(2000);
            img2.animate().alpha(0).scaleX(0f).scaleY(0f).rotation(img2.getRotation()+3600).setDuration(2000);
            img1Visible = true;
        }
    }


}

