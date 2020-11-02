package net.dohaw.play.corelib_s.helpers;

public class NumbersHelper {

    public static int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }

}
