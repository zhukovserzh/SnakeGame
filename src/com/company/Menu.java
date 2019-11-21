package com.company;

import java.util.Scanner;

public class Menu
{
    public static void show()
    {
        System.out.println("****Snake Game****");
        System.out.println("Make your choose (1 or 0):");
        System.out.println("1. Game");
        System.out.println("0. Exit");

        input();
    }

    public static void input()
    {
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        //input.close();

        switch (choose)
        {
            case 1:
                Game game = new Game();
                game.play();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Please repeat your choice!");
                show();
                break;
        }
    }
}
