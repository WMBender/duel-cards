package br.com.weslei.bender.api.duelcards.domain.card.details;

import br.com.weslei.bender.api.duelcards.domain.card.Card;
import br.com.weslei.bender.api.duelcards.domain.card.dto.request.UpdateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.enumeration.CardType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static io.micrometer.common.util.StringUtils.isEmpty;
import static java.util.Objects.isNull;

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

    @Min(value = 1, message = "Nível inválido: deve ser pelo menos 1")
    @Max(value = 12, message = "Nível inválido: deve ser no máximo 12")
    private Integer level;

    @NotNull(message = "Pontos de Ataque nulo")
    private Integer attackPoints;

    @NotNull(message = "Pontos de Defesa nulo")
    private Integer defensePoints;

    @Override
    public CardType getCardType() {
        return CardType.MONSTER;
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
        if (!isNull(requestDto.getMonsterAttribute())) {
            this.setMonsterAttribute(requestDto.getMonsterAttribute());
        }
        if (!isNull(requestDto.getMonsterType())) {
            this.setMonsterType(requestDto.getMonsterType());
        }
        if (!isNull(requestDto.getHasEffect())) {
            this.setHasEffect(requestDto.getHasEffect());
        }
        if (!isNull(requestDto.getLevel())) {
            this.setLevel(requestDto.getLevel());
        }
        if (!isNull(requestDto.getAttackPoints())) {
            this.setAttackPoints(requestDto.getAttackPoints());
        }
        if (!isNull(requestDto.getDefensePoints())) {
            this.setDefensePoints(requestDto.getDefensePoints());
        }
    }
}
