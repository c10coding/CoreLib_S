package net.dohaw.play.utilityapi.helpers;

public class NumbersHelper {

    public int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }

}
