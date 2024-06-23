package com.example.maths;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class Second extends AppCompatActivity
{
    String msg,res;
    TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        tv1 = findViewById(R.id.textView1);
        tv2 = findViewById(R.id.textView2);
        Intent intent = getIntent();
        msg = intent.getStringExtra("msg");
        tv1.setText(msg);
        res = intent.getStringExtra("res");
        tv2.setText(res);
    }
}
