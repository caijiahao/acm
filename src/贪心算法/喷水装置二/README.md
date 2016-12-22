
登录 | 注册
风雨程序路
一个小小的Acmer的刷题记录
 目录视图 摘要视图 订阅
 nyoj_12 喷水装置（二）
标签： acmnyoj贪心
2016-05-02 16:52 169人阅读 评论(0) 收藏 举报
 分类： 贪心算法（7）
版权声明：本文为博主原创文章，未经博主允许...请随便转载（233...）
喷水装置（二）
时间限制：3000 ms  |  内存限制：65535 KB
难度：4
描述
有一块草坪，横向长w,纵向长为h,在它的橫向中心线上不同位置处装有n(n<=10000)个点状的喷水装置，每个喷水装置i喷水的效果是让以它为中心半径为Ri的圆都被润湿。请在给出的喷水装置中选择尽量少的喷水装置，把整个草坪全部润湿。
输入
第一行输入一个正整数N表示共有n次测试数据。
每一组测试数据的第一行有三个整数n,w,h，n表示共有n个喷水装置，w表示草坪的横向长度，h表示草坪的纵向长度。
随后的n行，都有两个整数xi和ri,xi表示第i个喷水装置的的横坐标（最左边为0），ri表示该喷水装置能覆盖的圆的半径。
输出
每组测试数据输出一个正整数，表示共需要多少个喷水装置，每个输出单独占一行。
如果不存在一种能够把整个草坪湿润的方案，请输出0。
样例输入
2
2 8 6
1 1
4 5
2 10 6
4 5
6 5
样例输出
1
2
分析：
计算每个喷水装置润湿草坪的圆与草坪边界的交点（说明图见点击打开链接）
按左交点排序。
遍历所有喷水装置，从所有满足条件（左交点小于等于前一个选定装置的右交点（或起点），且右交点大于前一个选定装置的右交点（或起点））的喷水装置中选择右交点最大的，直到右交点大于终点。
代码：
[cpp] view plain copy
#include<cstdio>
#include<cmath>
#include<cstdlib>
struct Node
{
    double s,e;
}node[10005];
int cmp(const void* a,const void* b)
{
    return (*(Node*)a).s>(*(Node*)b).s?1:-1;
}
int main()
{
    int N;
    scanf("%d",&N);
    while(N--)
    {
        int n,w,h;
        scanf("%d%d%d",&n,&w,&h);
        for(int i=0;i<n;i++)
        {
            int x,r;
            scanf("%d%d",&x,&r);
            if(r<=h/2.0)//直径小于草坪宽度的直接舍弃
            {
                i--;
                n--;
                continue;
            }
            node[i].s=x-sqrt(r*r-h*h/4.0);
            node[i].e=2.0*x-node[i].s;
            if(node[i].s>=w||node[i].e<=0)//左交点大于终点的，以及右交点小于起点的直接舍弃
            {
                i--;
                n--;
                continue;
            }
        }
        qsort(node,n,sizeof(Node),cmp);
        double maxe=0;
        double last=0;
        int i;
        int sum=0;
        int ok=0;
        while(1)
        {
            maxe=0;
            ok=0;//标记此次遍历或搜索是否找到满足条件的喷水装置，如果没找到，则直接结束搜索输出0
            for(i=0;i<n;i++)
            {
                if(node[i].s<=last)
                {
                    if(node[i].e>last)
                    {
                        if(!ok)
                            sum++;
                        ok=1;
                        if(node[i].e>maxe)
                            maxe=node[i].e;
                    }
                }
                else if(ok)
                {
                    last=maxe;
                    break;
                }
            }
            if(ok)
                last=maxe;
            else
                break;
            if(last>=w)
                break;
        }
        if(ok)
            printf("%d\n",sum);
        else
            printf("0\n");
    }
    return 0;
}


顶
0

踩
0


