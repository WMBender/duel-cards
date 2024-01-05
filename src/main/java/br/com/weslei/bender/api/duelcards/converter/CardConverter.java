package br.com.weslei.bender.api.duelcards.converter;

import br.com.weslei.bender.api.duelcards.domain.card.Card;
import br.com.weslei.bender.api.duelcards.domain.card.dto.request.CreateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.request.UpdateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.response.CardResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardConverter {

    @Autowired
    private ModelMapper modelMapper;

    public Card toCard(CreateCardRequestDto requestDto) {
        return modelMapper.map(requestDto, Card.class);
    }

    public Card toCard(UpdateCardRequestDto requestDto) {
        return modelMapper.map(requestDto, Card.class);
    }

    public CardResponseDto toCardResponseDto(Card card) {
        return modelMapper.map(card, CardResponseDto.class);
    }
}
