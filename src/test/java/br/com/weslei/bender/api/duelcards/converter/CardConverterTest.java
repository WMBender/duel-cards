package br.com.weslei.bender.api.duelcards.converter;

import br.com.weslei.bender.api.duelcards.domain.card.details.MonsterAttribute;
import br.com.weslei.bender.api.duelcards.domain.card.details.MonsterCard;
import br.com.weslei.bender.api.duelcards.domain.card.details.MonsterType;
import br.com.weslei.bender.api.duelcards.domain.card.details.SpellCard;
import br.com.weslei.bender.api.duelcards.domain.card.details.TrapCard;
import br.com.weslei.bender.api.duelcards.domain.card.dto.request.CreateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.enumeration.CardRarity;
import br.com.weslei.bender.api.duelcards.domain.card.enumeration.CardType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CardConverterTest {

    @InjectMocks
    CardConverter cardConverter;

    @Mock
    ModelMapper modelMapper;

    @Test
    void toMonsterCard() {
        // Arrange
        CreateCardRequestDto requestDto = createSampleRequestDto();
        MonsterCard expectedMonsterCard = createSampleMonsterCard();

        when(modelMapper.map(requestDto, MonsterCard.class)).thenReturn(expectedMonsterCard);

        // Act
        MonsterCard result = cardConverter.toMonsterCard(requestDto);

        // Assert
        assertEquals(expectedMonsterCard, result);
    }

    @Test
    void toSpellCard() {
        //Arrange
        CreateCardRequestDto requestDto = createSampleRequestDto();
        SpellCard expectedSpellCard = createSampleSpellCard();

        when(modelMapper.map(requestDto, SpellCard.class)).thenReturn(expectedSpellCard);

        // Act
        SpellCard result = cardConverter.toSpellCard(requestDto);

        // Assert
        assertEquals(expectedSpellCard, result);
    }

    @Test
    void toTrapCard() {
        //Arrange
        CreateCardRequestDto requestDto = createSampleRequestDto();
        TrapCard expectedTrapCard = createSampleTrapCard();

        when(modelMapper.map(requestDto, TrapCard.class)).thenReturn(expectedTrapCard);

        // Act
        TrapCard result = cardConverter.toTrapCard(requestDto);

        // Assert
        assertEquals(expectedTrapCard, result);
    }

    private CreateCardRequestDto createSampleRequestDto() {

        return CreateCardRequestDto.builder()
                .name("SampleName")
                .description("SampleDescription")
                .cardType(CardType.MONSTER)
                .cardRarity(CardRarity.RARE)
                .monsterCard(createMonsterDetails())
                .build();
    }

    private MonsterCard createSampleMonsterCard() {
        return createMonsterDetails();
    }

    private MonsterCard createMonsterDetails() {
        return MonsterCard.builder()
                .monsterType(MonsterType.DRAGON)
                .monsterAttribute(MonsterAttribute.EARTH)
                .hasEffect(Boolean.TRUE)
                .level(10)
                .attackPoints(3100)
                .defensePoints(2000)
                .build();
    }

    private SpellCard createSampleSpellCard() {
        return SpellCard.builder()
                .spellType("SampleSpellType")
                .build();
    }

    private TrapCard createSampleTrapCard() {
        return TrapCard.builder()
                .trapType("SampleTrapType")
                .build();
    }

//    @Test
//    void toCard_withCreateCardRequestDto_withSuccess() {
//        //Arrange
//        var request = CreateCardRequestDto.builder()
//                .name("testName")
//                .description("testDescription")
//                .cardType(CardType.SPELL)
//                .cardRarity(CardRarity.RARE)
//                .build();
//
//        var card = Card.builder()
//                .name(request.getName())
//                .description(request.getDescription())
//                .cardType(request.getCardType())
//                .cardRarity(request.getCardRarity())
//                .build();
//
//        when(modelMapper.map(request, Card.class))
//                .thenReturn(card);
//        //Act
//        var result = cardConverter.toCard(request);
//
//        //Assert
//        assertEquals(card, result);
//    }
//
//    @Test
//    void testToCard_withUpdateCardRequestDto_withSuccess() {
//        //Arrange
//        var request = UpdateCardRequestDto.builder()
//                .id(1L)
//                .name("testName")
//                .description("testDescription")
//                .cardType(CardType.SPELL)
//                .cardRarity(CardRarity.RARE)
//                .build();
//
//        var card = Card.builder()
//                .id(request.getId())
//                .name(request.getName())
//                .description(request.getDescription())
//                .cardType(request.getCardType())
//                .cardRarity(request.getCardRarity())
//                .build();
//
//        when(modelMapper.map(request, Card.class))
//                .thenReturn(card);
//        //Act
//        var result = cardConverter.toCard(request);
//
//        //Assert
//        assertEquals(card, result);
//    }
//
//    @Test
//    void toCardResponseDto_withSuccess() {
//        //Arrange
//        var card = Card.builder()
//                .id(10L)
//                .name("testName")
//                .description("testDescription")
//                .cardType(CardType.TRAP)
//                .cardRarity(CardRarity.COMMON)
//                .createdAt(LocalDateTime.now())
//                .updatedAt(LocalDateTime.now())
//                .build();
//
//        var response = CardResponseDto.builder()
//                .id(card.getId())
//                .name(card.getName())
//                .description(card.getDescription())
//                .cardType(card.getCardType())
//                .cardRarity(card.getCardRarity())
//                .createdAt(card.getCreatedAt())
//                .updatedAt(card.getUpdatedAt())
//                .build();
//
//        when(modelMapper.map(card, CardResponseDto.class))
//                .thenReturn(response);
//        //Act
//        var result = cardConverter.toCardResponseDto(card);
//
//        //Assert
//        assertEquals(response, result);
//    }


}