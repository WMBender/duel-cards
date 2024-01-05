package br.com.weslei.bender.api.duelcards.domain.card.dto.request;

import br.com.weslei.bender.api.duelcards.domain.card.enumeration.CardRarity;
import br.com.weslei.bender.api.duelcards.domain.card.enumeration.CardType;
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
public class UpdateCardRequestDto {

    @NotNull
    Long id;

    @NotBlank
    @Size(min = 1, max = 200)
    private String name;

    @NotBlank
    @Size(min = 1, max = 500)
    private String description;

    @NotNull
    private CardType cardType;

    @NotNull
    private CardRarity cardRarity;
}
