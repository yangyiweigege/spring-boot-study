package com.weige.ssm.vali;

public class TestVolatile{

    public static void main(String[] args){
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();

        while(true){
        	//System.out.println(td.isFlag());
            if(td.isFlag()){
                System.out.println("########");
                break;
            }
        }
    }
}
