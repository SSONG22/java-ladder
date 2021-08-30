package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderController {
    public void startLadderGame() {
        List<String> players = InputView.inputPlayers();
        int ladderHeight = InputView.inputLadderHeight();

        Ladder ladder = new Ladder(players.size(), ladderHeight);
        LadderGame ladderGame = new LadderGame(players, ladderHeight);

        ResultView.printLadder(ladderGame);
    }
}
