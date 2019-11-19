package com.fju.water;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        float money = intent.getFloatExtra("MONEY",0);  //getXXExtra:XX依照前面之屬性選擇(int,float,double,char......)
        Log.d("ResultActivity",money+"");
        TextView moneyText = findViewById(R.id.money);
        //moneyText.setText(money+"");
        int m = (int) (money + 0.5f);  //強制轉成int後面小數點直接捨去 ; 四捨五入: +0.5 = 取至個位, +0.05 = 取至小數點後一位
        moneyText.setText(m+ "");
    }
}
