## RateLimiter-using-Sliding-Window

Create a rate limiter program using a sliding window which allows/blocks request based on timestamps. Program will receive sequence of timestamps via arguments. For each timestamp it has to output allowed/blocked based on the sliding window. Sliding window to have 2 configurations, R: maximum number of requests allowed in sliding window S: sliding window time period in seconds

### My Approach

### Using Sliding Window with Counter

**Time Compliexity - O(n), Since Sliding window protocol runs of "n" time in single loop**

**Space Compliexity - O(n), Since using Stack lead to extra space**

**Pseudo Code**

```python

rateLimiter(R,S,Sequence):
  
  if R<=0:
     throw error and stop program;
  
  if S<=0:
     throw error and stop program;
  
  counter = 0;
  
  stack;
  
  for i from 0 to len(Sequence):
      
      stack.add(Sequence[i]);
      
      if i == R:
         i = i + (S-counter);
         counter = 0;
         
  end of for loop
  
  for i from 0 to len(Sequence):
      if sequence[i] in stack:
         print(sequence[i],"allowed");
      else:
         print(sequence[i],"blocked");
  end for loop

end procedure

```

**Approach**

```

Step 1: Start the procedure

Step 2: Ensure R or S is not equal to 0 or less than 0, if R or S is equal to zero or less than, then preint respective error message and end the program

Step 3: Initialize the counter to 0

step 4: Run loop for sequence times

Step 5: Add the Sequence[itr] to the stack

Step 6: increment counter for all insertion

Step 7: If itr becomes R, then wait(ignore) the sequence until the time period - S 

Step 8: set counter 0.

Step 9: Repeat from step 5 to step 8 till all the sequence value is completely traversed and end loop

Step 10: Run loop for every sequence value

Step 11: if sequence is present in the stack then print sequence is allowed, if sequence is not present in stack then print sequence is blocked

Step 12: repeat step 11 for every value in sequence and end loop

Step 13: End procedure

```

### Runtime Environment

- java complier version 16 (java16)

- RAM = 4 GB

- Windows 10

- Editor - VS code

### Github Link

- Git hub repo link = [RateLimter using Sliding window](https://github.com/Ajay2521/RateLimiter-using-Sliding-Window)

- Source Code link = [Java Source Code](https://github.com/Ajay2521/RateLimiter-using-Sliding-Window/blob/main/1807004_Ajay_M.java)


### Sample Input and Output

- Given Sample Case 1:

```

Input: 2 5 1 2 4 5 6 7 8 9

Expected Output: 

1 allowed 
2 allowed 
4 blocked
5 blocked
6 blocked
7 allowed
8 allowed
9 blocked

Obtained Output:

```

<p align="center">

<img src="https://user-images.githubusercontent.com/60919132/131948112-cda388b3-4e69-4db3-a430-e022da74fb9b.png" >

</p>


- Sample Case 2:

```

Input: 0 2 1 2 4 5 6 7 8 9

Expected Output: Error message for R

Obtained Output:

```

<p align="center">

<img src="https://user-images.githubusercontent.com/60919132/131948386-d010c23c-fee6-42fe-8ce3-8dcda7cfb170.png" >

</p>

- Sample Case 3:

```

Input: 1 0 1 2 4 5 6 7 8 9

Expected Output: Error message for S

Obtained Output:

```

<p align="center">

<img src="https://user-images.githubusercontent.com/60919132/131948714-a1f895f8-e8ca-4c6f-8fc7-5d0d3015556f.png" >

</p>

- Sample Case 4:

```

Input: 1 3 1 2 4 5 6 7 8 9

Expected Output: 

1 allowed 
2 blocked 
4 blocked
5 allowed
6 blocked
7 blocked
8 allowed
9 blocked

Obtained Output:

```

<p align="center">

<img src="https://user-images.githubusercontent.com/60919132/131948936-40619fcc-e639-451a-b3c5-66b89a3bc383.png" >

</p>


- Sample Case 5:

```

Input: 3 7 1 2 8 9 10 11 13 3 17 14 4 6 12 5

Obtained Output:

```

<p align="center">

<img src="https://user-images.githubusercontent.com/60919132/131949034-75e854db-8d26-4e8d-9d2a-53a4428e48d1.png" >

</p>

