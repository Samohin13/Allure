package ru.netology.javaqa.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;


public class DataGenerator {
    private void DataGenerator() {
    }


    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    }

    public static String generateCity() {
        String[] cities = {"Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург",
                "Казань", "Нижний Новгород", "Челябинск", "Самара", "Омск", "Ростов-на-Дону", "Уфа",
                "Красноярск", "Воронеж", "Пермь", "Волгоград", "Краснодар", "Саратов", "Тюмень",
                "Тольятти"};

        return cities[new Random().nextInt(cities.length)];

    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();

    }

    public static class Registration {
        private Registration() {
        }

        public static userInfo generatorUser(String locale) {
            return new userInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class userInfo {
        String city;
        String name;
        String phone;
    }
}


