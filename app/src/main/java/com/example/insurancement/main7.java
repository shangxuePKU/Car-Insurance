package com.example.insurancement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class main7 extends Activity {

    private EditText edit7_001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        edit7_001 = (EditText)this.findViewById(R.id.edit7_001);
        edit7_001.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.appoint = edit7_001.getText().toString();
            }
        });

    }

    //上一步
    public void btn_img7_001(View view){
        Intent intent = new Intent(main7.this, main6.class);
        startActivity(intent);
    }
    //下一步
    public void btn7_001(View view){
        Intent intent = new Intent(main7.this, main8.class);
        startActivity(intent);
    }
}
