package br.com.weslei.bender.api.duelcards.domain.Player;

import br.com.weslei.bender.api.duelcards.domain.card.Card;
import br.com.weslei.bender.api.duelcards.domain.card.details.MonsterCard;

import java.util.Collections;
import java.util.List;

public class Player {

    private Integer lifePoints;
    private List<Card> deck;
    private List<Card> hand;

    public void draw() throws Exception {
        if (deck.isEmpty()) {
            throw new Exception("No more cards in the deck!");
        }
        Card cardFromDeck = deck.get(0);
        deck.remove(0);
        deck.add(cardFromDeck);
    }

    public void drawTimes(Integer n) throws Exception {
        for (int i = 0; i < n; i++) {
            this.draw();
        }
    }

    public void useEffect(Card card) {

    }

    public void attack(MonsterCard card) {

    }

    public void decreaseLifePoints(Integer damage) throws Exception {
        int decreasedLifePoints = this.lifePoints - damage;
        if (decreasedLifePoints <= 0) {
            throw new Exception("LifePointsDecreaseToZero");
        }
        this.lifePoints = decreasedLifePoints;
    }

    public void increaseLifePoints(Integer points) {
        this.lifePoints += points;
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }
}
