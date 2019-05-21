package com.xul.happymall.support.utils;

import com.xul.happymall.support.enums.ExceptionEnum;
import com.xul.happymall.support.exception.HappymallSystemException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by lxu on 2018/12/14.
 */
@SuppressWarnings("all")
public class DateUtil {

    private static final Logger log = LoggerFactory.getLogger(DateUtil.class);

    public static final String ISO_DATETIME_FORMAT = "dd-MMM-yyyy HH:mm:ss";
    public static final String ISO_DATETIME_WITH_MILLISECOND_FORMAT = "dd-MMM-yyyy HH:mm:ss.SSS";
    public static final String ISO_DATE_FORMAT = "dd-MMM-yyyy";
    public static final String ISO_SHORT_DATE_FORMAT = "dd-MMM-yy";
    public static final String ISO_TIME_FORMAT = "HH:mm:ss";
    public static final String ISO_TIME_WITH_MILLISECOND_FORMAT = "HH:mm:ss.SSS";
    public static final String UNIX_LONG_DATE_FORMAT = "EEE MMM dd HH:mm:ss z yyyy";
    public static final String US_DATE_FORMAT = "MM/dd/yyyy";
    public static final String US_SHORT_DATE_FORMAT = "MM/dd/yy";

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_START = "yyyy-MM-dd 00:00:00";
    public static final String DATE_FORMAT_END = "yyyy-MM-dd 23:59:59";
    public static final String DATE_FORMAT_MONTH = "yyyy-MM";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String COMPARE_DAY = "day";
    public static final String COMPARE_TIME = "time";

    /**
     * 将日期格式化为特定的字符串(Date to String)
     *
     * @param date   java.util.Date
     * @param format 可以为null,默认格式为"yyyy-MM-dd HH:mm:ss"
     * @return 返回"yyyy-MM-dd HH:mm:ss,yyyy-MM-dd"格式的字符串,如果为空或null则的返回yyyy-MM-dd
     * HH:mm:ss
     * @throws HappymallSystemException
     */
    public static String format(Date date, String format) throws HappymallSystemException {
        if (date == null)
            return "";
        try {
            if (format == null) {
                format = DATETIME_FORMAT;
            }
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        } catch (Exception e) {
            log.error("日期格式化产生异常", e);
            throw new HappymallSystemException(ExceptionEnum.DATA_ERROR);
        }
    }

    /**
     * 将日期格式化为特定的字符串(Date to String)
     *
     * @param date java.util.Date
     * @return 返回"yyyy-MM-dd HH:mm:ss"格式的字符串
     * @throws HappymallSystemException
     */
    public static String format(Date date) throws HappymallSystemException {
        return format(date, null);
    }

    /**
     * 将日期字符串解析为日期类型(String to Date)
     *
     * @param dateString 不可心为null或空
     * @param format     可以为null,默认格式化"yyyy-MM-dd"
     * @return
     * @throws HappymallSystemException
     */
    public static Date parse(String dateString, String format) throws HappymallSystemException {
        try {
            if (format == null) {
                format = DATETIME_FORMAT;
            }
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(dateString);
        } catch (Exception e) {
            log.error("日期格式化产生异常", e);
            throw new HappymallSystemException(ExceptionEnum.DATA_ERROR);
        }
    }

    /**
     * 将日期格式化为特定的字符串(Date to String)
     *
     * @param dateString
     * @return
     * @throws HappymallSystemException
     */
    public static Date parse(String dateString) throws HappymallSystemException {
        return parse(dateString, null);
    }

    /**
     * 比较两个日期间隔，返回天数
     *
     * @param d1
     * @param d2
     * @return
     */
    public static long getPeriodDate(Date d1, Date d2) {
        return (d1.getTime() - d2.getTime()) / 1000 / 60 / 60 / 24;
    }

