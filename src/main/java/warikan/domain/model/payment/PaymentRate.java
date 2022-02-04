package warikan.domain.model.payment;

import javax.annotation.Nonnull;

/** 支払割合。 */
public final class PaymentRate {
    private final PaymentType paymentType;

    private final Integer rate;

    private PaymentRate(PaymentType paymentType, Integer rate) {
        super();
        this.paymentType = paymentType;
        this.rate = rate;
    }

    /**
     * ファクトリメソッド。
     *
     * @param paymentType {@link PaymentType}
     * @param rate
     * @return {@link PaymentRate}
     */
    @Nonnull
    public static PaymentRate of(@Nonnull PaymentType paymentType, @Nonnull Integer rate) {
        return new PaymentRate(paymentType, rate);
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public Integer getRate() {
        return rate;
    }
}
