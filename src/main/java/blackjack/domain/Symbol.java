package blackjack.domain;

public enum Symbol {
    ACE(1, "A"),
    TWO(2, "2"),
    THREE(3, "3");

    private static final int ZERO = 0;
    private static final int ACE_BONUS_SCORE = 10;
    private static final int MAXIMUM_SCORE_FOR_ACE_BONUS_SCORE = 11;

    private final int score;
    private final String name;

    Symbol(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public int calculateAceBonusScore(int score, int aceCounts) {
        int scoreWithAceBonus = score;
        for (int i = ZERO; i < aceCounts; i++) {
            int aceBonusScore = findAceBonusScore(scoreWithAceBonus);
            scoreWithAceBonus += aceBonusScore;
        }
        return scoreWithAceBonus - score;
    }

    private int findAceBonusScore(int score) {
        if (score < MAXIMUM_SCORE_FOR_ACE_BONUS_SCORE) {
            return ACE_BONUS_SCORE;
        }
        return ZERO;
    }

    public boolean isAce() {
        return this == ACE;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}