    /**
     * 比较两个日期间隔，返回天数
     *
     * @param d1
     * @param d2
     * @return
     */
    public static long getPeriodDate(Date d1, Date d2, String compareType) throws HappymallSystemException {
        if (COMPARE_DAY.equals(compareType)) {
            try {
                d1 = parse(format(d1, DATE_FORMAT), DATE_FORMAT);
                d2 = parse(format(d2, DATE_FORMAT), DATE_FORMAT);
            } catch (Exception e) {
                log.error("日期格式化产生异常", e);
                throw new HappymallSystemException(ExceptionEnum.DATA_ERROR);
            }
        }
        return (d1.getTime() - d2.getTime()) / 1000 / 60 / 60 / 24;
    }

    /***
     * 得到两个时间相隔的时间差
     *
     * @param start
     *            开始时间字符串 yyyy-MM-dd HH:mm:ss
     * @param end
     *            结束时间字符串 yyyy-MM-dd HH:mm:ss
     * @return XX天XX小时XX分XX秒
     */
    public static String getTimelag(String start, String end) throws HappymallSystemException {
        Date now;
        Date date;
        try {
            now = parse(start);
            date = parse(end);
            return getTimelag(now, date);
        } catch (Exception e) {
            log.error("日期格式化产生异常", e);
            throw new HappymallSystemException(ExceptionEnum.DATA_ERROR);
        }
    }

    /***
     * 得到两个时间相隔的时间差
     *
     * @param start
     *            开始时间
     * @param end
     *            结束时间
     * @return XX天XX小时XX分XX秒
     */
    public static String getTimelag(Date start, Date end) throws HappymallSystemException {
        try {
            long l = end.getTime() - start.getTime();
            long day = l / (24 * 60 * 60 * 1000);
            long hour = (l / (60 * 60 * 1000) - day * 24);
            long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            return "" + day + "天" + hour + "小时" + min + "分" + s + "秒";

        } catch (Exception e) {
            log.error("日期格式化产生异常", e);
            throw new HappymallSystemException(ExceptionEnum.DATA_ERROR);
        }
    }

    /**
     * 得到两个日期相差多少天
     *
     * @param startDate 2013-03-01
     * @param endDate   2013-03-09
     * @return
     * @throws HappymallSystemException
     */
    public static long getTimelagDay(String startDate, String endDate) throws HappymallSystemException {
        try {
            startDate = startDate + " 00:00:00";
            endDate = endDate + " 00:00:00";

            Date start = parse(startDate);
            Date end = parse(endDate);

            long l = end.getTime() - start.getTime();
            long day = l / (24 * 60 * 60 * 1000);
            return day;

        } catch (Exception e) {
            log.error("日期格式化产生异常", e);
            throw new HappymallSystemException(ExceptionEnum.DATA_ERROR);
        }
    }

    /**
     * 得到当天时间的区域 如：2011-11-04 00：00：00 ~ 2011-11-04 23：59：59
     *
     * @return
     */
    public static String[] getCurrentTimeRange() throws HappymallSystemException {
        Calendar start = Calendar.getInstance();

        start.set(Calendar.HOUR_OF_DAY, 0);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);

        Calendar end = Calendar.getInstance();

        end.set(Calendar.HOUR_OF_DAY, 23);
        end.set(Calendar.MINUTE, 59);
        end.set(Calendar.SECOND, 59);

