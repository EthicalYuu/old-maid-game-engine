# The Old Maid Card Game

> ⚠️ **Important:** This README provides a high-level overview of the project. For comprehensive details, including architecture, design decisions, and implementation, please refer to the [Project Documentation (PDF)](./JAVA%20MULTITHREADING%20COMPUTERIZED%20OLD%20MAID%20GAME%20REPORT.pdf).

A Java multithreading and OOP implementation of the Old Maid card game, where players are simulated as threads playing the game automatically.

## Table of Contents
- [Introduction](#introduction)
- [Game Rules](#game-rules)
- [Features](#features)
- [Usage](#usage)
- [Project Design](#project-design)
  
## Introduction

The Old Maid game demonstrates the use of Java multithreading to simulate concurrent processes. Each player in the game is represented as a separate thread, with synchronization ensuring an efficient and orderly execution. The implementation adheres to object-oriented design principles for clarity, maintainability, and scalability.

## Game Rules

1. The game is played using a standard 52-card deck plus one additional Joker card.
2. Players discard matching pairs (same value, same color) from their hands.
   - Spades (♠) match with Clubs (♣).
   - Diamonds (♦) match with Hearts (♥).
3. A random card is passed between players in a circular fashion.
4. The game continues until one player remains with the Joker, who is declared the loser.

## Features

- **Java Multithreading**: Each player is a separate thread. Efficient synchronization ensures smooth gameplay.
- **Object-Oriented Design**: Classes like `Game`, `Player`, `DeckManager`, and `TurnManager` encapsulate distinct responsibilities.
- **Fully Automated Gameplay**: The game runs autonomously without human input.
- **Efficient Synchronization**: Threads use `wait` and `notify` mechanisms for optimal CPU usage.

## Usage

-   The game accepts the number of players as input (2-12).
-   Players will automatically draw cards, discard pairs, and pass cards until a winner is determined.
-   At the end of the game, results are displayed.

Project Design
--------------

### Core Classes

-   **`Game`**: Initializes and starts the game. Manages players and results.
-   **`Player`**: Represents a player in the game. Extends the `Thread` class.
-   **`DeckManager`**: Handles card distribution and drawing.
-   **`TurnManager`**: Controls turn progression and synchronization.
-   **`DeckFactory`**: Creates and shuffles the card deck.
-   **`Card`**: Represents individual cards with attributes like suit, color, and rank.

### Synchronization

-   **Stages of Gameplay**:
    1.  **Drawing Cards**: Threads draw cards in turn.
    2.  **Discarding Matches**: Threads discard matching pairs.
    3.  **Gameplay**: Players pass cards and check for matches.
-   Threads use `wait()` and `notifyAll()` to coordinate turns efficiently.

Documentation
-------------

For detailed documentation on the system's architecture, design, and implementation, please refer to the [Project Documentation (PDF)](./JAVA%20MULTITHREADING%20COMPUTERIZED%20OLD%20MAID%20GAME%20REPORT.pdf).

