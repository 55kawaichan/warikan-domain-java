package warikan.domain.model.party;

import java.time.LocalDateTime;

import javax.annotation.Nonnull;

import warikan.domain.model.members.Member;
import warikan.domain.model.members.MemberName;
import warikan.domain.model.members.MemberPaymentAmounts;
import warikan.domain.model.members.Members;
import warikan.domain.model.payment.PaymentRates;

/** 飲み会。 */
public final class Party {
	private final PartyName name;

	private final LocalDateTime startDateTime;

	private final Members members;

	private Party(PartyName name, LocalDateTime startDateTime, Members members) {
		super();
		this.name = name;
		this.startDateTime = startDateTime;
		this.members = members;
	}

	public Party(PartyName name, LocalDateTime startDateTime) {
		super();
		this.name = name;
		this.startDateTime = startDateTime;
		this.members = null;
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
	public static Party of(@Nonnull PartyName name, @Nonnull LocalDateTime startDateTime, @Nonnull Members members) {
		return new Party(name, startDateTime, members);
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

	public PartyName getName() {
		return name;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public Members getMembers() {
		return members;
	}

	/**
	 * メンバー追加
	 *
	 * @param member
	 * @return
	 */
	@Nonnull
	public Party addMenber(@Nonnull Member member) {
		Members newMembers;
		if (this.members == null) {
			newMembers = Members.of(member);
		} else {
			newMembers = members.add(member);
		}

		return Party.of(this.name, this.startDateTime, newMembers);
	}

	/**
	 * メンバー削除
	 *
	 * @param member
	 * @return
	 */
	@Nonnull
	public Party deleteMember(@Nonnull MemberName memberName) {
		Members deletedmembers = members.delete(memberName);
		return Party.of(this.name, this.startDateTime, deletedmembers);
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
		return this.members.calcMemberPaymentAmount(unit);
	}

	@Override
	public String toString() {
		return "Party [name=" + name + ", startDateTime=" + startDateTime + ", members=" + members + "]";
	}
}
