import java.util.Scanner;

public class Main {
    static char operator;
    static int num1;
    static int num2;
    static int result;

    public static void main(String [] args) throws Exception {

        calc("");

    }

    public static String calc(String input) throws Exception {

        Scanner expression = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String exp = expression.nextLine();

        char[]operators = new char[8];

        for(int i = 0; i<exp.length(); i++){
            operators[i] = exp.charAt(i);
            if (operators[i] == '+'){
                operator = '+';
            }
            else if (operators[i] == '-'){
                operator = '-';
            }
            else if (operators[i] == '*'){
                operator = '*';
            }
            else if (operators[i] == '/'){
                operator = '/';
            }
        }

        String stringNumber = new String(operators);
        String [] operands = stringNumber.split("[+-/*]");
        if(operands.length > 2) {throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");}
        if(operands.length < 2) {throw new Exception("Не является математической операцией!");}
        String number1 = operands[0];
        String number2 = operands[1];
        String number3 = number2.trim();


        if(compareRoman(number1) && compareRoman(number3)) {
            num1 = romanToInt(number1);
            num2 = romanToInt(number3);
            int resultatRoman = calculate(num1, operator, num2);
            if(resultatRoman<0){throw new Exception("В римской системе нет отрицательных чисел");}
            intToRoman(resultatRoman);
        } else if (!compareRoman(number1) && !compareRoman(number3)) {
            num1 = Integer.parseInt(number1);
            num2 = Integer.parseInt(number3);
            if (num1 == 0 || num2 == 0 || num1 > 10 || num2 > 10) {
                throw new Exception("Числа должны быть от 1 до 10");}
            int resultatArabian = calculate(num1, operator, num2);
            System.out.println("Ответ:" + resultatArabian);
        }else{throw new Exception("Используются одновременно разные системы счисления");}

        return input;
    }



    public static int romanToInt(String roman) throws Exception {
        return switch (roman) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> throw new Exception("Числа должны быть от I до X");
        };
    }


    public static int calculate(int num1, char operator, int num2) {

        if (operator == '+'){
            result = num1 + num2;
            return result;
        }
        else if (operator == '-'){
            result = num1 - num2;
            return result;
        }
        else if (operator == '/'){
            result = num1 / num2;
            return result;
        }
        else if (operator == '*'){
            result = num1 * num2;
            return result;
        }

        return result;
    }

    static String [] roman2 = new String[]{"0","I","II","III","IV","V","VI", "VII","VIII","IX","X","XI","XII","XIII",
            "XIV","XV","XVI","XVII" ,"XVIII" ,"XIX" ,"XX" ,"XXI" ,"XXII" ,"XXIII" ,"XXIV" ,"XXV", "XXVI" ,"XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII",
            "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII" ,"XLIII" ,"XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII",
            "LIII","LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII" ,"LXIV" ,"LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII",
            "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX" ,"LXXXI" ,"LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI",
            "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV" ,"XCVI" ,"XCVII","XCVIII","XCIX","C"};


    static void intToRoman(int num) {
        for(int i = 1; i<roman2.length; i++){
            if(i == num){
                System.out.println("Ответ: " + roman2[i]);
            }
        }
    }

    static boolean compareRoman(String a){
        for(int i=0; i<roman2.length; i++){
            if(roman2[i].equals(a)){
                return true;}
        }
        return false;
    }

}
