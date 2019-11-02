# codeCount
统计 文件夹下某个文件的代码行数
总行数 = code + coment + blank;


## code
1. /*  */ code
2. code


## coment
1. /*  打头  */结尾 在同一行 
2. /*  打头  */结尾 不在同一行              设置为待结束状态
3. // 打头                                


### 特殊情况
1.
```java
    /**
     * adsda
     * 
   sadsadsa  */ int a; // asdsada

    /**
     * adsda
     * 
   sadsadsa  */ // asdsada

// 

/*

    */
```
2.
```java
    int a; // coment
```
3.
```java
    /* */ // aa
```
(特殊情况 /* */ //a 在同一行)


## blank
""

多个文件分开统计最后汇总

分而治之 使用   ForkJoinPool 和 RecursiveTask 分化



1. 读取文件夹
2. 创建多个线程 分别读取文件 
    并每个文件对应一个 JugeCode(保存当前文件行数信息)