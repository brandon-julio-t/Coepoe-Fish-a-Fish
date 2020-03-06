package coepoeFishAFish.models;

import coepoeFishAFish.gameVariables.Fishes;
import coepoeFishAFish.helpers.Utilities;

public class Player {

    private String name;
    private String gender;
    private int level;
    private final Inventory inventory;

    public Player() {
        this.name = "";
        this.gender = "";
        this.level = 0;
        this.inventory = new Inventory();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void sellFish() {
        this.inventory.addMoney(this.inventory.getSellingPrice());
        this.inventory.clearAllFishes();
    }

    public Fish doFishing() {
        this.inventory.useBait();

        int random = Utilities.getRandom(0, 9);
        Fish caughtFish = Fishes.values()[random].fish;
        this.inventory.addFish(caughtFish);

        return caughtFish;
    }

}