        String[] timeRange = new String[2];
        try {
            timeRange[0] = format(start.getTime());
            timeRange[1] = format(end.getTime());
        } catch (Exception e) {
            log.error("日期格式化产生异常", e);
            throw new HappymallSystemException(ExceptionEnum.DATA_ERROR);
        }
        return timeRange;
    }

    public static String[] getTimeRange(String day) throws HappymallSystemException {
        String[] timeRange = new String[2];
        try {
            if (StringUtils.isEmpty(day)) {
                day = getSomeDay(0);
            }
            Calendar start = Calendar.getInstance();
            start.setTime(parse(day, DATE_FORMAT));
            start.set(Calendar.HOUR_OF_DAY, 0);
            start.set(Calendar.MINUTE, 0);
            start.set(Calendar.SECOND, 0);

            Calendar end = Calendar.getInstance();
            end.setTime(parse(day, DATE_FORMAT));
            end.set(Calendar.HOUR_OF_DAY, 23);
            end.set(Calendar.MINUTE, 59);
            end.set(Calendar.SECOND, 59);

            timeRange[0] = format(start.getTime());
            timeRange[1] = format(end.getTime());
        } catch (Exception e) {
            log.error("日期格式化产生异常", e);
            throw new HappymallSystemException(ExceptionEnum.DATA_ERROR);
        }
        return timeRange;
    }

    public static Date[] getTimeRangeDate(String day) throws HappymallSystemException {
        Date[] timeRange = new Date[2];
        try {
            if (StringUtils.isEmpty(day)) {
                day = getSomeDay(0);
            }
            Calendar start = Calendar.getInstance();
            start.setTime(parse(day, DATE_FORMAT));
            start.set(Calendar.HOUR_OF_DAY, 0);
            start.set(Calendar.MINUTE, 0);
            start.set(Calendar.SECOND, 0);

            Calendar end = Calendar.getInstance();
            end.setTime(parse(day, DATE_FORMAT));
            end.set(Calendar.HOUR_OF_DAY, 23);
            end.set(Calendar.MINUTE, 59);
            end.set(Calendar.SECOND, 59);

            timeRange[0] = start.getTime();
            timeRange[1] = end.getTime();
        } catch (Exception e) {
            log.error("日期格式化产生异常", e);
            throw new HappymallSystemException(ExceptionEnum.DATA_ERROR);
        }
        return timeRange;
    }

    public static String getTimeRangeToString(String day) throws HappymallSystemException {
        String[] timeRange = getTimeRange(day);
        StringBuffer s = new StringBuffer();
        try {
            s.append(timeRange[0]).append(",").append(timeRange[1]);
        } catch (Exception e) {
            log.error("日期格式化产生异常", e);
            throw new HappymallSystemException(ExceptionEnum.DATA_ERROR);
        }
        return s.toString();
    }

    /**
     * 得到某天
     *
     * @param interval
     * @return
     */
    public static String getSomeDay(int interval) throws HappymallSystemException {
        String day = null;
        try {
            Calendar now = Calendar.getInstance();
            now.set(Calendar.DAY_OF_MONTH, now.get(Calendar.DAY_OF_MONTH) + interval);
            day = format(now.getTime(), DATE_FORMAT);
        } catch (Exception e) {
            log.error("日期格式化产生异常", e);
            throw new HappymallSystemException(ExceptionEnum.DATA_ERROR);
        }
        return day;
    }

    /**
     * 得到某天
     *
     * @param interval
     * @return
     */
    public static Date getSomeDayToDate(int interval) {
        Calendar now = Calendar.getInstance();
        now.set(Calendar.DAY_OF_MONTH, now.get(Calendar.DAY_OF_MONTH) + interval);
        return now.getTime();
    }

    public static Date addMinute(Date date, int minute) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minute);
        return cal.getTime();
    }

    public static Date addSecond(Date date, int second) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, second);
        return cal.getTime();
    }

    /**
     * @param date
     * @param days
     * @return Date
     */
    public static Date addDays(Date date, int days) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, days);
        return cal.getTime();
    }

    /**
     * @param date
     * @param months
     * @return
     */
    public static Date addMonths(Date date, int months) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }

    /**
     * 得到日期差
     *
     * @param fromDate
     * @param toDate
     * @return long
     */
    public static long getDayGap(Date fromDate, Date toDate, boolean includeToday) {
        long day = (toDate.getTime() - fromDate.getTime()) / 1000 / 3600 / 24;
        return includeToday ? day + 1 : day;
    }

    /**
     * 得到当前月份
     *
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        if (date == null) return -1;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 得到当前日期
     *
     * @param date
     * @return
     */
    public static int getDay(Date date) {
        if (date == null) return -1;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 判断是否在两日期之间
     *
     * @param fromDate
     * @param toDate
     * @param compareDate
     * @return
     */
    public static boolean isBetween(Date fromDate, Date toDate, Date compareDate) {
        return isBetween(fromDate, toDate, compareDate, COMPARE_DAY);
    }

    /**
     * 判断是否在两日期之间
     *
     * @param fromDate
     * @param toDate
     * @param compareDate
     * @param compareStyle
     * @return
     */
    public static boolean isBetween(Date fromDate, Date toDate, Date compareDate, String compareStyle) {
        if (compareDate == null) {
            return false;
        }
        assert fromDate != null : "From Date is null";
        assert toDate != null : "To date is null";
        if (isBeforeOrEqual(toDate, compareDate, compareStyle) && isAfterOrEqual(fromDate, compareDate, compareStyle)) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Compare two dates, if COMPARE_DAY then compare two dates ignore time.
     * If COMPARE_TIME, then will compare two dates with time.
     * */
    /*************************Compare date 1 before date 2*********************************/
    public static boolean isBefore(Date referDate, Date compareDate) {
        return isBefore(referDate, compareDate, COMPARE_DAY);
    }

    public static boolean isBefore(Date referDate, Date compareDate, String compareStyle) {
        return before(referDate, compareDate, false, compareStyle);
    }

    public static boolean isBeforeOrEqual(Date referDate, Date compareDate) {
        return isBeforeOrEqual(referDate, compareDate, COMPARE_DAY);
    }

    public static boolean isBeforeOrEqual(Date referDate, Date compareDate, String compareStyle) {
        return before(referDate, compareDate, true, compareStyle);
    }

    /*************************Compare date 1 after date 2*********************************/

    public static boolean isAfter(Date referDate, Date compareDate) {
        return isAfter(referDate, compareDate, COMPARE_DAY);
    }

    public static boolean isAfter(Date referDate, Date compareDate, String compareStyle) {
        return after(referDate, compareDate, false, compareStyle);
    }

    public static boolean isAfterOrEqual(Date referDate, Date compareDate) {
        return isAfterOrEqual(referDate, compareDate, COMPARE_DAY);
    }

    public static boolean isAfterOrEqual(Date referDate, Date compareDate, String compareStyle) {
        return after(referDate, compareDate, true, compareStyle);
    }

    /*************************Compare date 1 and date 2 at the same day*********************************/

    public static boolean isEqual(Date referDate, Date compareDate) {
        return isEqual(referDate, compareDate, COMPARE_DAY);
    }

    public static boolean isEqual(Date referDate, Date compareDate, String compareStyle) {
        if (!COMPARE_DAY.equals(compareStyle) && !COMPARE_TIME.equals(compareStyle)) {
            log.error("Can't identify compare way. Use compare day as default");
            compareStyle = COMPARE_DAY;
        }
        if (COMPARE_TIME.equals(compareStyle)) {
            return compareDate.getTime() == referDate.getTime();
        }

        if (COMPARE_DAY.equals(compareStyle)) {
            Calendar referCal = Calendar.getInstance();
            referCal.setTime(referDate);

            Calendar compareCal = Calendar.getInstance();
            compareCal.setTime(compareDate);
            if (compareCal.get(Calendar.YEAR) != referCal.get(Calendar.YEAR)) return false;
            if (compareCal.get(Calendar.MONTH) != referCal.get(Calendar.MONTH)) return false;
            if (compareCal.get(Calendar.DAY_OF_YEAR) != referCal.get(Calendar.DAY_OF_YEAR)) return false;
            return true;
        }

        return false;
    }

    private static boolean before(Date referDate, Date compareDate, boolean allowEqual, String compareStyle) {
        if (referDate == null || compareDate == null) {
            log.error("+++++ before .Refer Date and Compare Date should not be null. +++++");
        } else {
            if (!COMPARE_DAY.equals(compareStyle) && !COMPARE_TIME.equals(compareStyle)) {
                log.error("Can't identify compare way. Use compare day as default");
                compareStyle = COMPARE_DAY;
            }
            if (COMPARE_TIME.equals(compareStyle)) {
                if (allowEqual) {
                    return compareDate.getTime() <= referDate.getTime();
                } else {
                    return compareDate.getTime() < referDate.getTime();
                }
            }

            if (COMPARE_DAY.equals(compareStyle)) {
                Calendar referCal = Calendar.getInstance();
                referCal.setTime(referDate);

                Calendar compareCal = Calendar.getInstance();
                compareCal.setTime(compareDate);
                if (compareCal.get(Calendar.YEAR) < referCal.get(Calendar.YEAR)) {
                    return true;
                } else {
                    if (compareCal.get(Calendar.YEAR) > referCal.get(Calendar.YEAR)) {
                        return false;
                    }
                    if (compareCal.get(Calendar.MONTH) < referCal.get(Calendar.MONTH)) {
                        return true;
                    } else {
                        if (compareCal.get(Calendar.MONTH) > referCal.get(Calendar.MONTH)) {
                            return false;
                        }
                        if (allowEqual) {
                            return compareCal.get(Calendar.DAY_OF_YEAR) <= referCal.get(Calendar.DAY_OF_YEAR);
                        }
                        return compareCal.get(Calendar.DAY_OF_YEAR) < referCal.get(Calendar.DAY_OF_YEAR);
                    }
                }
            }

        }

        return false;
    }

    private static boolean after(Date referDate, Date compareDate, boolean allowEqual, String compareStyle) {
        if (!COMPARE_DAY.equals(compareStyle) && !COMPARE_TIME.equals(compareStyle)) {
            log.error("Can't identify compare way. Use compare day as default");
            compareStyle = COMPARE_DAY;
        }
        if (COMPARE_TIME.equals(compareStyle)) {
            if (allowEqual) {
                return compareDate.getTime() >= referDate.getTime();
            } else {
                return compareDate.getTime() > referDate.getTime();
            }
        }

        if (COMPARE_DAY.equals(compareStyle)) {
            Calendar referCal = Calendar.getInstance();
            referCal.setTime(referDate);

            Calendar compareCal = Calendar.getInstance();
            compareCal.setTime(compareDate);
            if (compareCal.get(Calendar.YEAR) > referCal.get(Calendar.YEAR)) {
                return true;
            } else {
                if (compareCal.get(Calendar.YEAR) < referCal.get(Calendar.YEAR)) {
                    return false;
                }
                if (compareCal.get(Calendar.MONTH) > referCal.get(Calendar.MONTH)) {
                    return true;
                } else {
                    if (compareCal.get(Calendar.MONTH) < referCal.get(Calendar.MONTH)) {
                        return false;
                    }
                    if (allowEqual) {
                        return compareCal.get(Calendar.DAY_OF_YEAR) >= referCal.get(Calendar.DAY_OF_YEAR);
                    }
                    return compareCal.get(Calendar.DAY_OF_YEAR) > referCal.get(Calendar.DAY_OF_YEAR);
                }
            }
        }

        return false;
    }

    public static List<String> getListDay(String beginTime, String endTime, String dateTimeFormat)
            throws HappymallSystemException {
        List<String> list = new ArrayList<String>();

        Date endDay = parse(endTime, DATE_FORMAT);
        Date beginDay = parse(beginTime, DATE_FORMAT);
        Calendar startDay = Calendar.getInstance();
        startDay.setTime(beginDay);

        long l = endDay.getTime() - beginDay.getTime();

        long day = l / (24 * 60 * 60 * 1000);

        for (int i = 0; i <= (int) day - 1; i++) {
            startDay.add(Calendar.DATE, 1);
            list.add(format(startDay.getTime(), dateTimeFormat));
        }
        return list;
    }

    public static Date getLast7Day(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        date = calendar.getTime();
        return date;
    }

    public static Date getLastDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        return date;
    }

    private DateUtil() {
    }
}
