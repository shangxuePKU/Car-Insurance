package com.example.insurancement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.ArrayWheelAdapter;

public class main2 extends Activity implements OnWheelChangedListener{
    private WheelView mCity;
    private WheelView mArea;
    private RelativeLayout relativeLayout = null;
    private Button button2_001 = null;//下一步
    private TextView textView2_001 =null;//请选择
    private String mCurrentCityName;
    private String mCurrentAreaName;
    private Map<String,String> mAreaDatasMap = new HashMap<String, String>();

    private EditText edit2_001, edit2_002, edit2_004;

    String[] mCityDatas = new String[]{"北京"};

    String[] mAreaDatas = new String[]{
            "东城", "西城", "海淀", "朝阳",
            "丰台", "门头沟", "石景山", "房山",
            "通州", "顺义", "昌平", "大兴",
            "怀柔", "平谷", "延庆", "密云"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edit2_001 = (EditText)this.findViewById(R.id.edit2_001);
        edit2_002 = (EditText)this.findViewById(R.id.edit2_002);
        edit2_004 = (EditText)this.findViewById(R.id.edit2_004);


        edit2_001.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.name = edit2_001.getText().toString();
            }
        });

        edit2_002.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.idCard = edit2_002.getText().toString();
            }
        });

        edit2_004.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                data.message.Message.phone = edit2_004.getText().toString();
            }
        });


        relativeLayout = (RelativeLayout)findViewById(R.id.layout2_003);
        relativeLayout.setVisibility(View.INVISIBLE);

        button2_001 = (Button) findViewById(R.id.btn2_001);

        textView2_001= (TextView)findViewById(R.id.textview2_001);

    }


    //地址
    public void btn_img2_002 (View view){

        relativeLayout.setVisibility(View.VISIBLE);
        button2_001.setVisibility(View.INVISIBLE);

        mCity = (WheelView) findViewById(R.id.wheerView2_001);
        mArea = (WheelView) findViewById(R.id.wheerView2_002);

        mCity.setViewAdapter(new ArrayWheelAdapter<String>(this, mCityDatas));
        mCity.addChangingListener((OnWheelChangedListener) this);
        mArea.addChangingListener((OnWheelChangedListener) this);

        mCity.setVisibleItems(5);
        mArea.setVisibleItems(5);

        updateAreas();

    }

    //取消选择城区
    public void btn_img2_003 (View view){
        relativeLayout.setVisibility(View.INVISIBLE);
        button2_001.setVisibility(View.VISIBLE);
    }
    //确定城区
    public void btn2_002 (View view){
        relativeLayout.setVisibility(View.INVISIBLE);
        button2_001.setVisibility(View.VISIBLE);

        textView2_001.setText(mCurrentCityName+"市"+mCurrentAreaName+"区");
        data.message.Message.address = mCurrentCityName+"市"+mCurrentAreaName+"区";

    }

    private void updateAreas(){
        int numCurrent = mCity.getCurrentItem();
        Log.d("CurrentNum",numCurrent+"");
        mCurrentCityName = mCityDatas[numCurrent];
        Log.d("CurrentCity",mCurrentCityName);

        mArea.setViewAdapter(new ArrayWheelAdapter<String>(this, mAreaDatas));
        mArea.setCurrentItem(0);
        mCurrentAreaName = mAreaDatas[0];
    }

    @Override
    public void onChanged(WheelView wheel, int oldValue, int newValue) {

        if(wheel == mCity){
            updateAreas();


        }else if(wheel == mArea){
            mCurrentAreaName = mAreaDatas[newValue];

        }
    }

    //上一步
    public void btn_img2_001 (View view){
        Intent intent = new Intent(main2.this, HomeActivity.class);
        startActivity(intent);
    }
    //下一步
    public void btn2_001 (View view){
        Intent intent = new Intent(main2.this, main3.class);
        startActivity(intent);
    }
}
