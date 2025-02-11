class Q8atoi {
    public int myAtoi(String s) {
        int result;
        int index = 0;
        StringBuilder number = new StringBuilder();
        boolean negative = false;

        //spaces
        while (index < s.length() && Character.isWhitespace(s.charAt(index))) {
            index++;
        }

        // check if negative or positive
        if (index < s.length() && s.charAt(index) == '-') {
            negative = true;
            index++;
        } else if (index < s.length() && s.charAt(index) == '+') {
            index++;
        }

        // make the number string
        for (int i = index; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                number.append(s.charAt(i));
            } else {
                break; 
            }
        }

        // edge case, no digits
        if (number.length() == 0) {
            return 0;
        }

        try {
            result = Integer.parseInt(number.toString());
        } catch (NumberFormatException e) {
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        return negative ? -result : result;
    }
}