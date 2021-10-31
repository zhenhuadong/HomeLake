package com.zhenhua.homelake.http.url;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncodeDecoderDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String url_a1 = "https://www.amazon.com/s/ref=nb_sb_noss?url=search-alias%3Daps&field-keywords=url+encode+decode";
		String url_j1 ="https://search.jd.com/Search?keyword=url%20decode%20encode&enc=utf-8&wq=url%20decode%20encode&pvid=46f60f2a1ad14add9972851e1dbce1f4";

		String url_a2 = "https://www.amazon.com/s/ref=nb_sb_noss?url=search-alias%3Daps&field-keywords=hp+ibm+apple&rh=i%3Aaps%2Ck%3Ahp+ibm+apple";
		String url_j2 ="https://search.jd.com/Search?keyword=ibm%20apple&enc=utf-8&pvid=30d56a3fe56843c0876f48711c829911";
		
		System.out.println(URLDecoder.decode(url_a1, "UTF-8"));
		System.out.println(URLDecoder.decode(url_j1, "UTF-8"));
		System.out.println(URLDecoder.decode(url_a2, "UTF-8"));
		System.out.println(URLDecoder.decode(url_j2, "UTF-8"));
		
		System.out.println(URLEncoder.encode("https://baike.baidu.com/item/���/32416?fr=aladdin", "UTF-8"));
		System.out.println(URLEncoder.encode("https://baike.baidu.com/item/%E4%BD%A0%E5%A5%BD/32416?fr=aladdin", "UTF-8"));
		System.out.println(URLDecoder.decode("https%3A%2F%2Fbaike.baidu.com%2Fitem%2F%E4%BD%A0%E5%A5%BD%2F32416%3Ffr%3Daladdin","UTF-8"));
		System.out.println(URLDecoder.decode("https://baike.baidu.com/item/%E4%BD%A0%E5%A5%BD/32416?fr=aladdin", "UTF-8"));
		
		System.out.println(URLDecoder.decode("https://search.jd.com/Search?keyword=%E7%94%B5%E8%84%91&enc=utf-8&wq=%E7%94%B5%E8%84%91&pvid=095b4d0b7a25451793d5006ddb4d0b7f", "UTF-8"));
//		System.out.println(urlEncodeDemo());
		System.out.println();
		System.out.println();
		System.out.println();

	}
	
	public static String urlEncodeDemo(String url) {
		try {
			return URLEncoder.encode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String urlDecodeDemo(String url) {
		
		try {
			URLDecoder.decode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String urlEncodeChineseDemo(String url) {
		try {
			return URLEncoder.encode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String urlDecodeChineseDemo(String url) {
		try {
			URLDecoder.decode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
