package warikan.domain.model.members;

import javax.annotation.Nonnull;

/** 参加者支払い金額。 */
public final class MemberPaymentAmount {
    private final Member member;

    private final Integer paymentAmount;

    private MemberPaymentAmount(Member member, Integer paymentAmount) {
        super();
        this.member = member;
        this.paymentAmount = paymentAmount;
    }

    /**
     * ファクトリメソッド。
     *
     * @param member {@link Member}
     * @param paymentAmount
     * @return {@link MemberPaymentAmount}
     */
    @Nonnull
    public static MemberPaymentAmount of(@Nonnull Member member, @Nonnull Integer paymentAmount) {
        return new MemberPaymentAmount(member, paymentAmount);
    }
}
