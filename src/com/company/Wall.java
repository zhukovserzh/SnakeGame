package com.company;

public class Wall
{
    private Field field;
    final private char WALL_VIEW = '+';

    Wall(Field field)
    {
        this.field = field;
    }

    public void setAllWalls()
    {
        setTopWall();
        setBottomWall();
        setLeftWall();
        setRightWall();
    }

    public char getWallView()
    {
        return WALL_VIEW;
    }

    private void setTopWall()
    {
        for (int x = 0; x < field.getWeight(); x++)
        {
            field.setCellView(0, x, WALL_VIEW);
        }
    }

    private void setBottomWall()
    {
        for (int x = 0; x < field.getWeight(); x++)
        {
            field.setCellView(field.getHeight() - 1, x, WALL_VIEW);
        }
    }

    private void setLeftWall()
    {
        for (int y = 0; y < field.getHeight(); y++)
        {
            field.setCellView(y, 0, WALL_VIEW);
        }
    }

    private void setRightWall()
    {
        for (int y = 0; y < field.getHeight(); y++)
        {
            field.setCellView(y, field.getWeight() - 1, WALL_VIEW);
        }
    }
}
