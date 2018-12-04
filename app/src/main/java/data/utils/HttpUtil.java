package data.utils;

/**
 * Created by shangxue on 16/8/26.
 */

import android.util.Log;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class HttpUtil {

    public static final int HTTP_TIMEOUT = 60000;//毫秒

    public static String sendEventContractUrl = "http://192.168.3.117:8080/webapi/sendEventContract";
    public static String getImageByCodeUrl = "http://192.168.3.117:8080/mobileapi/contract/getImageByCode";

    public static String responseBody = null;
    public static String testRetrun= null;

    public static HttpClient httpClient = new DefaultHttpClient();
    public static String TAG = "jsonStr";

    private static String ENCODING = "UTF-8";

    //回调
    public static interface PostResposeListner{

        public void back(boolean status, String result) throws JSONException;

    }

    static PostResposeListner postResposeListner;

    public static void setPostResposeListner(PostResposeListner Listner) {
        postResposeListner = Listner;
    }

    public static String post(String url, Map<String, Object> paramsMap) {
        CloseableHttpClient client = null;
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            client = HttpClients.createDefault();
            if (paramsMap != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (Map.Entry<String, Object> param : paramsMap.entrySet()) {
                    System.out.println(param.getKey()+ ":" + param.getValue());
                    NameValuePair pair = new BasicNameValuePair(param.getKey(),
                            param.getValue().toString());
                    paramList.add(pair);
                }
                method.setEntity(new UrlEncodedFormEntity(paramList, ENCODING));
            }
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity);
                System.out.println(responseText);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }


    /**
     * @param url 发送事件证书的请求
     * @param rawParams 请求参数
     *                   获取并保存code contractId
     * @return 服务器响应字符串
     * @throws Exception
     */
    public static void postRequest4contract(final String url
            , final Map<String ,Object> rawParams)throws Exception
    {
        FutureTask<String> task = new FutureTask<String>(
                new Callable<String>()
                {
                    @Override
                    public String call() throws Exception
                    {
                        // 创建httppost对象
                        Log.v("post","request");
                        HttpPost post = new HttpPost(url);

                        // 参数封装
//                        List<NameValuePair> params =
//                                new ArrayList<NameValuePair>();
//
//                        for(String key : rawParams.keySet())
//                        {
//                            //封装请求参数
//
//                            params.add(new BasicNameValuePair(key
//                                    , rawParams.get(key)));
//                            Log.v("参数封装","ddddowjeoijrwje");
//                            Log.v(key, rawParams.get(key));
//                        }


                        String JsonString = GsonUtil.GsonString(rawParams);
                        Log.v(TAG,JsonString);

                        StringEntity STE = new StringEntity(JsonString);
                        post.setEntity(STE);


                        //header
//                        post.addHeader("token", com.aisino.anysign.data.Message.tokenStrings);
//                        Log.v("token", com.aisino.anysign.data.Message.tokenStrings);

                        // 发出post请求
                        HttpResponse httpResponse = httpClient.execute(post);
                        Log.d("服务器响应",httpResponse.getStatusLine()
                                .getStatusCode()+"");


                        // 如果服务器成功地返回响应
                        if (httpResponse.getStatusLine()
                                .getStatusCode() == 200)
                        {
                            Log.v("服务器响应","200");
                            // 获取服务器响应字符串
                            String result = EntityUtils
                                    .toString(httpResponse.getEntity());

                            Log.e("实体",""+result.substring(5,20));

                            JSONObject json = new JSONObject(result);

                            Log.v("status",""+json.getInt("status"));
                            Log.v("message",json.getString("message"));

                            if (json.getInt("status") == 0){
                                Log.d("status","0");
                                postResposeListner.back(true,json.getString("datas"));
                            }else
                                Log.d("status",json.getString("message"));
                                postResposeListner.back(false,json.getString("message"));
                            return result;
                        }
                        return null;
                    }
                });
        new Thread(task).start();

    }
    /**
     * @param url 不带token的请求
     * @param rawParams 请求参数
     *                  获取并保存code contractId
     * @return 服务器响应字符串
     * @throws Exception
     */
    public static void postRequest(final String url
            , final Map<String ,String> rawParams)throws Exception
    {
        FutureTask<String> task = new FutureTask<String>(
                new Callable<String>()
                {
                    @Override
                    public String call() throws Exception
                    {
                        // 创建httppost对象
                        Log.v("post","request");
                        HttpPost post = new HttpPost(url);

                        // 参数封装
                        List<NameValuePair> params =
                                new ArrayList<NameValuePair>();

                        for(String key : rawParams.keySet())
                        {
                            //封装请求参数
                            params.add(new BasicNameValuePair(key
                                    , rawParams.get(key)));
                            Log.v("参数封装","ddddowjeoijrwje");
                            Log.v(key,rawParams.get(key));
                        }


                        String JsonString = GsonUtil.GsonString(rawParams);
                        Log.i("Json",JsonString);
                        System.out.println(JsonString);

                        StringEntity STE = new StringEntity(JsonString);
                        post.setEntity(STE);

                        // 发出post请求
                        HttpResponse httpResponse = httpClient.execute(post);

                        // 如果服务器成功地返回响应
                        if (httpResponse.getStatusLine()
                               .getStatusCode() == 200)
                        {
                            Log.v("服务器响应","200");
                            // 获取服务器响应字符串
                            String result = EntityUtils
                                    .toString(httpResponse.getEntity());

                            Log.e("实体",""+result.substring(5,20));

                            JSONObject json = new JSONObject(result);

                            Log.v("status",""+json.getInt("status"));
                            Log.v("message",json.getString("message"));

                            if (json.getInt("status") == 0){
                                postResposeListner.back(true,json.getString("datas"));
                            }else
                                postResposeListner.back(false,json.getString("message"));
                            return result;
                        }
                        return null;
                    }
                });
        new Thread(task).start();
    }

    /**
     * @param url 验证token请求URL
     *            参数为token
     * @return 服务器响应字符串
     * @throws Exception
     */
