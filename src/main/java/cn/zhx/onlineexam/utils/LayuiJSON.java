package cn.zhx.onlineexam.utils;


import net.sf.json.JSONObject;

/**
 * @author zhx
 *
 *
 * @create 2019-0
 * -27-20
 */
public class LayuiJSON {
    //Layui返回格式的封装类
    public static String jsonStr(String msg,int count,Object data)  {
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", msg);
        obj.put("count",count);
        obj.put("data",data);
        return obj.toString();
    }
    public static String jsonStr(String msg,long count,Object data)  {
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", msg);
        obj.put("count",count);
        obj.put("data",data);
        return obj.toString();
    }
    //登录使用的json格式
    public static String jsonStr(String msg,int code)  {
        JSONObject obj = new JSONObject();
        obj.put("code", code);
        obj.put("msg", msg);
        return obj.toString();
    }


}
