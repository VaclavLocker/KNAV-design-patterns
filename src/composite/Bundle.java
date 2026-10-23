package composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Bundle implements CatalogItem {

    private final String name;
    private final List<CatalogItem> items = new ArrayList<>();

    public Bundle(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPriceCzk() {
        return items.stream().mapToInt(CatalogItem::getPriceCzk).sum();
    }

    @Override
    public void add(CatalogItem item) {
        Objects.requireNonNull(item, "Item is required");
        if (item == this) {
            throw new IllegalArgumentException("A bundle cannot contain itself");
        }
        items.add(item);
    }

    @Override
    public void remove(CatalogItem item) {
        items.remove(item);
    }

    @Override
    public void showDetails(String indentation) {
        System.out.println(indentation + "Bundle: " + name + ", " + getPriceCzk() + " CZK");
        items.forEach(item -> item.showDetails(indentation + "  "));
    }
}
