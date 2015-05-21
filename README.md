# InterviewQuestions #
An automated test suite, designed for use in a technical Java interview
 
## So what's this all about? ##

I'm a project manager and technical lead for a team of Java developers. One of my roles is to interview potential new hires and see if they'd be a good fit for our team.

The first part of that interview is always an informal conversation, something to break the ice and (hopefully) make them comfortable. But sooner or later we have to get into the nitty-gritty, technical questions.

And that's when it almost always blows up.

There are a handful of classic interview questions, like FizzBuzz, reversing a string, or calculating the first 100 prime numbers, that every senior developer agrees is trivial, and about half of junior developers think are [unfair, useless, trick questions](http://www.reddit.com/r/webdev/comments/35owh3/designer_applies_for_js_job_fails_at_fizzbuzz/) that we shouldn't be wasting their time with.

I've interviewed people with Master's Degrees in Computer Science -- friggin' *Master's Degrees!* -- that couldn't whiteboard FizzBuzz.

Now, it's entirely possible that these candidates came from a degree mill, or that they cheated their way through six years of education. Stranger things have happened. But there's another possibility.

Maybe it's the whiteboard.

When we write code, we have a bunch of tools to help us. We have IDEs that color syntax and point out stupid mistakes. We can run our code, print stuff out to the console, even run a debugger if we have to. All of that makes it a lot easier to work through a problem until we get to the correct solution, and none of that is available on a whiteboard.

That's what this project is for.

`InterviewQuestions` is a collection of Maven projects, each of which contains a method for the candidate to implement and a unit test to make sure they did it right. If the unit test passes, so do they. And if it fails, you get to see how they deal with a setback, how they debug the problem, and how they check their own thinking in search of the correct answer.

## Using this project ##

To use this project, clone it:

`git clone https://github.com/thomasgalvin/InterviewQuestions.git`

And then build it:

```
cd InterviewQuestions
mvn clean install 
```

This will build some utilities needed by the unit tests. It will also build and test the `InterviewSolutions` project, to make sure nothing about your environment has uncovered a bug in the tests. After that, you can open up the Questions projects in an IDE (or not, it's up to you), and let the candidate work through them. 

## Junior Developer Questions ##

The interview for a Junior Developer position includes the following projects:

* **Junior Developer 01 - Hello, World** - Write a "Hello, World!" and "Hello, ${name}!" method.
* **Junior Developer 02 - FizzBuzz** - Solve the classic FizzBuzz problem.
* **Junior Developer 03 - Sort** - Sort an array of integers, using whatever algorithm they like.
* **Junior Developer 04 - Array Merge** - Merge two arrays, alternating elements from each.
* **Junior Developer 05 - Clever Array Merge** - Same as Array Merge, but the arrays might be of differing lengths.
* **Junior Developer 06 - Fibonacci** - Write a function that returns the first 100 Fibonacci numbers.
* **Junior Developer 07 - Sums** - Write three methods that sum the numbers in an array, using a for-loop, a while-loop, and recursion.
* **Junior Developer 08 - String Reverse** - Reverse a String.
* **Junior Developer 09 - Factorial** - Write a method that calculates the factorial of an integer.
* **Junior Developer 10 - Find Primes** - Write a method that finds the first 100 prime numbers.

## Developer Questions ##

The interview for a Developer position includes the following projects:

* **Developer 01 - Array List** - Write `add` and `delete` methods for an Array List.
* **Developer 02 - Linked List** - Write `add` and `delete` methods for a Linked List.
* **Developer 03 - Comparator** - Write an implementation of a java.util.Comparator, using provided criteria
* **Developer 04 - Quick Sort** -Implement the QuickSort algorithm
* **Developer 05 - Prime Sieve** -Implement the Sieve of Eratosthenes to find prime numbers

## Solutions ##

This project also includes an `InterviewSolutions` module, with working answers to all of these questions.

That probably makes some of you angry. What good is a suite of test questions if the candidate can just download the answers ahead of time!

Well, two things. First, if they know what GitHub is and how to clone a project, they're probably good enough to solve these problems anyway.

Second, these aren't trick questions. This is all stuff that should have been covered in any four-year computer science degree. If the potential candidate checks out this code and learns something new, I consider that a win.