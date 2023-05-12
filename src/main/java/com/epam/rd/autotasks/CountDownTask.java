package com.epam.rd.autotasks;


public class CountDownTask implements Task{
    int countdown;


    public CountDownTask(int value) {

        if (value<0){
            countdown = 0;
        } else {
            this.countdown = value;
        }
    }

    public int getValue() {
        return countdown;
    }


    @Override
    public void execute() {
        if (countdown > 0) {
            countdown--;
        }
    }

    @Override
    public boolean isFinished() {
        return countdown == 0;

    }
}
