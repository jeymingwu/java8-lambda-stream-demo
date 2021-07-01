# java8-lambda-stream-demo

# Lambda 表达式

## Lambda 基础
### 1. Lambda 表达式概括

+ Java Lambda 表达式：Java 8 新特性；也称匿名函数，是一种**未绑定标识符的函数定义**；
    + Lambda 是一个函数，但不需要明明；
    + 匿名函数：Java 8 之前通过匿名内部类来实现；Java 8 之后可以使用 Lambda 表达式实现；
    
+ 出现的原因：为适应多核 CPU 的使用，方便高效的并发程序，通过简单的修改就能编写复杂集合处理算法；
  
+ Lambda 的优点：
    + 优化代码，使代码更加紧凑；（省去冗余代码减轻代码量，增加代码可读性）
    + 并行处理，更好地支持多核处理；（可方便地并行操作大集合，充分发挥多核 CPU 的潜能）
    + 改善集合操作；（Java 8 引入 Stream API，方便大数据处理）

### 2. Lambda 表达式语法

+ 基本语法：```参数 -> 具体实现```
    + 输入的参数
    + Lambda 表达式运算符：```->``
    + 函数主体：具体实现
    + 总结：一段带输入参数的可执行语句块；
    
+ Lambda 表达式的特点：
    + 可选类型声明：不需声明参数类型，编译器自动识别参数类型和参数值；
    + 可选的参数圆括号：一个参数可以不需定义圆括号，但多个参数需要；
    + 可选的大括号：若函数主体只包含一个语句，则可以不需要使用大括号；
    + 可选的返回关键字：若函数主体只有一个表达式返回值则编译器会自动返回值，大括号需要指明表达式返回了一个数值；
    
+ Lambda 表达式的五种形式：
  + 不包含参数：```Runnable noArguments = () -> System.out.println("hello world");```
  + 有且只有一个参数：```ActionListener oneArguments = event -> System.out.println("hello world");```
  + 有多个参数：```BinaryOperator<Long> add = (x, y) -> x + y;```
  + 表达式主体是一个代码块：```Runnable noArguments = () -> { System.out.println("hello"); System.out.println("world");};```
  + 显式声明参数类型：```BinaryOperator<Long> add = (Long x, Long y) -> x + y;``
    
+ Lambda 表达式参数类型由上下文推断：
    + 赋值上下文；
    + 方法调用上下文；
    + 类型转换上下文；

### 3. Lambda 变量和作用域

+ 访问局部变量：
    + 可直接在 Lambda 表达式中访问外层的局部变量；（但局部变量必须是常量，可不用 final 修饰，但必须是只能赋值一次）
    + Lambda 表达式中被访问外层的局部变量不可以被更改；（解析同上）
    + Lambda 表达式中不允许声明一个与局部变量同名的参数或者局部变量；
  
+ 访问对象字段与静态变量：对实例的字段和静态变量既可读又可写；

+ 总结：可读写实例变量，只能读取局部变量；
  + 实例变量与局部变量的实现不同：实例变量存储在堆中，局部变量存储在栈上；若线程需直接访问一个非 final 的局部变量，那么在该线程执行的时候可能该局部变量已经被销毁；
  + 局部变量的访问限制为了使 Java 可以做到并行处理；（命令式编程模式 -> 函数式编程模式）

### 4. Lambda 表达式的引用

+ Lambda 表达式引用：Lambda 表达式一种快捷写法；实现比较简单、复用地方不多的时候推介使用； 
  
+ Lambda 表达式的引用两大类：
    + 方法引用：```类名::方法名```
    + 构造器引用：```类名::new```

+ Lambda 表达式引用语法格式：
    + 静态方法引用：调用类的静态方法；
      + 特点：
        1. 被引用的参数列表和接口中的方法参数一致；
        2. 接口方法没有返回值，引用方法可有可无；
        3. 接口方法有返回值，引用方法必须有相同类型的返回值；
      + [静态方法引用 Demo](./src/main/java/com/example/lambda/ref/static/FinderMain.java)
      
    + 参数方法引用：调用类的普通方法；[Demo](./src/main/java/com/example/lambda/ref/parametric/FinderMain.java)
    + 实例方法引用：调用实例的方法；[Demo](./src/main/java/com/example/lambda/ref/instance/InstanceMain.java)
    + 构造器引用：引用一个类的构造函数；[Demo](./src/main/java/com/example/lambda/ref/constructor/ConstructorMain.java)
  
