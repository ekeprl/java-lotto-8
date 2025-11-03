package lotto.model;

import java.util.*;

public class LottoTickets {
    private final List<Lotto> tickets;

    public LottoTickets(List<Lotto> tickets) {
        this.tickets = new ArrayList<>(tickets);
    }

    public Map<Rank, Integer> match(DrawingLotto drawinglotto) {
        Map<Rank, Integer> result = initializeRankCount();

        tickets.forEach(lotto -> {
            Rank rank = drawinglotto.match(lotto);
            result.put(rank, result.get(rank) + 1);
        });

        return result;
    }

    private Map<Rank, Integer> initializeRankCount() {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values())
                .forEach(rank -> result.put(rank, 0));
        return result;
    }

    public List<Lotto> getTickets() {
        return new ArrayList<>(tickets);
    }

    public int getCount() {
        return tickets.size();
    }
}
