package br.com.weslei.bender.api.duelcards.domain.card;

import br.com.weslei.bender.api.duelcards.domain.card.details.MonsterAttribute;
import br.com.weslei.bender.api.duelcards.domain.card.details.MonsterCard;
import br.com.weslei.bender.api.duelcards.domain.card.details.MonsterType;
import br.com.weslei.bender.api.duelcards.domain.card.details.SpellCard;
import br.com.weslei.bender.api.duelcards.domain.card.details.SpellType;
import br.com.weslei.bender.api.duelcards.domain.card.details.TrapCard;
import br.com.weslei.bender.api.duelcards.domain.card.details.TrapType;
import br.com.weslei.bender.api.duelcards.domain.card.dto.request.UpdateCardRequestDto;
import br.com.weslei.bender.api.duelcards.domain.card.enumeration.CardRarity;
import br.com.weslei.bender.api.duelcards.domain.card.enumeration.CardType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
public class CardTest {

    @Test
    void update_withMonsterCard_withSuccess() {
        //Arrange
        var requestDto = UpdateCardRequestDto.builder()
            .id(1L)
            .name("name")
            .description("description")
            .cardType(CardType.MONSTER)
            .cardRarity(CardRarity.COMMON)
            .monsterAttribute(MonsterAttribute.FIRE)
            .monsterType(MonsterType.FIEND)
            .hasEffect(false)
            .level(2)
            .attackPoints(1000)
            .defensePoints(0)
            .build();

        MonsterCard monsterCard = new MonsterCard();

        // Act
        monsterCard.update(requestDto);

        // Assert
        assertEquals(requestDto.getName(), monsterCard.getName());
        assertEquals(requestDto.getDescription(), monsterCard.getDescription());
        assertEquals(requestDto.getCardRarity(), monsterCard.getCardRarity());
        assertEquals(requestDto.getMonsterAttribute(), monsterCard.getMonsterAttribute());
        assertEquals(requestDto.getMonsterType(), monsterCard.getMonsterType());
        assertFalse(monsterCard.getHasEffect());
        assertEquals(requestDto.getLevel(), monsterCard.getLevel());
        assertEquals(requestDto.getAttackPoints(), monsterCard.getAttackPoints());
        assertEquals(requestDto.getDefensePoints(), monsterCard.getDefensePoints());

    }

    @Test
    void update_withSpellCard_withSuccess() {
        //Arrange
        var requestDto = UpdateCardRequestDto.builder()
            .id(1L)
            .name("name")
            .description("description")
            .cardType(CardType.SPELL)
            .cardRarity(CardRarity.COMMON)
            .spellType(SpellType.CONTINUOUS)
            .build();

        SpellCard spellCard = new SpellCard();

        // Act
        spellCard.update(requestDto);

        // Assert
        assertEquals(requestDto.getName(), spellCard.getName());
        assertEquals(requestDto.getDescription(), spellCard.getDescription());
        assertEquals(requestDto.getCardRarity(), spellCard.getCardRarity());
        assertEquals(requestDto.getCardType(), spellCard.getCardType());
        assertEquals(requestDto.getSpellType(), spellCard.getSpellType());

    }

    @Test
    void update_withTrapCard_withSuccess() {
        //Arrange
        var requestDto = UpdateCardRequestDto.builder()
            .id(1L)
            .name("name")
            .description("description")
            .cardType(CardType.TRAP)
            .cardRarity(CardRarity.COMMON)
            .trapType(TrapType.COUNTER)
            .build();

        TrapCard spellCard = new TrapCard();

        // Act
        spellCard.update(requestDto);

        // Assert
        assertEquals(requestDto.getName(), spellCard.getName());
        assertEquals(requestDto.getDescription(), spellCard.getDescription());
        assertEquals(requestDto.getCardRarity(), spellCard.getCardRarity());
        assertEquals(requestDto.getCardType(), spellCard.getCardType());
        assertEquals(requestDto.getTrapType(), spellCard.getTrapType());

    }
}
