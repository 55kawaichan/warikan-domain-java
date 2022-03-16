package warikan.domain.model.members;

import javax.annotation.Nonnull;

import lombok.EqualsAndHashCode;

/** 参加者支払い金額。 */
@EqualsAndHashCode
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

	@Override
	public String toString() {
		return "MemberPaymentAmount [member=" + member + ", paymentAmount=" + paymentAmount + "]";
	}

}
