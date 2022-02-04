package warikan.domain.model.party;

import java.time.LocalDateTime;

import javax.annotation.Nonnull;

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
}
