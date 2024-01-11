package br.com.weslei.bender.api.duelcards.service.card;

import br.com.weslei.bender.api.duelcards.converter.CardConverter;
import br.com.weslei.bender.api.duelcards.domain.card.Card;
import br.com.weslei.bender.api.duelcards.domain.card.details.MonsterAttribute;
import br.com.weslei.bender.api.duelcards.domain.card.details.MonsterCard;
import br.com.weslei.bender.api.duelcards.domain.card.details.MonsterType;
import br.com.weslei.bender.api.duelcards.domain.card.details.SpellCard;
import br.com.weslei.bender.api.duelcards.domain.card.details.SpellType;
import br.com.weslei.bender.api.duelcards.domain.card.details.TrapCard;
import br.com.weslei.bender.api.duelcards.domain.card.details.TrapType;
import br.com.weslei.bender.api.duelcards.domain.card.dto.request.CreateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.request.UpdateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.response.CardResponseDto;
import br.com.weslei.bender.api.duelcards.domain.card.enumeration.CardRarity;
import br.com.weslei.bender.api.duelcards.domain.card.enumeration.CardType;
import br.com.weslei.bender.api.duelcards.domain.card.exception.CardNotFoundException;
import br.com.weslei.bender.api.duelcards.repository.CardRepository;
import br.com.weslei.bender.api.duelcards.repository.MonsterRepository;
import br.com.weslei.bender.api.duelcards.repository.SpellRepository;
import br.com.weslei.bender.api.duelcards.repository.TrapRepository;
import br.com.weslei.bender.api.duelcards.service.CardServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.apache.commons.lang3.RandomUtils.nextLong;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CardServiceImplTest {

    @InjectMocks
    private CardServiceImpl cardService;

    @Mock
    private CardRepository cardRepository;

    @Mock
    private MonsterRepository monsterRepository;

    @Mock
    private SpellRepository spellRepository;

    @Mock
    private TrapRepository trapRepository;

    @Mock
    private CardConverter cardConverter;

    @Test
    void getAllCards_withSuccess() {
        //Arrange
        var card = mock(Card.class);
        var cardResponseDto = new CardResponseDto();
        var expected = List.of(cardResponseDto);

        when(cardRepository.findAll()).thenReturn((List.of(card)));
        when(cardConverter.toCardResponseDto(card)).thenReturn(cardResponseDto);
        //Act
        var result = cardService.getAllCards();

        //Assert
        assertEquals(expected, result);
    }

    @Test
    void getCardById_withSuccess() throws Exception {
        //Arrange
        var cardId = 7L;
        var card = mock(Card.class);
        var expected = new CardResponseDto();

        when(cardRepository.findById(cardId)).thenReturn(Optional.of(card));
        when(cardConverter.toCardResponseDto(card)).thenReturn(expected);
        //Act
        var result = cardService.getCardById(cardId);

        //Assert
        assertEquals(expected, result);
    }

    @Test
    void getCardById_withNotFoundException() {
        //Arrange
        var cardId = 7L;

        when(cardRepository.findById(cardId)).thenReturn(Optional.empty());
        //Act && Assert
        assertThrows(Exception.class, () ->
                cardService.getCardById(cardId)
        );
    }

    @Test
    void saveCard_withMonsterCard_withSuccess() {
        //Arrange
        var request = createMonsterRequestDto();
        var card = mock(MonsterCard.class);

        when(cardConverter.toMonsterCard(request)).thenReturn(card);
        //Act && Assert
        assertDoesNotThrow(() -> cardService.saveCard(request));
        verify(monsterRepository).save(card);

    }

    @Test
    void saveCard_withSpellCard_withSuccess() {
        //Arrange
        var request = createSpellRequestDto();
        var card = mock(SpellCard.class);

        when(cardConverter.toSpellCard(request)).thenReturn(card);
        //Act && Assert
        assertDoesNotThrow(() -> cardService.saveCard(request));
        verify(spellRepository).save(card);

    }

    @Test
    void saveCard_withTrapCard_withSuccess() {
        //Arrange
        var request = createTrapRequestDto();
        var card = mock(TrapCard.class);

        when(cardConverter.toTrapCard(request)).thenReturn(card);
        //Act && Assert
        assertDoesNotThrow(() -> cardService.saveCard(request));
        verify(trapRepository).save(card);

    }

    @Test
    void deleteCard_withSuccess() {
        //Arrange
        var cardId = 10L;
        var card = mock(Card.class);

        when(cardRepository.findById(cardId))
                .thenReturn(Optional.of(card));
        //Act && Assert

        assertDoesNotThrow(() -> cardService.deleteCard(cardId));
        verify(cardRepository).delete(card);
    }

    @Test
    void deleteCard_withNotFoundException() {
        //Arrange
        var cardId = 10L;

        when(cardRepository.findById(cardId))
                .thenReturn(Optional.empty());
        //Act && Assert
        assertThrows(Exception.class, () -> cardService.deleteCard(cardId));
    }

    @Test
    void updateCard_withMonsterCard_withSuccess() throws Exception {
        //Arrange
        CardServiceImpl serviceSpy = spy(cardService);
        var request = mock(UpdateCardRequestDto.class);
        var card = mock(MonsterCard.class);
        var cardId = 1L;

        when(request.getCardType()).thenReturn(CardType.MONSTER);
        when(request.getId()).thenReturn(cardId);
        doReturn(card)
                .when(serviceSpy).findMonsterCardThrowsExceptionIfNotFound(cardId);

        //Act && Assert
        assertDoesNotThrow(() -> serviceSpy.updateCard(request));
        verify(card).update(request);
        verify(monsterRepository).save(card);
    }

    @Test
    void updateCard_withSpellCard_withSuccess() throws Exception {
        //Arrange
        CardServiceImpl serviceSpy = spy(cardService);
        var request = mock(UpdateCardRequestDto.class);
        var card = mock(SpellCard.class);
        var cardId = 1L;

        when(request.getCardType()).thenReturn(CardType.SPELL);
        when(request.getId()).thenReturn(cardId);
        doReturn(card)
                .when(serviceSpy).findSpellCardThrowsExceptionIfNotFound(cardId);

        //Act && Assert
        assertDoesNotThrow(() -> serviceSpy.updateCard(request));
        verify(card).update(request);
        verify(spellRepository).save(card);
    }

    @Test
    void updateCard_withTrapCard_withSuccess() throws Exception {
        //Arrange
        CardServiceImpl serviceSpy = spy(cardService);
        var request = mock(UpdateCardRequestDto.class);
        var card = mock(TrapCard.class);
        var cardId = 1L;

        when(request.getCardType()).thenReturn(CardType.TRAP);
        when(request.getId()).thenReturn(cardId);
        doReturn(card)
                .when(serviceSpy).findTrapCardThrowsExceptionIfNotFound(cardId);
        //Act && Assert
        assertDoesNotThrow(() -> serviceSpy.updateCard(request));
        verify(card).update(request);
        verify(trapRepository).save(card);
    }

    @Test
    void updateCard_withNotFoundException() {
        //Arrange
        var request = mock(UpdateCardRequestDto.class);

        when(request.getCardType()).thenReturn(CardType.MONSTER);
        when(monsterRepository.findById(request.getId()))
            .thenReturn(Optional.empty());
        //Act && Assert
        assertThrows(CardNotFoundException.class, () -> cardService.updateCard(request));
    }

    @Test
    void findMonsterCardThrowsExceptionIfNotFound_withSuccess() throws CardNotFoundException {
        //Arrange
        var cardId = nextLong();
        var card = new MonsterCard();

        when(monsterRepository.findById(cardId)).thenReturn(Optional.of(card));
        //Act
        var result = cardService.findMonsterCardThrowsExceptionIfNotFound(cardId);

        //Assert
        assertEquals(card, result);
    }

    @Test
    void findMonsterCardThrowsExceptionIfNotFound_withNotFoundException() {
        //Arrange
        var cardId = nextLong();
        var card = new MonsterCard();

        when(monsterRepository.findById(cardId)).thenReturn(Optional.empty());
        //Act && Assert
        assertThrows(CardNotFoundException.class, () ->
            cardService.findMonsterCardThrowsExceptionIfNotFound(cardId)
        );
    }

    @Test
    void findSpellCardThrowsExceptionIfNotFound_withSuccess() throws CardNotFoundException {
        //Arrange
        var cardId = nextLong();
        var card = new SpellCard();

        when(spellRepository.findById(cardId)).thenReturn(Optional.of(card));
        //Act
        var result = cardService.findSpellCardThrowsExceptionIfNotFound(cardId);

        //Assert
        assertEquals(card, result);
    }

    @Test
    void findSpellCardThrowsExceptionIfNotFound_withNotFoundException() {
        //Arrange
        var cardId = nextLong();
        var card = new MonsterCard();

        when(spellRepository.findById(cardId)).thenReturn(Optional.empty());
        //Act && Assert
        assertThrows(CardNotFoundException.class, () ->
            cardService.findSpellCardThrowsExceptionIfNotFound(cardId)
        );
    }

    @Test
    void findTrapCardThrowsExceptionIfNotFound_withSuccess() throws CardNotFoundException {
        //Arrange
        var cardId = nextLong();
        var card = new TrapCard();

        when(trapRepository.findById(cardId)).thenReturn(Optional.of(card));
        //Act
        var result = cardService.findTrapCardThrowsExceptionIfNotFound(cardId);

        //Assert
        assertEquals(card, result);
    }

    @Test
    void findTrapCardThrowsExceptionIfNotFound_withNotFoundException() {
        //Arrange
        var cardId = nextLong();
        var card = new TrapCard();

        when(trapRepository.findById(cardId)).thenReturn(Optional.empty());
        //Act && Assert
        assertThrows(CardNotFoundException.class, () ->
            cardService.findTrapCardThrowsExceptionIfNotFound(cardId)
        );
    }

    private CreateCardRequestDto createMonsterRequestDto() {
        var monsterCard = MonsterCard.builder()
            .monsterAttribute(MonsterAttribute.FIRE)
            .monsterType(MonsterType.DRAGON)
            .hasEffect(Boolean.FALSE)
            .level(10)
            .attackPoints(3000)
            .defensePoints(2000)
            .build();

        return CreateCardRequestDto.builder()
                .name("dragon")
                .description("A fearsome ancient dragon")
                .cardRarity(CardRarity.COMMON)
                .cardType(CardType.MONSTER)
                .monsterCard(monsterCard)
                .build();

    }

    private CreateCardRequestDto createSpellRequestDto() {
        var spellCard = SpellCard.builder()
                .spellType(SpellType.NORMAL)
                .build();

        return CreateCardRequestDto.builder()
                .name("Pot of happiness")
                .description("Gain 2000LP")
                .cardRarity(CardRarity.COMMON)
                .cardType(CardType.SPELL)
                .spellCard(spellCard)
                .build();

    }

    private CreateCardRequestDto createTrapRequestDto() {
        var trapCard = TrapCard.builder()
                .trapType(TrapType.NORMAL)
                .build();

        return CreateCardRequestDto.builder()
                .name("Close match")
                .description("Remove all cards on the field from play.")
                .cardRarity(CardRarity.COMMON)
                .cardType(CardType.TRAP)
                .trapCard(trapCard)
                .build();

    }

}
