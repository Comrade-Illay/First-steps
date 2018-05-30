package com.company;

public class GregorianCalendar {
    public static final int JANUARY = 1;
    public static final int FEBRUARY = 2;
    public static final int MARCH = 3;
    public static final int APRIL = 4;
    public static final int MAY = 5;
    public static final int JUNE = 6;
    public static final int JULY = 7;
    public static final int AUGUST = 8;
    public static final int SEPTEMBER = 9;
    public static final int OCTOBER = 10;
    public static final int NOVEMBER = 11;
    public static final int DECEMBER = 12;

    public static final int NUMBER_OF_DAYS_IN_LONG_MONTH = 31;
    public static final int NUMBER_OF_DAYS_IN_SHORT_MONTH = 30;
    public static final int DAY_START_OF_THE_MONTH = 1;
    public static final int MONTH_START_OF_THE_YEAR = 1;

    public static final int NUMBER_OF_DAYS_IN_FEBRUARY_LEAP = 29;
    public static final int NUMBER_OF_DAYS_IN_FEBRUARY_NOT_LEAP = 28;

    public static final int HUNDREAD = 100;
    public static final int FOUR_HUNDREAD = 400;
    public static final int FOUR = 4;

    public static boolean isYearLeap(int year) {
        return ((year % FOUR == 0) && (year % HUNDREAD != 0)) ||
                ((year % FOUR == 0) && (year % HUNDREAD == 0) && (year % FOUR_HUNDREAD == 0));
    }
    public static String getDateOfTheNextDay(int day, int month, int year) {
        if ((month == JANUARY || month == MARCH || month == MAY ||
                month == JULY || month == AUGUST || month == OCTOBER) &&
                day == NUMBER_OF_DAYS_IN_LONG_MONTH) {
            day = DAY_START_OF_THE_MONTH;
            month++;
        } else if ((month == APRIL || month == JUNE || month == SEPTEMBER ||
                month == NOVEMBER) && day == NUMBER_OF_DAYS_IN_SHORT_MONTH) {
            day = DAY_START_OF_THE_MONTH;
            month++;
        } else if (month == DECEMBER && day == NUMBER_OF_DAYS_IN_LONG_MONTH) {
            day = DAY_START_OF_THE_MONTH;
            month = MONTH_START_OF_THE_YEAR;
            year++;
        } else if (month == FEBRUARY) {
            if (day < NUMBER_OF_DAYS_IN_FEBRUARY_LEAP && isYearLeap(year)) {
                day++;
            } else if (day < NUMBER_OF_DAYS_IN_FEBRUARY_NOT_LEAP && !isYearLeap(year)) {
                day++;
            } else {
                day = DAY_START_OF_THE_MONTH;
                month++;
            }
        } else day++;

        return "Day: " + day + " Month: " + month + " Year: " + year;
    }
}
