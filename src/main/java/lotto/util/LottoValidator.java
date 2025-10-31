package lotto.util;

import lotto.exceptions.ErrorMessage;

public class LottoValidator {
    public static ValidationResult inputNumberImplement(String input) {
        // 1단계: 형식 검증
        if (!isValidFormat(input)) {
            return new ValidationResult(false, ErrorMessage.INVALID_INPUT_FORMAT);
        }

        // 2단계: 범위 검증
        if (!isInRange(input)) {
            return new ValidationResult(false, ErrorMessage.OUT_OF_RANGE);
        }

        return new ValidationResult(true, null);
    }

    private static boolean isValidFormat(String input) {
        return input.matches("^[0-9]+$") && !input.isEmpty();
    }

    private static boolean isInRange(String input) {
        int num = Integer.parseInt(input);
        return num >= 1 && num <= 45;
    }

    public static ValidationResult validatePurchaseAmount(String input) {
        if (!isValidFormat(input)) {
            return new ValidationResult(false, ErrorMessage.INVALID_INPUT_FORMAT);
        }

        int amount = Integer.parseInt(input);
        if (amount % 1000 != 0) {
            return new ValidationResult(false, ErrorMessage.INVALID_PURCHASE_AMOUNT);
        }

        return new ValidationResult(true, null);
    }
}
