# Bloom_Filter
Java Bloom Filter class

Project for algorithms course.  This class is intended to be a spell checker for the 850 words of Basic English, but it's not too difficult to generalize this for other uses.  The Lines.java file reads a file based on a given path and reads it line by line, this code is heavily borrowed from my notes of previous classes.  The Bloom Filter class uses 8 hash functions to store bits into a Bit Array.  The Bit Array class is actually an array of ints represented in binary since according to our professor, a Java bool array would not be as efficient, but I think it was just to give us extra work with bitwise operations.  To compile and run:

```
javac Driver.java
java Driver <vocabulary> <target to be checked>
```

It assumes that each line of each file contains only one word.  The Bloom Filter class has an option to print a visual representation of the bit array which looks pretty cool and can give insight about how sparse/dense the bits are within the arrays.  The calculations at the end only work for the 850 words of Basic English, so ignore them when using it for other stuff.
