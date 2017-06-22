package com.secondproject.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.util.naver.Search;

@WebServlet("/searchTest")
public class SearchTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clientId = "HI7oAnTDg6I_l3gyYakf";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "gqOC6yp27Q";// 애플리케이션 클라이언트 시크릿값";
		try {
			String text = URLEncoder.encode("그린팩토리", "UTF-8");
			String apiURL = "https://openapi.naver.com/v1/search/local.json?query=" + text; // json
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"));
			}
			String inputLine;
			StringBuffer response2 = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response2.append(inputLine);
			}
			br.close();
			String data = response2.toString();
			System.out.println(data);
			System.out.println(new String(data.getBytes(), "euc-kr"));
			response.setContentType("text/plain; charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.print(new String(data.getBytes(), "euc-kr"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
