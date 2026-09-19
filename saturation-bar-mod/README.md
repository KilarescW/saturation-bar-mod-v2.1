# Saturation Bar Mod

This is a client-sided Minecraft mod for version 1.21 that adds a yellow glow around the hunger bar to indicate your current saturation level.

## How to Build (Create the .jar)

Since this is source code, you need to compile it into a `.jar` file to use it in Minecraft.

### Prerequisites
1. **Install JDK 21**: You must have Java Development Kit (JDK) 21 installed on your computer. 
   - Download it from [Adoptium (Temurin)](https://adoptium.net/) or any other JDK 21 provider.
2. **Fabric Loader**: Install the [Fabric Loader](https://fabricmc.net/use/) for version 1.21.
3. **Fabric API**: Download the [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api) and put it in your `.minecraft/mods` folder.

### Build Steps
1. Open a terminal/command prompt in the `saturation-bar-mod` folder.
2. Run the Gradle build command:
   - **Windows**: `gradlew build`
   - **Mac/Linux**: `./gradlew build`
3. Once the build finishes, you will find the compiled mod file here:
   `build/libs/saturation-bar-1.0.0.jar`
4. Copy that `.jar` file into your Minecraft `mods` folder.

## Features
- **Saturation Glow**: A semi-transparent yellow border appears around the hunger bar.
- **Dynamic Length**: The border grows or shrinks based on your actual saturation value.
- **Client-Sided**: No need to install this on a server; it works in singleplayer and multiplayer.
