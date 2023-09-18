package ru.aston.osipov_vv.task6;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPITest {

    static class Date {
        public int day;
        public int month;
        public int year;

        public String toString() {
            return day + "/" + month + "/" + year;
        }
    }

    @Test
    public void testOne() {
        // Вывести все четные числа в диапазоне от 1 до 100
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            list.add(i + 1);

        list.stream().filter((n) -> n % 2 == 0).forEach(System.out::println);
    }

    @Test
    public void testTwo() {
        // Посчитать сумму чисел в массиве [1, 2, 3, 4, 5], используя reduce()
        int[] array = new int[] {1, 2, 3, 4, 5};
        System.out.println(Arrays.stream(array).reduce(0, Integer::sum));
    }

    @Test
    public void testThree() {
        // Отсортировать элементы массива [1, 3, 5, 7, 9] по возрастанию,
        int[] array = new int[] {1, 3, 5, 7, 9};
        array = Arrays.stream(array).sorted().toArray();
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testFour() {
        // Пропустить первые 10 элементов списка [0, 1, 2,.., 99] и начать выводить с 11-го
        // элемента, выводя каждый 10-й элемент
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            list.add(i);

        System.out.println(list.stream().skip(10).filter((n) -> n % 10 == 0));
    }

    @Test
    public void testFive() {
        // Выведите на экран только те элементы списка, которые больше заданного числа.
        final int testNumber = 15;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            list.add(i);

        System.out.println(list.stream().sorted().dropWhile((n) -> n <= testNumber));
    }

    @Test
    public void testSix() {
        // Выведите на экран строки, которые начинаются с заданной подстроки.
        List<String> list = fillListTestSix();
        String testString = "testF";
        list.stream().filter((n) -> n.startsWith(testString)).forEach(System.out::println);
    }

    @Test
    public void testSeven() {
        // Выведите на экран элементы списка, которые не входят в другой список.
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            if (i % 3 == 0) list1.add(i);
            if (i % 5 == 0) list2.add(new Random().nextInt(1, 100));
        }
        System.out.println(list2);

        list1.stream().filter((n) -> !list2.contains(n)).forEach(System.out::println);
    }

    @Test
    public void testEight() {
        // Проверить, есть ли четное число в списке [0, 1, 2, 3],
        List<Integer> list = List.of(0, 1, 2, 3);
        System.out.println(list.stream().filter((n) -> n % 2 == 0).findAny());
    }

    @Test
    public void testNine() {
        // Собрать элементы Stream в карту, где ключом будет первая буква каждого слова,
        // а значением — само слово. Отсортировать ключи в алфавитном порядке.
        List<String> list = fillListWithNumbers();
        Map<Character, String> map = list.stream()
                .collect(Collectors.toMap(s -> s.charAt(0), s -> s));
        System.out.println(map);
    }

    @Test
    public void testTen() {
        // Собрать числа в Stream в список сумм цифр каждого числа.
        List<Integer> list = IntStream.range(100, 1000).boxed().toList();
        list = list.stream()
                .map(
                        n -> String.valueOf(n)
                                .chars()
                                .map(Character::getNumericValue)
                                .sum()
                ).collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    public void testEleven() {
        // Собрать даты в Stream в список, где каждый элемент — это количество дат в каждом месяце года.
        List<Date> list = fillListWithDates();
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            final int k = i;
            res.add((int) list.stream()
                    .filter(d -> d.month == k)
                    .count());
        }

//        Map<Integer, Integer> count = list.stream()
//                        .collect(Collectors.groupingBy(
//                                date -> date.month, Collectors.counting())
//                        ).entrySet().stream()
//                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().intValue()));
//        List<Integer> res = IntStream.rangeClosed(1, 12)
//                .mapToObj(month -> count.getOrDefault(month, 0))
//                .collect(Collectors.toList());

        System.out.println(res);
    }

    @Test
    public void testTwelve() {
        // Создайте три Stream-а из массивов чисел 1…10, 5…20 и 10…30 соответственно.
        // Объедините их в один Stream и выведите числа, которые кратны 3 или 5.
        Stream<Integer> test1 = IntStream.rangeClosed(1, 10).boxed();
        Stream<Integer> test2 = IntStream.rangeClosed(5, 20).boxed();
        Stream<Integer> test3 = IntStream.rangeClosed(10, 30).boxed();
        Stream<Integer> res = Stream.concat(Stream.concat(test1, test2), test3);
        res.filter(n -> n % 3 == 0 && n % 5 == 0).forEach(System.out::println);
    }

    @Test
    public void testThirteen() {
        // Создать стрим, который выводит числа от 1 до 10.
        // Найти среднее арифметическое этих чисел и вывести его на экран.
        List<Integer> list = IntStream.rangeClosed(1, 10).boxed().toList();
        System.out.println(list.stream().collect(Collectors.averagingInt(n -> n)));
    }

    @Test
    public void testFourteen() {
        // Разделить слова в Stream на две группы по первой букве: гласные и согласные,
        // посчитать количество слов в каждой группе.
        List<String> list = fillListWithNumbers();
        final String VOWELS = "aeyuio";

        list.stream()
                .collect(Collectors.groupingBy(
                        str -> VOWELS.indexOf(str.charAt(0)) == -1, Collectors.counting()))
                .values().forEach(System.out::println);
    }

    @Test
    public void testFifteen() {
        // Разделить числа в Stream на три группы по остатку от деления на 3 (0, 1, 2),
        // посчитать сумму чисел в каждой группе.
        List<Integer> list = IntStream.rangeClosed(1, 100).boxed().toList();
        Map<Integer, Integer> count = list.stream()
                .collect(Collectors.groupingBy(
                        number -> number % 3, Collectors.reducing(Integer::sum))
                ).entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().get()));
        count.values().forEach(System.out::println);
    }

    @Test
    public void testSixteen() {
        // Создание трех Stream из массивов и объединение их в один.
        // Затем вывод на экран среднего геометрического значения элементов этого Stream.
        int[] array1 = IntStream.rangeClosed(1, 10).toArray();
        int[] array2 = IntStream.rangeClosed(5, 15).toArray();
        int[] array3 = IntStream.rangeClosed(10, 15).toArray();
        Stream<Integer> stream1 = Arrays.stream(array1).boxed();
        Stream<Integer> stream2 = Arrays.stream(array2).boxed();
        Stream<Integer> stream3 = Arrays.stream(array3).boxed();
        double res = Stream.concat(Stream.concat(stream1, stream2), stream3)
                .reduce(1, (n1, n2) -> n1 * n2);

        System.out.println(res / (array1.length + array2.length + array3.length));
    }

    @Test
    public void testSeventeen() {
        // Создание Stream целых чисел и поиск всех чисел, у которых сумма цифр равна заданному числу.
        final int TEST_N = 13;
        Stream<Integer> stream = IntStream.rangeClosed(1, 100).boxed();
        List<Integer> res = stream
                .filter(n -> String.valueOf(n)
                        .chars()
                        .map(Character::getNumericValue)
                        .sum() == TEST_N).toList();
        System.out.println(res);
    }

    @Test
    public void testEighteen() {
        // Сгруппировать слова в Stream по первой букве, посчитать количество слов в каждой группе и
        // вывести результаты в виде словаря, где ключ — первая буква слова, а значение — количество
        // слов, начинающихся на эту букву.
        List<String> list = fillListWithNumbers();
        Map<Character, Integer> map = list.stream()
                .collect(Collectors.groupingBy(
                        s -> s.charAt(0), Collectors.counting())
                ).entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().intValue()));
        System.out.println(map);
    }

    @Test
    public void testNineteen() {
        // Для любого набора случайно-сгенерированных чисел нужно определить количество парных.
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 15; i++)
            list.add(random.nextInt(6));

        Long res = list.stream()
                .collect(Collectors.groupingBy(
                        value -> value, Collectors.counting()
                )).values().stream()
                .map(value -> value - (value % 2))
                .filter(value -> value % 2 == 0)
                .reduce(0L, Long::sum) / 2;
        System.out.println(res);
    }

    private List<String> fillListTestSix() {
        List<String> list = new ArrayList<>();
        list.add("testOne");
        list.add("testTwo");
        list.add("testThree");
        list.add("testFour");
        list.add("testFive");
        list.add("testSix");
        list.add("testSeven");
        list.add("testEight");
        list.add("testNine");
        list.add("testTen");
        list.add("testEleven");
        list.add("testTwelve");
        list.add("testThirteen");
        list.add("testFourteen");
        list.add("testFifteen");
        list.add("testSixteen");
        list.add("testSeventeen");
        list.add("testEighteen");
        list.add("testNineteen");
        list.add("testTwenty");
        return list;
    }
    private List<String> fillListWithNumbers() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("eight");
        list.add("nine");
        list.add("ten");
        list.add("eleven");
        list.add("twelve");
        list.add("thirteen");
        list.add("fourteen");
        list.add("fifteen");
        list.add("sixteen");
        list.add("seventeen");
        list.add("eighteen");
        list.add("nineteen");
        list.add("twenty");
        return list;
    }
    private List<Date> fillListWithDates() {
        Random random = new Random();
        List<Date> list = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            Date date = new Date();
            date.day = random.nextInt(1, 28);
            date.month = random.nextInt(1, 12);
            date.year = random.nextInt(2000, 2100);
            list.add(date);
        }
        return list;
    }
}
