解题链接：http://blog.csdn.net/weishengmingerfendou/article/details/47094347
题目链接：http://acm.nyist.net/JudgeOnline/problem.php?pid=1218

分析：

因为人的排的顺序不一样， 最后的结果也不一样；题上说为让的到最多肉松的人得到的最少，所以很明显就是贪心， 而这道题贪心的目的就是得到一个最优的排序。  这就需要我们找到一个排序的比较函数。

假设对于A,B两人以前的顺序已经排好， 现在的问题就是A, B的顺序。 设前面所有人左手乘积为t; 如果A在前，A得到的肉松饼的个数为 t/a2,  B的到的个数为(t*a1)/b2； 如果B在前, 那么A的到的就是（t*b1)/a2, B得到的个数就是t/b2;

现在的目标就让两者的最大值去最小； 现在我们发现t是对结果没影响的。 所以显而易见就是对a1/b2  和 b1/a2 求最小。  如果我们让A排在B前面， 那么就是a1/b2 < b1/a2, 化简就是a1*a2 < b1*b2 , 所以我们就的到了排序的比较函数。

下面就高精度的问题了， 这是我第一次写这样高精度的题， 写个模板，方便用。也是为了纪念一下。