package br.com.weslei.bender.api.duelcards.domain.card.dto.request;

import br.com.weslei.bender.api.duelcards.domain.card.Card;
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
    @Size(min = 1, max = 200)
    private String name;

    @NotBlank(message = "Descrição não pode ser nulo!")
    @Size(min = 1, max = 500)
    private String description;

    @NotNull(message = "Tipo da carta não pode ser nulo!")
    private Card.CardType cardType;

    @NotNull(message = "Raridade não pode ser nula!")
    private Card.CardRarity cardRarity;

}
