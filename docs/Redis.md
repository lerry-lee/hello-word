# Redis

Redis基础

# 概述

Redis 是 C 语言开发的一个开源的高性能键值对（key-value）的内存数据库，可以用作数据库、缓存、消息中间件等。

它是一种 NoSQL（not-only sql，泛指非关系型数据库）的数据库。

- 性能优秀，数据在内存中，读写速度非常快，支持并发 10W QPS。

- 单进程单线程，是线程安全的，采用 IO 多路复用机制。

- 丰富的数据类型，支持字符串（strings）、散列（hashes）、列表（lists）、集合（sets）、有序集合（sorted sets）等。

- 支持数据持久化。

- 可以将内存中数据保存在磁盘中，重启时加载。

- 主从复制，哨兵，高可用。

- 可以用作分布式锁。

- 可以作为消息中间件使用，支持发布订阅。

# redisObject

redisObject 是 Redis 类型系统的核心, 数据库中的每个键、值, 以及 Redis 本身处理的参数, 都表示为这种数据类型.

```C
/*
 * Redis 对象
 */
typedef struct redisObject {

    // 类型
    unsigned type:4;

    // 对齐位
    unsigned notused:2;

    // 编码方式
    unsigned encoding:4;

    // LRU 时间（相对于 server.lruclock）
    unsigned lru:22;

    // 引用计数
    int refcount;

    // 指向对象的值
    void *ptr;

} robj;
```

**type、 encoding 和 ptr 是最重要的三个属性.**

type 记录了对象所保存的值的类型, 它的值可能是以下常量的其中一个.

```C
/*
 * 对象类型
 */
#define REDIS_STRING 0  // 字符串
#define REDIS_LIST 1    // 列表
#define REDIS_SET 2     // 集合
#define REDIS_ZSET 3    // 有序集
#define REDIS_HASH 4    // 哈希表
```

encoding 记录了对象所保存的值的编码, 它的值可能是以下常量的其中一个.

```C
/*
 * 对象编码
 */
#define REDIS_ENCODING_RAW 0            // 编码为字符串
#define REDIS_ENCODING_INT 1            // 编码为整数
#define REDIS_ENCODING_HT 2             // 编码为哈希表
#define REDIS_ENCODING_ZIPMAP 3         // 编码为 zipmap
#define REDIS_ENCODING_LINKEDLIST 4     // 编码为双端链表
#define REDIS_ENCODING_ZIPLIST 5        // 编码为压缩列表
#define REDIS_ENCODING_INTSET 6         // 编码为整数集合
#define REDIS_ENCODING_SKIPLIST 7       // 编码为跳跃表
```

ptr 是一个指针, 指向实际保存值的数据结构, 这个数据结构由 type 属性和 encoding 属性决定.

举个例子, 如果一个 redisObject 的 type 属性为 REDIS_LIST, encoding 属性为 REDIS_ENCODING_LINKEDLIST, 那么这个对象就是一个 Redis 列表, 它的值保存在一个双端链表内, 而 ptr 指针就指向这个双端链表;

另一方面, 如果一个 redisObject 的 type 属性为 REDIS_HASH, encoding 属性为 REDIS_ENCODING_ZIPMAP, 那么这个对象就是一个 Redis 哈希表, 它的值保存在一个 zipmap 里, 而 ptr 指针就指向这个 zipmap.

下图展示了 redisObject 、Redis 所有数据类型、以及 Redis 所有编码方式（底层实现）三者之间的关系:

![img.png](Redis/redisObject数据类型和编码方式.png)

# 常见数据类型

1. String 是 Redis 最基本的类型，可以理解成与 Memcached一模一样的类型，一个 Key 对应一个 Value。Value 不仅是 String，也可以是数字。
   String 类型是二进制安全的，意思是 Redis 的 String 类型可以包含任何数据，比如 jpg 图片或者序列化的对象。String 类型的值最大能存储 512M。
   
2. Hash是一个键值（key-value）的集合。Redis 的 Hash 是一个 String 的 Key 和 Value 的映射表，Hash 特别适合存储对象。常用命令：hget，hset，hgetall 等。

3. List 列表是简单的字符串列表，按照插入顺序排序。可以添加一个元素到列表的头部（左边）或者尾部（右边） 常用命令：lpush、rpush、lpop、rpop、lrange（获取列表片段）等。
   应用场景：List 应用场景非常多，也是 Redis 最重要的数据结构之一，比如 Twitter 的关注列表，粉丝列表都可以用 List 结构来实现。
   数据结构：List 就是链表，可以用来当消息队列用。Redis 提供了 List 的 Push 和 Pop 操作，还提供了操作某一段的 API，可以直接查询或者删除某一段的元素。
   
4. Set 是 String 类型的无序集合。集合是通过 hashtable 实现的。Set 中的元素是没有顺序的，而且是没有重复的。常用命令：sdd、spop、smembers、sunion 等。

5. Zset 和 Set 一样是 String 类型元素的集合，且不允许重复的元素。常用命令：zadd、zrange、zrem、zcard 等。
   实现方式：Redis Sorted Set 的内部使用 HashMap 和跳跃表（skipList）来保证数据的存储和有序，HashMap 里放的是成员到 Score 的映射。 
   而跳跃表里存放的是所有的成员，排序依据是 HashMap 里存的 Score，使用跳跃表的结构可以获得比较高的查找效率，并且在实现上比较简单。

数据类型应用场景总结:

![img.png](Redis/数据类型应用场景总结.png)
