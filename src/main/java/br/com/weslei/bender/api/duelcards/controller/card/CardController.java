package br.com.weslei.bender.api.duelcards.controller.card;

import br.com.weslei.bender.api.duelcards.domain.card.dto.request.CreateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.request.UpdateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.response.CardResponseDto;
import br.com.weslei.bender.api.duelcards.domain.card.exception.CardNotFoundException;
import br.com.weslei.bender.api.duelcards.service.CardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardController implements CardControllerApi {

    private final CardService cardService;

    @Override
    @GetMapping
    public List<CardResponseDto> getCards() {
        return cardService.getAllCards();
    }

    @Override
    @GetMapping("/{cardId}")
    public CardResponseDto getCardById(@PathVariable Long cardId) throws CardNotFoundException {
        return cardService.getCardById(cardId);
    }

    @Override
    @PostMapping
    public void createCard(@Valid @RequestBody CreateCardRequestDto requestDto) {
        cardService.saveCard(requestDto);
    }

    @Override
    @PutMapping
    public void updateCard(@Valid @RequestBody UpdateCardRequestDto requestDto) throws CardNotFoundException {
        cardService.updateCard(requestDto);
    }

    @Override
    @DeleteMapping("/{cardId}")
    public void deleteCard(@PathVariable Long cardId) throws CardNotFoundException {
        cardService.deleteCard(cardId);
    }
}
