package lotto.controller;

import lotto.view.InputView;

import java.util.List;

public class LottoController {

    public void run() {

        int purchaseAmount = InputView.getPurchaseAmount();
        List<Integer> lottoNumbers = InputView.getLottoNumbers();
        int bonusNumber = InputView.getBonusNumber();



    }
}
