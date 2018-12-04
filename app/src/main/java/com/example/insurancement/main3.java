package com.example.insurancement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class main3 extends Activity {
    private EditText edit3_001, edit3_002, edit3_003,
                    edit3_004, edit3_005, edit3_006,
                edit3_007, edit3_008, edit3_009,
            edit3_010, edit3_011;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        edit3_001 = (EditText)this.findViewById(R.id.edit3_001);
        edit3_002 = (EditText)this.findViewById(R.id.edit3_002);
        edit3_003 = (EditText)this.findViewById(R.id.edit3_003);
        edit3_004 = (EditText)this.findViewById(R.id.edit3_004);
        edit3_005 = (EditText)this.findViewById(R.id.edit3_005);
        edit3_006 = (EditText)this.findViewById(R.id.edit3_006);
        edit3_007 = (EditText)this.findViewById(R.id.edit3_007);
        edit3_008 = (EditText)this.findViewById(R.id.edit3_008);
        edit3_009 = (EditText)this.findViewById(R.id.edit3_009);
        edit3_010 = (EditText)this.findViewById(R.id.edit3_010);
        edit3_011 = (EditText)this.findViewById(R.id.edit3_011);

        edit3_001.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.car1 = edit3_001.getText().toString();
            }
        });

        edit3_002.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.car2 = edit3_002.getText().toString();
            }
        });

        edit3_003.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.car3 = edit3_003.getText().toString();
            }
        });

        edit3_004.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.car4 = edit3_004.getText().toString();
            }
        });

        edit3_005.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.car5 = edit3_005.getText().toString();
            }
        });

        edit3_006.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.car6 = edit3_006.getText().toString();
            }
        });

        edit3_007.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.car7 = edit3_007.getText().toString();
            }
        });

        edit3_008.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.car8 = edit3_008.getText().toString();
            }
        });

        edit3_009.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.car9 = edit3_009.getText().toString();
            }
        });

        edit3_010.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.car10 = edit3_010.getText().toString();
            }
        });

        edit3_011.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.car11 = edit3_011.getText().toString();
            }
        });



    }

    //返回
    public void  btn_img3_001 (View view){
        Intent intent = new Intent(main3.this, main2.class);
        startActivity(intent);
    }

    //下一步
    public void txt3_001 (View view){
        Intent intent = new Intent(main3.this, main4.class);
        startActivity(intent);
    }
}
