package br.com.weslei.bender.api.duelcards.domain.card.dto.response;

import br.com.weslei.bender.api.duelcards.domain.card.Card;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardResponseDto {

    private Long id;

    private String name;

    private String description;

    private Card.CardType cardType;

    private Card.CardRarity cardRarity;

    private LocalDateTime createdAt;

    private LocalDateTime updateAt;

}
