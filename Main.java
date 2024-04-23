import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws Exception {
        System.out.println("Input: ");

        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(calculator(input));
    }

    public static String calculator(String input) throws Exception {


        String[] arr = input.split("[+\\-*/]");


        String a1 = arr[0];
        String a = a1.trim();
        String b1 = arr[1];
        String b = b1.trim();
        String c = oper(input);



        String [] aa = a.split("");
        int lastIndexA = aa.length - 1;
        if (!aa[0].equals("\"") || !aa[lastIndexA].equals("\"") || lastIndexA > 11){
            throw new Exception ("NOT");
        }



        String [] bb = b.split("");
        int lastIndexB = bb.length - 1;


        if (c==null){
            throw new Exception("NOO");
        } else if (!bb[0].equals("\"") && !bb[lastIndexB].equals("\"") && (c.equals("/") || c.equals("*")) && lastIndexB <= 10) {
            return (calcUmnoDel(c, a, b));
        } else if (bb[0].equals("\"") && bb[lastIndexB].equals("\"") && lastIndexB <= 10 && (c.equals("+") || c.equals("-")) ) {
            return (calcPlusMinus(c, a, b));
        } else throw new Exception("Nein");
    }

    static String oper(String input){
        if (input.contains("+")) return "+";
        else if (input.contains("-")) return "-";
        else if (input.contains("*")) return "*";
        else if (input.contains("/")) return "/";
        else return null;
    }


    static private String calcPlusMinus(String c, String a, String b) throws Exception {
        String plus;
        String minus;

        String [] aa = a.split("");
        int lastIndexA = aa.length;
        String resA = a.substring(0, lastIndexA -1);

        String [] bb = b.split("");
        int lastIndexB = bb.length;
        String resB = b.substring(1, lastIndexB);


        if (c.equals("+")) {
            plus = resA + resB;
            return plus;

        } else if (c.equals("-")) {
            minus = (resA.replace(resB, ""));
            return minus +"\"";

        } else throw new Exception("Not");
    }

    static private String calcUmnoDel(String c, String a, String b) throws Exception {

        int e = e(b);

        String umno;
        String umno2;
        String del;
        String[] delProm;
        int sum = 0;

        String [] aa = a.split("");
        int lastIndexA = aa.length;
        String resA = a.substring(1, lastIndexA -1);

        int res;

        if (e < 11 && e > 0 && c.equals("*")) {
            umno = resA.repeat(e);
            String [] umnoUmno = umno.split("");
            int sum2 = 40;
            if (sum2 >= umnoUmno.length){
                return "\"" + umno + "\"";}
                else  {
                       umno2 = umno.substring(0,40) + "...";
                       return umno2;
            }

        } else if (e < 11 && e > 0 && c.equals("/")) {
            delProm = resA.split("");
            for (int i = 0; i < delProm.length; i++) {
                sum = sum + 1;
            }
            res = sum / e;
            del = resA.substring(0, res);
            return "\"" + del + "\"";
        } else throw new Exception("Not");
    }


    public static int e(String b) throws Exception {

        String[] arr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        for (int i = 0; i < arr.length; i++) {
            if (b.equals(arr[i])) {
                return Integer.parseInt(b);
            }
        }
        throw new Exception("NO");
    }

}


