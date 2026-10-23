import builder.BuilderDemo;
import composite.CompositeDemo;
import prototype.PrototypeDemo;
import singleton.SingletonDemo;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Builder ===");
        BuilderDemo.main(args);

        System.out.println("\n=== Singleton ===");
        SingletonDemo.main(args);

        System.out.println("\n=== Prototype ===");
        PrototypeDemo.main(args);

        System.out.println("\n=== Composite ===");
        CompositeDemo.main(args);

        System.out.println("\n=== Facade ===");
        FacadeDemo.main(args);
    }
}
