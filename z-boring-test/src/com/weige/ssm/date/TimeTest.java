package com.weige.ssm.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.crypto.Data;

public class TimeTest {

	public static void main(String[] args) throws ParseException {
		String string = "2013-05-28";
		System.out.println(string.length());
		System.out.println();
		if (string.length() != 10 || !string.substring(4, 5).equals("-") || !string.substring(7, 8).equals("-")) {
			System.out.println("格式不对");
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date today = sdf.parse(sdf.format(new Date()));
		System.out.println("今日" + today);
		Date date = sdf.parse("2017-02-28");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);// 时间后挪一天
		Date result = cal.getTime();
		System.out.println("加一天后时间:" + sdf.format(result));
	}
}
