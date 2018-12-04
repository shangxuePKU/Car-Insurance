package com.example.insurancement;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main5 extends Activity {
    private EditText edit5_001, edit5_002, edit5_003,
                    edit5_004, edit5_005, edit5_006;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        edit5_001 = (EditText)this.findViewById(R.id.edit5_001);
        edit5_002 = (EditText)this.findViewById(R.id.edit5_002);
        edit5_003 = (EditText)this.findViewById(R.id.edit5_003);
        edit5_004 = (EditText)this.findViewById(R.id.edit5_004);
        edit5_005 = (EditText)this.findViewById(R.id.edit5_005);
        edit5_006 = (EditText)this.findViewById(R.id.edit5_006);

        edit5_001.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.cast1 = edit5_001.getText().toString();
            }
        });

        edit5_002.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.cast2 = edit5_002.getText().toString();
            }
        });

        edit5_003.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.cast3 = edit5_003.getText().toString();
            }
        });

        edit5_004.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.cast4 = edit5_004.getText().toString();
            }
        });

        edit5_005.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.cast5 = edit5_005.getText().toString();
            }
        });

        edit5_006.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.cast6 = edit5_006.getText().toString();
            }
        });


        edit5_004.setOnTouchListener(new View.OnTouchListener() {
            @TargetApi(Build.VERSION_CODES.N)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){

                    AlertDialog.Builder builder = new AlertDialog.Builder(main5.this);
                    View view1 = View.inflate(main5.this, R.layout.date_time_dialog, null);
                    final DatePicker datePicker = (DatePicker) view1.findViewById(R.id.date_picker);

                    builder.setView(view1);
                    Calendar calendar = null;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(System.currentTimeMillis());
                        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)
                                , calendar.get(Calendar.DAY_OF_MONTH), null);

                    }
                    if (view.getId() == R.id.edit5_004){
                        final int inType = edit5_004.getInputType();
                        edit5_004.setInputType(InputType.TYPE_NULL);
                        edit5_004.onTouchEvent(motionEvent);
                        edit5_004.setInputType(inType);
                        edit5_004.setSelection(edit5_004.getText().length());

                        builder.setTitle("选取有效日期");
                        builder.setPositiveButton("确  定", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                StringBuffer sb = new StringBuffer();
                                sb.append(String.format("%d-%02d-%02d",
                                        datePicker.getYear(),
                                        datePicker.getMonth() + 1,
                                        datePicker.getDayOfMonth()));

                                edit5_004.setText(sb+" 0时");

                                //story expireTime
                                try {
                                    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                                    Date date = fmt.parse(sb+" 0时");
//                                    Message.mExpireTime = date;
//                                    Message.mExpireTimeStr = fmt.format(date);
                                    Log.v("mExpireTime", fmt.format(date));

                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                                edit5_004.requestFocus();
                                dialog.cancel();
                            }
                        });
                    }
                    Dialog dialog = builder.create();
                    dialog.show();
                }
                return false;
            }
        });

        edit5_005.setOnTouchListener(new View.OnTouchListener() {
            @TargetApi(Build.VERSION_CODES.N)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){

                    AlertDialog.Builder builder = new AlertDialog.Builder(main5.this);
                    View view1 = View.inflate(main5.this, R.layout.date_time_dialog, null);
                    final DatePicker datePicker = (DatePicker) view1.findViewById(R.id.date_picker);

                    builder.setView(view1);
                    Calendar calendar = null;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(System.currentTimeMillis());
                        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)
                                , calendar.get(Calendar.DAY_OF_MONTH), null);

                    }
                    if (view.getId() == R.id.edit5_005){
                        final int inType = edit5_005.getInputType();
                        edit5_005.setInputType(InputType.TYPE_NULL);
                        edit5_005.onTouchEvent(motionEvent);
                        edit5_005.setInputType(inType);
                        edit5_005.setSelection(edit5_005.getText().length());

                        builder.setTitle("选取有效日期");
                        builder.setPositiveButton("确  定", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                StringBuffer sb = new StringBuffer();
                                sb.append(String.format("%d-%02d-%02d",
                                        datePicker.getYear(),
                                        datePicker.getMonth() + 1,
                                        datePicker.getDayOfMonth()));

                                edit5_005.setText(sb+"24时");

                                //story expireTime
                                try {
                                    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                                    Date date = fmt.parse(sb+"24");
//                                    Message.mExpireTime = date;
//                                    Message.mExpireTimeStr = fmt.format(date);
                                    Log.v("mExpireTime", fmt.format(date));

                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                                edit5_005.requestFocus();
                                dialog.cancel();
                            }
                        });
                    }
                    Dialog dialog = builder.create();
                    dialog.show();
                }
                return false;
            }
        });
    }

    //上一步
    public void btn_img5_001 (View view) {
        Intent intent = new Intent(main5.this, main4.class);
        startActivity(intent);
    }
    //下一步
    public void btn5_001(View view){
        Intent intent = new Intent(main5.this, main6.class);
        startActivity(intent);
    }
}
