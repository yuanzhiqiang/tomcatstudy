package com.yunmall.HowTomcatWorksApps;


import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
  
  
public class IOSEmojiUtil {  
      
    public static String[] ios5emoji ;  
    public static String[] ios4emoji ;  
    public static String[] androidnullemoji ;  
    public static String[] adsbuniemoji;  
      
    public static void initios5emoji(String[] i5emj,String[] i4emj,String[] adnullemoji,String[] adsbemoji){  
        ios5emoji = i5emj;  
        ios4emoji = i4emj;  
        androidnullemoji = adnullemoji;  
        adsbuniemoji = adsbemoji;  
    }  
      
      
    //eg. param: 0xF0 0x9F 0x8F 0x80  
    public static String hexstr2String(String hexstr) throws UnsupportedEncodingException{  
        byte[] b = hexstr2bytes(hexstr);  
        return new String(b, "UTF-8");  
    }  
      
    //eg. param: E018  
    public static String sbunicode2utfString(String sbhexstr) throws UnsupportedEncodingException{  
        byte[] b = sbunicode2utfbytes(sbhexstr);  
        return new String(b, "UTF-8");  
    }  
      
    //eg. param: 0xF0 0x9F 0x8F 0x80  
    public static byte[] hexstr2bytes(String hexstr){  
        String[] hexstrs = hexstr.split(" ");  
        byte[] b = new byte[hexstrs.length];  
          
        for(int i=0;i<hexstrs.length;i++){  
            b[i] = hexStringToByte(hexstrs[i].substring(2))[0];  
        }  
        return b;  
    }  
      
    //eg. param: E018  
    public static byte[] sbunicode2utfbytes(String sbhexstr) throws UnsupportedEncodingException{  
        int inthex = Integer.parseInt(sbhexstr, 16);  
        char[] schar = {(char)inthex};  
        byte[] b = (new String(schar)).getBytes("UTF-8");  
        return b;  
    }  
      
    public static byte[] hexStringToByte(String hex) {  
        int len = (hex.length() / 2);  
        byte[] result = new byte[len];  
        char[] achar = hex.toCharArray();  
        for (int i = 0; i < len; i++) {  
            int pos = i * 2;  
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));  
        }  
        return result;  
    }  
  
  
    private static byte toByte(char c) {  
        byte b = (byte) "0123456789ABCDEF".indexOf(c);  
        return b;  
    }  
    /**
     * 检查是否含有emoji符号
     * @param str
     * @return
     */
    public static boolean hasEmoji(String str){
    	if(StringUtils.isBlank(str)){
    		return false;
    	}
    	Matcher m = patm.matcher(str);
    	return m.find(); 
    }
    
    /**
     * 检查是否含有emoji字符串
     * @param str
     * @return
     */
    public static boolean hasEmojiTxt(String str){
    	if(StringUtils.isBlank(str)){
    		return false;
    	}
    	Matcher m = patMU8.matcher(str);
    	return m.find(); 
    }
    
//    public static String PARTN_EMOJI="[\\uD83C-\\uD83D][\\uDC00-\\uDE0A]";
    public static String PARTN_EMOJI="([\\uD83D\\uDC0D-\\uD83D\\uDEC0])|([\\uD83C\\uDC04-\\uD83C\\uDFF0])|([\\u2122-\\u2B55])|([\\u0023-\\u0039])\\u20E3|\\u00AE|\\u00A9|\\u303D|\\u3297|\\u3299";
    public static Pattern patm = Pattern.compile(PARTN_EMOJI);

    public static String PARTN_EMOJI_UTF8="\\[:(u([0-9A-F]){4}){1,2}\\]";
    public static Pattern patMU8 = Pattern.compile(PARTN_EMOJI_UTF8);
       
//    public static void main(String[] args) throws UnsupportedEncodingException {  
//        // TODO Auto-generated method stub  
//    	
//    	System.out.println(hasEmoji(null));
////    	System.out.println((byte)Integer.parseInt("E2",16));
////    	
////        byte[] b1 = {-30,-102,-67}; //ios5 //0xE2 0x9A 0xBD       
////        byte[] b5 = {-62,-87}; //ios5 //0xE2 0x9A 0xBD       
////        String dd = new String(b5,"utf-8");
////        System.out.println(HexUtils.toHexString(dd.getBytes()));
////        System.out.println(hasEmoji(dd));
////  
//    }  
      
}  