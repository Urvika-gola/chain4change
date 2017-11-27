package com.example.urvikagola.hack4climate;

import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;

public class Main3Activity extends AppCompatActivity {
     TickerView tickerView;
    int limit = 52;
    ImageView img;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tickerView = (TickerView) findViewById(R.id.tickerView);
        TextView tv1= (TextView) findViewById(R.id.text1);
        TextView tv2= (TextView) findViewById(R.id.text2);

        Typeface typeface1 = Typeface.createFromAsset(getAssets(), "fonts/PoiretOne-Regular." + "ttf");
        Typeface typeface2 = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Medium." + "ttf");

        tickerView.setTypeface(typeface1);
        tickerView.setCharacterList(TickerUtils.getDefaultNumberList());
        tv1.setTypeface(typeface2);
        tv2.setTypeface(typeface2);

        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");

        tickerView.setGravity(Gravity.START);
        tickerView.setText("8.9 %");
        tickerView.setText("9.5 %");
        tickerView.setText("10.7 %");
        tickerView.setText("11.1 %");
        tickerView.setText("11.2 %");
        tickerView.setText("11.9 %");
        tickerView.setText("12.1 %");
        tickerView.setText(message+" %");
        img = (ImageView)findViewById(R.id.imageviewhandler);
        img.setBackgroundResource(R.drawable.spin_animation);
        // Get the background, which has been compiled to an AnimationDrawable object.
        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
        // Start the animation (looped playback by default).
        frameAnimation.start();
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://b567829a.ngrok.io/chain4change/h4c/app/?id=2";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.i("coco","Response is: "+ response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("coco","dint work");
            }
        });
        queue.add(stringRequest);

    }


}
