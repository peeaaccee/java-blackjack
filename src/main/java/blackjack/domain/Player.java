package blackjack.domain;

public class Player {
    public class Player extends Participant {
        private static final int MAXIMUM_SCORE_FOR_ADDITIONAL_CARD = 21;

        public Player(String name) {
            super(name);
        }

        @Override
        public boolean isAbleToReceiveCard() {
            int minimumScore = calculateScoreWhenAceUsMinimum();
            return minimumScore < MAXIMUM_SCORE_FOR_ADDITIONAL_CARD;
        }

        public Result judgeResult(Dealer dealer) {
            int dealerScore = dealer.calculateFinalScore();
            int playerScore = calculateFinalScore();
            return Result.judge(dealerScore, playerScore);
        }
    }
}
