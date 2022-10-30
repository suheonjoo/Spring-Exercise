package me.whiteship.refactoring._20_large_class._41_extract_superclass._02_after;

public abstract class Party {
    protected String name;

    public Party(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract protected double monthlyCost();


    public double annualCost() {
        return this.monthlyCost() * 12;
    }
}
