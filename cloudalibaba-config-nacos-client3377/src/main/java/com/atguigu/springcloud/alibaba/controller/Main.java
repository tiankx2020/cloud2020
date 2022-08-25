package com.atguigu.springcloud.alibaba.controller;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年08月18日 19:14
 */
 class A {

    public void get(){

        System.out.print("A");

    }



    public void get(A a){

        a.get();

    }

}

 class B extends A {

    public void get(){

        System.out.print("B");

    }

}

public class Main {

    public static void main(String[] args) {

        A a = new B();

        B b = new B();

        a.get();

        b.get(a);

    }

}
