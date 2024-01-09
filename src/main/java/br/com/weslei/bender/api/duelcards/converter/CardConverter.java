package br.com.weslei.bender.api.duelcards.converter;

import br.com.weslei.bender.api.duelcards.domain.card.Card;
import br.com.weslei.bender.api.duelcards.domain.card.details.MonsterCard;
import br.com.weslei.bender.api.duelcards.domain.card.details.SpellCard;
import br.com.weslei.bender.api.duelcards.domain.card.details.TrapCard;
import br.com.weslei.bender.api.duelcards.domain.card.dto.request.CreateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.request.UpdateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.response.CardResponseDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public CardConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;

        modelMapper.addMappings(new PropertyMap<CreateCardRequestDto, MonsterCard>() {
            @Override
            protected void configure() {
                map().setMonsterType(source.getMonsterCard().getMonsterType());
                map().setHasEffect(source.getMonsterCard().getHasEffect());
                map().setLevel(source.getMonsterCard().getLevel());
                map().setAttackPoints(source.getMonsterCard().getAttackPoints());
                map().setDefensePoints(source.getMonsterCard().getDefensePoints());
            }
        });
    }

    public Card toCard(CreateCardRequestDto requestDto) {
        return modelMapper.map(requestDto, Card.class);
    }

    public Card toCard(UpdateCardRequestDto requestDto) {
        return modelMapper.map(requestDto, Card.class);
    }

    public CardResponseDto toCardResponseDto(Card card) {
        return modelMapper.map(card, CardResponseDto.class);
    }

    public MonsterCard toMonsterCard(CreateCardRequestDto requestDto) {
        return modelMapper.map(requestDto, MonsterCard.class);
    }

    public SpellCard toSpellCard(CreateCardRequestDto requestDto) {
        return modelMapper.map(requestDto, SpellCard.class);
    }

    public TrapCard toTrapCard(CreateCardRequestDto requestDto) {
        return modelMapper.map(requestDto, TrapCard.class);
    }
}
