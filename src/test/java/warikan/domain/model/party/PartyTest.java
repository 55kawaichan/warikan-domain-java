package warikan.domain.model.party;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import warikan.domain.model.members.Member;
import warikan.domain.model.members.MemberName;
import warikan.domain.model.members.MemberPaymentAmount;
import warikan.domain.model.members.MemberPaymentAmounts;
import warikan.domain.model.members.MemberType;
import warikan.domain.model.payment.PaymentType;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PartyTest {

    @Test
    public void testWarikan() {
        Party party = Party.of(PartyName.of("test"), LocalDateTime.now());
        Member taro = Member.of(MemberName.of("test太郎"), MemberType.Secretary, PaymentType.MIDIUM);
        Member ziro = Member.of(MemberName.of("test次郎"), MemberType.NonSecretary, PaymentType.MIDIUM);
        Member hanako = Member.of(MemberName.of("test花子"), MemberType.NonSecretary, PaymentType.MIDIUM);
        party = party.addMenber(taro);
        party = party.addMenber(ziro);
        party = party.addMenber(hanako);
        party = party.deleteMember(MemberName.of("test太郎"));
        MemberPaymentAmounts memberPaymentAmounts = party.warikan(10000);
        assertThat(memberPaymentAmounts,
            is(equalTo(MemberPaymentAmounts.of(List.of(
                MemberPaymentAmount.of(hanako, 5000),
                MemberPaymentAmount.of(ziro, 5000))))));
    }
}
