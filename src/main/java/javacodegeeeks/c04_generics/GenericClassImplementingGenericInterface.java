package javacodegeeeks.c04_generics;

/**
 * Created by sharath on 8/1/15.
 */
public class GenericClassImplementingGenericInterface<T> implements GenericInterfaceOneType<T> {
    @Override
    public void performAction(T action) {

    }

    static int atoi(String strInput) {
        boolean positive = true;
        StringBuilder sb = new StringBuilder(strInput.length());
        if(strInput == null)
            return 0;
        int i = 0;
        while(strInput.charAt(i) == ' ') {
            i++;
        }
        if(strInput.charAt(i) == '-') {
            positive = false;
            i++;
        }
        else if(strInput.charAt(i) == '-'){
            positive = true;
            i++;
        }
        else if(strInput.charAt(i) < '0' || strInput.charAt(i) > '9') {
            return 0;
        }
        else {
            for(int j = i; j < strInput.length(); j++) {
                if(strInput.charAt(i) >= '0' || (strInput.charAt(i) <= '9')) {
                    sb.append(strInput.charAt(i));
                }
            }
        }

        String result = sb.toString();
        int pos = 1;
        int sum = 0;
        for(int k = result.length() - 1; k >=0; k--) {
            int num = result.charAt(k) - 48;
            sum = sum + (num * pos);
            pos = pos * 10;
        }

        int finalResult = positive ? sum : (-1*sum);
        return finalResult;

    }
}
