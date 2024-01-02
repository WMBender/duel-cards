package br.com.weslei.bender.api.duelcards.service;

import br.com.weslei.bender.api.duelcards.domain.card.Card;
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

    @Override
    public List<CardResponseDto> getAllCards() {
        return cardRepository.findAll().stream()
            .map(Card::toCardResponseDto)
            .toList();
    }

    @Override
    public CardResponseDto getCardById(Long cardId) throws Exception {
        return cardRepository.findById(cardId)
                .map(Card::toCardResponseDto)
                .orElseThrow(() -> new Exception("Carta não encontrada"));
    }

    @Override
    public void saveCard(CreateCardRequestDto request) {
        var newCard = Card.toCard(request);
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
        cardToBeUpdated = Card.toCard(requestDto);
        cardRepository.save(cardToBeUpdated);
    }
}
