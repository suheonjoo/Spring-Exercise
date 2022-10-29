package me.whiteship.refactoring._06_mutable_data._21_replace_derived_variable_with_query._02_after;

import java.util.ArrayList;
import java.util.List;

public class ProductionPlan {

    /**
     * 필요 없는 데이터 삭제
     */
    //private double production;
    private List<Double> adjustments = new ArrayList<>();

    public void applyAdjustment(double adjustment) {
        this.adjustments.add(adjustment);
    }

    public double getProduction() {
        return this.adjustments.stream().mapToDouble(Double::valueOf).sum();
    }

}
