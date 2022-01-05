package com.example.demo.initordertest;

public class Beetle extends Insect {
    private int k = printInt("Beetle.k init\n");

    public Beetle() {
        System.out.print("s=" + s + ",");
        System.out.print("k=" + k + ",");
        System.out.print("j=" + j);
    }

    private static int x2 = printInt("Beetle.x2 is init\n");

    private int s = printInt("Beetle.s init\n");

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.print("Starting\n");
        Beetle b = new Beetle();
    }
}
