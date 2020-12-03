import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Password
{

    static void sim()
    {

        Integer value;
        String number;

        ArrayList<String> acceptedStrings = new ArrayList<>();

        int lowerBound = 138241;
        int upperBound = 674034;

        boolean accept_one = false;
        boolean accept_two = false;
        boolean accept_three = false;
        for (int i = lowerBound; i < upperBound; i++)
        {
            accept_one = false;
            accept_two = false;
            accept_three =false;
            number = String.valueOf(i);
            for (int j = 0; j < 5; j++)
            {
                accept_one = number.charAt(j) <= number.charAt(j + 1);
                if (!accept_one) break;
            }
            for (int j = 0; j < 5; j++)
            {
                accept_two = number.charAt(j) == number.charAt(j + 1);
                if (accept_two) break;
            }
            if (accept_two)
            {
                value = Integer.valueOf(number);
                Map<Integer, Integer> digitMap = new HashMap<>();
                int rem;
                while(value>0){
                    rem = value % 10;
                    // get the frequency count of this digit
                    Integer counter = digitMap.get(rem);
                    // for the first time count will be null, hence put 1
                    if (counter == null) {
                        digitMap.put(rem, 1);
                    } else {
                        // increment the count for this digit
                        digitMap.put(rem, ++counter);
                    }
                    // remove the last digit from the number
                    value = value / 10;
                }
                if(digitMap.containsValue(2)){
                    accept_three = true;
                }
            }
            if (accept_one && accept_two && accept_three)
            {
                acceptedStrings.add(number);
            }
        }
        System.out.println(acceptedStrings);
        System.out.println(acceptedStrings.size());
    }

    public static void main(String[] args)
    {
        sim();
    }
}

//        Two adjacent digits are the same (like 22 in 122345).
//        Going from left to right, the digits never decrease;
//they only ever increase or stay the same (like 111123 or 135679).