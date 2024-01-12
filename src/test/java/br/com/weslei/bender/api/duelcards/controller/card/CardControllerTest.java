package br.com.weslei.bender.api.duelcards.controller.card;

import br.com.weslei.bender.api.duelcards.domain.card.dto.request.CreateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.request.UpdateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.response.CardResponseDto;
import br.com.weslei.bender.api.duelcards.domain.card.exception.CardNotFoundException;
import br.com.weslei.bender.api.duelcards.service.CardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.apache.commons.lang3.RandomUtils.nextLong;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CardControllerTest {

    @InjectMocks
    private CardController cardController;

    @Mock
    private CardService cardService;

    @Test
    void getCards_withSuccess() {
        //Arrange
        var cardResponseDto = mock(CardResponseDto.class);
        var expectedResponse = List.of(cardResponseDto);

        when(cardService.getAllCards()).thenReturn(expectedResponse);

        //Act
        var result = cardController.getCards();

        //Assert
        assertEquals(expectedResponse, result);
    }

    @Test
    void getCardById_withSuccess() throws CardNotFoundException {
        //Arrange
        var cardId = nextLong();
        var expectedResponse = mock(CardResponseDto.class);

        when(cardService.getCardById(cardId)).thenReturn(expectedResponse);

        //Act
        var result = cardController.getCardById(cardId);

        //Assert
        assertEquals(expectedResponse, result);
    }

    @Test
    void createCard_withSuccess() {
        //Arrange
        var request = mock(CreateCardRequestDto.class);

        doNothing().when(cardService).saveCard(request);

        //Act && Assert
        assertDoesNotThrow(() -> cardController.createCard(request));

    }

    @Test
    void updateCard_withSuccess() throws CardNotFoundException {
        //Arrange
        var request = mock(UpdateCardRequestDto.class);

        doNothing().when(cardService).updateCard(request);

        //Act && Assert
        assertDoesNotThrow(() -> cardController.updateCard(request));

    }

    @Test
    void deleteCard_withSuccess() throws CardNotFoundException {
        //Arrange
        var cardId = nextLong();

        doNothing().when(cardService).deleteCard(cardId);

        //Act && Assert
        assertDoesNotThrow(() -> cardController.deleteCard(cardId));
    }
}
