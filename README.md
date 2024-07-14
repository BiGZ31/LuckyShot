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



#
#                     ██████╗░░█████╗░░██╗░░░░░░░██╗  ░█████╗░░█████╗░░██████╗███╗░░░███╗███████╗████████╗██╗░█████╗░░██████╗
#                     ██╔══██╗██╔══██╗░██║░░██╗░░██║  ██╔══██╗██╔══██╗██╔════╝████╗░████║██╔════╝╚══██╔══╝██║██╔══██╗██╔════╝
#                     ██████╦╝██║░░██║░╚██╗████╗██╔╝  ██║░░╚═╝██║░░██║╚█████╗░██╔████╔██║█████╗░░░░░██║░░░██║██║░░╚═╝╚█████╗░
#                     ██╔══██╗██║░░██║░░████╔═████║░  ██║░░██╗██║░░██║░╚═══██╗██║╚██╔╝██║██╔══╝░░░░░██║░░░██║██║░░██╗░╚═══██╗
#                     ██████╦╝╚█████╔╝░░╚██╔╝░╚██╔╝░  ╚█████╔╝╚█████╔╝██████╔╝██║░╚═╝░██║███████╗░░░██║░░░██║╚█████╔╝██████╔╝
#                     ╚═════╝░░╚════╝░░░░╚═╝░░░╚═╝░░  ░╚════╝░░╚════╝░╚═════╝░╚═╝░░░░░╚═╝╚══════╝░░░╚═╝░░░╚═╝░╚════╝░╚═════╝░



#                                            ▒█▀▀█ █░░█ 　 ▒█░░░ █░░█ ▀▀█▀▀ █▀▀█ ░▀░ █▀▀█ 
#                                            ▒█▀▀▄ █▄▄█ 　 ▒█░░░ █▄▄█ ░░█░░ █▄▄▀ ▀█▀ █▄▄█ 
#                                            ▒█▄▄█ ▄▄▄█ 　 ▒█▄▄█ ▄▄▄█ ░░▀░░ ▀░▀▀ ▀▀▀ ▀░░▀


messages:
   join: "&e[&6!&E] You just joined the &6bow &epractice &6!"
   leave: "&e[&6!&e] You just left the game !"
   ingame: "&e[&6!&e] You are already in this mode &6!"
   iron: "&e[&6!&e] You touched the iron target and won &e250 gold &6!"
   gold: "&e[&6!&e] You touched the Gold target and won &e500 gold &6!"
   diamond: "&e[&6!&e] You touched the Diamond target and won &e1000 gold &6!"
   reload: "&e[&6!&e] You just reloaded the config !"
   cooldownremove: "&e[&6!&e] You just removed your cooldown !"
   store: "&e[&6!&e] &6wwww.exemple.com"
   




#            ┏━━━┓                ┏┓
#            ┃┏━┓┃                ┃┃
#            ┃┃ ┗╋━━┳┓┏┳┓┏┳━━┳━┓┏━┛┣━━┓
#            ┃┃ ┏┫┏┓┃┗┛┃┗┛┃┏┓┃┏┓┫┏┓┃━━┫
#            ┃┗━┛┃┗┛┃┃┃┃┃┃┃┏┓┃┃┃┃┗┛┣━━┃
#            ┗━━━┻━━┻┻┻┻┻┻┻┛┗┻┛┗┻━━┻━━┛
commands:
#All commands are sent by console set %player% to get the player's name
  iron: "eco give %player% 250"
  gold: "eco give %player% 500"
  diamond: "eco give %player% 1000"
   




#               ╭━━╮╭╮        ╭━╮
#               ╰┃┃╯┃╰╮╭━╮╭━━╮┃━┫
#               ╭┃┃╮┃╭┫┃┻┫┃┃┃┃┣━┃
#               ╰━━╯╰━╯╰━╯╰┻┻╯╰━╯
items:
  leave: 
    name: "&4&lLeave"
    lore: "&7Return tu spawn and try again tommorow !"
  buymore:
    name: "&a&lPurshase More arrows"
    lore: "&7Buy more arrows at the store"
  info:
    name: "&eInfo"
    lore: "&7If you buy more arrows wait for them to pop in your inventory"






#               ╭━━━╮     ╭╮
#               ┃╭━╮┃    ╭╯╰╮
#               ┃┃ ┃┃╭━━╮╰╮╭╯╭╮╭━━╮╭━╮ ╭━━╮
#               ┃┃ ┃┃┃╭╮┃ ┃┃ ┣┫┃╭╮┃┃╭╮╮┃━━┫
#               ┃╰━╯┃┃╰╯┃ ┃╰╮┃┃┃╰╯┃┃┃┃┃┣━━┃
#               ╰━━━╯┃╭━╯ ╰━╯╰╯╰━━╯╰╯╰╯╰━━╯
#                    ┃┃
#                    ╰╯
joinloc:
  world:
  y:
  x:
  z:
  #on leave téléport to old position !
