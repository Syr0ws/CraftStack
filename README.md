# CraftStack

CraftStack is a lightweight library that simplifies raw item definition in code and loading from YAML
configuration files with the Spigot API.

## How it works

The library is built on a component-based system where each item is defined by a base material and a
set of independent components (such as name, lore, etc.).

### Define items in code

To create a new item, use the static method `Item#create(Material)` by providing a base `Material`.

```java
Item item = Item.create(Material.DIAMOND);
```

You can then attach components (e.g. properties) to the item using the methods `Item#addComponent(ItemComponent)` or
`Item#addComponents(ItemComponent[])`.

```java
Item item = Item.create(Material.DIAMOND);
item.addComponent(new DisplayName("name"));
item.addComponent(new Lore("line 1", "line 2", "line 3"));
item.addComponent(new CustomModelData(1));
```

Methods can also be **chained** to make the code more concise.

```java
Item item = Item.create(Material.DIAMOND)
        .addComponent(new DisplayName("name"))
        .addComponent(new Lore("line 1", "line 2", "line 3"))
        .addComponent(new CustomModelData(1));
```

### Define items in YAML files

Items can be defined and loaded from YAML files. Each item must be declared in its own section.

```yaml
item:
  # Item type.
  # See https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Material.html.
  type: "DIAMOND"
  # Display name.
  display-name: "&6Display name"
  # Lore.
  lore:
    - "line 1"
    - "line 2"
    - "line 3"
  # Custom model data.
  custom-model-data: 1
  # Amount.
  amount: 1
  # Damage / Durability
  damage: 0
```

Items can then be loaded programmatically using the `ItemLoaderService` interface. A default instance of this service
can be created from the `CraftStack` class.

```java
ItemLoaderService<ConfigurationSection> service = CraftStack.getDefaultComponentLoaderService();
```

The methods `ItemLoaderService#load(ConfigurationSection)` and `ItemLoaderService#loadAll(ConfigurationSection)` can
then be used to load a single or multiple items.

```java
ConfigurationSection section = ... ;

ItemLoaderService<ConfigurationSection> service = CraftStack.getDefaultComponentLoaderService();

try {
    List<Item> items = service.loadAll(section);
} catch (ItemException exception) {
    exception.printStackTrace();
}
```

_Note: An `ItemException` might be thrown if an item is defined with an invalid property._

### Conversion to an ItemStack

An `Item` can be converted to an `ItemStack` using the `Item#build()` method.

```java
ItemStack diamond = Item.create(Material.DIAMOND)
        .addComponent(new DisplayName("name"))
        .addComponent(new Lore("line 1", "line 2", "line 3"))
        .addComponent(new CustomModelData(1))
        .build();
```

## Available properties

| **Property**        | **Constructors**                       | Comment                                                                     |
|---------------------|----------------------------------------|-----------------------------------------------------------------------------|
| Display Name        | `DisplayName(String)`                  | Support for colors using color tags and hex.                                |
| Lore                | `Lore(List<String>)`, `Lore(String[])` | Support for colors using color tags and hex.                                |
| Custom Model Data   | `CustomModelData(int)`                 | -                                                                           |
| Amount              | `Amount(int)`                          | -                                                                           |
| Damage / Durability | `Damage(int)`                          | -                                                                           |
| Glowing             | `Glow()`                               | Add an enchantment effect to the item without showing any enchantment name. |

_Note: More properties will be supported as needed. Feel free to contribute and add support for new properties!_
