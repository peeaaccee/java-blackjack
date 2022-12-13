package blackjack.domain;

import java.util.Collections;
import java.util.List;

public class Players {
    private static final int MAXIMUM_PLAYER_COUNTS = 7;
    private static final String INVALID_PLAYER_COUNTS = "게임 참가자의 수는 딜러 제외 최소 1명 최대 7명입니다.";

    private final List<Player> players;

    private Players(List<Player> players) {
        validatePlayerCounts(players);
        validateNameDuplication(players);
        this.players = players;
    }

    private void validatePlayerCounts(List<Player> players) {
        if(players.isEmpty() || players.size() > MAXIMUM_PLAYER_COUNTS) {
            throw new IllegalArgumentException(INVALID_PLAYER_COUNTS);
        }
    }

    private void validateNameDuplication(List<Player> players) {
        int playerCounts = players.size();
        int distinctPlayerCounts = (int) players.stream()
                .map(Player::getName)
                .distinct()
                .count();

        if (playerCounts != distinctPlayerCounts) {
            throw new IllegalArgumentException("참가자들의 이름은 중복이 없어야 합니다.");
        }
    }

    public void receiveDefaultCards(CardDeck cardDeck) {
        players.forEach(player -> player.receiveCards(cardDeck.drawDefaultCards()));
    }

    public List<Player> toList() {
        return Collections.unmodifiableList(players);
    }
}
