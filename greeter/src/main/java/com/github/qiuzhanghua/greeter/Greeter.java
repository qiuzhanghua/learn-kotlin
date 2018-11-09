package com.github.qiuzhanghua.greeter;

public class Greeter {
    public static void main(String[] args) {
        final String output = GreetingFormatter.say(args[0]);
        System.out.println(output);
        System.out.println(GreetingKotlin.Companion.say(args[0]));
    }
}