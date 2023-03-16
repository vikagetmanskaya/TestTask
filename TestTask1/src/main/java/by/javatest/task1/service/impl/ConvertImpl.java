package by.javatest.task1.service.impl;

import by.javatest.task1.service.Convert;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ConvertImpl implements Convert {
    @Override
    public long convertIPv4ToInt(String ip) {
        String[] ipMassive = ip.split("\\.");
        int[] ipMassiveInt = Arrays.stream(ipMassive).mapToInt(num -> Integer.parseInt(num)).toArray();
        boolean contains = IntStream.of(ipMassiveInt).allMatch(x -> x < 256);
        int length = ipMassiveInt.length;
        long result = 0;
        if (ipMassiveInt.length == 4 && contains == true) {
            for (int i = 0; i < length; i++) {
                int power = 3 - i;
                result += (ipMassiveInt[i]) * Math.pow(256, power);
            }
        } else {
            result = 0;
            System.out.println("Протокол IPv4 поддерживает только 32-битные числа " +
                    "и состоит из 4 октетов!");
        }
        return result;
    }

    @Override
    public String convertIntToIPv4(long ip) {
        String binary = Long.toBinaryString(ip);
        int amountOfSymbols = binary.length();
        String result = "";
        if (amountOfSymbols > 32) {
            result = "Протокол IPv4 поддерживает только 32-битные числа" +
                    "и состоит из 4 октетов!";
        } else {
            StringBuilder stringBuilder = new StringBuilder(binary);
            while (amountOfSymbols < 32) {
                stringBuilder.insert(0, "0");
                amountOfSymbols++;
            }
            binary = String.valueOf(stringBuilder);
            String[] binaryMassiveMain = binary.split("(?<=\\G.{" + 8 + "})");
            int length = binaryMassiveMain.length;
            for (int i = 0; i < length; i++) {
                int current = Integer.parseInt(binaryMassiveMain[i], 2);
                if (i < length - 1) {
                    result += current + ".";
                } else {
                    result += current;
                }
            }
        }

        return result;
    }
}