上一篇nyoj_6 喷水装置（一）
下一篇nyoj_14 会场安排问题
我的同类文章
贪心算法（7）
•nyoj_47 过河问题2016-05-02阅读37
•nyoj_6 喷水装置（一）2016-05-02阅读113
•nyoj_106 背包问题2016-04-30阅读39
•nyoj_71 独木舟上的旅行2016-04-30阅读66
•nyoj_14 会场安排问题2016-05-02阅读39
•nyoj_218 Dinner2016-04-30阅读33
•nyoj_91 阶乘之和2016-04-30阅读53
参考知识库
img
软件测试知识库
2993关注|310收录
猜你在找
SEO搜索引擎优化教程讲解大数据培训——ELK实战Redis内存管理和优化Spark 1.x大数据平台GrowingIO田毅：Spark多数据源处理
NYOJ 12 喷水装置二贪心+区间覆盖贪心算法之喷水装置二nyoj12NYOJ12喷水装置二贪心算法nyoj 12 喷水装置二nyoj 12 喷水装置二
查看评论

  暂无评论

您还没有登录,请[登录]或[注册]
* 以上用户言论只代表其个人观点，不代表CSDN网站的观点或立场
核心技术类目
全部主题 Hadoop AWS 移动游戏 Java Android iOS Swift 智能硬件 Docker OpenStack VPN Spark ERP IE10 Eclipse CRM JavaScript 数据库 Ubuntu NFC WAP jQuery BI HTML5 Spring Apache .NET API HTML SDK IIS Fedora XML LBS Unity Splashtop UML components Windows Mobile Rails QEMU KDE Cassandra CloudStack FTC coremail OPhone  CouchBase 云计算 iOS6 Rackspace  Web App SpringSide Maemo Compuware 大数据 aptech Perl Tornado Ruby Hibernate ThinkPHP HBase Pure Solr Angular Cloud Foundry Redis Scala Django Bootstrap
个人资料
访问我的空间
F010011100000

访问：3198次
积分：512
等级：
排名：千里之外
原创：50篇转载：2篇译文：0篇评论：0条
文章搜索

 搜索
文章分类
语言入门(26)
贪心算法(8)
搜索(5)
数据结构(4)
动态规划(6)
图论(3)
文章存档
2016年05月(20)
2016年04月(32)
阅读排行
nyoj_60 谁获得了最高奖学金(319)
nyoj_12 喷水装置（二）(169)
nyoj_4 ASCII码排序(143)
nyoj_6 喷水装置（一）(113)
nyoj_96 n-1位数(106)
nyoj_42 一笔画问题(101)
nyoj_62 笨小熊(97)
nyoj_34 韩信点兵(82)
nyoj_97 兄弟郊游问题(73)
nyoj_37 回文字符串(70)
评论排行
nyoj_38 布线问题(0)
nyoj_34 韩信点兵(0)
nyoj_33 蛇形填数(0)
nyoj_31 5个数求最值(0)
nyoj_25 A Famous Music Composer(0)
nyoj_24 素数距离问题(0)
nyoj_22 素数求和问题(0)
nyoj_13 Fibonacci数(0)
nyoj_11 奇偶数分离(0)
nyoj_4 ASCII码排序(0)
推荐文章
* Android 反编译初探 应用是如何被注入广告的
* 凭兴趣求职80%会失败，为什么
* 安卓微信自动抢红包插件优化和实现
* 【游戏设计模式】之四 《游戏编程模式》全书内容提炼总结
* 带你开发一款给Apk中自动注入代码工具icodetools(完善篇)
公司简介|招贤纳士|广告服务|联系方式|版权声明|法律顾问|问题报告|合作伙伴|论坛反馈
网站客服杂志客服微博客服webmaster@csdn.net400-600-2320|北京创新乐知信息技术有限公司 版权所有|江苏知之为计算机有限公司|江苏乐知网络技术有限公司
京 ICP 证 09002463 号|Copyright © 1999-2016, CSDN.NET, All Rights Reserved GongshangLogo