//    public static void postRequest(final String url
//            , final String tokenstr )throws Exception
//    {
//        FutureTask<String> task = new FutureTask<String>(
//                new Callable<String>()
//                {
//                    @Override
//                    public String call() throws Exception
//                    {
//                        Log.v("eee","eeee");
//                        Log.v("post_token",tokenstr);
//
//                        // 创建httppost对象
//                        HttpPost post = new HttpPost(url);
//
//                        JSONObject object = new JSONObject();
//                        object.put("token",tokenstr);
//
//                        StringEntity STE = new StringEntity(object.toString());
//                        post.setEntity(STE);
//
//                        // 发出post请求
//                        HttpResponse httpResponse = httpClient.execute(post);
//
//                        //如果服务器成功地返回相应
//                        if (httpResponse.getStatusLine()
//                                .getStatusCode() == 200) {
//                            Log.v("服务器响应","200");
//
//                            //获取服务器相应字符串
//                            String result = EntityUtils
//                                    .toString(httpResponse.getEntity());
//
//                            Log.e("实体",""+result);
//
//                            JSONObject json = new JSONObject(result);
//
//                            Log.v("status",""+json.getInt("status"));
//                            Log.v("message",json.getString("message"));
//
//                            if (json.getInt("status") == 0){
//                                postResposeListner.back(true,json.getString("message"));
//                            }else
//                                postResposeListner.back(false,json.getString("message"));
//
//                            return result;
//                        }
//
//                        return null;
//                    }
//                });
//        new Thread(task).start();
//
//    }
    /**
     * @param url 获取历史记录
     *            参数为pageNum，pageSize
     * @return 服务器响应字符串
     * @throws Exception
     */
//    public static void postRequest(final String url
//            , final int pageNum, final int pageSize )throws Exception
//    {
//        FutureTask<String> task = new FutureTask<String>(
//                new Callable<String>()
//                {
//                    @Override
//                    public String call() throws Exception
//                    {
//                        Log.v("hhh","hhhhhh");
//
//                        // 创建httppost对象
//                        HttpPost post = new HttpPost(url);
//
//                        JSONObject object = new JSONObject();
//                        StringEntity STE = new StringEntity(object.toString());
//                        post.setEntity(STE);
//
//                        //header
//                        post.addHeader("token", com.aisino.anysign.data.Message.tokenStrings);
//
//                        // 发出post请求
//                        HttpResponse httpResponse = httpClient.execute(post);
//
//                        //如果服务器成功地返回相应
//                        if (httpResponse.getStatusLine()
//                                .getStatusCode() == 200) {
//                            Log.v("服务器响应","200");
//
//                            //获取服务器相应字符串
//                            String result = EntityUtils
//                                    .toString(httpResponse.getEntity());
//
//                            Log.e("实体",""+result);
//
//                            JSONObject json = new JSONObject(result);
//
//                            Log.v("status",""+json.getInt("status"));
//                            Log.v("message",json.getString("message"));
//
//                            if (json.getInt("status") == 0){
//                                postResposeListner.back(true,json.getString("datas"));
//                            }else
//                                postResposeListner.back(false,json.getString("message"));
//
//                            return result;
//                        }
//
//                        return null;
//                    }
//                });
//        new Thread(task).start();
//
//    }


    /**
     * @param url 带token的请求
     * @return 服务器响应字符串
     * @throws Exception
     */
