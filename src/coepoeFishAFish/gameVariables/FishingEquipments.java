package coepoeFishAFish.gameVariables;

import coepoeFishAFish.models.FishingEquipment;

public enum FishingEquipments {

    fishingPole(new FishingEquipment("Fishing Pole", 300)),
    advancedFishingRod(new FishingEquipment("Advanced Fishing Rod", 600)),
    advancedFishingPole(new FishingEquipment("Advanced Fishing Pole", 900)),
    ultimateFishingRod(new FishingEquipment("Ultimate Fishing Rod", 1200)),
    ultimateFishingPole(new FishingEquipment("Ultimate Fishing Pole", 1500));

    public final FishingEquipment fishingEquipment;

    FishingEquipments(FishingEquipment fishingEquipment) {
        this.fishingEquipment = fishingEquipment;
    }

}
