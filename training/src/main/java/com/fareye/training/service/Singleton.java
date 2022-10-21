package com.fareye.training.service;

public class Singleton {

    private static  volatile  Singleton instance;
    //for case 4  make the variable private static  volatile  Singleton instance;
    private String data;
    private Singleton(String data)
    {
        this.data=data;
    }
    public static Singleton getInstance1(String data)
    {  //thread safe but evety time new Objevt will be created with New Thread
        if(instance==null) {   //1
            instance = new Singleton(data);
        }

        return instance;
    }

    public static Singleton getInstance2(String data)
    {  //thread safe but each thread has to aquire lock  to access it.
        //every thread will be executing it once.
        synchronized (Singleton.class){
            //thread will wait untill it gets chance to enter then will be checking if instance is available though it was available
            //but the thread has to wait just beacuse of synchronization
            if(instance==null) {
                instance = new Singleton(data);
            }
        }
        return instance;
    }
    //to improve the above code  we will be putting instance check before synchronization block
    public static Singleton getInstance3(String data)
    {
        if(instance==null){
            synchronized (Singleton.class) {
                if (instance == null) {   //1
                    //but now if the instance was created . every thread has to wait before runing it
                    instance = new Singleton(data);
                }
            }
        }
        return instance;
    }

    public static Singleton getInstance4(String data)
    {  //for this set instance to volatile
        //EveryTime we Access this variable  we need to read it directly from the main memory can improve the performance by 40%
        Singleton result =instance;
        if(result==null){
            synchronized (Singleton.class) {
                if (instance == null) {   //1
                    //but now if the instance was created . every thread has to wait before runing it
                    instance = result=new Singleton(data);
                }
            }
        }
        return instance;
    }

}