### 5. Lambda 表达式与匿名函数

| 区别 | Lambda 表达式 | 匿名内部类 |
|:---:|:---:|:---:|
| 无标识性 | 计算结果有可能有唯一标识 | 确保创建一个拥有唯一表示的对象 |
| 作用域规则 | 无法继承父类 | 可继承父类属性，规则较 Lambda 表达式复杂 |
| 是否一个完全的类 | 不是 | 是，编译出单独的 class 文件 |

[Lambda 表达式与匿名函数比较 Demo](./src/main/java/com/example/lambda/function/TestLambdaAndInnerClass.java)

### 6. 函数式接口

+ 函数式接口：有且只有一个抽象方法，但可有多个非抽象方法的接口，抽象方法可被隐式1转换成 Lambda 表达式；
    + 函数式接口 ——> Lambda 表达式的类型；
    + 函数式接口，单一方法的命名并不重要，重要的是**方法签名** 和 Lambda 表达式的类型匹配；
+ 特点：
  1. 接口有且仅有一个抽象方法；
  2. 允许定义静态方法；
  3. 允许定义默认方法；
  4. 允许 java.lang.Object 中 public 的方法；
  5. 推介使用 @FunctionInterface 注解；
+ JDK 8 之后新增了一个函数接口包 ```java.util.function``` ，这里面包含了常用的一些函数接口：
| 接口 | 参数 | 返回类型 | 说明 |
|:---:|:---:|:---:|:---:|
| Predicate | T | boolean |	接受一个输入参数 T，返回一个布尔值结果 |
| Supplier | None | T | 无参数，返回一个结果，结果类型为 T |
| Consumer | T | void | 代表了接受一个输入参数 T 并且无返回的操作 |
| Function<T,R> | T | R | 接受一个输入参数 T，返回一个结果 R |
| UnaryOperator | T | T	| 接受一个参数为类型 T,返回值类型也为 T |
| BinaryOperator | (T，T) | T | 代表了一个作用于于两个同类型操作符的操作，并且返回了操作符同类型的结果 |

#### Predicate 接口

条件判断并返回一个 Boolean 值，其包含一个抽象方法（test）、常见的三种逻辑关系：与（and）、或（or）、非（negate）的默认方法和 isEqual 方法；

[Predicate 接口 Demo](./src/main/java/com/example/lambda/function/TestFunctionInPredicate.java)

> 总结：条件判断，类似 if 语句中的判断条件，配合 Lambda 表达式使用更加灵活，使判断条件根据业务情况可增可减；

参考：[Java 8 Predicate类基本使用详解](https://blog.csdn.net/qazzwx/article/details/107864622)

#### Supplier 接口

获取一个泛型参数指定类型的对象数据（产生一个数据），可理解为工厂类创建对象；

[Supplier 接口 Demo](./src/main/java/com/example/lambda/function/TestFunctionInSupplier.java)

> 总结：创建对象，类似工厂类；

#### Consumer 接口

与 Supplier 接口相反，Consumer 接口用于消费一个数据；

[Consumer 接口 Demo](./src/main/java/com/example/lambda/function/TestFunctionInConsumer.java)

> 总结：处理对象，加工对象；

参考：[Java 8 | Consumer Interface in Java with Examples](https://www.geeksforgeeks.org/java-8-consumer-interface-in-java-with-examples/)

#### Function<T, R> 接口 

根据一个类型的数据得到另一个类型的数据，根据输入得到输出；

[Function 接口 Demo](./src/main/java/com/example/lambda/function/TestFunctionInFunction.java)

> 总结：可指定入参和出参类型；

#### UnaryOperator 接口

功能接口，扩展 ```java.util.function.Function``` 接口；UnaryOperator 表示一个操作，接受一个参数并返回与其相同类型的结果；

[UnaryOperator 接口 Demo](./src/main/java/com/example/lambda/function/TestFunctionInUnaryOperator.java)

> 总结：与 Function 接口差不多，只是入参和出参的类型一致；

#### BinaryOperator 接口


## Lambda 应用