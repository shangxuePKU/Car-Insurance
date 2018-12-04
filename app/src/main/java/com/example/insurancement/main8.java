package com.example.insurancement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class main8 extends Activity {

    private EditText edit8_001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        edit8_001 = (EditText)this.findViewById(R.id.edit8_001);
        edit8_001.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.info1 = edit8_001.getText().toString();
            }
        });

    }

    //上一步
    public void btn_img8_001(View view){
        Intent intent = new Intent(main8.this, main7.class);
        startActivity(intent);
    }
    //下一步
    public void btn8_001(View view){
        Intent intent = new Intent(main8.this, main9.class);
        startActivity(intent);
    }
}
