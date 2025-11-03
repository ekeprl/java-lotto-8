package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> rankCount;
    private final int purchaseAmount;

    public LottoResult(Map<Rank, Integer> rankCount, int purchaseAmount) {
        this.rankCount = new EnumMap<>(rankCount);
        this.purchaseAmount = purchaseAmount;
    }

    public double calculateProfitRate() {
        int totalPrize = calculateTotalPrize();
        // (총 상금 - 구매 금액) / 구매 금액 × 100
        return Math.round((double) (totalPrize - purchaseAmount) / purchaseAmount * 100 * 10) / 10.0;
    }

    private int calculateTotalPrize() {
        return rankCount.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney()
                        * entry.getValue())
                .sum();
    }

    public Map<Rank, Integer> getRankCount() {
        return new EnumMap<>(rankCount);
    }

    public int getTotalPrize() {
        return calculateTotalPrize();
    }
}