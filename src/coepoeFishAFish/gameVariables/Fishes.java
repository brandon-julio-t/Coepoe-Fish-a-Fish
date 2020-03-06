package coepoeFishAFish.gameVariables;

import coepoeFishAFish.models.Fish;

public enum Fishes {

    guppyBlue(new Fish("Guppy Blue", 30)),
    appleSnail(new Fish("Apple Snail", 40)),
    guppyYellow(new Fish("Guppy Yellow", 50)),
    snakeSnail(new Fish("Snake Snail", 60)),
    flagFish(new Fish("Flag Fish", 70)),
    clownFish(new Fish("Clown Fish", 80)),
    tuna(new Fish("Tuna", 90)),
    tigerShark(new Fish("Tiger Shark", 100)),
    whiteShark(new Fish("White Shark", 110)),
    whale(new Fish("Whale", 120));

    public final Fish fish;

    Fishes(Fish fish) {
        this.fish = fish;
    }
}