//    public static void postRequest(final String url)throws Exception
//    {
//        FutureTask<String> task = new FutureTask<String>(
//                new Callable<String>()
//                {
//                    @Override
//                    public String call() throws Exception
//                    {
//                        Log.v("fff","fffff");
//
//                        // 创建httppost对象
//                        HttpPost post = new HttpPost(url);
//
//                        JSONObject object = new JSONObject();
//                        StringEntity STE = new StringEntity(object.toString());
//                        post.setEntity(STE);
//
//                        //header
//                        post.addHeader("token", com.aisino.anysign.data.Message.tokenStrings);
//
//                        // 发出post请求
//                        HttpResponse httpResponse = httpClient.execute(post);
//
//                        //如果服务器成功地返回相应
//                        if (httpResponse.getStatusLine()
//                                .getStatusCode() == 200) {
//                            Log.v("服务器响应","200");
//
//                            //获取服务器相应字符串
//                            String result = EntityUtils
//                                    .toString(httpResponse.getEntity());
//
//                            Log.e("实体",""+result);
//
//                            JSONObject json = new JSONObject(result);
//
//                            Log.v("status",""+json.getInt("status"));
//                            Log.v("message",json.getString("message"));
//
//                            if (json.getInt("status") == 0){
//                                postResposeListner.back(true,json.getString("datas"));
//                            }else
//                                postResposeListner.back(false,json.getString("message"));
//
//
//                            return result;
//                        }
//
//                        return null;
//                    }
//                });
//        new Thread(task).start();
//
//    }

    /**
     * @param url 带token请求URL
     * 返回有Map
     * @return 服务器响应字符串
     * @throws Exception
     */
//    public static void postRequest_Map(final String url)throws Exception
//    {
//        FutureTask<String> task = new FutureTask<String>(
//                new Callable<String>()
//                {
//                    @Override
//                    public String call() throws Exception
//                    {
//                        Log.v("ggggg","ggggg");
//
//                        // 创建httppost对象
//                        HttpPost post = new HttpPost(url);
//
//                        JSONObject object = new JSONObject();
//                        StringEntity STE = new StringEntity(object.toString());
//                        post.setEntity(STE);
//
//                        //header
//                        post.addHeader("token", com.aisino.anysign.data.Message.tokenStrings);
//
//                        // 发出post请求
//                        HttpResponse httpResponse = httpClient.execute(post);
//
//                        //如果服务器成功地返回相应
//                        if (httpResponse.getStatusLine()
//                                .getStatusCode() == 200) {
//                            Log.v("服务器响应","200");
//
//                            //获取服务器相应字符串
//                            String result = EntityUtils
//                                    .toString(httpResponse.getEntity());
//
//                            Log.e("实体",""+result);
//
//                            JSONObject json = new JSONObject(result);
//
//                            Log.v("status",""+json.getInt("status"));
//                            Log.v("message",json.getString("message"));
//
//                            //取模版list
//                            /*
//                            com.aisino.anysign.data.Message.templateList = json.getString("datas");
//                            Log.v("list", com.aisino.anysign.data.Message.templateList);
//                            JSONObject jsonObject = new JSONObject(com.aisino.anysign.data.Message.templateList);
//                            Log.v("pageInfo",jsonObject.getString("pageInfo"));
//                            jsonObject = new JSONObject(jsonObject.getString("pageInfo"));
//                            Log.v("list_in_pageInfo",jsonObject.getString("list"));
//*/
//
//                            if (json.getInt("status") == 0){
//                                postResposeListner.back(true,json.getString("datas"));
//                            }else
//                                postResposeListner.back(false,json.getString("message"));
//
//
//                            return result;
//                        }
//
//                        return null;
//                    }
//                });
//        new Thread(task).start();
//
//    }
    /*
     * @param urlEnd 请求URL
     * @param params 请求参数
     * @return 服务器响应字符串
     * @throws Exception
     */
