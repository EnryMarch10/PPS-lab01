# Lab 01

First laboratory of [Programming and Development Paradigms - a.y. 2025-2026](https://www.unibo.it/en/teaching/course-unit-catalogue/course-unit/2025/526526) ([Computer Science and Engineering](https://corsi.unibo.it/2cycle/ComputerScienceEngineering)).

## Author

[@EnryMarch10](https://github.com/EnryMarch10)

## Details

Refactoring the codebase using Test-Driven Development (TDD) with JUnit.

### Exercise 1 – IntelliJ Idea Basics, Software Quality and Tests

#### Steps:

1. **Analyze the existing code**
    - Review the proposed implementation to understand the application logic of the model (`example.model.*`).
    - Run the application to observe its current behavior.

2. **Review and execute the tests**
    - Analyze the provided test class (`SimpleBankAccountTest`).
    - Run the tests and verify the current results.

3. **Refactor using TDD**
    - Refactor and improve both the tests and the implementation.
    - Apply software quality principles (clean code, readability, maintainability).
    - Follow the Test-Driven Development (TDD) cycle: write a failing test → implement → refactor.

4. **Introduce a withdrawal fee**
    - Modify the solution to include a withdrawal fee of $1.
    - Update the tests first (TDD approach).
    - Update the implementation to satisfy the new tests.

### Exercise 2 - TDD

#### Step 1 – Implement `tdd.SmartDoorLock`

Following the Test-Driven Development (TDD) approach, provide an implementation for the `tdd.SmartDoorLock` interface.

> Refer to the methods’ documentation for detailed requirements.

##### Guidelines

- Write tests that verify complete user scenarios.
- Focus on realistic use cases rather than isolated method testing.
- Design test plans that describe full interaction flows, ending with clear final assertions.
- Build tests incrementally using the TDD cycle:
    - Write a failing test
    - Implement the minimal code to pass
    - Refactor
- Cover edge cases as well.
- Consider both **blocked** and **locked** states within realistic usage scenarios.

---

#### Step 2 – Implement `MinMaxStack`

Implement the `MinMaxStack` class using the TDD approach.

##### Guidelines

- Design tests that reflect realistic user interactions with the stack as a whole.
- Focus on behavioral scenarios rather than isolated method checks.
- Follow the TDD cycle strictly (fail → implement → refactor).
- Consider a simple strategy to track minimum and maximum values efficiently.
- Think about corner cases:
    - What happens if the stack is empty and `getMin()` is called?
    - What happens if `pop()` is called on an empty stack?
    - How are min/max values updated after removals?

---

#### Step 3 – Implement `CircularQueue`

Implement the full concept of a `CircularQueue` using the TDD approach.

> Only the interface description is provided. You must design the method signatures from scratch.

A `CircularQueue` is a fixed-size queue that overwrites the oldest elements when it becomes full (see interface documentation for details).

##### Guidelines

- Design tests that reflect realistic usage scenarios of the `CircularQueue` as a complete object.
- Apply the TDD approach when designing and refining the interface methods.
- Think of a simple implementation strategy (e.g., using a `List` or array with index tracking).
- Cover corner cases:
    - What happens if the queue is full and a new element is enqueued?
    - What happens if `dequeue()` is called on an empty queue?
    - How do you correctly maintain head and tail positions?

## License

[MIT](https://choosealicense.com/licenses/mit/)
