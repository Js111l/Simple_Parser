package com.company;

import java.lang.reflect.AnnotatedArrayType;
import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Wprowadź tekst: ");
        Scanner sc = new Scanner(System.in);


        String a =  sc.nextLine();

        Tokens aa = new Tokens();

        aa.setArgs(a);


        for (String s : Tokens.result) {
            System.out.println(s);
        }

        aa.setNumbers();



    }
}


class Tokens {

    static String abcd = "[a-zA-Z][a-zA-Z0-9_]*";
    static String numbers = "[0-9&&[^a-zA-Z]]+";
    static String brackets = "[\\x28]";
    static String brackets1 = "[\\x29]";
    static String brackets2 = "[\\x5B]";
    static String brackets3 = "[\\x5D]";
    static String aoperator = "[+]|[–]|[/]|[*]|[%]+";
    static String uoperator = "[+][+]|[–][-]|[!]+";
    static String aperator = "[=][=]|[=]|[+][=]|[-][=]|[*][=]|[/][=]|[%][=]|[\\^][=]+";
    static String roperator = "[>][=]|[<][=]|[>]|[<]|[!][=]|[=][=]+";
    static String logicoperator = "[\\x26][\\x26]|[\\x7C][\\x7C]+";


    static String [] args;

    static List<String> result = new ArrayList<>();

    void setArgs(String nnn) {
        this.args = nnn.split(" ");

    }

    token abcd1 = new token(abcd, "abcd");
    token numbers1 = new token(numbers, "number");
    token aoperator1 = new token(aoperator, "assignment operator");
    token uoperator1 = new token(uoperator, "unary operator");
    token aperator1 = new token(aperator, "a operator");
    token roperator1 = new token(roperator, "r operator");
    token logicaloperator1 = new token(logicoperator, "logical operator");
    token bracket = new token(brackets, "left bracket");
    token bracket1 = new token(brackets1, "right bracket");
    token bracket2 = new token(brackets2, "left bracket");
    token bracket3 = new token(brackets3, "right bracket");


    List<token> list = new ArrayList<>();

    void setNumbers() {
        list.add(abcd1);
        list.add(numbers1);
        list.add(aoperator1);
        list.add(uoperator1);
        list.add(aperator1);
        list.add(roperator1);
        list.add(logicaloperator1);
        list.add(bracket);
        list.add(bracket1);
        list.add(bracket2);
        list.add(bracket3);

        StringBuilder a=new StringBuilder();

        for (var i:list
        )
        {
            Pattern pattern=Pattern.compile(i.s);
            for (int m =0;m<args.length;m++)
            {
                Matcher matcher = pattern.matcher(args[m]);
                if (matcher.matches())
                {
                    System.out.println(matcher.group() +" "+ i.s1);

                }

            }

        }
        System.out.println(a);


    }


}


class token{
    String s;
    String s1;

    token(String a,String b){
        this.s=a;
        this.s1=b;
    }

}




