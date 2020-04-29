package com.example.helpy.logic;


/**
 * This class describes the reminder Object.
 * Each reminder that the user wishes to create will be created here.
 */


public class Reminders {

    /**Remind message String.*/
    private String remind;

    /**days value of time.*/
    private int date;

    /**months value of time.*/
    private int month;

    /**years value of time. */
    private int year;

    /**
     * Reminder Object. Creates a reminder with a specified thing to remind you about and the time of the message.
     * All input is provided by the uses and it will throw an illegal argument exception based on what the error is.
     * @param remind What needs to be reminded
     * @param date the hour of the time
     * @param month the minutes of the time
     * @param year if it is AM or PM
     */

    public Reminders(final String remind, final int date, final int month, final int year) {

        this.date = date;
        this.remind = remind;
        this.month = month;
        this.year = year;

    }

    public Reminders() {

        this.date = 0;
        this.remind = null;
        this.month = 0;
        this.year = 0;

    }

    /**
     * returns hours.
     * @return this.hours the hours unit
     */
    public int getMonth() {

        return this.month;

    }

    /**
     * returns minutes.
     * @return this.mintes the hours unit
     */
    public int getDate() {

        return this.date;

    }

    /**
     * returns the message.
     * @return this.remind the hours unit
     */
    public String getRemind() {

        return this.remind;

    }

    /**
     * returns if it is noon.
     * @return this.isItNoon the hours unit
     */
    public int getYear() {

        return this.year;

    }

    /**
     * changes hours.
     * @param date the hours unit
     */
    public void setDate(int date) {

        this.date = date;

    }

    /**
     * changes minutes.
     * @param month the hours unit
     */
    public void setMonth(int month) {

        this.month = month;

    }

    /**
     * changes the remind message.
     * @param remind the hours unit
     */
    public void setRemind(String remind) {

        this.remind = remind;

    }

    /**
     * changes the am or pm.
     * @param year the hours unit
     */
    public void setYear(int year) {

        this.year = year;

    }

    /**
     * checks if this time is greater than or less than another time
     * @param other the other time.
     */
    public boolean isLater(Reminders other) {

        // checks if other is in the morning or not
        if (other.getYear() < this.getYear())
            return false;


        // checks if the hours is lesser
        if (other.getMonth() < this.month)
            return false;

        // checks minutes
        if (other.getDate() < this.date)
            return false;

        // thus, it is later, so return true;
        return true;
    }
}
