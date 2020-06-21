package cn.zhx.onlineexam.utils;

import java.util.Random;

/**
 * @author zhx
 * @create 2019-07-20-20
 */
public class StringUtil {

    /**
     * 判断是否是空
     */
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断是否不是空
     */
    public static boolean isNotEmpty(String str) {
        if ((str != null) && !"".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 格式化模糊查询
     */
    public static String formatLike(String str) {
        if (isNotEmpty(str)) {
            return "%" + str + "%";
        } else {
            return null;
        }
    }

    public static String getRandomString(int length) {
        String str = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
    public static String displayWithComma(String str) {
        String str2 = "";
        try {
            str = new StringBuffer(str).reverse().toString(); // 先将字符串颠倒顺序
            int size = (str.length() % 3 == 0) ? (str.length() / 3) : (str.length() / 3 + 1); // 每三位取一长度
            //比如把一段字符串分成n段,第n段可能不是三个数,有可能是一个或者两个,
            //现将字符串分成两部分.一部分为前n-1段,第二部分为第n段.前n-1段，每一段加一",".而第n段直接取出即可
            for (int i = 0; i < size - 1; i++) { // 前n-1段
                str2 += "INSERT INTO user VALUES('160"+getRandomString(3)+"','学生','e10adc3949ba59abbe56e057f20f883e','"+str.substring(i * 3, i * 3 + 3)+"',"+"'"+getRandomString(10)+"@qq.com','"+getRandomString(11)+"',111,0);";
            }
            return str2;
        } catch (Exception e) {
            return null;
        }
    }
    public static void main(String[] args) {
      //  "INSERT INTO user VALUES('160"+getRandomString(3)+"','学生','e10adc3949ba59abbe56e057f20f883e',++)
        System.out.println(displayWithComma("谢青香余白凝沈人萍周巧茹刘清舒罗忆雪吕访枫文晓亦高东玲孙瑞绣叶飞烟唐蕊珠苏寒珊秦白莲易兰梦赵芸莹袁丽思邓海菡曹琳敏姚丹萱程仲媛夏夜雪刘书蝶丁艾玲陈晨辰方映菡漕凝蝶龚天媛乔秋珊曾清怡石韫玉陈如仪曾青香黎庄雅康渲染何浩岚萧家美于雨柏邵雨莹汤曼妮"));
        System.out.println(getRandomString(3));
    }
}
