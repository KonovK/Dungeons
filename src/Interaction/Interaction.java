package Interaction;

import heroes.Monster;
import heroes.Player;

public class Interaction {

    public static int interactionMonster(Player player, Monster monster) {
        player.info();
        while (player.getHealth() > 0 && monster.getHealth() > 0) {
            playerAttack(player, monster);
            monsterAttack(player, monster);
        }
        if (player.getHealth() > 0) {
            System.out.println("Игрок победил!");
        } else if (monster.getHealth() > 0) {
            System.out.println("Монстер победил!");
        }
        return player.getHealth();
    }
    public static void playerAttack(Player player, Monster monster) {
        int damage = player.getAttack() - monster.getDef();
        if (damage <= 2) {
            damage = 2;
        }
        monster.setHealth(monster.getHealth() - damage);
    }
    public static void monsterAttack(Player player, Monster monster) {
        int damage = monster.getAttack() - player.getDef();
        if (damage <= 2) {
            damage = 2;
        }
        player.setHealth(player.getHealth() - damage);
    }

}
