package com.yunmall.HowTomcatWorksApps;

import java.io.UnsupportedEncodingException;

public class UTFTest {

	
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String msg = "🎀";
		for(int i = 0; i < msg.length(); i++){
			System.out.println(msg.charAt(i));
		}
		byte[] byteArr = msg.getBytes("utf-8");
//		for(int i = 0; i < byteArr.length; i++){
//			System.out.println(Integer.toBinaryString(byteArr[i]));
//		}
		System.out.println(IOSEmojiUtil.hasEmoji(msg));
	}
}
