package com.company;

import java.util.Random;

public class Eat
{
    private int y;
    private int x;
    private Field field;
    final private char eatView = '*';
    final int border = 1;

    Eat (Field field)
    {
        this.field = field;
        y = border;
        x = border;
    }

    public void setEat()
    {
        while(true)
        {
            getRandomY();
            getRandomX();
            if (field.getCellView(y, x) == field.getEmptyFieldView())
            {
                field.setCellView(y, x, eatView);
                break;
            }
        }
    }

    public char getEatView()
    {
        return eatView;
    }

    private void getRandomY()
    {
        Random random = new Random();
        y = border + random.nextInt(field.getHeight() - 2*border);
    }

    private void getRandomX()
    {
        Random random = new Random();
        x = border + random.nextInt(field.getWeight() - 2*border);
    }
}
