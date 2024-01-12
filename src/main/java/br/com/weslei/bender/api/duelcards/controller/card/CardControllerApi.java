package br.com.weslei.bender.api.duelcards.controller.card;

import br.com.weslei.bender.api.duelcards.domain.card.dto.request.CreateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.request.UpdateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.response.CardResponseDto;
import br.com.weslei.bender.api.duelcards.domain.card.exception.CardNotFoundException;

import java.util.List;

public interface CardControllerApi {

    List<CardResponseDto> getCards();

    CardResponseDto getCardById(Long cardId) throws CardNotFoundException;

    void createCard(CreateCardRequestDto requestDto);

    void updateCard(UpdateCardRequestDto requestDto) throws CardNotFoundException;

    void deleteCard(Long cardId) throws CardNotFoundException;
}
