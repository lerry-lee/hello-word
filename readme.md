# hello world!

Java重点知识学习，包括但不限于并发和多线程、设计模式、内存模型、垃圾回收...

# 学习进度

## 设计模式

### 面向对象设计原则

对于面向对象软件系统的设计而言，在支持可维护性的同时，提高系统的可复用性是一个至关重要的问题，如何同时提高一个软件系统的可维护性和可复用性是面向对象设计需要解决的核心问题之一。在面向对象设计中，可维护性的复用是以设计原则为基础的。每一个原则都蕴含一些面向对象设计的思想，可以从不同的角度提升一个软件结构的设计水平。  

面向对象设计原则为支持可维护性复用而诞生，这些原则蕴含在很多设计模式中，它们是从许多设计方案中总结出的指导性原则。  

最常见的7种面向对象设计原则如下表所示：

| 设计原则名称 | 定义 |
| - | - |
| [单一职责原则(Single Responsibility Principle, SRP)](docs/设计模式/面向对象设计原则/单一职责原则.md) | 一个类只负责一个功能领域中的相应职责 |
| [开闭原则(Open-Closed Principle, OCP)](docs/设计模式/面向对象设计原则/开闭原则.md) | 软件实体应对扩展开放，而对修改关闭 |
| [里氏代换原则(Liskov Substitution Principle, LSP)](docs/设计模式/面向对象设计原则/里氏代换原则.md)(Open-Closed Principle, OCP) | 所有引用基类对象的地方能够透明地使用其子类的对象 |
| [依赖倒转原则(Dependence  Inversion Principle, DIP)](docs/设计模式/面向对象设计原则/依赖倒转原则.md)(Open-Closed Principle, OCP) | 抽象不应该依赖于细节，细节应该依赖于抽象 |
| [接口隔离原则(Interface Segregation Principle, ISP)](docs/设计模式/面向对象设计原则/接口隔离原则.md)(Open-Closed Principle, OCP) | 使用多个专门的接口，而不使用单一的总接口 |
| [合成复用原则(Composite Reuse Principle, CRP)](docs/设计模式/面向对象设计原则/合成复用原则.md)(Open-Closed Principle, OCP) | 尽量使用对象组合，而不是继承来达到复用的目的 |
| [迪米特法则(Law of Demeter, LoD)](docs/设计模式/面向对象设计原则/迪米特原则.md)(Open-Closed Principle, OCP) | 一个软件实体应当尽可能少地与其他实体发生相互作用 |

### 创建型模式

#### [单例模式](docs/设计模式/创建型/单例模式.md)

#### [简单工厂模式](docs/设计模式/创建型/简单工厂模式.md)

#### [工厂方法模式](docs/设计模式/创建型/工厂方法模式.md)

#### [抽象工厂模式](docs/设计模式/创建型/抽象工厂模式.md)

### 行为型模式

#### [状态模式](docs/设计模式/行为型/状态模式.md)

### 结构型模式

#### [适配器模式](docs/设计模式/结构型/适配器模式.md)

#### [代理模式](docs/设计模式/结构型/代理模式.md)

## 并发和多线程

### [synchronized解析](docs/并发和多线程/synchronized解析.md)