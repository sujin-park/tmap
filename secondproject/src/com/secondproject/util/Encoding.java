package com.secondproject.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Encoding {

	public static String nullToBlank(String tmp) { // null포인터 없애려고 만든 메소드
		return tmp == null ? "" : tmp;
	}
	
	public static String isoToEuc(String tmp) {
		String euc = "";
		try {
			if (tmp != null) {
				euc = new String(tmp.getBytes("ISO-8859-1"), "EUC-KR");
			}
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		} return euc;

		
	}
	public static String isoToUtf(String tmp) {
		String utf = "";
		try {
			if (tmp != null) {
				utf = new String(tmp.getBytes("ISO-8859-1"), "utf-8");
			}
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		} return utf;

		
	}
	public static String urlFormat(String tmp) {
		String url = "";
		try {
			if (tmp!=null) {
			url = URLEncoder.encode(tmp, "EUC-KR"); // %B4%EB%B8%B6
			}
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		return url;
		 
	}
}
