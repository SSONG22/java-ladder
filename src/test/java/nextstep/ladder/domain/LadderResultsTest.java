package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderResultsTest {
    LadderGame ladderGame;
    Ladder ladder;
    List<Player> players;

    @BeforeEach
    void setUp() {
        players = Arrays.asList("AAA", "BBB").stream().map(Player::new).collect(Collectors.toList());
        ladder = new Ladder(new LadderInfo(2, 4), () -> true);
        ladderGame = new LadderGame(Arrays.asList("AAA", "BBB"), ladder);
    }

    @DisplayName("AAA -> 에이, BBB -> 비 : ladderGame 에서 사다리를 타면 결과값을 반환한다.")
    @Test
    void LadderGame_start() {
        Map<Player, String> resultMap = new HashMap<>();
        resultMap.put(players.get(0), "에이");
        resultMap.put(players.get(1), "비");

        assertThat(ladderGame.climbLadder(Arrays.asList("에이", "비")))
                .isEqualTo(new LadderResults(resultMap));
    }

    @DisplayName("player 수와 결과 리스트 수가 맞지 않으면 fail")
    @Test
    void create() {
        assertThrows(IllegalArgumentException.class,
                () -> ladderGame.climbLadder(Arrays.asList("꽝", "일", "이", "삼"))
        );
    }
}