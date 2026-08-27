# Letter Frequency Analyzer

A simple console application that analyzes text and visualizes how often
each letter appears, using an ASCII bar chart.

## Features
- Reads any line of text from the console
- Case-insensitive counting (`A` and `a` count as the same letter)
- Ignores digits, spaces, and punctuation
- Displays results as a horizontal bar chart
- Keeps running until you type `exit`

## How to run
```
javac src/LetterFrequencyAnalyzer.java
java -cp src LetterFrequencyAnalyzer
```

## Example
```
=== Letter Frequency Analyzer ===
Type a sentence to analyze, or type 'exit' to quit.

Enter text: hello bro
b : * (1)
e : * (1)
h : * (1)
l : ** (2)
o : ** (2)
r : * (1)

Enter text: exit
```

## How it works
1. The program reads a line of text with `Scanner`
2. It loops through every character with an enhanced for-loop
   (`for (char ch : input.toCharArray())`)
3. In Java, a `char` is really a 16-bit integer (a Unicode code point), so
   `lower - 'a'` on a lowercase letter gives a number between 0 and 25 —
   exactly the index needed in a 26-slot array
4. Each slot in the `int[26]` array counts how many times that letter
   appeared.
5. A second loop (classic `for`, since it needs the index) walks the array
   and prints one row per letter that appeared, repeating `*` `count` times

## Complexity
- Time: O(n) — every character in the input is visited exactly once
- Space: O(1) — the counts array is always fixed size 26.

## What I learned
- How Java represents `char` as an integer under the hood, and how to use
  that for array indexing. 
- The difference between a classic `for` loop (by index) and an enhanced
  `for-each` loop (by value)
- How a `while` loop can drive a simple interactive menu until the user quits
- Why `.equals()` / `.equalsIgnoreCase()` must be used to compare `String`
  content instead of `==`