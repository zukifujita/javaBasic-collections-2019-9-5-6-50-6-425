# Overview

This repository is a part of the Java language training plan. Please read the following guidelines before start.

# Getting Start

## Basic Principals

Each repository contains a gradle java project with a number of unit tests. The initial state of all unit tests are *FAILED*. So the aim is to correct the failed test. Please follow the following steps to get the best experience:

* Read the test code and try to understand what it says.
* Trying to fix the test **WITHOUT RUNNING**. This is very important. Because once you run the test, you may find the failure message of the test telling you the expected result. That means you may lose the chance to figure it out by yourself. Note that you should **ONLY** be able to modify code within the **TODO AREA**. The code outside the **TODO AREA** is **NOT** changable.
* Run the test to examine if the fix is correct.
* Answer the following 4 questions after the test is passed.

The 4 questions are:

1. What is the knowledge point of the test? Where is the offical document to the knowledge point?
1. Why the test failed at first?
1. Why you corrected the test that way?
1. Do you have further questions on this knowledge point?

## Example

Let's take a look at an example:

```java
@Test
void should_pass_by_value() {
  int value = 5;

  tryingToUpdateValue(value);

  // TODO: please modify the following code to pass the test
  // <--start
  final int expected = 0;
  // --end-->

  assertEquals(expected, value);
}
```

First, read the test. From the title and code we can know that the test what to examine the behavior when passing an argument. We are not sure what `tryingToUpdateValue` does, so we can jump into its implementation:

```java
private static void tryingToUpdateValue(int value) {
  value += 2;
}
```

Now we have got the full context of the test. The argument is passed by value so the integer will be copied when passing into `tryingToUpdateValue`. Thus the value from the caller site will not change.

Notice that the todo area is in the test method. So we can modify codes within the todo area to pass the test:

```java
  // TODO: please modify the following code to pass the test
  // <--start
  final int expected = 5;
  // --end-->
```

Please note that not all todo areas are located in test method. And some todo area may have further restrictions, for example:

```java
  // TODO: You should not write concrete number here. Please find a property or constant instead.
  // <!--start
  final int maximumSymbol = 0;
  final int minimumSymbol = 0;
  // --end-->
```

The hint indicates that we should not write concrete number here. So I should not write `3` or `0xffffffff`, but write symbol (e.g. `Integer.MAX_VALUE`).

## Running Test

You could run unit tests with the help of IntelliJ. But it is also possible to run unit test via command line: `./gradlew build`.

If you just want to build your code without running test. Please use `./gradlew build -x test
`

- ANSWERS

1. What is the knowledge point of the test? Where is the official document to the knowledge point?

* 1. CollectionTest
    * should_go_through_an_iterator - To know what is an iterator and its methods.
    * should_create_a_sequence_without_putting_all_items_into_memory - To know what is the value through an iterable and create a sequence that the iterable are iterated over by iterator.
    * should_predict_linked_list_operation_result - To know what is the use of iterator, and what is the use of LinkedList, and modify the list of string from LinkedLIst
    * should_generate_distinct_sequence_on_the_fly - To know know what is the Character class, and compare() method.
    * should_reflects_back_to_original_list_for_sub_range - To know what is the use of subList() method.

* 1. ArrayTest
    * should_resize_array - To modify what logic should be done in MyStack class.

* 1. DistinctIterableJava
    * To know what is the difference between iterable and iterator.

* 1. MyStack
    * To know what logic should be done to pass the ArrayTest test case.

* 1. Sequence.java
    * To know what is the difference between iterable and iterator based on the sequence class.

1. Why the test failed at first?

* 1. CollectionTest
    * should_go_through_an_iterator - There is no iterated values in a collection.
    * should_create_a_sequence_without_putting_all_items_into_memory - There are no expected values that should be equal to the value from the Sequence.
    * should_predict_linked_list_operation_result - There are no values from the expected list.
    * should_generate_distinct_sequence_on_the_fly - There are no expected values.
    * should_reflects_back_to_original_list_for_sub_range - There are no expected values.

* 1. ArrayTest
    * should_resize_array - there are no implementations from MyStack class.

* 1. DistinctIterableJava
    * There are no/lack of  implementations.

* 1. MyStack
    * There are no/lack of  implementations.

* 1. Sequence.java
    * There are no/lack of implementations.

1. Why you corrected the test that way?

* 1. CollectionTest
    * should_go_through_an_iterator - While loop to check if there is a next element, and add the values to the list.
    * should_create_a_sequence_without_putting_all_items_into_memory - From Sequence class,
    * should_predict_linked_list_operation_result - Since the previous added value is "Juliet", and when the remove() function is called, it will remove "Juliet" also, since the remove() function is called after "Juliet" is added.
    * should_generate_distinct_sequence_on_the_fly - Since forEachRemaining is used, and there is a condition if the object is not yet added, it will not add a duplicate data.
    * should_reflects_back_to_original_list_for_sub_range - The answer will depend on what is the start and end index from the subList() method.

* 1. ArrayTest
    * should_resize_array - The functions are not net implemented in MyStack class. Created a new capacity to handle when the capacity is too small.

* 1. DistinctIterableJava
    * Created implementations that will handle some conditions, and return values.

* 1. MyStack
    * Created implementations that will handle the capacities of the ArrayList.

* 1. Sequence.java
    * Created implementations that will return the values depending on what are the start and end integer values.

1. Do you have further questions on this knowledge point?