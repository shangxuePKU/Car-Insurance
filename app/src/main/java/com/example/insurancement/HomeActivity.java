package com.example.insurancement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    //签署
    public void btn_img1_002(View view){
        Intent intent = new Intent(HomeActivity.this, main2.class);
        startActivity(intent);

    }

//    public void btn_layout1_001(View view){
//        Intent intent = new Intent(HomeActivity.this, HistoryActivity.class);
//        startActivity(intent);
//    }
}
