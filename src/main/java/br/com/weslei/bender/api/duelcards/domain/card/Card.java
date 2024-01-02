package br.com.weslei.bender.api.duelcards.domain.card;

import br.com.weslei.bender.api.duelcards.domain.card.dto.request.UpdateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.request.CreateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.response.CardResponseDto;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Table(name = "card")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @Enumerated(EnumType.STRING)
    private CardRarity cardRarity;

    private LocalDateTime createdAt;

    private LocalDateTime updateAt;

    public enum CardType {
        MONSTER,
        MAGIC,
        TRAP
    }

    public enum CardRarity {
        COMMON,
        RARE,
        SUPER_RARE,
        ULTRA_RARE
    }

    public static Card toCard(CreateCardRequestDto requestDto){
        return Card.builder()
            .name(requestDto.getName())
            .description(requestDto.getDescription())
            .cardType(requestDto.getCardType())
            .cardRarity(requestDto.getCardRarity())
            .build();
    }

    public static Card toCard(UpdateCardRequestDto requestDto){
        return Card.builder()
            .id(requestDto.getId())
            .name(requestDto.getName())
            .description(requestDto.getDescription())
            .cardType(requestDto.getCardType())
            .cardRarity(requestDto.getCardRarity())
            .build();
    }

    public static CardResponseDto toCardResponseDto(Card card){
        return CardResponseDto.builder()
            .id(card.getId())
            .name(card.getName())
            .description(card.getDescription())
            .cardType(card.getCardType())
            .cardRarity(card.getCardRarity())
            .createdAt(card.getCreatedAt())
            .updateAt(card.getUpdateAt())
            .build();
    }
}
