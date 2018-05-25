package com.mooc.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ArraryTest {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString()+".xlsx";
        System.out.println(str);
    }
}
