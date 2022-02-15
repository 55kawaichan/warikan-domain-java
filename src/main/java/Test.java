import java.time.LocalDateTime;

import warikan.domain.model.members.Member;
import warikan.domain.model.members.MemberName;
import warikan.domain.model.members.MemberPaymentAmounts;
import warikan.domain.model.members.MemberType;
import warikan.domain.model.party.Party;
import warikan.domain.model.party.PartyName;
import warikan.domain.model.payment.PaymentType;

public class Test {

	public static void main(String[] args) {
		System.out.println("hello");
		Party party = Party.of(PartyName.of("test"), LocalDateTime.now());
		System.out.println(party.toString());

		System.out.println("追加後");
		Member taro = Member.of(MemberName.of("test太郎"), MemberType.Secretary, PaymentType.MIDIUM);
		Member ziro = Member.of(MemberName.of("test次郎"), MemberType.NonSecretary, PaymentType.MIDIUM);
		Member hanako = Member.of(MemberName.of("test花子"), MemberType.NonSecretary, PaymentType.MIDIUM);
//		Member hanako2 = Member.of(MemberName.of("test花子"), MemberType.NonSecretary, PaymentType.SMALL);

		party = party.addMenber(taro);
		party = party.addMenber(ziro);
		party = party.addMenber(hanako);
//		party = party.addMenber(hanako2);
		party.getMembers().getValues().forEach(v -> System.out.println(v.getName().getValue()));

		System.out.println("削除後");
		party = party.deleteMember(MemberName.of("test太郎"));
		party.getMembers().getValues().forEach(v -> System.out.println(v.getName().getValue()));

		System.out.println("割り勘結果");
		MemberPaymentAmounts memberPaymentAmounts = party.warikan(10000);
		memberPaymentAmounts.getMemberPaymentAmounts().forEach(v -> System.out.println(v.toString()));
	}
}
