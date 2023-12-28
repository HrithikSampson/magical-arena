# Project Name

Magical Arena

## Problem Statement

Design a Magical Arena. Every Player is defined by a “health” attribute, “strength” attribute and an “attack” attribute - all positive integers. The player dies if his health attribute touches 0. 
Any two player can fight a match in the arena. Players attack in turns. Attacking player rolls the attacking dice and the defending player rolls the defending dice. The “attack”  value multiplied by the outcome of the  attacking dice roll is the damage created by the attacker. The defender “strength” value, multiplied by the outcome of the defending dice is the damage defended by the defender. Whatever damage created by attacker which is in excess of the damage defended by the defender will reduce the “health” of the defender. Game ends when any players health reaches 0

Player with lower health attacks first at the start of a match. 

Assume two players . Player A 50 health 5 strength 10 attack Player B 100 health 10 strength and 5 attack . Attacking die and Defending die are both 6 sided die with values ranging from 1- 6

Player A attacks and rolls die. Die roll : 5 . Player B defends and rolls die. Die roll 2

Attack damage is 5 * 10 = 50 ; Defending strength = 10 * 2 = 20 ; Player B health reduced by 30 to 70

Player B attacks and rolls die. Die roll : 4. Player A defends and rolls die. Die Roll 3

Attack damage is 4 * 5 = 20 ; Defending strength = 5 * 3 = 15 ; Player A health reduced by 5 to 45

And so on

## Overview

GameControls is the class controlling the game and taking user Input. It acts as a listener to the Game class listening for the Game to End. THis controller is a subtype of IGameController hence can be replaced if needed.

The Game owns the Arena and its lifetime is associated with it. It contains the Players playing in the game. Players can be added in this class.

The Player contains all the attributes of a player

The Arena is where the fight happens between the players.

## Prerequisites

- Java SDK (version 21.0.1)
- Gradle (version 8.5)

## Getting Started

To get started, follow these steps:

1. Clean the previous builds `./gradlew clean
2. Compile the build: `./gradlew build 
3. Execute Unit Tests again after cleaning: `./gradlew test

## Usage

```bash
./gradlew run --console=plain