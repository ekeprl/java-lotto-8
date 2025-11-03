package lotto.exceptions;

public enum ErrorMessage {
    INVALID_LOTTO_COUNT("로또 번호는 6개를 입력해야 합니다."),
    OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER("중복된 번호가 있습니다."),
    INVALID_INPUT_FORMAT("입력 형식이 올바르지 않습니다."),
    INVALID_PURCHASE_AMOUNT("입력 가격이 올바르지 않습니다."),
    BONUS_NUMBER_DUPLICATE("보너스 번호는 당첨 번호와 중복될 수 없습니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
