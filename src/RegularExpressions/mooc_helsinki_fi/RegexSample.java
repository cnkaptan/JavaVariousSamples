package RegularExpressions.mooc_helsinki_fi;

/**
 * Created by cihankaptan on 27/10/16.
 */
public class RegexSample {

    public static void main(String[] args){
        String num = "012345678";

        // student numbers start with the string "01" which is followed by seven numerical digits from 0 to 9.
        if (num.matches("01[0-9]{7}")) {
            System.out.println("The form is valid.");
        } else {
            System.out.println("The form is not valid.");
        }


        System.out.println("=========================================================================================");


        /**
         * VERTICAL BAR: LOGICAL OR
         *
         * The vertical bar means that the parts of the regular expression are optional.
         * For instance, the expression 00|111|0000 defines the strings 00, 111 and 0000.
         * The method matches returns true if the string matches one of the alternatives defined.
         */

        String string = "00";
        string = "1111";

        if(string.matches("00|111|0000")) {
            System.out.println("The string was matched by some of the alternatives");
        } else {
            System.out.println("The string not was matched by any of the alternatives");
        }

        // The regular expression 00|111|0000 requires the exactly same form of the string: its functionality is not like "contains".

        System.out.println("=========================================================================================");

        /**
         * ROUND BRACKETS: A DELIMITED PART OF THE STRING
         *
         * With the help of round brackets it is possible to define what part of the regular expression is affected by the symbols.
         * If we want to allow for the alternatives 00000 and 00001, we can define it with the help of a vertical bar: 00000|00001.
         * Thanks to round brakers we can delimit the choice to only a part of the string.
         * The expression 0000(0|1) defines the strings 00000 and 00001.
         */

//        System.out.print("Write a form of the verb to look: ");
//        String word = reader.nextLine();
        String word = "looks";

        if (word.matches("look(|s|ed|ing|er)")) {
            System.out.println("Well done!");
        } else {
            System.out.println("Check again the form.");
        }

        // Accordingly, the regular expression look(|s|ed) defines
        // the basic form of the verb to look (look), the third person (looks), and the past (looked).

        System.out.println("=========================================================================================");

        /**
         * REPETITIONS
         *
         * We often want to know whether a substring repeats within another string.
         * In regular expressions, we can use repetition symbols:
         */


        // The symbol * stands for a repetition from 0 to n times, for instance
        // trolo(lo)* sondaki extra 'lo' tekrarlamasa da tekrarlasa da gecer
        // trololo* bu ornekte sadece sondaki o yu baz alir yani trolol(o)*

        string = "trolololololo";

        if(string.matches("trolo(lo)*")) {
            System.out.println("The form is right.");
        } else {
            System.out.println("The form is wrong.");
        }


        String characterString = "nänänänänänänänä Bätmään!";

        if(characterString.matches("(nä)+ Bätmään!")) {
            System.out.println("The form is right.");
        } else {
            System.out.println("The form is wrong.");
        }

        // The symbol + stands for a repetition from 1 to n times, for instance

        string = "trolololololo";

        if(string.matches("tro(lo)+")) {
            System.out.println("The form is right.");
        } else {
            System.out.println("The form is wrong.");
        }

        characterString = "nänänänänänänänä Bätmään!";

        if(characterString.matches("(nä)+ Bätmään!")) {
            System.out.println("The form is right.");
        } else {
            System.out.println("The form is wrong.");
        }


        // The symbol ? stands for a repetition of 0 or 1 time, for instance

        string = "You have accidentally the whole name";

        if(characterString.matches("You have accidentally (deleted )?the whole name")) {
            System.out.println("The form is right.");
        } else {
            System.out.println("The form is wrong.");
        }

        // The symbol {a} stands for a repetition of a times, for instance
        // valid olmasi icin a kere tekrar
        string = "1010";

        if(string.matches("(10){2}")) {
            System.out.println("The form is right.");
        } else {
            System.out.println("The form is wrong.");
        }

        string = "1010";

        if(string.matches("[0-9]{2}")) {
            System.out.println("The form is right.");
        } else {
            System.out.println("The form is wrong.");
        }


        // The symbol {a,b} stands for a repetition from a to b times, for instance
        // valid olmasi icin tekrar araligi
        string = "1";

        if(string.matches("1{2,4}")) {
            System.out.println("The form is right.");
        } else {
            System.out.println("The form is wrong.");
        }

        // The symbol {a,} stands for a repetition from a to n times, for instance
        // en az 2 ve uzeri tekrar
        string = "11111";

        if(string.matches("1{2,}")) {
            System.out.println("The form is right.");
        } else {
            System.out.println("The form is wrong.");
        }

        string = "555555";
//        string = "5551555";
//        string = "5550555";
//        string = "5551010555";

        if(string.matches("5{3}(1|0)*5{3}")) {
            System.out.println("The form is right.");
        } else {
            System.out.println("The form is wrong.");
        }


        System.out.println("=========================================================================================");

        /**
         * SQUARE BRACKETS: CHARACTER GROUPS
         *
         * With the help of square brackets we can quickly define groups of characters.
         * The characters are written inside the brackets, and we can define an interval with the help of a hyphen (-).
         * For instance, [145] means the same as (1|4|5), whereas [2-36-9] means the same as (2|3|6|7|8|9).
         * Accordingly, [a-c]* defines a regular expression with a string made only of characters a, b and c.
         */

        System.out.println(isAWeekDay("abc"));
        System.out.println(isAWeekDay("wed"));

    }

    public static boolean isAWeekDay(String string){
        return string.matches("(mon|tue|wed|thu|fri|sat|sun)");
    }

    public static boolean clockTime(String string){
        return string.matches("[0-9]{2}:[0-9]{2}:[0-9]{2}");
    }

}
