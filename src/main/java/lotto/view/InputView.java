package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import lotto.exceptions.ErrorMessage;
import lotto.util.LottoValidator;
import lotto.util.ValidationResult;


public class InputView {
    public static int getPurchaseAmount() {
        while (true) {
            try {
                String purchaseAmount = Console.readLine();
                ValidationResult result = LottoValidator.validatePurchaseAmount(purchaseAmount);

                if (result.isValid()) {
                    return Integer.parseInt(purchaseAmount) / 1000;
                }
                throw new IllegalArgumentException(result.getErrorMessage().getMessage());
            } catch (IllegalArgumentException err) {
                System.out.println(err.getMessage());
            }
        }
    }

    public static List<Integer> getLottoNumbers() {
        while (true) {
            try {
                String input = Console.readLine();
                List<Integer> numbers = parseLottoNumbers(input);
                isValidLottoNumbers(numbers);
                return numbers;
            } catch (IllegalArgumentException err) {
                System.out.println(err.getMessage());
            }
        }
    }

    private static List<Integer> parseLottoNumbers(String input) {
        String[] inputs = input.split(",");
        return Arrays.stream(inputs)
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    private static void isValidCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_COUNT.getMessage());
        }
    }

    private static void isValidRange(List<Integer> numbers) {
        for (Integer num : numbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
            }
        }
    }

    private static void isNoDuplicate(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private static void isValidLottoNumbers(List<Integer> numbers) {
        isValidCount(numbers);
        isValidRange(numbers);
        isNoDuplicate(numbers);
    }

    public static int getBonusNumber() {
        while (true) {
            try {
                String bonusInput = Console.readLine();
                ValidationResult result = LottoValidator.inputNumberImplement(bonusInput);

                if (result.isValid()) {
                    return Integer.parseInt(bonusInput);
                }
                throw new IllegalArgumentException(result.getErrorMessage().getMessage());
            } catch (IllegalArgumentException err) {
                System.out.println(err.getMessage());
            }
        }
    }
}


