import java.util.Random;
import java.util.Scanner;

public class Hammer {

    Player playerUser;
    Player playerBoot1;
    Player playerBoot2;
    Player playerBoot3;

    public Hammer(Player playerUser, Player playerBoot1, Player playerBoot2, Player playerBoot3) {
        this.playerUser = playerUser;
        this.playerBoot1 = playerBoot1;
        this.playerBoot2 = playerBoot2;
        this.playerBoot3 = playerBoot3;
    }

    public void showSituation() {

        int i;
        int j;

        for (i = 0; i < 10; i++) {

            if (i != playerUser.getPositionV() && i != playerBoot1.getPositionV() && i != playerBoot2.getPositionV() && i != playerBoot3.getPositionV()) {
                for (j = 0; j < 10; j++) {
                    System.out.print("X");
                }
                System.out.println();
            }


            if (i == playerUser.getPositionV()) {
                for (j = 0; j < playerUser.getPositionH(); j++) {
                    System.out.print("X");
                }
                System.out.print("P");
                for (j = playerUser.getPositionH() + 1; j < 10; j++) {
                    System.out.print("X");
                }
                System.out.println();
            }


            if (i == playerBoot1.getPositionV()) {
                for (j = 0; j < playerBoot1.getPositionH(); j++) {
                    System.out.print("X");
                }
                System.out.print("B1");
                for (j = playerBoot1.getPositionH() + 1; j < 10; j++) {
                    System.out.print("X");
                }
                System.out.println();
            }

            if (i == playerBoot2.getPositionV()) {
                for (j = 0; j < playerBoot2.getPositionH(); j++) {
                    System.out.print("X");
                }
                System.out.print("B2");
                for (j = playerBoot2.getPositionH() + 1; j < 10; j++) {
                    System.out.print("X");
                }
                System.out.println();
            }
            if (i == playerBoot3.getPositionV()) {
                for (j = 0; j < playerBoot3.getPositionH(); j++) {
                    System.out.print("X");
                }
                System.out.print("B3");
                for (j = playerBoot3.getPositionH() + 1; j < 10; j++) {
                    System.out.print("X");
                }
                System.out.println();
            }
        }
    }

    public void move() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj ruch zawodnika");

        String someChar = scanner.next();

        switch (someChar) {
            case "w":
                if (playerUser.getPositionV() != 0) {
                    playerUser.setPositionV(playerUser.getPositionV() - 1);
                }
                break;
            case "s":
                if (playerUser.getPositionV() != 9) {
                    playerUser.setPositionV(playerUser.getPositionV() + 1);
                }
                break;
            case "a":
                if (playerUser.getPositionH() != 0) {
                    playerUser.setPositionH(playerUser.getPositionH() - 1);
                }
                break;
            case "d":
                if (playerUser.getPositionH() != 9) {
                    playerUser.setPositionH(playerUser.getPositionH() + 1);
                }
                break;
            default:
                break;
        }
    }


    public void moveRandomBoot(Player someBoot) {
        Random random = new Random();
        int randomMove = random.nextInt(3);


        switch (randomMove) {
            case 0:
                if (someBoot.getPositionV() != 0 && someBoot.getPositionV() != 10) {
                    someBoot.setPositionV(someBoot.getPositionV() - 1);
                }
                break;
            case 1:
                if (someBoot.getPositionV() != 9 && someBoot.getPositionV() != 10) {
                    someBoot.setPositionV(someBoot.getPositionV() + 1);
                }
                break;
            case 2:
                if (someBoot.getPositionH() != 0 && someBoot.getPositionV() != 10) {
                    someBoot.setPositionH(someBoot.getPositionH() - 1);
                }
                break;
            case 3:
                if (someBoot.getPositionH() != 10 && someBoot.getPositionV() != 10) {
                    someBoot.setPositionH(someBoot.getPositionH() + 1);
                }
        }
    }

    public void checkSituationUser() {
        if (playerUser.getPositionV() == playerBoot1.getPositionV() && playerUser.getPositionH() == playerBoot1.getPositionH()) {
            System.out.println("Zniszczono Boot1");
            playerBoot1.setPositionV(10);
        }
        if (playerUser.getPositionV() == playerBoot2.getPositionV() && playerUser.getPositionH() == playerBoot2.getPositionH()) {
            System.out.println("Zniszczono Boot2");
            playerBoot2.setPositionV(10);
        }
        if (playerUser.getPositionV() == playerBoot3.getPositionV() && playerUser.getPositionH() == playerBoot3.getPositionH()) {
            System.out.println("Zniszczono Boot3");
            playerBoot3.setPositionV(10);
        }
    }

    public void checkSituationBoot() {
        if ((playerUser.getPositionV() == playerBoot1.getPositionV() && playerUser.getPositionH() == playerBoot1.getPositionH()) || (playerUser.getPositionV() == playerBoot2.getPositionV() && playerUser.getPositionH() == playerBoot2.getPositionH()) || (playerUser.getPositionV() == playerBoot3.getPositionV() && playerUser.getPositionH() == playerBoot3.getPositionH())) {
            System.out.println("Zostałeś zniszczony przez BOOTa. Koniec gry.");
            playerUser.setPositionV(10);
        }
    }
}