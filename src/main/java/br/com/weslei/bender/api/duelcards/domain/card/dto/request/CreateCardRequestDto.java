package br.com.weslei.bender.api.duelcards.domain.card.dto.request;

import br.com.weslei.bender.api.duelcards.domain.card.details.MonsterCard;
import br.com.weslei.bender.api.duelcards.domain.card.details.SpellCard;
import br.com.weslei.bender.api.duelcards.domain.card.details.TrapCard;
import br.com.weslei.bender.api.duelcards.domain.card.enumeration.CardRarity;
import br.com.weslei.bender.api.duelcards.domain.card.enumeration.CardType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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
public class CreateCardRequestDto {

    @NotBlank(message = "Nome não pode ser nulo!")
    @Size(min = 1, max = 200, message = "Nome: Tamanho deve ser entre 1 e 200")
    private String name;

    @NotBlank(message = "Descrição não pode ser nulo!")
    @Size(min = 1, max = 500, message = "Descrição: Tamanho deve ser entre 1 e 500")
    private String description;

    @NotNull(message = "Tipo da carta: Não pode ser nulo!")
    private CardType cardType;

    @NotNull(message = "Raridade da carta: Não pode ser nula!")
    private CardRarity cardRarity;

    @Valid
    @JsonProperty(value = "monsterDetails")
    private MonsterCard monsterCard;

    @JsonProperty(value = "spellDetails")
    private SpellCard spellCard;

    @JsonProperty(value = "trapDetails")
    private TrapCard trapCard;

}
