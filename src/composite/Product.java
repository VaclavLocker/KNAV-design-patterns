package composite;

public final class Product implements CatalogItem {

    private final String name;
    private final int priceCzk;

    public Product(String name, int priceCzk) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (priceCzk < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.name = name;
        this.priceCzk = priceCzk;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPriceCzk() {
        return priceCzk;
    }

    @Override
    public void add(CatalogItem item) {
        throw new UnsupportedOperationException("A product cannot contain other items");
    }

    @Override
    public void remove(CatalogItem item) {
        throw new UnsupportedOperationException("A product cannot contain other items");
    }

    @Override
    public void showDetails(String indentation) {
        System.out.println(indentation + "Product: " + name + ", " + priceCzk + " CZK");
    }
}
