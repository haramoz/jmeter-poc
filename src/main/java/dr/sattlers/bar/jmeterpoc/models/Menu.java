package dr.sattlers.bar.jmeterpoc.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "menu")
public class Menu {
    private String item;
    private String description;
    private List<String> ingredients; 
    private String spicyLevel;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }


    public String getSpicyLevel() {
        return spicyLevel;
    }

    public void setSpicyLevel(String spicyLevel) {
        this.spicyLevel = spicyLevel;
    }

    public Menu(String item, String description, List<String> ingredients, String spicyLevel) {
        this.item = item;
        this.description = description;
        this.ingredients = ingredients;
        this.spicyLevel = spicyLevel;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    

}
