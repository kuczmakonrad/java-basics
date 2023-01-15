package pl.kuczdev.__work_questions.equals_and_hashcode.devcave.hashcode;

public class PhoneNumber {
    private short areaCode;
    private short prefix;
    private short lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "AREA CODE");
        this.prefix = rangeCheck(prefix, 999, "PREFIX");
        this.lineNum = rangeCheck(lineNum, 9999, "LINE NUM");
    }

    private static short rangeCheck(int value, int max, String arg) {
        if (value < 0 || value > max) {
            throw new IllegalArgumentException(arg + ": " + value);
        }
        return (short) value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || !(object instanceof PhoneNumber)) return false;

        PhoneNumber phoneNumber = (PhoneNumber) object;
        return this.areaCode == phoneNumber.areaCode && this.prefix == phoneNumber.prefix && this.lineNum == phoneNumber.lineNum;
    }

    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);

        return result;
    }
}
