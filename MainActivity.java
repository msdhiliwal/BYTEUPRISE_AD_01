package com.example.maths;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Intent intent;
    String val,val1,val2,res,msg;
    EditText et1,et2;
    RadioButton sum,sub,mul,div;
    TextView t1;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.editText1);
        et2 = findViewById(R.id.editText2);
        sum = findViewById(R.id.btn1);
        sub = findViewById(R.id.btn2);
        mul = findViewById(R.id.btn3);
        div = findViewById(R.id.btn4);
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((et1.getText().length()>0) && (et2.getText().length() > 0))
                {
                    double num1 = Double.parseDouble(et1.getText().toString());
                    double num2 = Double.parseDouble(et2.getText().toString());
                    double result = num1 + num2;
                    val1 = Double.toString(num1);
                    val2 = Double.toString(num2);
                    val = Double.toString(result);
                    intent=new Intent(getApplicationContext(),Second.class);
                    msg = "You have selected '+' Button";
                    res = val1+" + "+val2+" = "+val;
                    intent.putExtra("msg",msg);
                    intent.putExtra("res",res);
                }
                else {
                    Toast.makeText(MainActivity.this,"Enter Required Numbers",Toast.LENGTH_LONG).show();
                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((et1.getText().length()>0) && (et2.getText().length() > 0))
                {
                    double num1 = Double.parseDouble(et1.getText().toString());
                    double num2 = Double.parseDouble(et2.getText().toString());
                    double result = num1 - num2;
                    val1 = Double.toString(num1);
                    val2 = Double.toString(num2);
                    val = Double.toString(result);
                    intent=new Intent(getApplicationContext(),Second.class);
                    msg = "You have selected '−' Radio Button";
                    res = val1+" − "+val2+" = "+val;
                    intent.putExtra("msg",msg);
                    intent.putExtra("res",res);
                }
                else {
                    Toast.makeText(MainActivity.this,"Enter Required Numbers",Toast.LENGTH_LONG).show();
                }
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((et1.getText().length()>0) && (et2.getText().length() > 0))
                {
                    double num1 = Double.parseDouble(et1.getText().toString());
                    double num2 = Double.parseDouble(et2.getText().toString());
                    double result = num1 * num2;
                    val1 = Double.toString(num1);
                    val2 = Double.toString(num2);
                    val = Double.toString(result);
                    intent=new Intent(getApplicationContext(),Second.class);
                    msg = "You have selected '×' Radio Button";
                    res = val1+" × "+val2+" = "+val;
                    intent.putExtra("msg",msg);
                    intent.putExtra("res",res);
                }
                else {
                    Toast.makeText(MainActivity.this,"Enter Required Numbers",Toast.LENGTH_LONG).show();
                }
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((et1.getText().length()>0) && (et2.getText().length() > 0))
                {
                    double num1 = Double.parseDouble(et1.getText().toString());
                    double num2 = Double.parseDouble(et2.getText().toString());
                    double result = num1 / num2;val = Double.toString(result);
                    val1 = Double.toString(num1);
                    val2 = Double.toString(num2);
                    val = Double.toString(result);
                    intent=new Intent(getApplicationContext(),Second.class);
                    msg = "You have selected '÷' Radio Button";
                    res = val1+" ÷ "+val2+" = "+val;
                    intent.putExtra("msg",msg);
                    intent.putExtra("res",res);
                }
                else {
                    Toast.makeText(MainActivity.this,"Enter Required Numbers",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void submit(View view){
        startActivity(intent);
    }
}
