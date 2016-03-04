package com.dipu.dpms.test;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;

import sun.misc.BASE64Encoder;


public class Test {
  public static void main(String[] args) {
        A a = new A();
         B b = new B();
         C c = new C();
        
         a.x = 1;
         b.test();
         b.x = 2;
         c.test();
         c.x = 3;
         a.test();
  }

}
class A{
  protected static int x = 0;
  public void test(){
    System.out.println(x);
  }
}
class B extends A{
  public void test(){
    System.out.println(x);
  }
}
class C extends A{
  public void test(){
    System.out.println(x);
  }
}