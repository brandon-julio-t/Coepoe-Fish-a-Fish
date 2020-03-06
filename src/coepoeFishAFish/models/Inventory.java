package coepoeFishAFish.models;

import coepoeFishAFish.gameVariables.Fishes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private final Map<Fish, Integer> fishAndTotalCaughtFish;
    private int bait;
    private int money;
    private FishingEquipment fishingEquipment;

    public Inventory() {
        this.bait = 10;
        this.fishAndTotalCaughtFish = new HashMap<>();
        this.money = 0;
        this.fishingEquipment = new FishingEquipment("Fishing Rod", 0);
        Arrays.stream(Fishes.values()).forEach(e -> fishAndTotalCaughtFish.put(e.fish, 0));
    }

    public int getBait() {
        return bait;
    }

    public Map<Fish, Integer> getFishAndAmount() {
        return fishAndTotalCaughtFish;
    }

    public void addBait(int amount) {
        this.money -= amount * 5;
        this.bait += amount;
    }

    public void useBait() {
        this.bait--;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int amount) {
        this.money += amount;
    }

    public FishingEquipment getFishingEquipment() {
        return fishingEquipment;
    }

    public void setFishingEquipment(FishingEquipment fishingEquipment) {
        this.money -= fishingEquipment.getPrice();
        this.fishingEquipment = fishingEquipment;
    }

    public void addFish(Fish fish) {
        int oldValue = this.fishAndTotalCaughtFish.get(fish);
        this.fishAndTotalCaughtFish.replace(fish, oldValue + 1);
    }

    public void clearAllFishes() {
        this.fishAndTotalCaughtFish.entrySet().forEach(e -> this.fishAndTotalCaughtFish.replace(e.getKey(), 0));
    }

    public int getSellingPrice() {
        return this.fishAndTotalCaughtFish
                .entrySet()
                .stream()
                .mapToInt(e -> e.getKey().getPrice() * e.getValue())
                .reduce(0, Integer::sum);
    }

}
