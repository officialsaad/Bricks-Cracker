package com.usamamazhar20arid1744.myapplication;

public class Brick {

    private boolean isVisible;
    public int row,column,width,height;

    public Brick(int row, int column, int width, int height) {
        isVisible=true;
        this.row = row;
        this.column = column;
        this.width = width;
        this.height = height;
    }

    public void setVisible(){
        isVisible=false;
    }
    public boolean getVisibilty(){
        return isVisible;
    }


}
