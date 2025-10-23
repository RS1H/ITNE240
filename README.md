# Java IPC Project – ITNE240

This Java program demonstrates **Inter-Thread Communication** using two methods:  
1. **Pipes (`PipedInputStream` / `PipedOutputStream`)**  
2. **BlockingQueue**

---

## Overview

The program has two parts:

### 1. Pipe Communication  
- **Producer (`Prod`)** sends four messages through a `PipedOutputStream`.  
- **Consumer (`Cons`)** reads them from a connected `PipedInputStream`.  
- Each message is printed by both producer and consumer.  
- Communication stops automatically when the producer closes the stream.

### 2. Queue Communication  
- **Producer (`QProd`)** pushes messages into a shared `BlockingQueue`.  
- **Consumer (`QCons`)** takes messages from the same queue and converts them to uppercase.  
- The threads run concurrently and demonstrate safe inter-thread communication.

---

## Code Flow

1. Main class `project` runs both demos sequentially.  
2. First, it runs the **pipe example**, then the **queue example**.  
3. Each message is printed with a delay (`Thread.sleep`) to simulate real communication timing.  

---

## Example Output

```
-- pipes --
prod: i
cons got: I
prod: love
cons got: LOVE
prod: itne
cons got: ITNE
prod: 240
cons got: 240

-- queue --
QProd: network
QCons got: NETWORK
QProd: operating
QCons got: OPERATING
QProd: system
QCons got: SYSTEM
QProd: project
QCons got: PROJECT
```

---

## How to Run

```bash
# Compile
javac project.java

# Run
java project
```

**Requirements:**  
- Java 8 or later  
- No external libraries needed  

---

## Notes
- The code uses simple `Thread` subclasses, not the `Runnable` interface.  
- The queue version is safer for real applications because `BlockingQueue` handles synchronization internally.  
- Delays are used just for demonstration (1.5s for pipe, 2s for queue).

---

## Authors
**Rayan**
**Ali**
**Mohammed**  

  
University of Bahrain – ITNE240 Project  
