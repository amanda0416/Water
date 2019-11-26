package com.fju.water;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edMonth;
    private EditText edNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edMonth = findViewById(R.id.month);
        edNext = findViewById(R.id.next);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void reset(){
        edMonth.setText("");
        edNext.setText("");
        edMonth = findViewById(R.id.month);
        edNext = findViewById(R.id.next);
    }
    public void calculate(){
        if(!TextUtils.isEmpty(edMonth.getText().toString())){
            float degree = Float.parseFloat(edMonth.getText().toString());
            float money = 0 ;
            if(degree<11){
                money = 7.35f * degree;
            }else if(degree<31){
                money = 9.45f * degree-21;
            }else if(degree<51){
                money = 11.55f * degree-84;
            }else{
                money = 12.075f * degree-110.25f;
            }
            Intent intent = new Intent(this,ResultActivity.class);   // this = MainActivity本身
            intent.putExtra(getString(R.string.extra_money),money);
            startActivity(intent);
//            new AlertDialog.Builder(this).setTitle(getString(R.string.monthly_fee)).setMessage(getString(R.string.fee)+money).setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    reset();
//                }
//            }).show();
        }else {
            if(!TextUtils.isEmpty(edNext.getText().toString())){
                float degree = Float.parseFloat(edNext.getText().toString());
                float money = 0 ;
                if(degree<21){
                    money = 7.35f * degree;
                }else if(degree<61){
                    money = 9.45f * degree-42;
                }else if(degree<101){
                    money = 11.55f * degree-168;
                }else{
                    money = 12.075f * degree-220.5f;
                }
                Intent intent = new Intent(this,ResultActivity.class);   // this = MainActivity本身
                intent.putExtra("MONEY",money);
                startActivity(intent);
//                new AlertDialog.Builder(this).setTitle(getString(R.string.every_other_month_fee)).setMessage(getString(R.string.fee)+money).setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        reset();
//                    }
//                }).show();
            }
        }
//        if(TextUtils.isEmpty(edMonth.getText().toString())&&TextUtils.isEmpty(edNext.getText().toString())){
//            new AlertDialog.Builder(this).setTitle("抄表費用").setMessage("Fee Can Not Calculate").setPositiveButton("Ok", null).show();
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
