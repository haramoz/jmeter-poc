package dr.sattlers.bar.jmeterpoc.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "menu")
public class Menu {
    private String item;

    public Menu(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

}
