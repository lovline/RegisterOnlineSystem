package com.tusheng.oa;

import java.io.UnsupportedEncodingException;

public class Helper {
	public static String toUTF8(String src){
		String utf8Str="";
		try {
			utf8Str = new String(src.getBytes("ISO-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return utf8Str;
	}

}
