package coepoeFishAFish.models;

public abstract class BasicGameObject {

    protected final String name;
    protected final int price;

    public BasicGameObject(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}
