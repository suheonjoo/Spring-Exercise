package me.whiteship.refactoring._11_primitive_obsession._32_replace_conditional_with_polymorphism.variation._02_after;

import java.util.List;

public class RatingFactory {

    public static VoyageRating createRating(Voyage voyage, List<VoyageHistory> history) {
        if (voyage.zone().equals("china") && hasChinaHistory(history)) {
            return new ChinaExperiencedVoyageRating(voyage, history);
        } else {
            return new VoyageRating(voyage, history);
        }

    }

    private static boolean hasChinaHistory(List<VoyageHistory> history) {
        return history.stream().anyMatch(v -> v.zone().equals("china"));

    }


}
