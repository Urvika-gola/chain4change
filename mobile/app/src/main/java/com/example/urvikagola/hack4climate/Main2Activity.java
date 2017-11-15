package com.example.urvikagola.hack4climate;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.andexert.library.RippleView;


public class Main2Activity extends AppCompatActivity {
    EditText id1,id2;
    String DiamondID1, DiamondID2;
    TextView t1,t2,t3,vs;
    ImageView  img;
    RippleView rippleView;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        img = (ImageView)findViewById(R.id.imageviewhandler);
        img.setBackgroundResource(R.drawable.spin_animation);
        // Get the background, which has been compiled to an AnimationDrawable object.
        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
        // Start the animation (looped playback by default).
        frameAnimation.start();
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/PoiretOne-Regular." + "ttf");

        t1= (TextView) findViewById(R.id.text1);
        t2= (TextView) findViewById(R.id.text2);
        t3= (TextView) findViewById(R.id.text3);
        id1 = (EditText) findViewById(R.id.diamondid1);  //Take input
        id2 = (EditText) findViewById(R.id.diamondid2);  //Take input
        vs = (TextView) findViewById(R.id.vs);  //Take input

        t1.setTypeface(typeface);
        t2.setTypeface(typeface);
        t3.setTypeface(typeface);
        id1.setTypeface(typeface);
        id2.setTypeface(typeface);
        vs.setTypeface(typeface);
        DiamondID1=id1.getText().toString();
        DiamondID2=id1.getText().toString();
        submit = (Button) findViewById(R.id.submit);
        submit.setTypeface(typeface);
        rippleView=(RippleView)findViewById(R.id.more);
        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                Intent i = new Intent(Main2Activity.this,Main3Activity.class);
                //   Intent i = new Intent(MainActivity.this,RecyclerViewActivity.class);
                startActivity(i);
            }

        });
    }
        /** Called when the activity is first created. */


    }
