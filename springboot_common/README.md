**异常处理**   
异常处理，能减少代码的重复度和复杂度，有利于代码的维护，并且能快速定位到 Bug，大大提高我们的效率。   
全局异常处理方式一:   
1.自定义全局异常类
```java
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String exceptionHandler(Exception e) {
        System.out.println("全局异常捕获>>:" + e);
        return "全局异常捕获，错误原因>>" + e.getMessage();
    }
}
```   
2.手动抛出异常
```java
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping
    public String testErrorPage() {
        // 手动抛出异常
        int i = 3 / 0;
        return "Hello Spring Boot World!";
    }
}
```
3.测试打印   

4.说明   
@ControllerAdvice：指开启了全局异常的捕获。类上。   
@ExceptionHandler：指定义捕获异常的类型。方法上。   
该方式在很多情况下，不够人性化，不符合我们的要求。   
   
全局异常处理方式二：   
1.定义基础接口类 		BaseErrorInfoInterface，提供接口方法   
2.定义枚举类			ExceptionEnum，作为1的实现类，提供各错误定义   
3.自定义异常类		BizException，提供自定义业务异常，嵌入1   
4.自定义数据传输		ResultResponse，提供数据传输，嵌入1，2   
5.自定义全局异常处理	GlobalExceptionHanlder，开启全局异常处理，提供异常处理方法   
6.测试代码   
说明：   
后续新增异常处理，只需要2步   
1）ExceptionEnum 新增错误定义，可忽略，复用错误定义   
2）GlobalExceptionHandler 新增异常处理方法   
