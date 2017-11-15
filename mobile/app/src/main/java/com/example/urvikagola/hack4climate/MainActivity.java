package com.example.urvikagola.hack4climate;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.andexert.library.RippleView;

public class  MainActivity extends AppCompatActivity {

    ImageView img;
    TextView myTextView,myTextView1;
    Button button;
    RippleView rippleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView)findViewById(R.id.imageviewhandler);
        img.setBackgroundResource(R.drawable.spin_animation);
        // Get the background, which has been compiled to an AnimationDrawable object.
        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
        // Start the animation (looped playback by default).
        frameAnimation.start();
        myTextView = (TextView) findViewById(R.id.text1);
        myTextView1 = (TextView) findViewById(R.id.text2);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/PoiretOne-Regular.ttf");
        myTextView.setTypeface(typeface);
        myTextView1.setTypeface(typeface);
        button = (Button) findViewById(R.id.button);

        button.setTypeface(typeface);
        rippleView=(RippleView)findViewById(R.id.more);


        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                //   Intent i = new Intent(MainActivity.this,RecyclerViewActivity.class);
                startActivity(i);
            }

        });
    }


}
