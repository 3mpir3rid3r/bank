package com.nbs.common;

public class originalNumToLetter {

    String Number = null;

    public String getNumber(String Number) {

        this.Number = Number;
        String Num = null;
        //Defining variables q is quotient, r is remainder

        int len, q = 0, r = 0;
        String ltr = " ";
        String Str = "";
        constNumtoLetter n = new constNumtoLetter();
        int num = Integer.parseInt(Number);

        if (num <= 0) {
            System.out.println("Zero or Negative number not for conversion");
        }

        while (num > 0) {

            len = n.numberCount(num);

            //Take the length of the number and do letter conversion
            switch (len) {
                case 8:
                    q = num / 10000000;
                    r = num % 10000000;
                    ltr = n.twonum(q);
                    Str = Str + ltr + n.digit[4];
                    num = r;
                    break;

                case 7:
                case 6:
                    q = num / 100000;
                    r = num % 100000;
                    ltr = n.twonum(q);
                    Str = Str + ltr + n.digit[3];
                    num = r;
                    break;

                case 5:
                case 4:

                    q = num / 1000;
                    r = num % 1000;
                    ltr = n.twonum(q);
                    Str = Str + ltr + n.digit[2];
                    num = r;
                    break;

                case 3:

                    if (len == 3) {
                        r = num;
                    }
                    ltr = n.threenum(r);
                    Str = Str + ltr;
                    num = 0;
                    break;

                case 2:

                    ltr = n.twonum(num);
                    Str = Str + ltr;
                    num = 0;
                    break;

                case 1:
                    Str = Str + n.unitdo[num];
                    num = 0;
                    break;
                default:

                    num = 0;
                    System.out.println("Exceeding Crore....No conversion");
                    System.exit(1);

            }
            if (num == 0) {
                System.out.println(Str + " Rupees Only");
                Num = Str + " Rupees Only";
            }

        }
        return Num;
    }

}
