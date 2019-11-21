package com.company;

import java.util.LinkedList;
import java.util.Random;

public class Snake
{
    private Random random;
    private LinkedList<SnakeCell> snakeBody;
    private Field field;
    private char direction;
    private final int border = 1;
    private final char SNAKE_VIEW = '#';

    Snake (Field field)
    {
        this.field = field;
        this.random = new Random();
    }

    public void initialSetSnake()
    {
        while(true)
        {
            int headY = getRandomY();
            int headX = getRandomX();
            direction = getRandomChoose();

            if (field.getCellView(headY, headX) == ' ')
            {
                snakeBody = new LinkedList<>();
                snakeBody.addFirst(new SnakeCell(headY, headX));
                field.setCellView(snakeBody.getFirst().getY(), snakeBody.getFirst().getX(), '#');
                break;
            }
        }
    }

    public int getSnakeHeadY()
    {
        return snakeBody.getFirst().getY();
    }

    public int getSnakeHeadX()
    {
        return snakeBody.getFirst().getX();
    }

    public int getSnakeTailY()
    {
        return snakeBody.getLast().getY();
    }

    public int getSnakeTailX()
    {
        return snakeBody.getLast().getX();
    }

    public char getSnakeView()
    {
        return SNAKE_VIEW;
    }

    private int getRandomY()
    {
        return border + random.nextInt(field.getHeight() - 2*border);
    }

    private int getRandomX()
    {
        return border + random.nextInt(field.getWeight() - 2*border);
    }

    private char getRandomChoose()
    {
        int heightPlusWeight = field.getHeight() + field.getWeight();
        int randomYplusX = getRandomY() + getRandomX();

        if (randomYplusX >= heightPlusWeight*0.25)
            return 'W';
        else if (randomYplusX >= heightPlusWeight*0.5)
            return 'S';
        else if (randomYplusX >= heightPlusWeight*0.75)
            return 'A';
        else
            return 'D';
    }

    public void moveSnake(int snakeHeadY, int snakeHeadX)
    {
        snakeBody.addFirst(new SnakeCell(snakeHeadY, snakeHeadX));
        snakeBody.removeLast();
    }

    public void resizeSnake(int snakeHeadY, int snakeHeadX)
    {
        snakeBody.addFirst(new SnakeCell(snakeHeadY, snakeHeadX));
    }

}
