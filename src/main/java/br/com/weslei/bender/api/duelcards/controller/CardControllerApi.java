package br.com.weslei.bender.api.duelcards.controller;

import br.com.weslei.bender.api.duelcards.domain.card.dto.request.UpdateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.request.CreateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.response.CardResponseDto;

import java.util.List;

public interface CardControllerApi {

    List<CardResponseDto> getCards();
    CardResponseDto getCardById(Long cardId) throws Exception;
    void createCard(CreateCardRequestDto requestDto);
    void updateCard(UpdateCardRequestDto requestDto) throws Exception;
    void deleteCard(Long cardId) throws Exception;
}
