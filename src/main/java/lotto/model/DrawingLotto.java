package lotto.model;

import lotto.exceptions.ErrorMessage;

public class DrawingLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public DrawingLotto(Lotto winningNumbers, int bonusNumber) {
        validateBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    public Rank match(Lotto lotto) {
        int matchCount = winningNumbers.countMatching(lotto);
        boolean bonusMatch = lotto.contains(bonusNumber);
        return Rank.valueOf(matchCount, bonusMatch);
    }
}



