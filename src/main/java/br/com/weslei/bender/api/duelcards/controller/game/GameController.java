package br.com.weslei.bender.api.duelcards.controller.game;

import br.com.weslei.bender.api.duelcards.domain.Game.dto.FirstTurnPlayerRequestDto;
import br.com.weslei.bender.api.duelcards.service.GameServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GameController implements GameControllerApi {

    private final GameServiceImpl gameService;

    @Override
    public String decideFirstTurnPlayer(FirstTurnPlayerRequestDto requestDto) {
        return gameService.decideFirstTurnPlayer(requestDto);
    }
}
