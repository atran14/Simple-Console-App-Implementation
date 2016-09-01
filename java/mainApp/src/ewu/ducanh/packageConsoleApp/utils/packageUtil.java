package ewu.ducanh.packageConsoleApp.utils;

public class packageUtil {
    public static boolean isValidWeight(final Double inputW) {
        try {
            return inputW > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidLength(final Double inputL) {
        try {
            return inputL > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidTrackingNumber( final String packageType, final String trackingNumber ) {
        assert( packageType != null );
        if ( trackingNumber == null ) return false;
        else {
            int length = trackingNumber.length();
            char lastDigit = trackingNumber.charAt(length - 1);
            switch(packageType.toLowerCase()) {
                case "letter":
                    return lastDigit == '0';
                case "box":
                    return lastDigit == '1';
                case "metal crate":
                    return lastDigit == '2';
                case "wooden crate":
                    return lastDigit == '3';
                default:
                    return false;
            }
        }
    }

    public static boolean isOverweight(final Double inputW, final Double maxW) {
        if (!isValidWeight(inputW) || !isValidWeight(maxW)) {
            throw new IllegalArgumentException("One or both parameters are not valid");
        }

        return inputW > maxW;
    }

    public static boolean isOversize(final Double inputL, final Double maxL) {
        if (!isValidLength(inputL) || !isValidLength(maxL)) {
            throw new IllegalArgumentException("One or both parameters are not valid");
        }

        return inputL > maxL;
    }
}
