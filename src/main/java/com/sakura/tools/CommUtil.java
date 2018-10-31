package com.sakura.tools;


import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * 通用工具
 */

public class CommUtil {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private static final Whitelist user_content_filter = Whitelist.relaxed();


    /**
     * 过滤HTML
     *
     * @param content
     * @return
     */

    public static String filterHTML(String content) {
        String s = Jsoup.clean(content, user_content_filter);

        return s;
    }


    /**
     * 商品id生成
     */
    public static long genItemId() {
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //加上两位随机数
        Random random = new Random();
        int end2 = random.nextInt(99);
        //如果不足两位前面补0
        String str = millis + String.format("%02d", end2);
        long id = new Long(str);
        return id;
    }


    /**
     * 验证码随机数
     *
     * @param min 1 max 999999
     */

    public static int getRandNum(int min, int max) {
        int randNum = min + (int) (Math.random() * ((max - min) + 1));
        return randNum;
    }

    /**
     * 主要功能:生成流水号 yyyyMMddHHmmssSSS + 3位随机数
     * 注意事项:无
     *
     * @return 流水号
     */
    public static String createIdByDate() {
        // 精确到毫秒
        SimpleDateFormat fmt = new SimpleDateFormat("(yyyyMMddHHmmssSSS)");
        String suffix = fmt.format(new Date());
        suffix = suffix + "-" + Math.round((Math.random() * 100000));
        return suffix;
    }

    /**
     * 主要功能:生成uuid
     * 注意事项:无
     *
     * @return uuid 32 位
     */
    public static String createIdbyUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


    /**
     * MD5加密工具
     */
    public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }

}
