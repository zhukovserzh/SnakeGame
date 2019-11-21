package com.company;

public class Field
{
    final private int FIELD_HEIGHT = 10;
    final private int FIELD_WEIGHT = 30;
    private Cell[][] cellsArray;
    final private char EMPTY_FIELD_VIEW = ' ';

    Field()
    {
        cellsArray = new Cell[FIELD_HEIGHT][FIELD_WEIGHT];

        for (int y = 0; y < FIELD_HEIGHT; y++)
        {
            for (int x = 0; x < FIELD_WEIGHT; x++)
            {
                cellsArray[y][x] = new Cell(EMPTY_FIELD_VIEW);
            }
        }
    }

    public void setCellView(int y, int x, char view)
    {
        cellsArray[y][x].setView(view);
    }

    public char getCellView(int y, int x)
    {
        return cellsArray[y][x].getView();
    }

    public void show()
    {
        for (int y = 0; y < FIELD_HEIGHT; y++)
        {
            for (int x = 0; x < FIELD_WEIGHT; x++)
            {
                System.out.print(cellsArray[y][x].getView());
            }
            System.out.println();
        }
    }

    public int getHeight()
    {
        return FIELD_HEIGHT;
    }

    public int getWeight()
    {
        return FIELD_WEIGHT;
    }

    public char getEmptyFieldView()
    {
        return EMPTY_FIELD_VIEW;
    }
}
