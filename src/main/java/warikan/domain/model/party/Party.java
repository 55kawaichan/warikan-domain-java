package warikan.domain.model.party;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.annotation.Nonnull;

import warikan.domain.model.members.MemberPaymentAmounts;
import warikan.domain.model.members.Members;
import warikan.domain.model.payment.PaymentRates;

/** 飲み会。 */
public final class Party {
    private final PartyName name;

    private final LocalDateTime startDateTime;

    private final Members members;

    private final PaymentRates paymentRates;

    private Party(PartyName name, LocalDateTime startDateTime, Members members, PaymentRates paymentRates) {
        super();
        this.name = name;
        this.startDateTime = startDateTime;
        this.members = members;
        this.paymentRates = paymentRates;
    }

    public Party(PartyName name, LocalDateTime startDateTime) {
        super();
        this.name = name;
        this.startDateTime = startDateTime;
        this.members = null;
        this.paymentRates = null;
    }

    /**
     * ファクトリメソッド。
     *
     * @param name {@link PartyName}
     * @param startDateTime
     * @param members {@link Members}
     * @param paymentRates {@link PaymentRates}
     * @return {@link Party}
     */
    @Nonnull
    public static Party of(@Nonnull PartyName name, @Nonnull LocalDateTime startDateTime, @Nonnull Members members,
        @Nonnull PaymentRates paymentRates) {
        return new Party(name, startDateTime, members, paymentRates);
    }

    /**
     * ファクトリメソッド。
     *
     * @param name {@link PartyName}
     * @param startDateTime
     * @return {@link Party}
     */
    @Nonnull
    public static Party of(@Nonnull PartyName name, @Nonnull LocalDateTime startDateTime) {
        return new Party(name, startDateTime);
    }

    /**
     * 割り勘
     *
     * @param billing
     * @return {@link MemberPaymentAmounts}
     */
    @Nonnull
    public MemberPaymentAmounts warikan(Integer billing) {
        // 1. 参加者一覧からそれぞれの支払い割合を取得
        // 2. 請求金額を1の合計で割る
        // 3. 参加者一覧の数だけ下記を繰り返す
        //   3.1. 支払い割合 * 2の結果
        //   3.2. 参加者支払い金額を生成 
        // 4. 3の結果より参加者支払い金額一覧を生成してreturnする
        int totalRate = this.members.getTotalPaymentRate();
        int unit = billing / totalRate;

        return MemberPaymentAmounts.of(new ArrayList<>());
    }
}
