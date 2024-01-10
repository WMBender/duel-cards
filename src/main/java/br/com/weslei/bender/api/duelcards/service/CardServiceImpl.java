package br.com.weslei.bender.api.duelcards.service;

import br.com.weslei.bender.api.duelcards.converter.CardConverter;
import br.com.weslei.bender.api.duelcards.domain.card.Card;
import br.com.weslei.bender.api.duelcards.domain.card.details.MonsterCard;
import br.com.weslei.bender.api.duelcards.domain.card.details.SpellCard;
import br.com.weslei.bender.api.duelcards.domain.card.details.TrapCard;
import br.com.weslei.bender.api.duelcards.domain.card.dto.request.CreateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.request.UpdateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.response.CardResponseDto;
import br.com.weslei.bender.api.duelcards.domain.card.exception.CardNotFoundException;
import br.com.weslei.bender.api.duelcards.repository.CardRepository;
import br.com.weslei.bender.api.duelcards.repository.MonsterRepository;
import br.com.weslei.bender.api.duelcards.repository.SpellRepository;
import br.com.weslei.bender.api.duelcards.repository.TrapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final MonsterRepository monsterRepository;
    private final SpellRepository spellRepository;
    private final TrapRepository trapRepository;

    private final CardConverter cardConverter;

    @Override
    public List<CardResponseDto> getAllCards() {
        return cardRepository.findAll().stream()
                .map(cardConverter::toCardResponseDto)
                .toList();
    }

    @Override
    public CardResponseDto getCardById(Long cardId) throws Exception {
        var foundCard = this.findCardThrowsExceptionIfNotFound(cardId);
        return cardConverter.toCardResponseDto(foundCard);
    }

    @Override
    public void saveCard(CreateCardRequestDto request) {
        switch (request.getCardType()) {
            case MONSTER -> saveMonsterCard(request);
            case SPELL -> saveSpellCard(request);
            case TRAP -> saveTrapCard(request);
        }
    }

    private void saveMonsterCard(CreateCardRequestDto monsterCard) {
        var monsterDetails = cardConverter.toMonsterCard(monsterCard);
        monsterRepository.save(monsterDetails);
    }

    private void saveSpellCard(CreateCardRequestDto spellCard) {
        var spellDetails = cardConverter.toSpellCard(spellCard);
        spellRepository.save(spellDetails);
    }

    private void saveTrapCard(CreateCardRequestDto trapCard) {
        var trapDetails = cardConverter.toTrapCard(trapCard);
        trapRepository.save(trapDetails);
    }

    @Override
    public void deleteCard(Long cardId) throws Exception {
        var cardToBeDeleted = this.findCardThrowsExceptionIfNotFound(cardId);
        cardRepository.delete(cardToBeDeleted);
    }

    @Override
    public void updateCard(UpdateCardRequestDto requestDto) throws Exception {
        switch (requestDto.getCardType()) {
            case MONSTER -> updateMonster(requestDto);
            case SPELL -> updateSpell(requestDto);
            case TRAP -> updateTrap(requestDto);
        }
    }

    protected void updateMonster(UpdateCardRequestDto requestDto) throws Exception {
        var card = this.findMonsterCardThrowsExceptionIfNotFound(requestDto.getId());
        card.update(requestDto);
        monsterRepository.save(card);
    }

    protected void updateSpell(UpdateCardRequestDto requestDto) throws Exception {
        var card = this.findSpellCardThrowsExceptionIfNotFound(requestDto.getId());
        card.update(requestDto);
        spellRepository.save(card);
    }

    protected void updateTrap(UpdateCardRequestDto requestDto) throws Exception {
        var card = this.findTrapCardThrowsExceptionIfNotFound(requestDto.getId());
        card.update(requestDto);
        trapRepository.save(card);
    }

    protected Card findCardThrowsExceptionIfNotFound(Long cardId) throws Exception {
        return cardRepository.findById(cardId)
                .orElseThrow(CardNotFoundException::new);
    }

    public MonsterCard findMonsterCardThrowsExceptionIfNotFound(Long cardId) throws Exception {
        return monsterRepository.findById(cardId)
                .orElseThrow(CardNotFoundException::new);
    }

    public SpellCard findSpellCardThrowsExceptionIfNotFound(Long cardId) throws Exception {
        return spellRepository.findById(cardId)
                .orElseThrow(CardNotFoundException::new);
    }

    public TrapCard findTrapCardThrowsExceptionIfNotFound(Long cardId) throws Exception {
        return trapRepository.findById(cardId)
                .orElseThrow(CardNotFoundException::new);
    }
}
