package coepoeFishAFish.helpers;

import coepoeFishAFish.Main;
import coepoeFishAFish.gameVariables.FishingEquipments;
import coepoeFishAFish.models.Fish;
import coepoeFishAFish.models.FishingEquipment;
import coepoeFishAFish.models.Inventory;
import coepoeFishAFish.models.Player;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Menus {
    public static void playerInformation() {
        Player player = Main.State.getPlayer();
        Inventory inventory = player.getInventory();

        System.out.println();
        System.out.printf("Level: %d%n", player.getLevel());
        System.out.printf("Name: %s%n", player.getName());
        System.out.printf("Gender: %s%n", player.getGender());
        System.out.printf("Fishing Rod: %s%n", inventory.getFishingEquipment().getName());
        System.out.printf("Total bait: %d%n", inventory.getBait());
        System.out.printf("Total money: $%d%n", inventory.getMoney());
        System.out.println();
    }

    public static void fishing() {
        if (Main.State.getPlayer().getInventory().getBait() > 0) {
            Fish caughtFish = Main.State.getPlayer().doFishing();
            System.out.printf("Fish caught: %s ($%d)%n", caughtFish.getName(), caughtFish.getPrice());
        } else {
            System.out.println("Insufficient baits.");
        }
    }

    public static void sellFish() {
        String separator = "+==================+==================+==========+";

        System.out.println(separator);
        System.out.printf("| %16s | %16s | %8s |%n", "Name", "Price per Fish", "Amount");
        System.out.println(separator);
        Main.State.getPlayer().getInventory().getFishAndAmount()
                .forEach((fish, amount) -> System.out.printf("| %16s | %16s | %8d |%n",
                        fish.getName(), "$ " + fish.getPrice(), amount));
        System.out.println(separator);
        System.out.printf("Total sell price: %s%n",
                "$ " + Main.State.getPlayer().getInventory().getSellingPrice());

        if (getCommand().equalsIgnoreCase("sell")) {
            Main.State.getPlayer().sellFish();
            System.out.printf("Current money: %s%n", "$ " + Main.State.getPlayer().getInventory().getMoney());
        }
    }

    private static String getCommand() {
        String command;

        do {
            command = Utilities.getString("[Sell/Exit]: ");
        } while (!command.equalsIgnoreCase("sell") &&
                !command.equalsIgnoreCase("exit"));

        return command;
    }

    public static void buyOrUpgradeFishingEquipment() {
        System.out.println();
        System.out.println("A. Upgrade Fishing Equipment");
        System.out.println("B. Buy Bait");
        System.out.println("C. Back to Main Menu");

        while (true) {
            switch (getChoice()) {

                case "A":
                    String separator = "+======+==================================+==========";
                    FishingEquipments[] allFishingEquipments = FishingEquipments.values();
                    AtomicInteger counter = new AtomicInteger(1);

                    System.out.println(separator);
                    System.out.printf("| %4s | %32s | %8s |%n", "#", "Name", "Price");
                    System.out.println(separator);
                    Stream.of(allFishingEquipments)
                            .forEach(e -> System.out.printf("| %4d | %32s | %8s |%n",
                                    counter.getAndIncrement(),
                                    e.fishingEquipment.getName(),
                                    "$ " + e.fishingEquipment.getPrice()));
                    System.out.println(separator);

                    int input = Utilities.getInt("> ", 1, 5);
                    FishingEquipment chosenFishingEquipment = allFishingEquipments[input - 1].fishingEquipment;

                    if (Main.State.getPlayer().getInventory().getMoney() >= chosenFishingEquipment.getPrice()) {

                        Main.State.getPlayer().getInventory().setFishingEquipment(chosenFishingEquipment);

                        System.out.println(Main.State.getPlayer().getLevel() == input ? "Level doesn't change." :
                                Main.State.getPlayer().getLevel() < input ? "Level increased." : "Level decreased.");

                        Main.State.getPlayer().setLevel(input);

                    } else {

                        System.out.println("Insufficient funds.");

                    }

                    return;

                case "B":

                    System.out.println("Bait price: $5");
                    int amount = Utilities.getInt("Amount: ");
                    int cost = amount * 5;

                    if (cost <= Main.State.getPlayer().getInventory().getMoney()) {

                        Main.State.getPlayer().getInventory().addBait(amount);
                        System.out.printf("Now you have %d baits.%n", Main.State.getPlayer().getInventory().getBait());

                    } else {

                        System.out.println("Insufficient funds.");

                    }

                    return;

                case "C":
                    return;

            }
        }
    }

    private static String getChoice() {
        String choice;

        do {
            choice = Utilities.getString("[A/B/C]: ", 1, 1);
        } while (!choice.equals("A") &&
                !choice.equals("B") &&
                !choice.equals("C"));

        return choice;
    }

}
