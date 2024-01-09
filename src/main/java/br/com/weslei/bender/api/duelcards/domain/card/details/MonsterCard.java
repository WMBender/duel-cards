package br.com.weslei.bender.api.duelcards.domain.card.details;

import br.com.weslei.bender.api.duelcards.domain.card.Card;
import br.com.weslei.bender.api.duelcards.domain.card.enumeration.CardType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "monster_card")
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MonsterCard extends Card {

    @Enumerated(EnumType.STRING)
    private MonsterAttribute monsterAttribute;

    @Enumerated(EnumType.STRING)
    private MonsterType monsterType;

    private Boolean hasEffect;

    private Integer level;

    private Integer attackPoints;

    private Integer defensePoints;

    @Override
    public CardType getCardType() {
        return CardType.MONSTER;
    }
}
