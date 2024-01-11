package br.com.weslei.bender.api.duelcards.service;

import br.com.weslei.bender.api.duelcards.domain.card.dto.request.CreateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.request.UpdateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.response.CardResponseDto;
import br.com.weslei.bender.api.duelcards.domain.card.exception.CardNotFoundException;

import java.util.List;

public interface CardService {

    List<CardResponseDto> getAllCards();

    CardResponseDto getCardById(Long cardId) throws CardNotFoundException;

    void saveCard(CreateCardRequestDto request);

    void deleteCard(Long cardId) throws CardNotFoundException;

    void updateCard(UpdateCardRequestDto requestDto) throws CardNotFoundException;
}
