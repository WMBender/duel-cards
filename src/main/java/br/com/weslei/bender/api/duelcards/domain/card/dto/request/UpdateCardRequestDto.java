package br.com.weslei.bender.api.duelcards.domain.card.dto.request;

import br.com.weslei.bender.api.duelcards.domain.card.details.MonsterAttribute;
import br.com.weslei.bender.api.duelcards.domain.card.details.MonsterType;
import br.com.weslei.bender.api.duelcards.domain.card.details.SpellType;
import br.com.weslei.bender.api.duelcards.domain.card.details.TrapType;
import br.com.weslei.bender.api.duelcards.domain.card.enumeration.CardRarity;
import br.com.weslei.bender.api.duelcards.domain.card.enumeration.CardType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCardRequestDto {

    @NotNull
    Long id;

    @Size(min = 1, max = 200)
    private String name;

    @Size(min = 1, max = 500)
    private String description;

    @NotNull
    private CardType cardType;

    private CardRarity cardRarity;

    private MonsterAttribute monsterAttribute;

    private MonsterType monsterType;

    private Boolean hasEffect;

    @Min(value = 1, message = "Nível inválido: deve ser pelo menos 1")
    @Max(value = 12, message = "Nível inválido: deve ser no máximo 12")
    private Integer level;

    private Integer attackPoints;

    private Integer defensePoints;

    private SpellType spellType;

    private TrapType trapType;
}
