package warikan.domain.model.payment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import javax.annotation.Nonnull;

import org.apache.commons.lang3.Validate;

/** 支払割合一覧。 */
public final class PaymentRates {
    private final List<PaymentRate> values;

    private PaymentRates(@Nonnull List<PaymentRate> values) {
        Validate.notEmpty(values, "values are empty");
        this.values = new ArrayList<>(values);
    }

    private PaymentRates(@Nonnull PaymentRate head, @Nonnull List<PaymentRate> tail) {
        List<PaymentRate> values = new ArrayList<>();
        values.add(head);
        values.addAll(tail);
        this.values = values;
    }

    @Nonnull
    public static PaymentRates of(@Nonnull PaymentRate head, @Nonnull PaymentRate... tail) {
        return of(head, Arrays.asList(tail));
    }

    @Nonnull
    public static PaymentRates of(@Nonnull PaymentRate head, @Nonnull List<PaymentRate> tail) {
        return new PaymentRates(head, tail);
    }

    /**
     * 要素が含まれるかを返す。
     *
     * @param element 要素
     * @return 含まれる場合true
     */
    public boolean contains(@Nonnull PaymentRate element) {
        return values.contains(element);
    }

    /**
     * 述語に該当するかを返す。
     *
     * @param p 述語関数
     * @return 該当する場合true
     */
    public boolean exists(@Nonnull Predicate<PaymentRate> p) {
        return values.stream().anyMatch(p);
    }

    /**
     * 要素数を取得する。
     *
     * @return 要素数
     */
    public int size() {
        return values.size();
    }
}
