# Toss it in my backpak! (TIIMB)

<p align="center">
  <b>A lightweight, client-side only Minecraft utility mod for NeoForge and Fabric across multiple versions (1.21.1 & 26.2).</b>
</p>

---

## 🎒 Features / Особенности

- **Keybind to backpack (Default: `G`):**
  - Press `G` while holding an item to automatically move it into your main backpack inventory.
- **Smart Stacking:**
  - First searches your inventory (slots 9–35) for identical items (matching item ID and NBT/components) and tops them up to maximum stack size.
- **Top-Down Priority:**
  - Any remaining items are placed into the first available empty slot prioritizing the **very top row** of your inventory (slots 9–17 first, then 18–26, then 27–35).
- **100% Client-Side Safe:**
  - Works on purely vanilla multiplayer servers!
  - If your inventory is completely full, items are safely returned to your hand without being dropped or lost.
  - Subtle tactile UI click sound on successful move.
- **0 External Runtime Dependencies:**
  - No bloated libraries required. Only native NeoForge or standard Fabric API.

---

## 🛠️ Architecture & Multi-Version Tooling / Архитектура

This mod uses **[Stonecutter](https://stonecutter.kikugie.dev/)** (`dev.kikugie.stonecutter`) to manage multi-platform (Fabric & NeoForge) and multi-version (1.21.1 & 26.2) builds in a single codebase with preprocessor comments (`//? if fabric`, `//? if neoforge`, `//? if >=26.2`).

### Supported Targets:
1. `1.21.1-fabric` (Fabric Loader + Fabric API on Minecraft 1.21.1)
2. `1.21.1-neoforge` (NeoForge on Minecraft 1.21.1)
3. `26.2-fabric` (Fabric Loader on Minecraft 26.2 / Java 25)
4. `26.2-neoforge` (NeoForge on Minecraft 26.2 / Java 25)

---

## 🚀 Building & Developing / Сборка и разработка

### Switch Active Project in IDE:
You can switch the active version in your IDE using Gradle tasks or the Stonecutter IntelliJ plugin:

```bash
# Switch to Fabric 1.21.1
./gradlew "Set active project to 1.21.1-fabric"

# Switch to NeoForge 1.21.1
./gradlew "Set active project to 1.21.1-neoforge"

# Reset active project before git commit
./gradlew "Reset active project"
```

### Build Mod Jars:

```bash
# Build Fabric 1.21.1
./gradlew :1.21.1-fabric:build

# Build NeoForge 1.21.1
./gradlew :1.21.1-neoforge:build
```

The resulting mod `.jar` files will be in:
- `versions/1.21.1-fabric/build/libs/tossitinmybackpak-1.0.0.jar`
- `versions/1.21.1-neoforge/build/libs/tossitinmybackpak-1.0.0.jar`

---

## 📜 License
MIT License. Feel free to use in modpacks or customize!
