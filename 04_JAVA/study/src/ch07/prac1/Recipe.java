package ch07.prac1;

public abstract class Recipe {
    protected String title;
    protected int cookTime;
    protected boolean isVegan;

    public Recipe(String title, int cookTime, boolean isVegan){
        this.title = title;
        this.cookTime = cookTime;
        this.isVegan = isVegan;
    }
    public abstract String getDescription();
//    public abstract String toString();
}
