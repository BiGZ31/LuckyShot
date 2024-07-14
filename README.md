# Lucky Shot - Daily Rewards Minigame

![Lucky Shot Logo]([https://your-logo-url.com/logo.png](https://www.spigotmc.org/attachments/bowcosmetics-jpg.685623/))

Lucky Shot is a fun and engaging daily rewards minigame plugin for Minecraft servers. Players can test their luck and skills to win exciting rewards every day!

## Features

- **Daily Rewards:** Players can participate in the minigame once per day to earn unique rewards.
- **Customizable Rewards:** Configure the rewards to fit your server's needs.
- **User-Friendly GUI:** Intuitive and easy-to-use graphical user interface.
- **Leaderboard:** Track and display the top players.
- **Multilingual Support:** Supports multiple languages for a global player base.

## Installation

1. **Download the Plugin:**
   Download the latest version of Lucky Shot from the [SpigotMC Resource Page](https://www.spigotmc.org/resources/lucky-shot-daily-rewards-minigame.100111/).

2. **Place in Plugins Folder:**
   Move the downloaded `.jar` file to your server's `plugins` directory.

3. **Restart the Server:**
   Restart your Minecraft server to load the plugin.

4. **Configuration:**
   Edit the `config.yml` file in the `LuckyShot` folder to customize the plugin settings.

## Commands

- `/luckyshot` - Open the Lucky Shot minigame GUI.
- `/luckyshot rewards` - View available rewards.
- `/luckyshot leaderboard` - View the top players.

## Permissions

- `luckyshot.play` - Allows the player to participate in the minigame.
- `luckyshot.admin` - Allows access to admin commands.

## Configuration

The configuration file (`config.yml`) allows you to customize various aspects of the plugin. Here are some key settings:

```yaml
rewards:
  - name: "Diamond"
    chance: 0.1
  - name: "Emerald"
    chance: 0.05
  - name: "Gold Ingot"
    chance: 0.2
