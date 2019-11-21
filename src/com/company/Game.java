package com.company;

import java.util.Scanner;

public class Game
{
    private int userChoiseY;
    private int userChoiseX;
    private Field field;
    private Wall wall;
    private Eat eat;
    private Snake snake;

    Game ()
    {
        userChoiseY = 0;
        userChoiseX = 0;
        field = new Field();
        wall = new Wall(field);
        eat = new Eat(field);
        snake = new Snake(field);
    }

    public void play()
    {
        wall.setAllWalls();
        eat.setEat();
        snake.initialSetSnake();

        field.show();

        while(true)
        {
            showGameMenu();
            userInput();
            checkGameObjects();
            field.show();
        }
    }

    public void showGameMenu()
    {
        System.out.println();
        System.out.println("**Move Snake**");
        System.out.println("Enter your choose (W,A,S,D,E):");
        System.out.println("'W' - Up");
        System.out.println("'S' - Down");
        System.out.println("'A' - Left");
        System.out.println("'D' - Right");
        System.out.println("'E' - Exit game");
    }

    public void userInput()
    {
        userChoiseY = snake.getSnakeHeadY();
        userChoiseX = snake.getSnakeHeadX();

        Scanner input = new Scanner(System.in);
        char userInput = 'W';

        if (input.hasNext())
            userInput = input.next().toUpperCase().charAt(0);

        switch (userInput)
        {
            case 'W':
                //moveUp
                userChoiseY--;
                break;
            case 'S':
                //moveDown
                userChoiseY++;
                break;
            case 'A':
                //moveLeft
                userChoiseX--;
                break;
            case 'D':
                //moveRight
                userChoiseX++;
                break;
            case 'E':
                System.exit(0);
                break;
            default:
                System.out.println("Please repeat your choice!");
                //input.close();
                userInput();
                break;
        }
        //input.close();
    }

    public void checkGameObjects()
    {
            // User has choosen next cell after SNAKE HEAD - EMPTY cell.
        if (field.getCellView(userChoiseY, userChoiseX) == field.getEmptyFieldView())
        {
            field.setCellView(snake.getSnakeTailY(), snake.getSnakeTailX(), field.getEmptyFieldView());
            snake.moveSnake(userChoiseY, userChoiseX);
            field.setCellView(snake.getSnakeHeadY(), snake.getSnakeHeadX(), snake.getSnakeView());

        }   // User has choosen next cell after SNAKE HEAD - EAT cell.
        else if (field.getCellView(userChoiseY, userChoiseX) == eat.getEatView())
        {
            System.out.println("**Eaten!**");
            snake.resizeSnake(userChoiseY, userChoiseX);
            field.setCellView(snake.getSnakeHeadY(), snake.getSnakeHeadX(), snake.getSnakeView());
            eat.setEat();
        }   // User has choosen next cell after SNAKE HEAD - SNAKE or WALL cell.
        else if (field.getCellView(userChoiseY, userChoiseX) == snake.getSnakeView() ||
                 field.getCellView(userChoiseY, userChoiseX) == wall.getWallView())
        {
            System.out.println("**Game over!!!**");
            Menu.show();
        }

    }
}
