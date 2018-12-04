package com.example.insurancement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class main4 extends Activity {

    private EditText edit4_001, edit4_002, edit4_003,
            edit4_004, edit4_005, edit4_006;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        edit4_001 = (EditText)this.findViewById(R.id.edit4_001);
        edit4_002 = (EditText)this.findViewById(R.id.edit4_002);
        edit4_003 = (EditText)this.findViewById(R.id.edit4_003);
        edit4_004 = (EditText)this.findViewById(R.id.edit4_004);
        edit4_005 = (EditText)this.findViewById(R.id.edit4_005);
        edit4_006 = (EditText)this.findViewById(R.id.edit4_006);

        edit4_001.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.limit1 = edit4_001.getText().toString()+"元";
            }
        });

        edit4_002.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.limit2 = edit4_002.getText().toString()+"元";
            }
        });

        edit4_003.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.limit3 = edit4_003.getText().toString()+"元";
            }
        });

        edit4_004.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.limit4 = edit4_004.getText().toString()+"元";
            }
        });

        edit4_005.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.limit5 = edit4_005.getText().toString()+"元";
            }
        });

        edit4_006.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.limit6 = edit4_006.getText().toString()+"元";
            }
        });

    }
    //上一步
    public void btn_img4_001 (View view) {
        Intent intent = new Intent(main4.this, main3.class);
        startActivity(intent);
    }
    //下一步
    public void btn4_001(View view){
        Intent intent = new Intent(main4.this, main5.class);
        startActivity(intent);
    }
}
