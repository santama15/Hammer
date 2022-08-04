public class HammerDemo {

    public static void main(String[] args) {


        Player playerUser = new PlayerUser("Adam");
        Player playerBoot = new PlayerBoot("boot1");
        Player playerBoot2 = new PlayerBoot("boot2");
        Player playerBoot3 = new PlayerBoot("boot3");

        System.out.println(playerUser);
        System.out.println(playerBoot);
        System.out.println(playerBoot2);
        System.out.println(playerBoot3);


        Hammer hammer = new Hammer(playerUser, playerBoot, playerBoot2, playerBoot3);

        hammer.showSituation();

        while (playerUser.getPositionV() != 10) {

            if (playerBoot.getPositionV() == 10 && playerBoot2.getPositionV() == 10 && playerBoot3.getPositionV() == 10) {
                System.out.println("Brawo, zniszczyłeś wszystkie BOOTy. Koniec gry.");
                playerUser.setPositionV(10);
                break;
            } else
            hammer.move();
            hammer.checkSituationUser();
            hammer.showSituation();
            hammer.checkSituationUser();
            hammer.move();
            hammer.moveRandomBoot(playerBoot);
            hammer.moveRandomBoot(playerBoot2);
            hammer.moveRandomBoot(playerBoot3);
            hammer.checkSituationBoot();
            hammer.showSituation();
        }
    }
}