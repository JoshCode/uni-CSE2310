We have a path graph where every node has a certain weight. We want to select nodes such that there is at most a gap of 2 between selected nodes, while minimizing the total weight.

Now recover the solution of a given optimal value and an array containing the memoization values of the following problem:

```
7
1 18 18 1 18 18 1
```

The optimal value and memoization values are:

```
3
mem: [0, 1, 18, 18, 2, 20, 20, 3]
```

We expect the following solution:

```
[1, 4, 7]
```