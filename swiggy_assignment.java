import java.util.Random;

// Class representing a player in the magical arena
class Player {
    private int health;
    private final int attack;
    private final int strength;

    // Constructor to initialize player's attributes
    public Player(int health, int attack, int strength) {
        this.health = health;
        this.attack = attack;
        this.strength = strength;
    }

    // Getter methods for player attributes
    public int getHealth() {
        return this.health;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getStrength() {
        return this.strength;
    }

    // Check if the player is still alive
    public boolean isAlive() {
        return this.health > 0;
    }

    // Reduce the player's health by a given damage amount
    public void reduceHealth(int damage) {
        this.health -= damage;
    }
}

// Class representing the magical arena where the battle occurs
class MagicalArena {
    private static final int DICE_SIDES = 6;  // Using constant for dice sides
    private static final Random RANDOM = new Random();  
    private final Player playerA;
    private final Player playerB;

    private static int rollDice() {
        return RANDOM.nextInt(DICE_SIDES) + 1;
    }

    // Constructor to initialize players and random generator
    public MagicalArena(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    // Simulates a single attack round
    private void simulateAttack(Player attacker, Player defender) {
        int attackRoll = rollDice();
        int defenceRoll = rollDice();

        int damage = (attackRoll * attacker.getAttack()) - (defenceRoll * defender.getStrength());
        if (damage > 0) {
            defender.reduceHealth(damage);
        }
    }

    // Executes the fight between the two players
    public void startBattle() {
        Player attacker = determineInitialAttacker();
        Player defender = attacker == playerA ? playerB : playerA;

        // Continue the battle while both players are alive
        while (attacker.isAlive() && defender.isAlive()) {
            simulateAttack(attacker, defender);
            // Swap roles for the next round
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        announceWinner();
    }

    // Determines the initial attacker based on the players' health
    private Player determineInitialAttacker() {
        return playerA.getHealth() < playerB.getHealth() ? playerA : playerB;
    }

    // Announce the winner after the fight
    private void announceWinner() {
        if (playerA.isAlive()) {
            System.out.println("Player A Wins!");
        } else {
            System.out.println("Player B Wins!");
        }
    }
}

// Main class to run the battle simulation
public class swiggy_assignment {

    public static void main(String[] args) {
        // Initialize players with health, attack, and strength values
        Player playerA = new Player(10, 20, 30);
        Player playerB = new Player(10, 20, 30);

        // Create a magical arena and start the battle
        MagicalArena arena = new MagicalArena(playerA, playerB);
        arena.startBattle();
    }
}
