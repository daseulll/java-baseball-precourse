package baseball.domain;

import java.util.List;

public class User {
    private List<Integer> numbers;

    public User(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
