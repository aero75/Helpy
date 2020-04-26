package com.example.helpy.logic;

/**
 * This class describes the reminder Object.
 * Each reminder that the user wishes to create will be created here.
 */


public class Reminders {

    /**Remind message String.*/
    private String remind;

    /**hours value of time.*/
    private int hours;

    /**Minutes value of time.*/
    private int minutes;

    /**If it is in the AM or the PM.*/
    private boolean isItMorning;

    /**
     * Reminder Object. Creates a reminder with a specified thing to remind you about and the time of the message.
     * All input is provided by the uses and it will throw an illegal argument exception based on what the error is.
     * @param remind What needs to be reminded
     * @param hours the hour of the time
     * @param minutes the minutes of the time
     * @param isItMorning if it is AM or PM
     */

    public Reminders(final String remind, final int hours, final int minutes, final boolean isItMorning) {

        this.hours = hours;
        this.remind = remind;
        this.minutes = minutes;
        this.isItMorning = isItMorning;

    }

    /**
     * returns hours.
     * @return this.hours the hours unit
     */
    public int getHours() {

        return this.hours;

    }

    /**
     * returns minutes.
     * @return this.mintes the hours unit
     */
    public int getMinutes() {

        return this.minutes;

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
    public boolean getIsItMorning() {

        return this.isItMorning;

    }

    /**
     * changes hours.
     * @param hours the hours unit
     */
    public void setHours(int hours) {

        this.hours = hours;

    }

    /**
     * changes minutes.
     * @param minutes the hours unit
     */
    public void setMinutes(int minutes) {

        this.minutes = minutes;

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
     * @param morning the hours unit
     */
    public void setIsItMorning(boolean morning) {

        this.isItMorning = morning;

    }

    /**
     * checks if this time is greater than or less than another time
     * @param other the other time.
     */
    public boolean isLater(Reminders other) {

        // checks if other is in the morning or not
        if (other.getIsItMorning() && !this.isItMorning)
            return false;


        // checks if the hours is lesser
        if (other.hours < this.hours)
            return false;

        // checks minutes
        if (other.minutes < this.minutes)
            return false;

        // thus, it is later, so return true;
        return true;
    }
}
