package com.dream.qixing.mobile.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author duanzuocai@gmail.com
 * @version 20110907
 * @since 2009-10-16
 * @类说明：日期的工具类，包含了字符串和日期之间转换的方法
 */
public class DateUtils {
	
	public static String dateFormatToString(Long date, String type){
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTimeInMillis(date);
	    return dateFormatToString(calendar.getTime(), type);
	}

	public static Date dateFormatToDate(Long date, String type){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date);
		return calendar.getTime();
	}
	
	/**
	 * 传入年月，得到此月天数
	 * @param endDay
	 * @param format 格式
	 * @return String
	 */
	public static String getEndDays(String endDay, String format){
		Date date;
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		try {
			date = dateFormat.parse(endDay);
			
			// 得到当天日期
			Calendar cal = Calendar.getInstance();
			// 设置指定日期
			cal.setTime(date);
			cal.set(Calendar.DAY_OF_MONTH,1);
			cal.roll(Calendar.DAY_OF_MONTH,-1);
			
			dateFormat = new SimpleDateFormat("dd");
			String rel = dateFormat.format(cal.getTime());
			
			return rel;
		} catch (ParseException e) {
			System.out.println("获取当月最后一天出错");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 传入年月，得到此月最后一天
	 * @param endDay
	 * @param format 格式
	 * @param newFormat 生成后的格式
	 * @return Date
	 */
	public static Date getEndDayToDate(String endDay, String format, String newFormat){
		Date date;
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		try {
			date = dateFormat.parse(endDay);
			
			// 得到当天日期
			Calendar cal = Calendar.getInstance();
			// 设置指定日期
			cal.setTime(date);
			cal.set(Calendar.DAY_OF_MONTH,1);
			cal.roll(Calendar.DAY_OF_MONTH,-1);
			
			dateFormat = new SimpleDateFormat(newFormat);
			String rel = dateFormat.format(cal.getTime());
			
			return dateFormat.parse(rel);
		} catch (ParseException e) {
			System.out.println("获取当月最后一天出错");
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 得到此月最后一天
	 * @param day
	 * @return
	 */
	public static Date getEndDayToDate(Date day){
		String format = "yyyyMMdd hh:mm:ss";
		String day1 = dateFormatToString(day, format);
		return getEndDayToDate(day1, format, format);
	}
	
	/**
	 * 得到这个月第一天
	 * @param day
	 * @return
	 */
	public static Date getBeginDayToDate(Date day){
		return dateFormatToDate(day, "yyyyMM");
	}

	/**
	 * 传入年月，得到此月最后一天
	 * @param endDay
	 * @param format 格式
	 * @param newFormat 生成后的格式
	 * @return String
	 */
	public static String getEndDayToString(String endDay, String format, String newFormat){
		Date date;
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		try {
			date = dateFormat.parse(endDay);
			
			// 得到当天日期
			Calendar cal = Calendar.getInstance();
			// 设置指定日期
			cal.setTime(date);
			cal.set(Calendar.DAY_OF_MONTH,1);
			cal.roll(Calendar.DAY_OF_MONTH,-1);
			
			dateFormat = new SimpleDateFormat(newFormat);
			String rel = dateFormat.format(cal.getTime());
			
			return rel;
		} catch (ParseException e) {
			System.out.println("获取当月最后一天出错");
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 把时间转换成指定格式
	 * @param date
	 * @param format
	 * @return Date
	 */
	public static Date dateFormatToDate(String date, String format){
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		
		Date rel = null;
		try {
			rel = dateFormat.parse(date);
		} catch (ParseException e) {
			System.out.println("日期格式转换出错：DateUtils.dateFormatToDate(String date, String format) ");
			e.printStackTrace();
		}
		return rel;
	}

	/**
	 * 把时间转换成指定格式
	 * @param date
	 * @param format
	 * @return Date
	 */
	public static Date dateFormatToDate(Date date, String format){
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		
		String rel = dateFormat.format(date);
		return dateFormatToDate(rel, format);
	}
	
	/**
	 * 把时间转换成指定格式
	 * @param date
	 * @param format
	 * @return String
	 */
	public static String dateFormatToString(Date date, String format){
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}
	
	/**
	 * 把 String 时间转换成指定格式
	 * @param date
	 * @param oldFormat
	 * @param newFormat
	 * @return Date
	 */
	public static Date dateFormatToDate(String date, String oldFormat, String newFormat){
		SimpleDateFormat dateFormat = new SimpleDateFormat(oldFormat);
		Date d = null;
		String d2 = null;
		try {
			d = dateFormat.parse(date);
			dateFormat = new SimpleDateFormat(newFormat);
			d2 = dateFormat.format(d);
			d = dateFormat.parse(d2);
		} catch (ParseException e) {
			System.out.println("日期格式转换出错：DateUtils.dateFormatToDate(Date date, String format) in line 148");
			e.printStackTrace();
		}
		
		//return dateFormatToString(d,newFormat);
		return new Date(d.getTime());
	}

	/**
	 * 把 String 时间转换成指定格式
	 * @param date
	 * @param oldFormat
	 * @param newFormat
	 * @return String
	 */
	public static String dateFormatToString(String date, String oldFormat, String newFormat){
		SimpleDateFormat dateFormat = new SimpleDateFormat(oldFormat);
		Date d = null;
		try {
			d = dateFormat.parse(date);
		} catch (ParseException e) {
			System.out.println("日期格式转换出错：DateUtils.dateFormatToString(Date date, String format) in line 162");
			e.printStackTrace();
		}
		
		return dateFormatToString(d,newFormat);
	}
	
	/**
	 * 相加秒
	 * @param date
	 * @param num 秒数
	 * @return Date
	 */
	public static Date dateAddSecondToDate(Date date, int num, String type){
		return DateUtils.dateFormatToDate(new Date(date.getTime() + num*1000), type);
	}
	
	/**
	 * 相加秒
	 * @param date Date
	 * @param type 精确格式
	 * @param num 秒
	 * @param returntype 返回的限定格式
	 * @return
	 */
	public static Date dateAddSecondToDate(Date date, String type, int num,
			String returntype) {
		date = dateFormatToDate(date, type);
		
		return dateAddSecondToDate(date, num, returntype);
	}
	
	/**
	 * 相加秒
	 * @param date
	 * @param num 秒数
	 * @return Date
	 */
	public static String dateAddSecondToString(Date date, int num, String type){
		return DateUtils.dateFormatToString(new Date(date.getTime() + num*1000), type);
	}
	
	/**
	 * 相加秒
	 * @param date
	 * @param type
	 * @param num
	 * @param returntype
	 * @return
	 */
	public static Date dateAddSecondToDate(String date, String type, int num, String returntype){
		return DateUtils.dateFormatToDate(new Date(dateFormatToDate(date, type).getTime() + num*1000), returntype);
	}
	
	/**
	 * 相加秒
	 * @param date
	 * @param type
	 * @param num
	 * @param returntype
	 * @return
	 */
	public static String dateAddSecondToString(String date, String type, int num, String returntype){
		return DateUtils.dateFormatToString(new Date(dateFormatToDate(date, type).getTime() + num*1000), type);
	}
	
	/**
	 * 相加指定天数
	 * @param date
	 * @param num 天数
	 * @return Date
	 */
	public static Date dateAddDays(Date date, Long num){
		Long time = date.getTime();
		time += (num * 24 * 60 * 60 * 1000); 
		return new Date(time);
	}
	
	/**
	 * 相加指定天数
	 * @param date
	 * @param l
	 * @param type
	 * @return Date
	 */
	public static Date dateAddDaysForType(Date date, long num, String type) {
		Long time = date.getTime();
		time += (num * 24 * 60 * 60 * 1000); 
		return dateFormatToDate(new Date(time), type);
	}

	/**
	 * 相加指定天数
	 * @param date
	 * @param date 的格式
	 * @param num 天数
	 * @return Date
	 */
	public static Date dateAddDays(String date, String type, Long num){
		SimpleDateFormat dateFormat = new SimpleDateFormat(type);
		Long time = 0L;
		try {
			time = dateFormat.parse(date).getTime();
			time += (num * 24 * 60 * 60 * 1000); 
			return new Date(time);
		} catch (ParseException e) {
			System.out.println("日期格式转换出错：DateUtils.dateAddDays(String date, String type, int num) in line 200");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 相加指定天数
	 * @param date
	 * @param num 天数
	 * @param returnType 返回的格式
	 * @return String
	 */
	public static String dateAddDays(Date date, Long num, String returnType){
		SimpleDateFormat dateFormat = new SimpleDateFormat(returnType);
		Long time = date.getTime();
		Date date_ = null;
		
		time += (num * 24 * 60 * 60 * 1000); 
		
		String temp = dateFormat.format(new Date(time));
		
		return temp;
	}

	/**
	 * 相加指定天数
	 * @param date
	 * @param type date 的格式
	 * @param num 天数
	 * @param returnType 返回的格式
	 * @return String
	 */
	public static String dateAddDays(String date, String type, Long num, String returnType){
		SimpleDateFormat dateFormat = new SimpleDateFormat(returnType);
		SimpleDateFormat dateFormat_ = new SimpleDateFormat(type);
		
		Long time = 0L;
		try {
			time = dateFormat_.parse(date).getTime();
			time += (num * 24 * 60 * 60 * 1000); 
			Date date_ = null;
			String temp = dateFormat.format(new Date(time));
			return temp;
		} catch (ParseException e) {
			System.out.println("日期格式转换出错：DateUtils.dateAddDays(String date, String type, int num, String returnType) in line 241");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 减去指定天数
	 * @param date
	 * @param num 天数
	 * @return Date
	 */
	public static Date dateMinusDays(Date date, Long num){
		Long time = date.getTime();
		time -= (num * 24 * 60 * 60 * 1000);
		return new Date(time);
	}

	/**
	 * 减去指定天数
	 * @param date
	 * @param type date 的格式
	 * @param num 天数
	 * @return Date
	 */
	public static Date dateMinusDays(String date, String type, Long num){
		SimpleDateFormat dateFormat = new SimpleDateFormat(type);
		
		try {
			Long time = dateFormat.parse(date).getTime();
			time -= (num * 24 * 60 * 60 * 1000); 
			return new Date(time);
		} catch (ParseException e) {
			System.out.println("日期格式转换出错：DateUtils.dateMinusDays(String date, String type, int num) in line 280");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 减去指定天数
	 * @param date
	 * @param num 天数
	 * @param returnType 返回的格式
	 * @return String
	 */
	public static String dateMinusDays(Date date, Long num, String returnType){
		SimpleDateFormat dateFormat = new SimpleDateFormat(returnType);
		Long time = date.getTime();
		Date date_ = null;
		
		time -= (num * 24 * 60 * 60 * 1000); 
		
		String temp = dateFormat.format(new Date(time));
		
		return temp;
	}

	/**
	 * 减去指定天数
	 * @param date
	 * @param type date 的格式
	 * @param num 天数
	 * @param returnType 返回的格式
	 * @return String
	 */
	public static String dateMinusDays(String date, String type, Long num, String returnType){
		SimpleDateFormat dateFormat = new SimpleDateFormat(returnType);
		SimpleDateFormat dateFormat_ = new SimpleDateFormat(type);
		
		try {
			Long time = dateFormat_.parse(date).getTime();
			
			time -= (num * 24 * 60 * 60 * 1000); 
			
			String temp = dateFormat.format(new Date(time));
			
			return temp;
		} catch (ParseException e) {
			System.out.println("日期格式转换出错：DateUtils.dateMinusDays(String date, String type, iLongnum, String returnType) in line 327");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 相加指定月数
	 * @param date
	 * @param num 月数
	 * @return Date
	 */
	public static Date dateAddMonths(Date date, Long num){
		StringBuffer time_new;
		try {
			String y = dateFormatToString(date, "yyyy");
			String m = dateFormatToString(date, "MM");
			String d = dateFormatToString(date, "dd");
			String hmsS = dateFormatToString(date, "HH:mm:ss:SSSS");
			
			int b = (int) (Integer.parseInt(m) + num);
			
			if(b > 12) {
				int y_ = b / 12;
				b = b % 12;
				if(b == 0) b = 12;
				
				y = String.valueOf(Integer.parseInt(y) + y_);
			}
			if(b < 10)
				m = "0" + b;
			else
				m = String.valueOf(b);
			time_new = new StringBuffer(y + m + d + " " + hmsS);
			return dateFormatToDate(time_new.toString(), "yyyyMMdd HH:mm:ss:SSSS","yyyyMMdd HH:mm:ss:SSSS");
		} catch (NumberFormatException e) {
			System.out.println("日期格式转换出错：lines in 369 at DateUtils.dateAddMonths(Date date, int num)");
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 相加指定月数
	 * @param date
	 * @param date 的格式
	 * @param num 月数
	 * @return Date
	 */
	public static Date dateAddMonths(String date, String type, Long num){
		Date date_ = dateFormatToDate(date, type, type);
		return dateAddMonths(date_, num);
	}
	
	/**
	 * 相加指定月数
	 * @param date
	 * @param num 月数
	 * @param returnType 返回的格式
	 * @return String
	 */
	public static String dateAddMonths(Date date, Long num, String returnType){
		Date d = dateAddMonths(date, num);
		return dateFormatToString(d, returnType);
	}
	
	/**
	 * 相加指定月数
	 * @param date
	 * @param type date 的格式
	 * @param num 月数
	 * @param returnType 返回的格式
	 * @return String
	 */
	public static String dateAddMonths(String date, String type, Long num, String returnType){
		Date date_ = dateFormatToDate(date, type, returnType);
		return dateAddMonths(date_, num, returnType);
	}
	
	/**
	 * 减去指定月数
	 * @param date
	 * @param num 月数
	 * @return Date
	 */
	public static Date dateMinusMonths(Date date, Long num){
		StringBuffer time_new;
		try {
			String y = dateFormatToString(date, "yyyy");
			String m = dateFormatToString(date, "MM");
			String d = dateFormatToString(date, "dd");
			String hmsS = dateFormatToString(date, "HH:mm:ss:SSSS");
			
			int m_ = (int) (num % 12);
			Long y_ = num / 12;
			
			m_ = Integer.parseInt(m) - m_;
			if(m_ < 1) {
				y_ += 1 ;
				m_ = m_ + 12;
				if(m_ == 0) m_ = 12;
				
			}
			y = String.valueOf(Integer.parseInt(y) - y_);
			if(m_ < 10)
				m = "0" + m_;
			else
				m = String.valueOf(m_);
			time_new = new StringBuffer(y + m + d + " " + hmsS);
			return dateFormatToDate(time_new.toString(), "yyyyMMdd HH:mm:ss:SSSS","yyyyMMdd HH:mm:ss:SSSS");
		} catch (NumberFormatException e) {
			System.out.println("日期格式转换出错：lines in 369 at DateUtils.dateAddMonths(Date date, int num)");
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 减去指定月数
	 * @param date
	 * @param type date 的格式
	 * @param num 月数
	 * @return Date
	 */
	public static Date dateMinusMonths(String date, String type, Long num){
		Date d = dateFormatToDate(date, type, "yyyyMMdd HH:mm:ss:SSSS");
		return dateMinusMonths(d, num);
	}
	
	/**
	 * 减去指定月数
	 * @param date
	 * @param num 月数
	 * @param returnType 返回的格式
	 * @return String
	 */
	public static String dateMinusMonths(Date date, Long num, String returnType){
		Date d = dateMinusMonths(date, num);
		
		return dateFormatToString(d, returnType);
	}
	
	/**
	 * 减去指定月数
	 * @param date
	 * @param type date 的格式
	 * @param num 月数
	 * @param returnType 返回的格式
	 * @return String
	 */
	public static String dateMinusMonths(String date, String type, Long num, String returnType){
		Date date_ = dateMinusMonths(date, type, num);
		return dateFormatToString(date_, returnType);
	}
	
	/**
	 * 得到星期几
	 * @param date
	 * @return
	 */
	public static String getWeek(Date date) {
		  return dateFormatToString(date, "EEEE");
	}

	/**
	 * 得到星期几
	 * @param date
	 * @return
	 */
	public static int getWeekToNumber(Date date) {
		List<String> weekDays = Arrays.asList("星期一","星期二","星期三","星期四","星期五","星期六","星期日");
		return weekDays.indexOf(dateFormatToString(date, "EEEE"))+1;
	}

	/**
	 * 得到星期几
	 * @param date
	 * @param type
	 * @return
	 */
	public static String getWeek(String date, String type) {
		return dateFormatToString(dateFormatToDate(date, type), "EEEE");
	}
	
	/**
	 * 得到下周几
	 * @param num
	 * @return Date
	 */
	public static Date getNextWeek(int num){
		if(num > 7)return new Date();
		
		return dateAddDays(new Date(), 7L - getWeekToNumber(new Date()) + num);
	}
	
	/**
	 * 得到这周几
	 * @param num
	 * @return Date 完整时间格式
	 */
	public static Date getThisWeek(int num){
		if(num > 7)return new Date();
		
		Date date = new Date();
		
		return dateAddDays(date, -(0L + getWeekToNumber(date) - num));
	}
	
	/**
	 * 得到这周几
	 * @param num
	 * @param type
	 * @return Date 完整时间格式
	 */
	public static Date getThisWeekForType(int num, String type){
		if(num > 7)return new Date();
		
		Date date = dateFormatToDate(new Date(), type);
		
		return dateAddDays(date, -(0L + getWeekToNumber(date) - num));
	}
	
	/**
	 * 得到下周几
	 * @param num
	 * @return Date
	 */
	public static Date getNextWeekForType(int num, String type){
		if(num > 7)return new Date();
		
		return dateAddDaysForType(new Date(), 7L - getWeekToNumber(new Date()) + num, type);
	}
	
	/**
	 * 得到时间差
	 * @param begin
	 * @param end
	 * @return 月数
	 */
	public static int dateMinusDateForMonths(Date begin, Date end){
		int m1 = Integer.parseInt(dateFormatToString(begin, "MM"));
		int m2 = Integer.parseInt(dateFormatToString(end, "MM"));

		int y1 = Integer.parseInt(dateFormatToString(begin, "yyyy"));
		int y2 = Integer.parseInt(dateFormatToString(end, "yyyy"));
		
		int result = (y2*12 + m2) - (y1*12 + m1);
		
		return result>0?result:result*-1;
	}
	
	/**
	 * 得到时间差
	 * @param begin
	 * @param end
	 * @return 天数
	 */
	public static long dateMinusDateForDays(Date begin, Date end) {
		long quot = 0;
		quot = end.getTime() - begin.getTime();
		quot = quot / 1000 / 60 / 60 / 24;
		return quot < 0 ? quot * -1 : quot;
	}
	

	/**
	 * 得到时间差
	 * @param begin 开始时间
	 * @param end 结束时间
	 * @param type 时间类型
	 * @return 天数
	 */
	public static long dateMinusDateForDays(String begin, String end, String type) {
		long quot = 0;
		SimpleDateFormat ft = new SimpleDateFormat(type);
		try {
			Date date1 = ft.parse(begin);
			Date date2 = ft.parse(end);
			quot = date2.getTime() - date1.getTime();
			quot = quot / 1000 / 60 / 60 / 24;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return quot < 0 ? quot * -1 : quot;
	}
	
	/**
	 * 得到时间差
	 * @param begin
	 * @param end
	 * @return 分钟
	 */
	public static long dateMinusDateForMinute(Date begin, Date end) {
		long quot = 0;
		quot = end.getTime() - begin.getTime();
		quot = quot / 1000 / 60;
		return quot < 0 ? quot * -1 : quot;
	}
	
	
	/**
	 * 得到时间差
	 * @param begin 开始时间
	 * @param end 结束时间
	 * @param type 时间类型
	 * @return 分钟
	 */
	public static long dateMinusDateForMinute(String begin, String end, String type) {
		long quot = 0;
		SimpleDateFormat ft = new SimpleDateFormat(type);
		try {
			Date date1 = ft.parse(begin);
			Date date2 = ft.parse(end);
			quot = date2.getTime() - date1.getTime();
			quot = quot / 1000 / 60;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return quot < 0 ? quot * -1 : quot;
	}
	
	/**
	 * 把时间段切分成每个月如：2010/1/2,2010/3/4 --> [1/2,1/31],[2/1,2/28],[3/1,3/4] 
	 * @param begin
	 * @param end
	 * @return 月数组's：[begin, end]
	 */
	public static List<Date[]> splitDateToDateList(Date begin, Date end){
		List<Date[]> ds = new ArrayList();
		if (dateFormatToDate(begin, "yyyyMM").getTime() > dateFormatToDate(end, "yyyyMM").getTime()) 
			return null;
		else if(dateFormatToDate(begin, "yyyyMM").getTime() == dateFormatToDate(end, "yyyyMM").getTime()){
			Date[] d = new Date[2]; 
			d[0] = begin;
			d[1] = end;
			ds.add(d);
			return ds;
		}else {
			int months = dateMinusDateForMonths(begin, end);
			for(int i = 0 ; i <= months ; i++){
				Date[] d = new Date[2];
				Date now = dateAddMonths(begin, Long.parseLong(i+""));
				if(i == 0)
					d[0] = begin;
				else
					d[0] = getBeginDayToDate(now);
				
				if(i == months)
					d[1] = end;
				else
					d[1] = getEndDayToDate(now);
				
				ds.add(d);
			}
			return ds;
		}
	}

	/**
	 * 把时间段切分成每个月如：2010/1/2,2010/3/4 --> [1/2,1/31],[2/1,2/28],[3/1,3/4] 
	 * @param begin
	 * @param end
	 * @param type 格式
	 * @return 月数组's：[begin, end]
	 */
	public static List<String[]> splitDateToStringList(Date startTime,
			Date endTime, String type) {
		List<Date[]> f_d = splitDateToDateList(startTime, endTime);
		
		List<String[]> f_s = new ArrayList();
		
		for(int i = 0; i < f_d.size(); i++){
			String[] e = new String[2];
			
			e[0] = dateFormatToString(f_d.get(i)[0], type);
			e[1] = dateFormatToString(f_d.get(i)[1], type);
			
			f_s.add(e);
		}
		return f_s;
	}
	/**
	 * 获取当前的小时数，分钟也转为小时计算.
	 * @param date
	 * @return
	 */
	
	public static  double getCurrentHour(Date date){
		Date currentDate = new Date();
		Calendar cFF = Calendar.getInstance();
		cFF.setTime(currentDate);
		int hour= cFF.get(Calendar.HOUR_OF_DAY);
		int minute=cFF.get(Calendar.MINUTE);
		double time=hour+minute/60.0;
		return time;
	}
	public static void main(String[] args) throws ParseException {
		Date end = new Date();
		Date begin = dateMinusDays(end, 66L);
		
		List<String[]> ds = splitDateToStringList(begin, end, "yyyyMMdd");
		
		for(String[] d:ds){
			for(String dd:d){
				System.out.println(dd);
			}
			System.out.println("..............");
		}
	}
	
	/**
	 * 将日期格式转换为时间戳
	 * 
	 * @param dateString
	 * @return
	 */
	public static long date2TimeStatmp(String dateString) {
		try {
			if(dateString!=null&&!"".equals(dateString)){
				Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parse(dateString);
				return date.getTime()/1000;
			}else
				return 0;
		} catch (ParseException e) {
			return 0;
		}
	}
	

}
