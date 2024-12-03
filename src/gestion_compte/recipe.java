package gestion_compte;

public class recipe {
    private String title;
    private String description;
    private String[] ingredients;
    private double price;

    public recipe(String title, String description,String[] ingredients,double price ){
        this.title=title;
        this.description=description;
        this.ingredients=ingredients;
        this.price=price;
    }

    public recipe(String title,double price){
        this.title=title;
        this.price=price;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
