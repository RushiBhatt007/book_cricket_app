package com.example.rushi.rushi003;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.*;
import java.math.*;

public class MainActivity extends AppCompatActivity {
    int overs,tosswin,run1=0,run2=0,wkt1=0,wkt2=0,rem1,rem2,test1=0,test2=0;
    String p1,p2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public int runs(){
        double x = Math.random();
        x = x*7;
        int y = (int)x %10;
        return y;
    }
    public void toss(View view)
    {
        double x = Math.random();
        TextView a = (TextView)findViewById(R.id.tosswin);
        if(x>=0.5) {
            a.setText(p1);
            tosswin=1;
       }
       else{
            a.setText(p2);
            tosswin=2;
        }
    }
    public void button1(View view)
    {
        EditText txtname = (EditText)findViewById(R.id.editview_name1);
        p1      =  txtname.getText().toString();
        display1(p1);
    }
    public void button2(View view)
    {
        EditText txtname = (EditText)findViewById(R.id.editview_name2);
        p2      =  txtname.getText().toString();
        display2(p2);
    }
    public void button3(View view)
    {
        EditText txtname = (EditText)findViewById(R.id.intovers);
        String s      =  txtname.getText().toString();
        if(s.isEmpty())
            Toast.makeText(MainActivity.this,"ENTER VALID NUMBER OF OVERS",Toast.LENGTH_LONG).show();
        else {
            overs = Integer.parseInt(s);
            rem1 = overs * 6;
            rem2 = overs * 6;
        }
    }
    public void display2(String s)
    {
        TextView a = (TextView) findViewById(R.id.textview_team2);
        a.setText(s);
    }
    public void display1(String s)
    {
        TextView a = (TextView) findViewById(R.id.textview_team1);
        a.setText(s);
    }
    public void reset(View view){
        display1("");
        display2("");
        tosswin=0;
        p1="";
        p2="";
        overs=0;
        run1=0;
        run2=0;
        wkt1=0;
        wkt2=0;
        rem1=0;
        rem2=0;
        test1=0;
        test2=0;
        TextView a  = (TextView)findViewById(R.id.tosswin);
        TextView a1 = (TextView)findViewById(R.id.runs1);
        TextView a2 = (TextView)findViewById(R.id.wickets1);
        TextView a3 = (TextView)findViewById(R.id.total1);
        TextView a4 = (TextView)findViewById(R.id.rem1);
        TextView a5 = (TextView)findViewById(R.id.final1);
        TextView a6 = (TextView)findViewById(R.id.winner);
        a.setText("");
        a1.setText("");
        a2.setText("");
        a3.setText("");
        a4.setText("");
        a5.setText("");
        a6.setText("");
        TextView b1 = (TextView)findViewById(R.id.runs2);
        TextView b2 = (TextView)findViewById(R.id.wickets2);
        TextView b3 = (TextView)findViewById(R.id.total2);
        TextView b4 = (TextView)findViewById(R.id.rem2);
        TextView b5 = (TextView)findViewById(R.id.final2);
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
    }
    public void play1(View view){
        TextView a1 = (TextView)findViewById(R.id.runs1);
        TextView a2 = (TextView)findViewById(R.id.wickets1);
        TextView a3 = (TextView)findViewById(R.id.total1);
        TextView a4 = (TextView)findViewById(R.id.rem1);
        TextView a5 = (TextView)findViewById(R.id.final1);
        TextView a6 = (TextView)findViewById(R.id.winner);
        if((tosswin==1||test1==50) && rem1>0 && wkt2<=10)
        {
            int currentrun=runs();
            if(currentrun>=6)
            {
                currentrun=6;
                run1+=currentrun;
                a2.setText(wkt1+" WICKET");
                a1.setText("HUGE SIX");
                a3.setText("SCORE "+run1);
            }
            else if(currentrun==5)
            {
                currentrun=0;
                wkt1++;
                run1+=currentrun;
                a2.setText(wkt1+" WICKET");
                a1.setText("BOWLED");
                a3.setText("SCORE "+run1);
            }
            else{
                run1+=currentrun;
                a2.setText(wkt1+" WICKET");
                if(currentrun==0)
                    a1.setText("DOT BALL");
                else if(currentrun==1)
                    a1.setText("SINGLE");
                else if(currentrun==2)
                    a1.setText("QUICK DOUBLE");
                else if(currentrun==3)
                    a1.setText("TRIPLE");
                else if(currentrun==4)
                    a1.setText("BOUNDARY");
                a3.setText("SCORE "+run1);
            }
            if(run2!=0 &&run1>run2)
            {
                a6.setText("WINNER IS "+p1);
                a5.setText("RUNS "+run1+" FOR "+wkt1+" WICKETS");
            }
            rem1--;
            a4.setText("REMAINING BALLS "+rem1);
        }
        if(rem1==0)
        {
            test2=50;
            a5.setText("RUNS "+run1+" FOR "+wkt1+" WICKETS");
            if(run2!=0 && run1>run2)
            {
                a6.setText("WINNER IS "+p1);
            }
            else if(run2>run1)
            {
                a6.setText("WINNER IS "+p2);
            }
            else if(run1==run2){
                a6.setText("MATCH ENDS IN A DRAW");
            }
        }
    }
    public void play2(View view) {
        TextView a1 = (TextView) findViewById(R.id.runs2);
        TextView a2 = (TextView) findViewById(R.id.wickets2);
        TextView a3 = (TextView) findViewById(R.id.total2);
        TextView a4 = (TextView) findViewById(R.id.rem2);
        TextView a5 = (TextView) findViewById(R.id.final2);
        TextView a6 = (TextView) findViewById(R.id.winner);
        if ((tosswin == 2 || test2 == 50) && rem2 > 0 && wkt1<=10) {
            int currentrun = runs();
            if(currentrun>=6)
            {
                currentrun=6;
                run2+=currentrun;
                a1.setText("HUGE SIX");
                a3.setText("SCORE " + run2);
            }
            else if (currentrun == 5) {
                wkt2++;
                currentrun=0;
                a2.setText(wkt2 + " WICKET");
                a1.setText("BOWLED");
                a3.setText("SCORE " + run2);
            }
            else {
                run2 += currentrun;
                a2.setText(wkt2 + " WICKET");
                if(currentrun==0)
                    a1.setText("DOT BALL");
                else if(currentrun==1)
                    a1.setText("SINGLE");
                else if(currentrun==2)
                    a1.setText("QUICK DOUBLE");
                else if(currentrun==3)
                    a1.setText("TRIPLE");
                else if(currentrun==4)
                    a1.setText("BOUNDARY");
                a3.setText("SCORE " + run2);
            }
            if(run1!=0 && run2>run1)
            {
                a6.setText("WINNER IS "+p2);
                a5.setText("RUNS " + run2 + " FOR " + wkt2 + " WICKETS");
            }
            rem2--;
            a4.setText("REMAINING BALLS " + rem2);
        }
        if (rem2 == 0) {
            test1 = 50;
            a5.setText("RUNS " + run2 + " FOR " + wkt2 + " WICKETS");
            if(run1!=0 && run2>run1)
            {
                a6.setText("WINNER IS "+p2);
            }
            else if(run1>run2)
            {
                a6.setText("WINNER IS "+p1);
            }
            else if(run1==run2) {
                a6.setText("MATCH ENDS IN A DRAW");
            }
        }
    }
}
