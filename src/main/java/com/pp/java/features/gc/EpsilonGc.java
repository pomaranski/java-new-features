package com.pp.java.features.gc;

public class EpsilonGc {

    // https://openjdk.java.net/jeps/318
    // TODO run with -Xlog:gc -Xmx1024m
    // TODO run with -Xlog:gc -Xmx1024m -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC
    public static void main(String[] args) {
        System.out.println("Start");

        for (var i = 0; i < 10_000; i++) {
            var array = new int[1024 * 1024];
        }

        System.out.println("Stop");
    }
}
