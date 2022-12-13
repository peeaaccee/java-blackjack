package blackjack.domain;

import rentcar.Car;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CardsGenerator {

    private CardsGenerator() {
    }

    public static List<Card> generateCards() {
        return Arrays.stream(Symbol.values())
                .flatMap(CardsGenerator::generateCardsWithEachSymbol)
                .collect(Collectors.toList());
    }

    private static Stream<Card> generateCardsWithEachSymbol(Symbol symbol) {
        return Arrays.stream(Shape.values())
                .map(shape -> new Card(symbol, shape));
    }
}
