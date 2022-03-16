package warikan.domain.model.members;

import java.util.Objects;

import javax.annotation.Nonnull;

import warikan.domain.model.payment.PaymentType;

/** 参加者。 */
public final class Member {
    private final MemberName name;

    private final MemberType memberType;

    private final PaymentType paymentType;

    private Member(@Nonnull MemberName name, @Nonnull MemberType memberType, @Nonnull PaymentType paymentType) {
        this.name = name;
        this.memberType = memberType;
        this.paymentType = paymentType;
    }

    /**
     * ファクトリメソッド。
     *
     * @param name {@link MemberName}
     * @param memberType {@link MemberType}
     * @return {@link Member}
     */
    @Nonnull
    public static Member of(@Nonnull MemberName name, @Nonnull MemberType memberType, @Nonnull PaymentType paymentType) {
        return new Member(name, memberType, paymentType);
    }

    /**
     * ファクトリメソッド。
     *
     * @param name {@link MemberName}
     * @return {@link Member}
     */
    @Nonnull
    public static Member of(@Nonnull MemberName name) {
        return new Member(name, MemberType.NonSecretary, PaymentType.MIDIUM);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberType, name, paymentType);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Member other = (Member) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public String toString() {
        return "Member [name=" + name + ", memberType=" + memberType + ", paymentType=" + paymentType + "]";
    }

    public boolean isSecretary() {
        return memberType.equals(MemberType.Secretary);
    }

    public boolean nonSecretary() {
        return !isSecretary();
    }

    public MemberName getName() {
        return name;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }
    
    public MemberPaymentAmount calcPaymentAmount(int unit) {
    	return MemberPaymentAmount.of(this, paymentType.calcPaymentAmount(unit));
    }
}
