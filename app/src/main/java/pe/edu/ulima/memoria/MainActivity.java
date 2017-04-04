package pe.edu.ulima.memoria;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Button> btns;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btns = new ArrayList<>();

        btns.add((Button) findViewById(R.id.a));
        btns.add((Button) findViewById(R.id.b));
        btns.add((Button) findViewById(R.id.c));
        btns.add((Button) findViewById(R.id.d));
        btns.add((Button) findViewById(R.id.e));
        btns.add((Button) findViewById(R.id.f));
        btns.add((Button) findViewById(R.id.g));
        btns.add((Button) findViewById(R.id.h));
        btns.add((Button) findViewById(R.id.i));
        btns.add( (Button) findViewById(R.id.j));
        btns.add( (Button) findViewById(R.id.k));
        btns.add( (Button) findViewById(R.id.l));
        btns.add( (Button) findViewById(R.id.m));
        btns.add( (Button) findViewById(R.id.n));
        btns.add( (Button) findViewById(R.id.o));
        btns.add( (Button) findViewById(R.id.p));

        Collections.shuffle(btns);

        TypedArray imgs = getResources().obtainTypedArray(R.array.random_imgs);

        for(int i=0; i < btns.size()/2; i++){
            for (int j =0; j<imgs.length(); j++){
                btns.get(i).setBackgroundResource(imgs.getResourceId(j,j));
                i++;
            }
        }

        for(int i=btns.size()/2; i < btns.size(); i++){
            for (int j =0; j<imgs.length(); j++){
                btns.get(i).setBackgroundResource(imgs.getResourceId(j,j));
                i++;
            }
        }

    }
}
