package br.com.weslei.bender.api.duelcards.controller.game;

import br.com.weslei.bender.api.duelcards.domain.Game.dto.FirstTurnPlayerRequestDto;

public interface GameControllerApi {

    String decideFirstTurnPlayer(FirstTurnPlayerRequestDto requestDto);
}
