package br.com.weslei.bender.api.duelcards.service.card;

import br.com.weslei.bender.api.duelcards.converter.CardConverter;
import br.com.weslei.bender.api.duelcards.domain.card.Card;
import br.com.weslei.bender.api.duelcards.domain.card.dto.request.CreateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.request.UpdateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.response.CardResponseDto;
import br.com.weslei.bender.api.duelcards.repository.CardRepository;
import br.com.weslei.bender.api.duelcards.service.CardServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CardServiceImplTest {

    @InjectMocks
    private CardServiceImpl cardService;

    @Mock
    private CardRepository cardRepository;

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
    void saveCard_withSuccess() {
        //Arrange
        var request = mock(CreateCardRequestDto.class);
        var card = mock(Card.class);

        when(cardConverter.toCard(request)).thenReturn(card);
        //Act && Assert
        assertDoesNotThrow(() -> cardService.saveCard(request));
        verify(cardRepository).save(card);

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
    void updateCard_withSuccess() {
        //Arrange
        var request = mock(UpdateCardRequestDto.class);
        var card = mock(Card.class);
        var cardToBeUpdated = mock(Card.class);

        when(cardRepository.findById(request.getId()))
                .thenReturn(Optional.of(card));
        when(cardConverter.toCard(request)).thenReturn(cardToBeUpdated);
        //Act && Assert
        assertDoesNotThrow(() -> cardService.updateCard(request));
        verify(cardRepository).save(cardToBeUpdated);
    }

    @Test
    void updateCard_withNotFoundException() {
        //Arrange
        var request = mock(UpdateCardRequestDto.class);

        when(cardRepository.findById(request.getId()))
                .thenReturn(Optional.empty());
        //Act && Assert
        assertThrows(Exception.class, () -> cardService.updateCard(request));
    }

}