package code;

public class PositiveNumber {
    private int value;
    char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public void setDecimal(String s) {
        value = parse(s, 10);
    }

    public void setHexadecimal(String s) {
        value = parse(s, 16);
    }

    public void setBinary(String s) {
        value = parse(s, 2);
    }

    public String getDecimal() {
        return String.valueOf(value);
    }

    public String getHexadecimal() {
        StringBuilder out = new StringBuilder();
        int rem;
        int tmp = value;
        while (tmp > 0) {
            rem = tmp % 16;
            out.insert(0, hexDigits[rem]);
            tmp /= 16;
        }
        return out.toString();
    }

    public String getBinary() {
        StringBuilder out = new StringBuilder();
        int tmp = value;
        while (tmp > 0) {
            out.insert(0, (tmp % 2) == 0 ? "0" : "1");
            tmp /= 2;
        }
        return out.toString();
    }

    private int parse(String s, int basis) {
        int i = 0;
        int length = s.length();
        int limit = Integer.MAX_VALUE;

        if (length > 0) {
            char firstChar = s.charAt(0);
            if (firstChar < '0') {
                if (firstChar != '+') {
                    throw new ArithmeticException("Es sind nur positive Zahlen erlaubt!");
                }
                if (length == 1) {
                    throw new ArithmeticException("Es ist keine Zahl spezifiziert!");
                }
                i++;
            }
            int multmin = -limit / basis;
            int result = 0;
            while (i < length) {
                int digit = Character.digit(s.charAt(i++), basis);
                if (digit < 0 || result < multmin) {
                    throw new NumberFormatException("\"" + s + "\" ist keine Zahl!");
                }
                result *= basis;
                if (result < -limit + digit) {
                    throw new NumberFormatException("Die Uebergebene Zahl ist größer als Integer.MAX_VALUE");
                }
                result -= digit;
            }
            return -result;
        } else {
            throw new ArithmeticException("Es ist keine Zahl spezifiziert!");
        }
    }

}
