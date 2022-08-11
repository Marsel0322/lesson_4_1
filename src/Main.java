import java.util.Random;

public class Main {
    public static int bossHealth = 700;
    public static int bossDamage = 50;
    public static String bossDefence;
    public static int[] heroesHealth = {280, 270, 250, 200, 290, 240, 230, 310};
    public static int[] heroesDamage = {10, 15, 20, 0, 10, 15, 14, 5};
    public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic", "Medick", "Thor", "lucky", "Berserk", "Golem"};
    public static int roundNumber = 0;

    public static void main(String[] args) {
        printStatistics();
        while (!isGameFinished()) {
            playRound();
        }
    }

    public static void playRound() {
        roundNumber++;
        chooseBossDefence();
        bossHits();
        heroesHit();
        printStatistics();
        Medik();
        thor();
        lucky();
        Berserk();
        Golem();
    }
    public static void Medik() {
        Random random = new Random();
       int Medickhealth = random. nextInt(heroesAttackType.length);
        for (int i = 0; i < heroesHealth.length; i++) {
            if (i == 3) {
                continue;
            }
            if (heroesHealth[i] > 0 && heroesHealth[i] < 100 && heroesHealth[i] > 0){
                heroesHealth[Medickhealth]+= 50;
            }
            System.out.println("Medick healed :" +heroesAttackType[Medickhealth]);
            break;
            }

        }
public static void thor() {
        Random random = new Random();
        boolean Thor = random.nextBoolean();
        if (Thor){
            bossDamage = 0;
            System.out.println("Boss oglushon");
        }else {
            bossDamage = 50;
        }
}
public static void lucky() {
        Random random = new Random();
        int evasion = random. nextInt(3)+1;
        switch (evasion){
            case 1:
                heroesHealth[5]=heroesHealth[5] + bossDamage;
                System.out.println("lucky");
            case 2:
            case 3:
            case 4:
        }
}
public static void Berserk() {
    Random random = new Random();
    int randomDamage = random.nextInt(15)+1;
    int randomeS = random.nextInt(3)+1;
    if (heroesHealth[6]>0 && bossHealth>0){
        switch (randomeS) {
            case 1:
                heroesDamage[6]=(heroesDamage[6]+bossDamage)-randomDamage;
                System.out.println("Берсерк урон критичиский");
                System.out.println("потеря при увиличении урона: "+randomDamage);
                break;
            case 2:
                bossDamage=50;
                break;
                case 3:
                bossDamage=50;
                break;

        }
    }

}
public static void Golem() {
    for (int i = 0; i < heroesHealth.length ; i++) {
        if (heroesHealth[7] > 0 && heroesHealth[i] > 0 && heroesHealth[7] != heroesHealth[i]){
            heroesHealth[i] += bossDamage / 5;
            heroesHealth[7] -= bossDamage / 5;
        }
    }
}
    public static void chooseBossDefence() {
        Random random = new Random();
        int randomIndex = random.nextInt(heroesAttackType.length); // 0,1,2
        bossDefence = heroesAttackType[randomIndex];
    }

    public static void bossHits() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                if (heroesHealth[i] - bossDamage < 0) {
                    heroesHealth[i] = 0;
                } else {
                    heroesHealth[i] = heroesHealth[i] - bossDamage;
                }
            }
        }
    }

    public static void heroesHit() {
        for (int i = 0; i < heroesDamage.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                if (bossDefence == heroesAttackType[i]) {
                    Random random = new Random();
                    int coeff = random.nextInt(9) + 2; // 2,3,4,5,6,7,8,9,10
                    if (bossHealth - heroesDamage[i] * coeff < 0) {
                        bossHealth = 0;
                    } else {
                        bossHealth = bossHealth - heroesDamage[i] * coeff;
                    }
                    System.out.println("Critical damage: " + heroesDamage[i] * coeff);
                } else {
                    if (bossHealth - heroesDamage[i] < 0) {
                        bossHealth = 0;
                    } else {
                        bossHealth = bossHealth - heroesDamage[i];
                    }
                }
            }
        }
    }

    public static boolean isGameFinished() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        /*if (heroesHealth[0] <= 0 && heroesHealth[1] <= 0 && heroesHealth[2] <= 0) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;*/
        boolean allHeroesDead = true;
        for (int healthOfCurrentHero : heroesHealth) {
            if (healthOfCurrentHero > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    public static void printStatistics() {
        if (roundNumber == 0) {
            System.out.println("BEFORE START -------------");
        } else {
            System.out.println("ROUND " + roundNumber + " -------------");
        }
        /*String value;
        if (bossDefence == null) {
            value = "No defence";
        } else {
            value = bossDefence;
        }*/
        System.out.println("Boss health: " + bossHealth + "; damage: "
                + bossDamage + "; defence: "
                + (bossDefence == null ? "No defence" : bossDefence));
        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesAttackType[i] + " health: " +
                    heroesHealth[i] + "; damage: " + heroesDamage[i]);
        }
    }
}
