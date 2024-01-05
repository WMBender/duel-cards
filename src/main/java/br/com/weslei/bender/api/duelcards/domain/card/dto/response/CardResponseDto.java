package br.com.weslei.bender.api.duelcards.domain.card.dto.response;

import br.com.weslei.bender.api.duelcards.domain.card.enumeration.CardRarity;
import br.com.weslei.bender.api.duelcards.domain.card.enumeration.CardType;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    private CardType cardType;

    private CardRarity cardRarity;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime updatedAt;

}
