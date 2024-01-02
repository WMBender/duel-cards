package br.com.weslei.bender.api.duelcards.service;

import br.com.weslei.bender.api.duelcards.domain.card.dto.request.CreateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.request.UpdateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.response.CardResponseDto;

import java.util.List;

public interface CardService {

    List<CardResponseDto> getAllCards();

    CardResponseDto getCardById(Long cardId) throws Exception;

    void saveCard(CreateCardRequestDto request);

    void deleteCard(Long cardId) throws Exception;

    void updateCard(UpdateCardRequestDto requestDto) throws Exception;
}
