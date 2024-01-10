package br.com.weslei.bender.api.duelcards.domain.card.dto.response;

import br.com.weslei.bender.api.duelcards.domain.card.details.MonsterAttribute;
import br.com.weslei.bender.api.duelcards.domain.card.details.MonsterType;
import br.com.weslei.bender.api.duelcards.domain.card.details.SpellType;
import br.com.weslei.bender.api.duelcards.domain.card.details.TrapType;
import br.com.weslei.bender.api.duelcards.domain.card.enumeration.CardRarity;
import br.com.weslei.bender.api.duelcards.domain.card.enumeration.CardType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardResponseDto {

    private Long id;

    private String name;

    private String description;

    private CardType cardType;

    private CardRarity cardRarity;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime updatedAt;

    private MonsterAttribute monsterAttribute;

    private MonsterType monsterType;

    private Boolean hasEffect;

    private Integer level;

    private Integer attackPoints;

    private Integer defensePoints;

    private SpellType spellType;

    private TrapType trapType;

}
