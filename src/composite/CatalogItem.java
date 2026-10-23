package composite;

public interface CatalogItem {

    String getName();

    int getPriceCzk();

    void add(CatalogItem item);

    void remove(CatalogItem item);

    void showDetails(String indentation);
}
