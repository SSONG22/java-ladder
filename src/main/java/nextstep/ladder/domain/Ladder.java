package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int MIN_VALUE = 1;
    private static final String CREATE_LADDER_ERROR = "width 와 height 는 " + MIN_VALUE + "이상이어야 합니다.";
    private final List<Line> lines;

    public Ladder(final int width, final int ladderHeight, final PointCreator pointCreator) {
        if (width < MIN_VALUE || ladderHeight < MIN_VALUE) {
            throw new IllegalArgumentException(CREATE_LADDER_ERROR);
        }
        this.lines = Collections.unmodifiableList(createLines(width, ladderHeight, pointCreator));
    }

    private List<Line> createLines(final int width, final int ladderHeight, final PointCreator pointCreator) {
        return IntStream.range(0, ladderHeight)
                .mapToObj(index -> new Line(width, pointCreator))
                .collect(Collectors.toList());
    }

    public List<Line> valueOfLines() {
        return lines;
    }

}
