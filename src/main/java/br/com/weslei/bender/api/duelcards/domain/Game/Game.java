package br.com.weslei.bender.api.duelcards.domain.Game;

import br.com.weslei.bender.api.duelcards.domain.BanList.BanList;
import br.com.weslei.bender.api.duelcards.domain.Game.enumeration.RockPaperScissors;
import br.com.weslei.bender.api.duelcards.domain.GameField.GameField;
import br.com.weslei.bender.api.duelcards.domain.Player.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    private Player player1;
    private Player player2;
    private final Integer initialLifePoints = 8000;
    private Integer turn;
    private Integer firstTurnPlayer;
    private final LocalTime maxTurnTime = LocalTime.of(0, 3);
    private BanList banList;
    private Integer initialHandSize;
    private final Integer maxHandSize = 7;
    private final Integer minDeckSize = 40;
    private final Integer maxDeckSize = 60;
    private final Integer maxExtraDeckSize = 15;
    private GameField field;

    public Game newGame(Player p1, Player p2) {
        this.player1 = p1;
        this.player2 = p2;
        return this;
    }

    public void increaseTurn() {
        this.turn++;
    }

    public String decideFirstTurnPlayer(RockPaperScissors p1Choice, RockPaperScissors p2Choice) {
        switch (p1Choice) {
            case ROCK -> {
                return winnerDecider(p2Choice, RockPaperScissors.SCISSORS, RockPaperScissors.PAPER);
            }
            case PAPER -> {
                return winnerDecider(p2Choice, RockPaperScissors.ROCK, RockPaperScissors.SCISSORS);
            }
            case SCISSORS -> {
                return winnerDecider(p2Choice, RockPaperScissors.PAPER, RockPaperScissors.ROCK);
            }
        }
        return null;
    }

    private String winnerDecider(RockPaperScissors p2Choice, RockPaperScissors p2loserChoice, RockPaperScissors p2WinnerChoice) {
        if (p2loserChoice.equals(p2Choice)) {
            this.setFirstTurnPlayer(1);
            return "1";
        }
        if (p2WinnerChoice.equals(p2Choice)) {
            this.setFirstTurnPlayer(2);
            return "2";
        }
        return "Draw";
    }

}
