package by.javatest.task1.main;

import by.javatest.task1.service.Convert;
import by.javatest.task1.service.impl.ConvertImpl;


public class Main {
    public static void main(String[] args) {
        Convert convert = new ConvertImpl();
        String result = (convert.convertIntToIPv4(618970019642690137L));
        System.out.println(result);

    }
}
