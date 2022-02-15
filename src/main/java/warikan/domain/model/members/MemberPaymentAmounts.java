package warikan.domain.model.members;

import java.util.List;

import javax.annotation.Nonnull;

/** 参加者支払い金額一覧。 */
public final class MemberPaymentAmounts {
    private final List<MemberPaymentAmount> memberPaymentAmounts;

    private MemberPaymentAmounts(List<MemberPaymentAmount> memberPaymentAmounts) {
        super();
        this.memberPaymentAmounts = memberPaymentAmounts;
    }

    /**
     * ファクトリメソッド。
     *
     * @param memberPaymentAmounts
     * @return {@link MemberPaymentAmounts}
     */
    @Nonnull
    public static MemberPaymentAmounts of(@Nonnull List<MemberPaymentAmount> memberPaymentAmounts) {
        return new MemberPaymentAmounts(memberPaymentAmounts);
    }

    public List<MemberPaymentAmount> getMemberPaymentAmounts() {
		return memberPaymentAmounts;
	}
}
