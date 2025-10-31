package lotto.util;

import lotto.exceptions.ErrorMessage;

public class ValidationResult {
    private final boolean valid;
    private final ErrorMessage errorMessage;

    public ValidationResult(boolean valid, ErrorMessage errorMessage) {
        this.valid = valid;
        this.errorMessage = errorMessage;
    }

    public boolean isValid() {
        return valid;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