//    public static String sendPost_NO_Token (final String urlEnd, final List<NameValuePair> params){
//
//
//        JSONObject obj = new JSONObject();
//
//        System.out.println("in sendPost_NO_Token");
//
//                try {
//                    //ini
//                    String postUrl = baseUrl + urlEnd;
//                    Log.v("posturl", postUrl);
//
//                    //发起post请求
//                    HttpPost post = new HttpPost(postUrl);
//
//                    //设置请求参数
//                    post.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
//
//                    //执行post请求
//                    HttpResponse response = httpClient.execute(post);
//
//                    Log.v("code",String.valueOf(response.getStatusLine().getStatusCode()));
//
//                    //服务器success
//                    if (response.getStatusLine().getStatusCode() == 200) {
//                        Log.v("code", "200");
//
//                        //响应信息
//                        responseBody = EntityUtils.toString(response.getEntity());
//
//
//                        try {
//                            obj = new JSONObject(responseBody);
//                            String message = obj.getString("message");
//                            int status = obj.getInt("status");
//
//                            System.out.println("status:"+status);
//                            System.out.println("message:"+message);
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                        //testRetrun = responseBody.substring(5, 10);
//                        return responseBody;
//
//                    }
//                    return null;
//                    /*
//                    //entity
//                    HttpEntity entity = response.getEntity();
//                    if (entity != null) {
//                        BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()));
//                        String line = null;
//
//                        while ((line = br.readLine()) != null) {
//                            Message msg = new Message();
//                            msg.what = 0x123;
//                            msg.obj = line;
//                            Looper.prepare();
//                            handler.sendMessage(msg);
//                            Looper.loop();
//                        }
//                    }*/
//
//
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//                System.out.println("sendPost_NO_Token  END");
//
//        //  httpclient.getParams().setIntParameter(HttpConnectionParams.SO_TIMEOUT,3000); //超时设置
//        // httpclient.getParams().setIntParameter(HttpConnectionParams.CONNECTION_TIMEOUT, 3000);//连接超时
//        //  System.out.println("executing request " + post.getRequestLine());
//
//
//
//        //return testRetrun;
//        return responseBody;
//
//    }

//    public static String sendPost_with_Token(String urlEnd, String params) {
//        String responseBody = null;
//        try {
//            URL postUrl = new URL(baseUrl+ urlEnd);
//            HttpURLConnection urlConnection = (HttpURLConnection)postUrl
//                    .openConnection();
//            urlConnection.setRequestMethod("POST");
//            urlConnection.setRequestProperty("Content-Type",
//                    "application/x-www-form-urlencoded;charset=utf-8");
//            urlConnection.setRequestProperty("Content-Length",
//                    String.valueOf(params.length()));
//            urlConnection.setDoOutput(true);
//            urlConnection.setUseCaches(false);
//            urlConnection.setConnectTimeout(30000);
//            urlConnection.setReadTimeout(30000);
//            urlConnection.connect();
//
//            DataOutputStream outputStream = new DataOutputStream(
//                    urlConnection.getOutputStream());
//            outputStream.writeBytes(params);
//            outputStream.flush();
//            outputStream.close();
//
//            int respCode = urlConnection.getResponseCode();
//            if (HttpURLConnection.HTTP_OK == respCode) {
//                BufferedReader bufferedReader = new BufferedReader(
//                        new InputStreamReader(urlConnection.getInputStream(),
//                                "UTF-8"));
//                String inputLine = null;
//                StringBuffer response = new StringBuffer();
//                while (null != (inputLine = bufferedReader.readLine())) {
//                    response.append(inputLine);
//                }
//
//                bufferedReader.close();
//                responseBody = response.toString();
//            } else {
//                //TODO:
//            }
//
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        return responseBody;
//    }

    // inputstream转string
    public static String converStreamToString(InputStream inputStream)
        throws IOException
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 1;
        while ((i=inputStream.read())!=-1)
        {
            byteArrayOutputStream.write(i);

        }
        return byteArrayOutputStream.toString();
    }

    /**
     * 把json对象串转成map对象
     * @param jsonObj
     * @return map
     */
    public static Map getMapFromJsonObj(JSONObject jsonObj){
        Map map = new HashMap();
        for(Iterator iterator = jsonObj.keys(); iterator.hasNext();){
            String Key =(String) iterator.next();
            try {
                map.put(Key,jsonObj.get(Key));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


        return map;
    }

    /**
     *
     * map转换json.
     * <br>详细说明
     * @param map 集合
     * @return
     * @return String json字符串
     * @throws
     * @author slj
     */
    public static String MapToJson(Map<String, String> map) {
        Set<String> keys = map.keySet();
        String key = "";
        String value = "";
        StringBuffer jsonBuffer = new StringBuffer();
        jsonBuffer.append("{");
        for (Iterator<String> it = keys.iterator(); it.hasNext();) {
            key = (String) it.next();
            value = map.get(key);
            jsonBuffer.append(key + ":" +"\""+ value+"\"");
            if (it.hasNext()) {
                jsonBuffer.append(",");
            }
        }
        jsonBuffer.append("}");
        return jsonBuffer.toString();
    }
}
