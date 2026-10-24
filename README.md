# KNAV - Design Patterns

Solutions to the design pattern exercises from the [KNAVProject](https://github.com/JakubObornik/KNAVProject/tree/main) course repository.

Each pattern follows the structure required by the assignment, but uses its own example from a phone shop domain instead of the one from the assignment.

## Patterns

### Exercise 1 - Creational patterns

| Pattern | Example | Run |
|---|---|---|
| Builder | Building phones with optional parameters and validation | `builder.BuilderDemo` |
| Singleton | One shared phone warehouse used by the e-shop and the branch store | `singleton.SingletonDemo` |
| Prototype | Copying a configured phone including its installed apps | `prototype.PrototypeDemo` |

### Exercise 2 - Structural patterns

| Pattern | Example | Run |
|---|---|---|
| Bridge | Customer notifications (order confirmation, shipping notice) sent through independent channels (email, SMS) | `bridge.BridgeDemo` |
| Composite | Product catalog where bundles contain products or other bundles and sum their prices | `composite.CompositeDemo` |
| Facade | Placing and cancelling an order through one facade over inventory, payment, shipping and email services | `facade.FacadeDemo` |

## Running

Requirements: Java 21, no external libraries.

1. Open the project folder in IntelliJ IDEA.
2. Run any of the demo classes above, or `Main` to run all of them in sequence.
