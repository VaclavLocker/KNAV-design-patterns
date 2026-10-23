package composite;

public class CompositeDemo {

    public static void main(String[] args) {
        CatalogItem phone = new Product("iPhone 16 Pro", 32990);
        CatalogItem phoneCase = new Product("Silicone case", 790);
        CatalogItem screenProtector = new Product("Screen protector", 390);
        CatalogItem charger = new Product("20W charger", 590);
        CatalogItem cable = new Product("USB-C cable", 290);

        CatalogItem chargingKit = new Bundle("Charging kit");
        chargingKit.add(charger);
        chargingKit.add(cable);

        CatalogItem protectionKit = new Bundle("Protection kit");
        protectionKit.add(phoneCase);
        protectionKit.add(screenProtector);

        CatalogItem starterPack = new Bundle("iPhone 16 Pro starter pack");
        starterPack.add(phone);
        starterPack.add(chargingKit);
        starterPack.add(protectionKit);

        starterPack.showDetails("");
        System.out.println("Total price: " + starterPack.getPriceCzk() + " CZK");

        starterPack.remove(protectionKit);
        System.out.println("\nAfter removing " + protectionKit.getName() + ":");
        starterPack.showDetails("");
        System.out.println("Total price: " + starterPack.getPriceCzk() + " CZK");

        try {
            phone.add(cable);
        } catch (UnsupportedOperationException e) {
            System.out.println("\nCannot add to " + phone.getName() + ": " + e.getMessage());
        }
    }
}
