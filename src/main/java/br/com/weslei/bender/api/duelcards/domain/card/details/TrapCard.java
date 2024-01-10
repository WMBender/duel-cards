package br.com.weslei.bender.api.duelcards.domain.card.details;

import br.com.weslei.bender.api.duelcards.domain.card.Card;
import br.com.weslei.bender.api.duelcards.domain.card.dto.request.UpdateCardRequestDto;
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

import static io.micrometer.common.util.StringUtils.isEmpty;
import static java.util.Objects.isNull;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "trap_card")
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TrapCard extends Card {

    @Enumerated(EnumType.STRING)
    private TrapType trapType;

    @Override
    public CardType getCardType() {
        return CardType.TRAP;
    }

    public void update(UpdateCardRequestDto requestDto) {
        if (!isEmpty(requestDto.getName())) {
            this.setName(requestDto.getName());
        }
        if (!isEmpty(requestDto.getDescription())) {
            this.setDescription(requestDto.getDescription());
        }
        if (!isNull(requestDto.getCardRarity())) {
            this.setCardRarity(requestDto.getCardRarity());
        }
        if (!isNull(requestDto.getTrapType())) {
            this.setTrapType(requestDto.getTrapType());
        }
    }
}
