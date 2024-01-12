package br.com.weslei.bender.api.duelcards.domain.Game.dto;

import br.com.weslei.bender.api.duelcards.domain.Game.enumeration.RockPaperScissors;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FirstTurnPlayerRequestDto {

    RockPaperScissors p1Choice;
    RockPaperScissors p2Choice;
}
