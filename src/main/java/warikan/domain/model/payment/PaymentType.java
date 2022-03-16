package warikan.domain.model.payment;

/** 支払い区分 */
public enum PaymentType {
    /** スモール */
    SMALL(8),
    /** ミディアム。 */
    MIDIUM(10),
    /** ラージ。 */
    LARGE(12),
    /** スリーXラージ。 */
    ThreeXL(14);

    private final int rate;

    PaymentType(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }
    
    public int calcPaymentAmount(int unit) {
    	return rate * unit;
    }
}
