package com.example.rachit.cal;
import android.support.v7.app.AppCompatActivity;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button add,sub,mul,div,equal,num,clear,nb;
    TextView t1;
    String re = "";
    String res = "";
    int a,l,j,i;
    float result;
    float b[]=new float[2];
    char [] ch;
    String rt="yo";
    Stack st = new Stack();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clear = (Button) findViewById(R.id.clear);
        equal = (Button) findViewById(R.id.equal);
        clear.setOnClickListener(this);
        float result;
        t1 = (TextView) findViewById(R.id.t1);
    }
    public void Number(View v)
    {nb = (Button) v;
if(res!=rt)
{

            res = res + nb.getText().toString();
        t1.setText(res);
        re=res;}
        else{
    res="";
    rt="yo";
    res = res + nb.getText().toString();
    re=res;
    t1.setText(res);
        }
    }
    public void Operator(View v)
    {   nb = (Button) v;
        re = re + nb.getText().toString();
        String n="[0-9]*";
        char min='-';
        String mi=Character.toString(min);
        String rg="[-]?[0-9]+[.]?[0-9]*[+-/*]?"+n;
        Pattern pt =Pattern.compile(rg);
        Matcher m=pt.matcher(re);
        boolean b=m.matches();
        if(b)
        {
            res = res + nb.getText().toString();
            t1.setText(res);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"false",Toast.LENGTH_LONG);
        }
        String rg1="[-]?[0-9]+[.]?[0-9]*[+-/*]{1}[0-9]+";
        Pattern pt1 =Pattern.compile(rg1);
        Matcher m1=pt1.matcher(res);
        boolean b1=m1.matches();
        if(b1)
        {
            assign();
            res=res+nb.getText().toString();
            t1.setText(res);
            re=res;

        }
    }
    public void onClick(View v) {
        res="";
        t1.setText("");
    }

    public void assign()
    {
        char c='.';
        ch=res.toCharArray();
        l=ch.length;
        String at="";

        j=0;
        i=0;
        while(j<l)
        {
            if((ch[j]=='+'||ch[j]=='-'||ch[j]=='/'||ch[j]=='*')&&j>0)
            {

                b[i] = Float.parseFloat(at);
                at="";
                c = (ch[j]);
                i++;


            }
else{            at=at+ch[j];}
            j++;
        }
        if(Integer.parseInt(at)>=0)
        {
        b[i]=Float.parseFloat(at);
        equal(c);
        }
    }

    public void equal(char op) {
        if (op == '+') {
            result = b[0] + b[1];
        } else if (op == '*') {
            result = b[0] * b[1];
        } else if (op == '-') {
            result = b[0] - b[1];
        } else if (op == '/') {
            result = b[0] / b[1];
        } else{
            result=b[0];
        }
        rt=Float.toString(result);
        result=0;
        res=rt;
        re=res;
        t1.setText(res);
    }
    public void equal1(View v)
    {
        try{assign();}
        catch(Exception e)
        {
            return;
        }
    }
}
