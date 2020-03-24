package edu.unl.hcc.leetcode.microsoft;

/**
 * Given a clock time in hh:mm format, determine, to the nearest
 * degree, the angle between the hour and the minute hands.
 *
 * Bonus: When, during the course of a day, will the angle be zero?
 */
public class AngleClock {


    public static int findAngle(int hour, int min) {
        if(hour>12||hour<0||min<0||min>60) return 0;

        //find minute hand angle


        //find hour hand angle


        //get actual value

    }

    public static void main(String[] args) {
        System.out.println("Angle for 12:00 is:" + findAngle(12, 0));
        System.out.println("Angle for 6:00 is:" + findAngle(6, 0));
        System.out.println("Angle for 5:45 is:" + findAngle(5, 45));
    }
}

