package br.com.weslei.bender.api.duelcards.domain.card.exception;

public class CardNotFoundException extends Exception {
    public CardNotFoundException() {
        super("Carta não encontrada");
    }
}
