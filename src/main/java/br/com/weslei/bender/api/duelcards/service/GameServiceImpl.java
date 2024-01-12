package br.com.weslei.bender.api.duelcards.service;

import br.com.weslei.bender.api.duelcards.domain.BanList.BanList;
import br.com.weslei.bender.api.duelcards.domain.Game.Game;
import br.com.weslei.bender.api.duelcards.domain.Game.dto.FirstTurnPlayerRequestDto;
import br.com.weslei.bender.api.duelcards.domain.Player.Player;

public class GameServiceImpl {

    private Game game;

    public String decideFirstTurnPlayer(FirstTurnPlayerRequestDto requestDto) {
        return game.decideFirstTurnPlayer(requestDto.getP1Choice(), requestDto.getP2Choice());
    }

    public void startGame(Player p1, Player p2, BanList banList) {

    }


}
