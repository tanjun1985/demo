package com.example.demo.initordertest;

public class Insect {
    private int i = 9;
    protected int j;

    public Insect() {
        System.out.print("i=" + i + ",j = " + j + "\n");
        j = 39;
    }

    private static int x1 = printInt("Inset.x1 init\n");

    static int printInt(String s) {
        System.out.print(s);
        return 47;
    }
}
