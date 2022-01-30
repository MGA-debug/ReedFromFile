package ru.appline.logic;

import ru.appline.logic.reader.MyReader;

public class Base {
    public static void main(String[] args) {

        new MyReader("src/ru/appline/logic/test")
                .read()
                .getInformation();
    }
}
