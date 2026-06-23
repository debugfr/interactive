# InteractiveChat

A Minecraft 1.12.2 Spigot plugin that adds interactive chat placeholders for viewing player inventories, enderchests, and items.

## Features

- **Chat Placeholders:**
  - `[ec]`, `[enderchest]`, `[e]` - View player's enderchest
  - `[inv]`, `[inventory]` - View player's inventory
  - `[item]`, `[i]` - View player's held item

- **Right-click Shulker Boxes** - Preview contents when right-clicking

- **Everyone can view** - Any player can click on these placeholders to see others' items

## Installation

1. Download or compile the `.jar` file
2. Place in your `plugins/` folder
3. Restart server
4. Done! Plugin loads automatically

## Building

Requirements:
- Java 8+
- Maven 3.6+

```bash
git clone https://github.com/debugfr/interactive.git
cd interactive
mvn clean package
```

The compiled `.jar` will be in `target/`

## Usage

Simply type in chat with the placeholders:

```
Hey check this out [inv]
My enderchest is full [ec]
Look at this item [item]
```

Players who see the message can click the colored text to view your inventory/enderchest/item.

## Permissions

None required - all players can view all inventories.

## Notes

- Requires Spigot 1.12.2
- Full shulker preview may require additional NBT support
- Works in all chat formats