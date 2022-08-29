package com.istiaq66.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button bt;
    ImageView img;
    TextView txt;
    private  long backPressedTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

    bt = findViewById(R.id.button_toss);
    img = findViewById(R.id.diceImage);
    txt = findViewById(R.id.scoreText);




    bt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            //----------Generating random Numbers-----------//

            Random random = new Random();
            int score = random.nextInt(6) + 1;

            //----------Generating random Numbers-----------//





            //-------------starting animation-----------//

            StartAnimation();

            //-------------starting animation-----------//


            //------Generating a new thread after 1 second-----//

            final Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    txt.setText(String.valueOf(score));

                    switch (score){

                        case 1:
                            img.setImageResource(R.drawable.dice1);
                            break;
                        case 2:
                            img.setImageResource(R.drawable.dice2);
                            break;
                        case 3:
                            img.setImageResource(R.drawable.dice3);
                            break;
                        case 4:
                            img.setImageResource(R.drawable.dice4);
                            break;
                        case 5:
                            img.setImageResource(R.drawable.dice5);
                            break;
                        case 6:
                            img.setImageResource(R.drawable.dice6);
                            break;

                    }

                }
            },1000);

            //------Generating a new thread after 1 second-----//





        }
    });


    }

    //---------Animation Function---------//

    public void StartAnimation(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(img,"rotationY", 0f, 360f);
        animator.setDuration(1000);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator);
        animatorSet.start();
    }

    //---------Animation Function---------//






    //----Exit app----//

    @Override
    public void onBackPressed() {

        if(backPressedTime + 2000>System.currentTimeMillis())
        {
            super.onBackPressed();
            this.finishAffinity();
            return;
        }
        else
        {
            Toast.makeText(getBaseContext(),"Press back again to exit",Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();

    }

    //----Exit app----//




}