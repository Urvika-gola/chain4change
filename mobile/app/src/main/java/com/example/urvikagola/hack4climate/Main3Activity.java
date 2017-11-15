package com.example.urvikagola.hack4climate;

import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;

public class Main3Activity extends AppCompatActivity {
     TickerView tickerView;
    int limit = 52;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tickerView = (TickerView) findViewById(R.id.tickerView);
        Typeface typeface1 = Typeface.createFromAsset(getAssets(), "fonts/PoiretOne-Regular." + "ttf");
        tickerView.setTypeface(typeface1);
        tickerView.setCharacterList(TickerUtils.getDefaultNumberList());
        tickerView.setGravity(Gravity.START);
        tickerView.setText("10.9 %");
        tickerView.setText("25.5 %");
        tickerView.setText("45.7 %");
        tickerView.setText("50.1 %");
        tickerView.setText("58.2 %");
        tickerView.setText("62.9 %");
        tickerView.setText("68.1 %");
        tickerView.setText("71.5 %");
        tickerView.setText("75.9 %");
        tickerView.setText("58.2 %");
        tickerView.setText("62.9 %");
        tickerView.setText("68.1 %");
        tickerView.setText("71.5 %");
        tickerView.setText("75.9 %");
        tickerView.setText("81.4 %");
        img = (ImageView)findViewById(R.id.imageviewhandler);
        img.setBackgroundResource(R.drawable.spin_animation);
        // Get the background, which has been compiled to an AnimationDrawable object.
        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
        // Start the animation (looped playback by default).
        frameAnimation.start();

    }
}
