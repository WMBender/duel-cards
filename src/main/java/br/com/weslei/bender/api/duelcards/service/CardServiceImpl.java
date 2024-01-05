package br.com.weslei.bender.api.duelcards.service;

import br.com.weslei.bender.api.duelcards.converter.CardConverter;
import br.com.weslei.bender.api.duelcards.domain.card.dto.request.CreateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.request.UpdateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.response.CardResponseDto;
import br.com.weslei.bender.api.duelcards.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    private final CardConverter cardConverter;

    @Override
    public List<CardResponseDto> getAllCards() {
        return cardRepository.findAll().stream()
                .map(cardConverter::toCardResponseDto)
                .toList();
    }

    @Override
    public CardResponseDto getCardById(Long cardId) throws Exception {
        return cardRepository.findById(cardId)
                .map(cardConverter::toCardResponseDto)
                .orElseThrow(() -> new Exception("Carta não encontrada"));
    }

    @Override
    public void saveCard(CreateCardRequestDto request) {
        var newCard = cardConverter.toCard(request);
        cardRepository.save(newCard);
    }

    @Override
    public void deleteCard(Long cardId) throws Exception {
        var cardToBeDeleted = cardRepository.findById(cardId)
                .orElseThrow(() -> new Exception("Carta não encontrada"));
        cardRepository.delete(cardToBeDeleted);
    }

    @Override
    public void updateCard(UpdateCardRequestDto requestDto) throws Exception {
        var cardToBeUpdated = cardRepository.findById(requestDto.getId())
                .orElseThrow(() -> new Exception("Carta não encontrada"));
        cardToBeUpdated = cardConverter.toCard(requestDto);
        cardRepository.save(cardToBeUpdated);
    }
}
