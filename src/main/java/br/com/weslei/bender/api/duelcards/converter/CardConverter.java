package br.com.weslei.bender.api.duelcards.converter;

import br.com.weslei.bender.api.duelcards.domain.card.Card;
import br.com.weslei.bender.api.duelcards.domain.card.details.MonsterCard;
import br.com.weslei.bender.api.duelcards.domain.card.details.SpellCard;
import br.com.weslei.bender.api.duelcards.domain.card.details.TrapCard;
import br.com.weslei.bender.api.duelcards.domain.card.dto.request.CreateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.dto.response.CardResponseDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardConverter {

    private final ModelMapper modelMapper;

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

        modelMapper.addMappings(new PropertyMap<CreateCardRequestDto, SpellCard>() {
            @Override
            protected void configure() {
                map().setSpellType(source.getSpellCard().getSpellType());
            }
        });

        modelMapper.addMappings(new PropertyMap<CreateCardRequestDto, TrapCard>() {
            @Override
            protected void configure() {
                map().setTrapType(source.getTrapCard().getTrapType());
            }
        });

    }

    public CardResponseDto toCardResponseDto(Card card) {
        CardResponseDto dto = modelMapper.map(card, CardResponseDto.class);

        if (card instanceof MonsterCard monsterCard) {
            dto.setMonsterAttribute(monsterCard.getMonsterAttribute());
            dto.setMonsterType(monsterCard.getMonsterType());
            dto.setHasEffect(monsterCard.getHasEffect());
            dto.setLevel(monsterCard.getLevel());
            dto.setAttackPoints(monsterCard.getAttackPoints());
            dto.setDefensePoints(monsterCard.getDefensePoints());
        } else if (card instanceof SpellCard spellCard) {
            dto.setSpellType(spellCard.getSpellType());
        } else if (card instanceof TrapCard trapCard) {
            dto.setTrapType(trapCard.getTrapType());
        }

        return dto;
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
