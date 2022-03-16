package warikan.domain.model.members;

import java.util.List;

import javax.annotation.Nonnull;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/** 参加者支払い金額一覧。 */
@EqualsAndHashCode
@ToString
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
