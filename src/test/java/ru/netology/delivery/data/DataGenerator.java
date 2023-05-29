package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }


    public static String generateDate(int datesToAdd) {

        String date = LocalDate.now().plusDays(datesToAdd).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity(String locale) {

        String[] cities = {"Абакан", "Анадырь", "Архангельск", "Астрахань", "Барнаул", "Владикавказ", "Горно-Алтайск",
                "Йошкар-Ола", "Казань", "Калининград", "Калуга", "Краснодар", "Магадан", "Магас", "Махачкала", "Нарьян-Мар",
                "Петропавловск-Камчатский", "Салехард", "Самара", "Саранск", "Саратов", "Хабаровск", "Ханты-Мансийск",
                "Южно-Сахалинск", "Белгород", "Великий Новгород", "Владивосток", "Волгоград",
                "Вологда", "Воронеж", "Горно-Алтайск", "Иваново", "Йошкар-Ола", "Кемерово",
                "Кострома", "Нижний Новгород", "Новосибирск", "Петрозаводск", "Ростов-на-Дону",
                "Севастополь", "Симферополь", "Ставрополь"};

        return cities[new Random().nextInt(cities.length)];

    }

    public static String generateName(String locale) {

        Locale localeRu = new Locale("ru");
        Faker faker = new Faker(localeRu);
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {

        Faker faker = new Faker();
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {

            Locale localeRu = new Locale("ru");
            Faker faker = new Faker(localeRu);
            String city = faker.address().city();
            String name = faker.name().fullName();
            String phone = faker.phoneNumber().phoneNumber();
            UserInfo user = new UserInfo(city, name, phone);
            return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
