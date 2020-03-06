package coepoeFishAFish;

import coepoeFishAFish.helpers.Menus;
import coepoeFishAFish.helpers.Utilities;
import coepoeFishAFish.models.Player;

public class Main {

    public static void main(String[] args) {

        Main.State.player.setName(Utilities.getString("Name [2-25 characters]: ", 2, 25));
        Main.State.player.setGender(getGender());

        Utilities.pause();

        while (true) {

            System.out.println();
            System.out.println("Main Menu");
            System.out.println("=============================");
            System.out.println("1. Profile");
            System.out.println("2. Fishing");
            System.out.println("3. Sell Fish");
            System.out.println("4. Shop / Upgrade Fishing Rod");
            System.out.println("5. Exit");
            int input = Utilities.getInt("> ", 1, 5);

            switch (input) {

                case 1:
                    Menus.playerInformation();
                    Utilities.pause();
                    break;

                case 2:
                    Menus.fishing();
                    Utilities.pause();
                    break;

                case 3:
                    Menus.sellFish();
                    Utilities.pause();
                    break;

                case 4:
                    Menus.buyOrUpgradeFishingEquipment();
                    Utilities.pause();
                    break;

                case 5:
                    return;

            }

        }

    }

    private static String getGender() {
        String gender;

        do {
            gender = Utilities.getString("Gender [M/F]: ", 1, 1);
        } while (!gender.equals("M") && !gender.equals("F"));

        return gender.equals("M") ? "Male" : "Female";
    }

    public static class State {

        private static final Player player = new Player();

        public static Player getPlayer() {
            return player;
        }
    }

}