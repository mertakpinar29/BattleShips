import java.util.*;
public class main {
    public static void Entrance() {
        System.out.println("Welcome to the BattleShips!");
        System.out.println("RULES:\n-you can NOT place two or more ships on the same location.\n-you can’t place ships outside the 10 by 10 grid");
    }

    public static void displayEmptyMap(String[][] Map) {
        System.out.println("   0123456789");
        for (int i = 0; i < Map.length; i++) {
            System.out.print(i + " " + "|");
            for (int j = 0; j < Map[i].length; j++) {
                Map[i][j] = " ";
                System.out.print(Map[i][j]);
            }
            System.out.print("|" + " " + i);
            System.out.println();
        }
    }

    public static void playerShips(String[][] Map) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            boolean runner1 = true;
            boolean runner2 = true;
            boolean runner3 = true;
            int Xcor;
            int Ycor;
            while (runner3) {
                System.out.println("Enter X coordinate for your " + (i + 1) + ". ship.");
                Xcor = input.nextInt();
                while (runner1) {
                    if (Xcor < 0 || Xcor > 9) {
                        System.out.println("This value is out of bounds.\nEnter a proper value.");
                        Xcor = input.nextInt();
                    } else {
                        runner1 = false;
                    }
                }

                System.out.println("Enter Y coordinate for your " + (i + 1) + ". ship.");
                Ycor = input.nextInt();
                while (runner2) {
                    if (Ycor < 0 || Ycor > 9) {
                        System.out.println("This value is out of bounds.\nPlease try again.");
                        Ycor = input.nextInt();
                    } else {
                        runner2 = false;
                    }
                }
                if (Map[Xcor][Ycor] != " ") {
                    System.out.println("You already placed a ship here.\nEnter a proper value.");
                } else {
                    Map[Xcor][Ycor] = "@";
                    runner3 = false;
                }
            }
        }
        System.out.println("   0123456789");
        for (int i = 0; i < Map.length; i++) {
            System.out.print(i + " " + "|");
            for (int j = 0; j < Map[i].length; j++) {
                System.out.print(Map[i][j]);
            }
            System.out.print("|" + " " + i);
            System.out.println();
        }
    }

    public static void computerShips(String[][] Map) {
        Random randomCoordinateGenerator = new Random();

        System.out.println("Computer is deploying ships");
        for (int i = 0; i < 5; i++) {
            boolean runner = true;
            int randomXcor;
            int randomYcor;
            while (runner) {
                randomXcor = randomCoordinateGenerator.nextInt(10);
                randomYcor = randomCoordinateGenerator.nextInt(10);
                if (Map[randomXcor][randomYcor] == " ") {
                    Map[randomXcor][randomYcor] = "C";
                    System.out.println((i + 1) + ". ship DEPLOYED");
                    runner = false;
                } else {
                }
            }
        }
    }

    public static void Battle(String[][] Map) {
        Scanner input = new Scanner(System.in);
        int playerShips = 5;
        int computerShips = 5;
        while (playerShips != 0 && computerShips != 0) {
            System.out.println("   0123456789");
            for (int i = 0; i < Map.length; i++) {
                System.out.print(i + " " + "|");
                for (int j = 0; j < Map[i].length; j++) {
                    if (Map[i][j] == "C") {
                        System.out.print(" ");
                    } else if (Map[i][j] == "@") {
                        System.out.print(Map[i][j]);
                    } else if (Map[i][j] == " ") {
                        System.out.print(Map[i][j]);
                    } else if (Map[i][j] == "x") {
                        System.out.print(Map[i][j]);
                    } else if (Map[i][j] == "!") {
                        System.out.print(Map[i][j]);
                    }
                }
                System.out.print("|" + " " + i);
                System.out.println();
            }
            System.out.println();
            System.out.println("Your ships: "+playerShips+" | Computer ships: "+computerShips);
            for (; ; ) {
                System.out.println("YOUR TURN TO ATTACK!");
                boolean runnerX = true;
                boolean runnerXY = true;
                boolean runnerY = true;
                int Xcor;
                int Ycor;
                while (runnerXY) {
                    System.out.println("Enter X coordinate:");
                    Xcor = input.nextInt();
                    while (runnerX) {
                        if (Xcor < 0 || Xcor > 9) {
                            System.out.println("This value is out of bounds.\nEnter a proper value.");
                            Xcor=input.nextInt();
                        } else {
                            runnerX = false;
                        }
                    }


                        System.out.println("Enter Y coordinate:");
                        Ycor = input.nextInt();
                        while(runnerY) {
                            if (Ycor < 0 || Ycor > 9) {
                                System.out.println("This value is out of bounds.\nEnter a proper value.");
                                Ycor=input.nextInt();
                            } else {
                                runnerY = false;
                            }
                        }
if(Map[Xcor][Ycor]=="@"){
    System.out.println("Oh no,you sunk your own ship!");
    playerShips--;
    Map[Xcor][Ycor]="x";
    runnerXY=false;
}
else if(Map[Xcor][Ycor]=="C"){
    System.out.println("Boom!You sunk the ship!");
    computerShips--;
    Map[Xcor][Ycor]="!";
    runnerXY=false;
}
else {
    System.out.println("You Missed!");
    runnerXY=false;
}
                }
            break;
            }
        for(;;){
            System.out.println("COMPUTER'S TURN");
            Random randomShotGenerator=new Random();
            int randomXCor=randomShotGenerator.nextInt(10);
            int randomYCor=randomShotGenerator.nextInt(10);
            if(Map[randomXCor][randomYCor]=="@"){
                System.out.println("The Computer sunk one of your ships!");
                Map[randomXCor][randomYCor]="x";
                playerShips--;
            }
            else if(Map[randomXCor][randomYCor]=="C"){
                System.out.println("The Computer sunk one of its own ships!");
                Map[randomXCor][randomYCor]="!";
                computerShips--;
            }
            else{System.out.println("Computer Missed!");}
        break;
        }
        }
        System.out.println("   0123456789");
        for (int i = 0; i < Map.length; i++) {
            System.out.print(i + " " + "|");
            for (int j = 0; j < Map[i].length; j++) {
                if (Map[i][j] == "C") {
                    System.out.print(" ");
                } else if (Map[i][j] == "@") {
                    System.out.print(Map[i][j]);
                } else if (Map[i][j] == " ") {
                    System.out.print(Map[i][j]);
                } else if (Map[i][j] == "x") {
                    System.out.print(Map[i][j]);
                } else if (Map[i][j] == "!") {
                    System.out.print(Map[i][j]);
                }
            }
            System.out.print("|" + " " + i);
            System.out.println();
        }
        System.out.println();
        System.out.println("Your ships: "+playerShips+" | Computer ships: "+computerShips);
        if(playerShips==0){System.out.println("You lost all of your ships!\nYou lost the battle.");}
        else if(computerShips==0){System.out.println("You just made history!\nYou won the battle.");}
    }

} 
