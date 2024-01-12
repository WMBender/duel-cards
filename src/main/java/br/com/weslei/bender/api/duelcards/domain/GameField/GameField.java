package br.com.weslei.bender.api.duelcards.domain.GameField;

import br.com.weslei.bender.api.duelcards.domain.card.Card;

import java.util.List;

public class GameField {

    private List<Card> p1MonsterZones;
    private List<Card> p1spellTrapZones;
    private List<Card> p1Graveyard;
    private List<Card> p1Banish;
    private Card p1FieldSpell;

    private List<Card> p2MonsterZones;
    private List<Card> p2spellTrapZones;
    private List<Card> p2Graveyard;
    private List<Card> p2Banish;
    private Card p2FieldSpell;

}
