package data.message;

import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by shangxue on 16/8/26.
 */
public class Message {

    //用户信息
    public static String platformName = null;
    public static String clientName = null;
    public static String clientCode = null;
    public static String contractTemplateName = null;

    //content which including descr
    public static HashMap<String,String> content = new HashMap<String, String>();
    public static JSONObject contentJsonObj = new JSONObject();
    public static String contentStr = new String();

    public static Integer[] customerIds = new Integer[1];

    //String name
    public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    public static String contractName = df.format(new Date());

    //Integer sendType, default=0
    public static Integer sendType = 2;//串发：2 并发：3 单发：1

    public static String type = "template";

    public static Integer signKeyType = 1;

    //main2
    public static String name = "张三";
    public static String idCard = "110123199908011536";
    public static String address = "北京市东城区";
    public static String phone = "13108899635";
    //main3
    public static String car1 = "京L8TH32";
    public static String car2 = "客车";
    public static String car3 = "家庭自用汽车";
    public static String car4 = "TGBL689213";
    public static String car5 = "THJK39Y67HJ906543";
    public static String car6 = "夏利N5";
    public static String car7 = "5";
    public static String car8 = "3.0";
    public static String car9 = "1.4980L";
    public static String car10 = "48KW";
    public static String car11 = "2016-12-28";
    //main4
    public static String limit1 = "110000元";
    public static String limit2 = "11000元";
    public static String limit3 = "10000元";
    public static String limit4 = "1000元";
    public static String limit5 = "2000元";
    public static String limit6 = "100元";
    //mainj5
    public static String cast1 = "30";
    public static String cast2 = "577.77";
    public static String cast3 = "5.78";
    public static String cast4 = "2016-12-28 0时";
    public static String cast5 = "2016-12-28 24时";
    public static String cast6 = "诉讼";
    //main6
    public static String tax1 = "1270";
    public static String tax2 = "132106689230111688";
    public static String tax3 = "350";
    public static String tax4 = "0";
    public static String tax5 = "0";
    public static String tax6 = "350";
    public static String tax7 = "B00303224268";
    public static String tax8 = "北京市朝阳区地税局";
    //main7
    public static String appoint = "1.您的车辆不享受奥运限行减免，属按尾号限行范围，进行交强险保费减免，" +
            "减免总天数为53天，减免保费87.23，减免后保费金额＝本年度交强险保费金额－减免保费金额。\n\n特别提示：" +
            "除法律法规另有规定外，投保人拥有保险合同解除权，涉及（减）退保保费的，退还给投保人。\n本单投保人为：李四";
    //main8
    public static String info1 = "1.请详细阅读保险条款，特别是责任免除和投保人、被保险人义务。\n2.收到本保险单后，" +
            "请立即核对，如有不符或遗漏，请及时通知保险人并办理变更或补充手续。\n3.保险费应一次性交清，" +
            "请您及时核对保险单和发票（收据），如有不符，请及时与保险人联系。\\n4.投保人应如实告知对保险费计算" +
            "有影响的或被保险机动车因改装、加载、改变使用性质等导致危险程度增加的重要事项，并及时通知保险人办理批改手续。"+
            "\n5.被保险人应当在交通事故发生后及时通知保险人。";
    //main9
    public static String info2 = "北京市朝阳支公司专兼业部";
    public static String info3 = "朝阳区霄云里4号";
    public static String info4 = "110105";
    public static String info5 = "95585";
    public static String info6 = "2016-12-28";

    public static Long contractId = null;
    public static String code = null;

}

