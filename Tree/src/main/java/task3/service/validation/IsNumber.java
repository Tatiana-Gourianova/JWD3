package task3.service.validation;


    /**
     * <p>Checks whether the String a valid Java number.</p>
     **/
    public class IsNumber {
private boolean isNumber=true;

public boolean getisNumber() {
return isNumber;}


        public IsNumber(String s) {
            if (s.length() == 0) {
                this.isNumber= false;
            }

            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if ((i != 0 && c == '-')
                        || (!Character.isDigit(c) && c != '-')
                        || (chars.length == 1 && c == '-')) {
                    this.isNumber=false;
                }
            }
            //this.isNumber=true;

        }
    }