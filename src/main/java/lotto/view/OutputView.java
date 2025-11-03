package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoTickets;
import lotto.model.Rank;

import java.util.Map;

public class OutputView {

    public static void printLottos(LottoTickets lottoTickets) {
        System.out.println();
        System.out.println(lottoTickets.getCount() + "개를 구매했습니다.");

        for (Lotto lotto : lottoTickets.getTickets()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(LottoResult result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<Rank, Integer> rankCount = result.getRankCount();

        //등수
        printRankResult(Rank.FIFTH, rankCount);
        printRankResult(Rank.FOURTH, rankCount);
        printRankResult(Rank.THIRD, rankCount);
        printRankResult(Rank.SECOND, rankCount);
        printRankResult(Rank.FIRST, rankCount);

        // 총 상금
        System.out.printf("총 당첨 금액은 %s원입니다.%n",
                formatMoney(result.getTotalPrize()));

        // 수익률 출력
        System.out.printf("총 수익률은 %.1f%%입니다.%n",
                result.calculateProfitRate());
    }

    private static void printRankResult(Rank rank, Map<Rank, Integer> rankCount) {
        int count = rankCount.get(rank);
        String matchInfo = buildMatchInfo(rank);

        System.out.printf("%s (%s원) - %d개%n",
                matchInfo,
                formatMoney(rank.getPrizeMoney()),
                count);
    }

    private static String buildMatchInfo(Rank rank) {
        String info = rank.getMatchCount() + "개 일치";

        if (rank.isBonusMatch()) {
            info += ", 보너스 볼 일치";
        }

        return info;
    }

    private static String formatMoney(int money) {
        return String.format("%,d", money);
    }
}
