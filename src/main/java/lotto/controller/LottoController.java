package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {

    public void run() {
        // 구매 금액 입력 및 로또 번호 입력
        int purchaseAmount = InputView.getPurchaseAmount();
        LottoTickets lottoTickets = generateLottos(purchaseAmount);
        OutputView.printLottos(lottoTickets);

        // 당첨 번호
        List<Integer> lottoNumbers = InputView.getLottoNumbers();
        int bonusNumber = InputView.getBonusNumber();
        DrawingLotto winningLotto = new DrawingLotto(
                new Lotto(lottoNumbers), bonusNumber);

        // 통계 계산
        Map<Rank, Integer> rankCount = lottoTickets.match(winningLotto);
        LottoResult result = new LottoResult(rankCount, purchaseAmount);

        OutputView.printResult(result);
    }

    private LottoTickets generateLottos(int purchaseAmount) {
        int count = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }

        return new LottoTickets(lottos);
    }
}
