package springTest.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springTest.service.HelloService;

/**
 * Created by guofengrui on 2017/7/7.
 */

@Service
public class HelloServiceImpl implements HelloService{

    @Override
    public void sayHello(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("userHello");
    }

    @Override
    @Transactional
    public void txTest(){
        try{
            int temp = 0;
            temp = 2;
            System.out.println(temp);
            System.out.println("----");
            int[] array = new int[2];
            System.out.println(array[3]);
            System.out.println(temp);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            System.out.println();
        }
    }

}
