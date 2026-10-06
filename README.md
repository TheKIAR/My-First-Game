# 🎮 My First Game

<p align="center"><strong>Java • Swing/AWT • 2D Game Development • Real-Time Systems</strong><br><em>A hands-on adventure game built to explore the foundations of game programming.</em></p>

<p align="center"><a href="https://github.com/TheKIAR/My-First-Game"><img src="https://github.com/TheKIAR/My-First-Game/blob/main/assets/runtime-screenshot.png?raw=true" alt="My First Game runtime" width="820"></a></p>
<p align="center"><img src="https://github.com/TheKIAR/My-First-Game/actions/workflows/ci.yml/badge.svg" alt="Java CI"></p>

## 🎬 Gameplay preview

<p align="center"><img src="./assets/demo.gif" alt="My First Game gameplay" width="820"></p>

A short look at the game loop, player movement, world rendering and interactive objects.

## 🕹️ Meet the project

This is a first complete game project focused on the systems that make a 2D game work: a real-time loop, player input, tile worlds, collisions, animation, sound, objects and HUD rendering.

## 📚 Tutorial attribution & current status

This repository is currently a **learning project based substantially on the Ryisnow game-development tutorial series**.

**Tutorial reference:**  
https://youtube.com/playlist?list=PL_QPQmz5C6WUF-pOQDsbsKbaBZqXj4qSq

The current project includes my own character-design changes, while much of the underlying implementation and project structure follows the tutorial series. This attribution is included to represent the current state of the project accurately.

**Current licensing status:** This repository does **not** currently include an open-source license. Please do not treat the current tutorial-derived code, artwork, audio, or other third-party material as freely reusable. Check the original creator's terms and the individual asset licenses before redistribution or commercial use.

### 🔨 Planned transformation

The long-term goal is to rebuild this into a substantially more original game. Planned work includes:

- Reworking the overall architecture and core systems
- Rewriting gameplay mechanics and player systems
- Creating an original world and level design
- Replacing/reworking UI and HUD
- Replacing or creating original artwork and animations
- Replacing or creating properly licensed/original audio
- Developing an original story, identity and branding
- Adding original gameplay features and mechanics
- Reviewing dependencies and third-party assets
- Improving testing, documentation and release packaging

Once the project has been sufficiently rebuilt and all third-party material has been reviewed or replaced, an appropriate license will be selected and added.

## ✨ Gameplay systems

- 🔄 Real-time game loop
- 🗺️ Tile-based world and map loading
- 🧍 Player movement and animation
- 🧱 Tile and object collision detection
- 🔑 Interactive keys, doors and chests
- ❤️ Health / status HUD
- 🔊 Music and sound effects
- 🎒 Collectible items and world objects
- 📷 Camera / world rendering
- ⌨️ Keyboard input
- 🐞 Debug information

## 🧩 Architecture

**Input → Game Loop → Player / Entities → Collision → World & Objects → Rendering → HUD / Audio**

## 📁 Project structure

    src/
    ├── entity/    Player and entity classes
    ├── main/      Game loop, input, audio, UI and collision
    ├── object/    Interactive world objects
    └── tile/      Tile and world-map management

    res/
    ├── maps/
    ├── objects/
    ├── player/
    ├── sound/
    └── tiles/

## 🚀 Run locally

**Requirements:** Java 17+.

    mkdir -p out
    javac -d out $(find src -name "*.java")
    java -cp out main.Main

Keep the res directory at the repository root.

## 🎯 Portfolio focus

Java OOP · Game-loop design · Real-time input · Collision detection · Tile/map systems · Resource loading · Animation · Audio · 2D rendering

## ⚠️ Asset note

Some artwork, audio, code patterns and other material may originate from the tutorial or third-party resources. Verify the applicable permissions and licenses before redistribution or commercial use.

## 🚀 Next upgrades

Game-state system · Enemies/combat · Save/load · Settings · Runnable JAR · Fixed-timestep loop · More gameplay media · Original mechanics · Original world · Original assets · Original branding

## 🌐 Connect

🌐 [Portfolio](https://ragibashhab.netlify.app/) · 💼 [LinkedIn](https://www.linkedin.com/in/md-ragib-ashhab-768a19240/) · 🔗 [Linktree](https://linktr.ee/RagibAshhab) · 🐙 [GitHub](https://github.com/TheKIAR)

---
<p align="center"><sub>Built by Md. Ragib Ashhab • Java & Game Development</sub></p>