package com.example.urvikagola.hack4climate;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;


public class Main2Activity extends AppCompatActivity {
    EditText id1,id2;
    String DiamondID1, DiamondID2;
    TextView t1,t2,t3,vs;
    ImageView  img;
    RippleView rippleView;
    Button submit;
    String resp1,resp2;
    int result;

    public Main2Activity() throws IOException {
    }

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

        submit = (Button) findViewById(R.id.submit);
        submit.setTypeface(typeface);
        rippleView=(RippleView)findViewById(R.id.more);


        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {

               // calculatevolley();
               float result = calculate(32,36);

                Intent i = new Intent(Main2Activity.this,Main3Activity.class);
                i.putExtra("message", "12.5");
                //Intent i = new Intent(MainActivity.this,RecyclerViewActivity.class);
                startActivity(i);
            }

        });


    }
    void calculatevolley() {
        DiamondID1 = id1.getText().toString();
        DiamondID2 = id2.getText().toString();

        RequestQueue queue = Volley.newRequestQueue(this);

        final String url = "http://b567829a.ngrok.io/chain4change/h4c/app/?id=4";

// prepare the Request


        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        Log.d("PANO", response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("PANO", "NOT FOUND");
                    }
                }
        );

// add it to the RequestQueue
        queue.add(getRequest);
// add it to the RequestQueue  


        /*String url1 ="http://b567829a.ngrok.io/chain4change/h4c/app/?id="+DiamondID2;
        Log.i("pano",url1);
        // Request a string response from the provided URL.
        StringRequest stringRequest1 = new StringRequest(Request.Method.GET, url1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.i("coco","Response is: "+ response.substring(0,500));
                        resp2=response.substring(0,500);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("coco","dint work");
            }
        });
        queue.add(stringRequest);
        result= calculate(Integer.parseInt(resp1),Integer.parseInt(resp2));
    } */
    }
    float calculate(int p1,int p2)
    {
        float perc;
        Log.i("result",p1+"");
        Log.i("result",p2+"");

        if(p1<p2)
        {
            perc=((p2-p1)/p1)*100;

        }
        else
        {
            perc=((p1-p2)/p2)*100;
        }
        return perc;
    }

        /** Called when the activity is first created. */


    }
