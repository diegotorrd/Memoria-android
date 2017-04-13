package pe.edu.ulima.memoria;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Button> btns;
    private Button btn1;
    private Button btn2;
    private int cont;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btns = new ArrayList<>();
        btn1=null;
        btn2=null;
        cont=0;

        btns.add((Button) findViewById(R.id.a));
        btns.add((Button) findViewById(R.id.b));
        btns.add((Button) findViewById(R.id.c));
        btns.add((Button) findViewById(R.id.d));
        btns.add((Button) findViewById(R.id.e));
        btns.add((Button) findViewById(R.id.f));
        btns.add((Button) findViewById(R.id.g));
        btns.add((Button) findViewById(R.id.h));
        btns.add((Button) findViewById(R.id.i));
        btns.add((Button) findViewById(R.id.j));
        btns.add((Button) findViewById(R.id.k));
        btns.add((Button) findViewById(R.id.l));
        btns.add((Button) findViewById(R.id.m));
        btns.add((Button) findViewById(R.id.n));
        btns.add((Button) findViewById(R.id.o));
        btns.add((Button) findViewById(R.id.p));

        Collections.shuffle(btns);

        TypedArray imgs = getResources().obtainTypedArray(R.array.random_imgs);

        for(int i=0; i < btns.size()/2; i++){
            for (int j =0; j<imgs.length(); j++){
                btns.get(i).setTag(imgs.getResourceId(j,j));
                i++;
            }
        }

        for(int i=btns.size()/2; i < btns.size(); i++){
            for (int j =0; j<imgs.length(); j++){
                btns.get(i).setTag(imgs.getResourceId(j,j));
                i++;
            }
        }



    }

    public void click(View view){
        if(btn1==null && btn2==null){
            btn1 = (Button) view;
            btn1.setBackgroundResource((int) btn1.getTag());
        }else if(btn1!=null && btn2 ==null){
            btn2 = (Button) view;
            btn2.setBackgroundResource((int) btn2.getTag());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    if(btn1.getTag().equals(btn2.getTag())){
                        cont+=2;
                        btn1=null;
                        btn2=null;
                        if(cont==16){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(MainActivity.this,"¡Bien Hecho! Acabó el juego", Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                    }else{
                        SystemClock.sleep(500);
                        btn1.post(new Runnable() {
                            @Override
                            public void run() {
                                btn1.setBackgroundColor(getResources().getColor(R.color.colorButton));
                                btn1=null;
                            }
                        });
                        btn2.post(new Runnable() {
                            @Override
                            public void run() {
                                btn2.setBackgroundColor(getResources().getColor(R.color.colorButton));
                                btn2=null;
                            }
                        });
                    }
                }
            }).start();
        }

    }

}
