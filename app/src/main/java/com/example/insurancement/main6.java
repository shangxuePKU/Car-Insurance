package com.example.insurancement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class main6 extends Activity {

    private EditText edit6_001, edit6_002, edit6_003,
            edit6_004, edit6_005, edit6_006,
            edit6_007, edit6_008;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        edit6_001 = (EditText)this.findViewById(R.id.edit6_001);
        edit6_002 = (EditText)this.findViewById(R.id.edit6_002);
        edit6_003 = (EditText)this.findViewById(R.id.edit6_003);
        edit6_004 = (EditText)this.findViewById(R.id.edit6_004);
        edit6_005 = (EditText)this.findViewById(R.id.edit6_005);
        edit6_006 = (EditText)this.findViewById(R.id.edit6_006);
        edit6_007 = (EditText)this.findViewById(R.id.edit6_007);
        edit6_008 = (EditText)this.findViewById(R.id.edit6_008);

        edit6_001.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.tax1 = edit6_001.getText().toString();
            }
        });

        edit6_002.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.tax2 = edit6_002.getText().toString();
            }
        });

        edit6_003.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.tax3 = edit6_003.getText().toString();
            }
        });

        edit6_004.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.tax4 = edit6_004.getText().toString();
            }
        });

        edit6_005.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.tax5 = edit6_005.getText().toString();
            }
        });

        edit6_006.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.tax6 = edit6_006.getText().toString();
            }
        });

        edit6_007.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.tax7 = edit6_007.getText().toString();
            }
        });

        edit6_008.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.tax8 = edit6_008.getText().toString();
            }
        });

    }

    //上一步
    public void btn_img6_001(View view){
        Intent intent = new Intent(main6.this, main5.class);
        startActivity(intent);
    }
    //下一步
    public void btn6_001(View view){
        Intent intent = new Intent(main6.this, main7.class);
        startActivity(intent);
    }
}
