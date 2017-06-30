# DataStructuresAlgorithms

<p>This repository contains code and unit tests for a few algorithms I have implemented
either as challenges or to study them.
Those annotated with (Self) I have implemented myself. The others I have fetched the solution 
on the Internet and then debugged it to learn it better.
</p>

<b>Network.java (Self)</b><br/>
<p>
We have a set of elements. In this example I will use eight.
1 2 3 4 5 6 7 8
We can make a set of connections. For example we can connect 1 to 6.
1 2 3 4 5 
|
6 7 8

We can make any number of connections and any two elements can be connected. Let’s make the following connections: 1-2, 6-2, 2-4, 5-8

Now we need to be able to determine if two elements are connected, either directly or through a series of connections. 1 and 6 are connected, as are 6 and 4. But 7 and 4 are not connected, neither are 5 and 6. We do not care about the path, 1 and 2 are connected both directly and also through 6, but for this problem the fact that there are two paths is irrelevant.
</p>

<b>SmallestIntegerNotOnList</b><br/>
<p>You receive an array of positive integers. You need to return what's the smallest
existing integer positive number that is not on the list.
For instance, if the input array is: [0, 1, 3, 6] then the answer is 2
if the input array is [2, 6, 64] then the answer is 0</p>

<b>TwoElementsInArraySumEqualsToX</b><br/>
<p>given an array A[] of n numbers and another number x, determines whether or not there exist two elements in S whose sum is exactly x.</p>

<b>FindSmallestWindowInStringWithAllCharsFromOtherString</b>
<p>Given two strings string1 and string2, find the smallest substring in string1 containing all characters of string2 efficiently.
For Example:

Input :  string = "this is a test string"
         pattern = "tist"
Output :  Minimum window is "t stri"
Explanation: "t stri" contains all the characters
              of pattern.
              </p>

