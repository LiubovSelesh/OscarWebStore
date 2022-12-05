package com.telran.oscar.utils;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public static Iterator<Object[]> registrationFormWithValidData() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/RegValidData.csv")));

        String line = reader.readLine();

        while (line != null) {

            list.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> registrationWithInvalidEmail() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/RegInvalidEmail.csv")));

        String line = reader.readLine();

        while (line != null) {

            list.add(line.split(","));
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> registrationWithInvalidPassword() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/RegInvalidPassword.csv")));

        String line = reader.readLine();

        while (line != null) {

            list.add(line.split(","));
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> registrationWithInvalidConfirm() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/RegInvalidConfirm.csv")));

        String line = reader.readLine();

        while (line != null) {

            list.add(line.split(","));
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> loginWithValidData() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/loginValidData.csv")));

        String line = reader.readLine();

        while (line != null) {

            list.add(line.split(","));
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> loginWithInvalidEmail() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/loginInvalidEmail.csv")));

        String line = reader.readLine();

        while (line != null) {

            list.add(line.split(","));
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> loginWithInvalidPassword() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/loginInvalidPassword.csv")));

        String line = reader.readLine();

        while (line != null) {

            list.add(line.split(","));
            line = reader.readLine();
        }
        return list.iterator();
    }
}
