package com.example.insurancement;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import data.message.Message;
import data.utils.DialogUtil;
import data.utils.GsonUtil;
import data.utils.HttpUtil;
import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.ArrayWheelAdapter;

public class main9 extends Activity implements OnWheelChangedListener {

    private EditText edit9_002, edit9_004, edit9_005, edit9_006;
    private WheelView mCity;
    private WheelView mArea;
    private RelativeLayout relativeLayout = null;

    private Button button9_001 = null;//下一步
    private TextView textView9_001 = null;//请选择
    private String mCurrentCityName;
    private String mCurrentAreaName;

    String[] mCityDatas = new String[]{"北京"};

    String[] mAreaDatas = new String[]{
            "东城", "西城", "海淀", "朝阳",
            "丰台", "门头沟", "石景山", "房山",
            "通州", "顺义", "昌平", "大兴",
            "怀柔", "平谷", "延庆", "密云"};

    public Handler handler;
    protected static final int TEXT = 0;
    protected static final int TOAST = 1;

    String mplatformName = "test";
    String mclientName = "test";
    String mclientCode = "12345678901234567890";
    String mcontractTemplateName = "移动测试专用";



    String mcontentStr = " ";
    Integer[] mcustomerIds = new Integer[]{-1};
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    String mcontractName = df.format(new Date());
    Integer msendType = Message.sendType;
    String mtype = Message.type;
    Integer msignKeyType = Message.signKeyType;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);


        edit9_002 = (EditText)this.findViewById(R.id.edit9_002);

        edit9_004 = (EditText)this.findViewById(R.id.edit9_004);
        edit9_005 = (EditText)this.findViewById(R.id.edit9_005);
        edit9_006 = (EditText)this.findViewById(R.id.edit9_006);

        edit9_002.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Message.info2 = editable.toString();

            }
        });

        edit9_004.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Message.info4 = edit9_004.getText().toString();
            }
        });

        edit9_005.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Message.info5 = edit9_005.getText().toString();
            }
        });

        edit9_006.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Message.info6 = edit9_006.getText().toString();
            }
        });


        handler = new Handler() {

            @Override
            public void handleMessage(android.os.Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case TEXT:
                        break;
                    case TOAST:
                        //失败则提示失败原因
                        String result = message.getData().getString("toast");
                        Toast.makeText(getApplicationContext(), result,
                                Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        };


        relativeLayout = (RelativeLayout) findViewById(R.id.layout9_003);
        relativeLayout.setVisibility(View.INVISIBLE);

        //下一步
        button9_001 = (Button) findViewById(R.id.btn9_001);

        //请选择
        textView9_001 = (TextView) findViewById(R.id.textview9_001);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    //地址
    public void btn_img9_002(View view) {

        relativeLayout.setVisibility(View.VISIBLE);
        button9_001.setVisibility(View.INVISIBLE);

        mCity = (WheelView) findViewById(R.id.wheerView9_001);
        mArea = (WheelView) findViewById(R.id.wheerView9_002);

        mCity.setViewAdapter(new ArrayWheelAdapter<String>(this, mCityDatas));
        mCity.addChangingListener((OnWheelChangedListener) this);
        mArea.addChangingListener((OnWheelChangedListener) this);

        mCity.setVisibleItems(5);
        mArea.setVisibleItems(5);

        updateAreas();

    }

    //取消选择城区
    public void btn_img9_003(View view) {
        relativeLayout.setVisibility(View.INVISIBLE);
        button9_001.setVisibility(View.VISIBLE);
    }

    //确定城区
    public void btn9_002(View view) {
        relativeLayout.setVisibility(View.INVISIBLE);
        button9_001.setVisibility(View.VISIBLE);

        textView9_001.setText(mCurrentCityName + "市" + mCurrentAreaName + "区");

        Message.info3 = mCurrentCityName + "市" + mCurrentAreaName + "区";
    }

    private void updateAreas() {
        int numCurrent = mCity.getCurrentItem();
        Log.d("CurrentNum", numCurrent + "");
        mCurrentCityName = mCityDatas[numCurrent];
        Log.d("CurrentCity", mCurrentCityName);

        mArea.setViewAdapter(new ArrayWheelAdapter<String>(this, mAreaDatas));
        mArea.setCurrentItem(0);
        mCurrentAreaName = mAreaDatas[0];
    }

    @Override
    public void onChanged(WheelView wheel, int oldValue, int newValue) {

        if (wheel == mCity) {
            updateAreas();


        } else if (wheel == mArea) {
            mCurrentAreaName = mAreaDatas[newValue];

        }
    }

    //上一步
    public void btn_img9_001(View view) {
        Intent intent = new Intent(main9.this, main8.class);
        startActivity(intent);
    }

    //下一步
    public void btn9_001(View view) {
        Map<String, String> contentmap = new HashMap<String, String>();
//        JSONObject contentmap = new JSONObject();
//        JSONArray JsonArray = new JSONArray();


        contentmap.put("name", Message.name);
        contentmap.put("idCard", Message.idCard);
        contentmap.put("address", Message.address);
        contentmap.put("phone", Message.phone);
        contentmap.put("car1", Message.car1);
        contentmap.put("car2", Message.car2);
        contentmap.put("car3", Message.car3);
        contentmap.put("car4", Message.car4);
        contentmap.put("car5", Message.car5);
        contentmap.put("car6", Message.car6);
        contentmap.put("car7", Message.car7);
        contentmap.put("car8", Message.car8);
        contentmap.put("car9", Message.car9);
        contentmap.put("car10", Message.car10);
        contentmap.put("car11", Message.car11);
        contentmap.put("limit1", Message.limit1);
        contentmap.put("limit2", Message.limit2);
        contentmap.put("limit3", Message.limit3);
        contentmap.put("limit4", Message.limit4);
        contentmap.put("limit5", Message.limit5);
        contentmap.put("limit6", Message.limit6);
        contentmap.put("cast1", Message.cast1);
        contentmap.put("cast2", Message.cast2);
        contentmap.put("cast3", Message.cast3);
        contentmap.put("cast4", Message.cast4);
        contentmap.put("cast5", Message.cast5);
        contentmap.put("cast6", Message.cast6);
        contentmap.put("tax1", Message.tax1);
        contentmap.put("tax2", Message.tax2);
        contentmap.put("tax3", Message.tax3);
        contentmap.put("tax4", Message.tax4);
        contentmap.put("tax5", Message.tax5);
        contentmap.put("tax6", Message.tax6);
        contentmap.put("tax7", Message.tax7);
        contentmap.put("tax8", Message.tax8);
        contentmap.put("appoint", Message.appoint);
        contentmap.put("info1", Message.info1);
        contentmap.put("info2", Message.info2);
        contentmap.put("info3", Message.info3);
        contentmap.put("info4", Message.info4);
        contentmap.put("info5", Message.info5);
        contentmap.put("info6", Message.info6);

//        JsonArray.add(contentmap);//将JSONObject对象添加到Json数组中


        //map to jsonstr

        String contentstr = GsonUtil.GsonString(contentmap);
        Log.d("contentstr",contentstr);


        //生成合同
        try {
            query(mplatformName, mclientName, mclientCode, mcontractTemplateName,
                    contentmap, mcustomerIds, mcontractName, msendType, mtype,
                    msignKeyType
            );
        } catch (Exception e) {
            DialogUtil.showDialog(this
                    , "服务器响应异常，请稍后再试！", false);
            e.printStackTrace();
        }
    }

    // 定义发送请求的方法
    private void query(String platformName, String clientName, String clientCode
            , String contractTemplateName, Map<String,String> contentStr, Integer[] customerIds
            , String contractName, Integer sendType, String type, Integer signKeyType)
            throws Exception {
        Log.d("customerIds", String.valueOf(customerIds[0]));
        // 使用Map封装请求参数\
        Map<String, Object> map = new HashMap<String, Object>();
//        JSONObject map = new JSONObject();
        map.put("platformName", platformName);
        map.put("clientName", clientName);
        map.put("clientCode", clientCode);
        map.put("contractTemplateName", contractTemplateName);
        map.put("content", contentStr);
        map.put("customerIds", customerIds);
        map.put("contractName", contractName);
        map.put("sendType", sendType);
        map.put("type", type);
        map.put("signKeyType", signKeyType);

        String jsonmap = GsonUtil.GsonString(map);
//
//        JSONObject jsonObject = JSONObject.fromObject(jsonmap);
        Map<String,Object> map1 = new HashMap<String, Object>();
        map1.put("datas",map);


        //在网页中输出中文，java在网络传输中使用"ISO-8859-1"
//        name = etContractName.getText().toString();
//        String mName = new String(name.getBytes("UTF-8"),"ISO-8859-1");
//        map.put("name", mName);


        // 定义发送请求的URL
        String url = HttpUtil.sendEventContractUrl;
        Log.v("url", url);
        // 发送请求
        Log.v("发送生成合同请求", "main9");
//        map1= new HashMap<String, Object>();
        HttpUtil.postRequest4contract(url, map1);
//        HttpUtil.post(url, map1);
        //设置回调函数
        HttpUtil.setPostResposeListner(new HttpUtil.PostResposeListner() {

            @Override
            public void back(boolean status, String result) {
                if (status == true) {
                    Log.v("result", result);

                    //取datas
                    JSONObject json = null;
                    try {
                        json = new JSONObject(result);
                        Message.contractId = json.getLong("contractId");
                        Message.code =  json.getString("code");
//
                        //用code请求页数

//                        //跳转到合同图片缩略图展示
                        ComponentName componetName = new ComponentName(
                                //这个是另外一个应用程序的包名
                                "com.example.photowallfallsdemo",
                                //这个参数是要启动的Activity
                                "com.example.photowallfallsdemo.ContractReviewActivity");
//
                        Intent intent= new Intent();
                        //我们给他添加一个参数表示从apk1传过去的
                        Bundle bundle = new Bundle();
                        bundle.putString("code", Message.code);
                        bundle.putLong("contractId", Message.contractId);
                        intent.putExtras(bundle);
                        intent.setComponent(componetName);
                        startActivity(intent);
//
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {

                    android.os.Message message = new android.os.Message();
                    Bundle bundle = new Bundle();
                    bundle.putString("toast", result);
                    Log.d("失败",result);

                    message.setData(bundle);
                    message.what = 1;//标志是哪个进程传数据
                    //处理完成后给handler发送消息
                    handler.sendMessage(message);
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "main9 Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.insurancement/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "main9 Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.insurancement/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