oldposloc:
  enabled: false
leaveloc:
  world:
  y:
  x:
  z:
  
  
  
  
  
  
#            ╔═══╗
#            ║╔═╗║
#            ║╚═╝║╔══╗╔═╗╔╗╔╗╔╗╔══╗╔══╗╔╗╔══╗╔═╗─╔══╗
#            ║╔══╝║║═╣║╔╝║╚╝║╠╣║══╣║══╣╠╣║╔╗║║╔╗╗║══╣
#            ║║   ║║═╣║║ ║║║║║║╠══║╠══║║║║╚╝║║║║║╠══║
#            ╚╝   ╚══╝╚╝ ╚╩╩╝╚╝╚══╝╚══╝╚╝╚══╝╚╝╚╝╚══╝

#                       bow.admin


#                              ████████████████████████████████████████
#                              ██████▀░░░░░░░░▀████████▀▀░░░░░░░▀██████
#                              ████▀░░░░░░░░░░░░▀████▀░░░░░░░░░░░░▀████
#                              ██▀░░░░░░░░░░░░░░░░▀▀░░░░░░░░░░░░░░░░▀██
#                              ██░░░░░░░░░░░░░░░░░░░▄▄░░░░░░░░░░░░░░░██
#                              ██░░░░░░░░░░░░░░░░░▄▀░█░░░░░░░░░░░░░░░██    
#                              ██░░░░░░░░░░████▄▄▄▀░░▀▀▀▀▄░░░░░░░░░░░██
#                              ██▄░░░░░░░░░████░░░░░░░░░░█░░░░░░░░░░▄██
#                              ████▄░░░░░░░████░░░░░░░░░░█░░░░░░░░▄████
#                              ██████▄░░░░░████▄▄▄░░░░░░░█░░░░░░▄██████
#                              ████████▄░░░▀▀▀▀░░░▀▀▀▀▀▀▀░░░░░▄████████
#                              ██████████▄░░░░░░░░░░░░░░░░░░▄██████████
#                              ████████████▄░░░░░░░░░░░░░░▄████████████
#                              ██████████████▄░░░░░░░░░░▄██████████████
#                              ████████████████▄░░░░░░▄████████████████
#                              ██████████████████▄▄▄▄██████████████████
#
#██╗░░░░░███████╗░█████╗░██╗░░░██╗███████╗  ░█████╗░  ██████╗░███████╗██╗░░░██╗██╗███████╗░██╗░░░░░░░██╗                                                                                                          
#██║░░░░░██╔════╝██╔══██╗██║░░░██║██╔════╝  ██╔══██╗  ██╔══██╗██╔════╝██║░░░██║██║██╔════╝░██║░░██╗░░██║            
#██║░░░░░█████╗░░███████║╚██╗░██╔╝█████╗░░  ███████║  ██████╔╝█████╗░░╚██╗░██╔╝██║█████╗░░░╚██╗████╗██╔╝            
#██║░░░░░██╔══╝░░██╔══██║░╚████╔╝░██╔══╝░░  ██╔══██║  ██╔══██╗██╔══╝░░░╚████╔╝░██║██╔══╝░░░░████╔═████║░
#███████╗███████╗██║░░██║░░╚██╔╝░░███████╗  ██║░░██║  ██║░░██║███████╗░░╚██╔╝░░██║███████╗░░╚██╔╝░╚██╔╝░   
#╚══════╝╚══════╝╚═╝░░╚═╝░░░╚═╝░░░╚══════╝  ╚═╝░░╚═╝  ╚═╝░░╚═╝╚══════╝░░░╚═╝░░░╚═╝╚══════╝░░░╚═╝░░░╚═╝░░

#                  ░█████╗░███╗░░██╗  ░██████╗██████╗░██╗░██████╗░░█████╗░████████╗
#                  ██╔══██╗████╗░██║  ██╔════╝██╔══██╗██║██╔════╝░██╔══██╗╚══██╔══╝
#                  ██║░░██║██╔██╗██║  ╚█████╗░██████╔╝██║██║░░██╗░██║░░██║░░░██║░░░
#                  ██║░░██║██║╚████║  ░╚═══██╗██╔═══╝░██║██║░░╚██╗██║░░██║░░░██║░░░
#                  ╚█████╔╝██║░╚███║  ██████╔╝██║░░░░░██║╚██████╔╝╚█████╔╝░░░██║░░░
#                  ░╚════╝░╚═╝░░╚══╝  ╚═════╝░╚═╝░░░░░╚═╝░╚═════╝░░╚════╝░░░░╚═╝░░░                                                                                                             
#

