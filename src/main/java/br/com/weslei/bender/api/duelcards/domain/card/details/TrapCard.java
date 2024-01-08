package br.com.weslei.bender.api.duelcards.domain.card.details;

import br.com.weslei.bender.api.duelcards.domain.card.Card;
import br.com.weslei.bender.api.duelcards.domain.card.enumeration.CardType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "trap_card")
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TrapCard extends Card {

    private String trapType;

    @Override
    public CardType getCardType() {
        return CardType.TRAP;
    }
}
