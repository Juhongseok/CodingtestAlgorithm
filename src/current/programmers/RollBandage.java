package current.programmers;

public class RollBandage {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        int answer = solution.solution(bandage, health, attacks);

        System.out.println("answer = " + answer);
    }

    static class Solution {

        public int solution(int[] bandage, int health, int[][] attacks) {
            int[] attackPerSeconds = init(attacks);

            Bandage band = new Bandage(bandage);
            Player player = new Player(health, band);

            for (int i = 0; i < attackPerSeconds.length; i++) {
                if (player.isDie()) {
                    break;
                }

                if (attackPerSeconds[i] != 0) {
                    player.hit(attackPerSeconds[i]);
                    continue;
                }

                player.heal();
            }

            return player.currentHealth();
        }

        private int[] init(int[][] attacks) {
            int maxSecond = attacks[attacks.length - 1][0];
            int[] attacksPerSeconds = new int[maxSecond + 1];

            int attackIndex = 0;

            for (int second = 0; second < maxSecond + 1; second++) {
                if (attacks[attackIndex][0] == second) {
                    attacksPerSeconds[second] = attacks[attackIndex][1];
                    attackIndex++;
                }
            }

            return attacksPerSeconds;
        }

        static class Player {
            private int currentHealth;
            private int maxHealth;
            private Bandage bandage;

            public Player(int maxHealth, Bandage bandage) {
                this.currentHealth = maxHealth;
                this.maxHealth = maxHealth;
                this.bandage = bandage;
            }

            public void hit(int attackPerSecond) {
                currentHealth -= attackPerSecond;
                bandage.clear();
            }

            public void heal() {
                currentHealth = bandage.heal(currentHealth);
                currentHealth = Math.min(currentHealth, maxHealth);
            }

            public int currentHealth() {
                return isDie() ? -1 : currentHealth;
            }

            public boolean isDie() {
                return currentHealth <= 0;
            }

        }

        static class Bandage {
            private int healingAmount;
            private int processedHealingSecond;
            private int maxHealingSecond;
            private int bonusHealingAmount;

            public Bandage(int[] bandage) {
                this.processedHealingSecond = 0;
                this.maxHealingSecond = bandage[0];
                this.healingAmount = bandage[1];
                this.bonusHealingAmount = bandage[2];
            }

            public int heal(int currentHealth) {
                int healedHealth = currentHealth + healingAmount;
                processedHealingSecond++;

                return completeHeal(healedHealth);
            }

            private int completeHeal(int healedHealth) {
                if (processedHealingSecond == maxHealingSecond) {
                    healedHealth += bonusHealingAmount;
                    clear();
                }

                return healedHealth;
            }

            public void clear() {
                processedHealingSecond = 0;
            }

        }

    }

}
