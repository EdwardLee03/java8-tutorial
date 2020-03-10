package com.winterbe.java8.samples.lambda;

import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Common standard functions from the Java API.
 *
 * @author Benjamin Winterberg
 */
public class Lambda3 {

    // 函数式接口
    @FunctionalInterface
    interface Fun {
        void foo();
    }

    public static void main(String[] args) throws Exception {

        // Predicates

        // 谓词函数
        Predicate<String> predicate = (s) -> s.length() > 0;

        predicate.test("foo");              // true
        predicate.negate().test("foo");     // false

        // 谓词函数
        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        // 谓词函数
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();


        // Functions

        // 一元函数
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        backToString.apply("123");     // "123"


        // Suppliers

        // 对象提供者函数
        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();   // new Person


        // Consumers

        // 对象消费者函数
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getFirstName());
        greeter.accept(new Person("Luke", "Skywalker"));


        // Comparators

        // 比较函数
        Comparator<Person> comparator = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        comparator.compare(p1, p2);             // > 0
        comparator.reversed().compare(p1, p2);  // < 0


        // Runnables

        Runnable runnable = () -> System.out.println(UUID.randomUUID());
        runnable.run();


        // Callables

        Callable<UUID> callable = UUID::randomUUID;
        callable.call();
    }
}
