package com.wipro.bootcamp.dogage;

/**
 * Created by osnircunha on 7/13/15.
 */
public class DogAgeUtil {
    private DogAgeUtil(){ }

    public static double calculate(int index, double yearAge, double monthAge){
        double idadeTotal = 0;
        double firstYear = 0;
        double nextYears = 0;

        switch (index){
            case 0:
                firstYear = 12.5;
                nextYears = 4.49;
                break;
            case 1:
                firstYear = 12.5;
                nextYears = 5.4;
                break;
            case 2:
                firstYear = 12.5;
                nextYears = 5.95;
                break;
            case 3:
                firstYear = 12.5;
                nextYears = 7.65;
                break;
            case 4:
                firstYear = 9;
                nextYears = 8.4;
                break;
            case 5:
                firstYear = 10.5;
                nextYears = 13.42;
                break;
        }
        if(yearAge <= 2){
            idadeTotal = (firstYear * yearAge) + (firstYear * (monthAge/12));
        } else {
            idadeTotal = (firstYear * 2) + ((yearAge-2) * nextYears) + ((monthAge/12) * nextYears);
        }

        return idadeTotal;
    }
}
