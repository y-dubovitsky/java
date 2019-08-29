package second.streams.operations;

import java.util.stream.Stream;

public class SkipLimitDemo {

    public Object[] getArray() {
        return Stream.of(1,2,3,4,5,6,7,89,1,4,34,6,26,6,235,62,62,1,1,5,62,6)
                .skip(2)
                .limit(3)
                .toArray();
    }
}
