# Beyond Java 8

Very briefly capturing some of new/ update in API that were introduced after Java 8 that 
may come handy for dev folks while programming.



## Java 9

### 1. Factory method for collections

A convenient factory method is introduced in the different collections
class like Map, List, set that let us create immutable
collection object with ease.

Map:
```java
Map myMap = Map.of("K1", "Some val for K",
                "G1", "Some val for G1");
```
By above method you can add atmost 10 entries. To create a
immutable map with more than 10 entries, the below method can be used.
```java
import static java.util.Map.entry;
import static java.util.Map.ofEntries;

Map bigMap = ofEntries(
        entry("one","asd"),
        entry("two","asd"),
        entry("three","asd"),
        entry("four","asd"),
        entry("five","asd"),
        entry("six","asd"),
        entry("seven","asd"),
        entry("eight","asd"),
        entry("nine","asd"),
        entry("ten","asd"),
        entry("eleven","asd")
        ); 
```
Similarly, List and set to have these factory methods as below.

List:
```java
List mylist = List.of("Debian", "George", "cloney");
```

Set:

```java
Set mylist = Set.of("Debian", "George", "cloney");
```
#### Note:
1. Returns an immutable object.(ie) you can't add or remove element.
2. Does not accept null as argument.
3. Set throws exception on duplicate value.


### 2. Improvement in Try catch with resource

From java 9, we dont have to necesarly declare the resource variable
inside the try with resource block. any reference of Final closable reference can be passed
as below.

```java
 MockClosableResource closableResource = new MockClosableResource();
 try (closableResource) {

 } catch (IOException e) {
    e.printStackTrace();
 }
 Assertions.assertTrue(closableResource.isClosed);

```

__Key point__:
* The resource variable should be final or effectively final
* if wish to pass mutiple varaible seperate them by `;`

## Java 10:

### 1. Type inference with var
Var keyword allow local varaible type inference. For Example

```java
var myMap = new HashMap<String, String>();
```

Note:
 * Can only be used for local varaible.
 * Once declared can't override the type. Else will result in compilation error. For example,

```java
var someNum = 10;
someNum = "asda"; // Compilation error
```
* the value for `var` variable should be assigned during declaration itself. You cant do something like below.

```java
var someText;
someText = ""; //Compilation error
```

## Java 14:

### 1. Switch expression
In java 13, the verbose switch statement is replaced with 
enhanced switch experession

```java
private void printHeroDescription(String name) {
        switch (name) {
            case "Supes":
                System.out.println("Man of steel");
                break;
            case "Batsy":
                System.out.println("A great detective");
                break;
            case "WonderWoman":
                System.out.println("Demi goddes");
                break;
            case "Flash":
            case "QuickSilver":
                System.out.println("Run fast");
                break;
            default:
                System.out.println(name);
                break;
        }
    }
```
The above code can be replaced with below
```java

private void printHeroDescription(String name) {
    switch(name) {
            case "Supes" -> System.out.println("Man of steel");
            case "Batsy" -> System.out.println("A great detective");
            case "WonderWoman" -> System.out.println("Demi goddess");
            case "Flash", "QuickSilver" -> System.out.println("Run fast");
            default -> System.out.println(name);
        }
}        
```
* Switch has a fallback mechanism in which the control flow continues
to next case until it encounter a break statement. Though it is not evil by itself , it causes
a lot of problem if not careful.
* switch expression eliminates the need for break statement.
* Two or more case with similar body can be combined in single case expression (eg: flash and quick silver)
* If the case body have more than one line, it can be wrapped in curly braces.
* The switch expression can be extended even more. __It can return a value__. For example the above method can be
rewritten as below

```java
private void printHeroDescription(String name) {
        String heroDesc = switch (name) {
            case "Supes" -> "Man of steel";
            case "Batsy" -> "A great detective";
            case "WonderWoman" -> "Demi goddess";
            case "Flash", "QuickSilver" -> "Runs fast";
            default -> "Not available right now";
        };
        System.out.println(heroDesc);
    }
```
* However, while doing as above, what if the case body is more than one line. 
Somehow we need to indicate a value need to be returned.
The return cannot be used as it might create ambuguity in case we are returning 
the switch expression itself in the method. Instead __yield__ is used.
* Also in case of using an enum as the selector for switch case and if we define 
case for all possible of enum, then we dont need to provide default case!!!
* IDE can help a lot in converting existing switch to enhanced switch expression.

## Java 15:

### 1. Text block
Text block were introduced in order to declare string that span multiple line.
The Text block can be created by putting string under thriple quates as below.
```java
   String bigBlockWithNewLine = """
                You're not brave... "men are brave".
                You say that you want to help people, but you can't feel their pain... their mortality...
                It's time you learn what it means to be a man.
                """;
```
__Key things:__
* Text block is again a string instance.
* The goal of text block is to enable us to declare string with multiple line with minimal escape squeance 
and improve code readability.
* The trailing space in each line is removed automatically. If wish to preserve it use `\s`
* To prevent the text going to new line then use `\`

```java
    String bigBlockWithNewLine = """
                I'm older now than my father ever was. \
                This may be the only thing I do that matters\
                """;
    var expected = "I'm older now than my father ever was. This may be the only thing I do that matters";
    assertEquals(expected, bigBlockWithNewLine);
```
* String interpolation is not supported in text block as of now.


### Java 16:

## 1. Pattern matching with instance of

An enhancement brought to get rid of instanceof-and cast idiom that we usually do in java like below.
```java
    void hadleVal(Obj someVal){
        if(someVal instanceof String) {
            String s = (String) someVal;
            //Do some stuff...
        }
    }   
```
Instead, we can do something like below.
```java
void hadleVal(Obj someVal){
        if(someVal instanceof String s) {
            //Do some stuff with variable s...
        }
    }   
```
Here when the predicate `someVal instanceof String` passes, then it also
converts the `someVal` variable to String and store it in `s`

Key point:

* You can chain your condition to do something like this.
```java
    if(someVal instanceof String s && s.length()>5) {
    
     }
```
* But you can't do OR condition as below. Because the resultant variable
will be accessible only if the predicate get pass.
```java
    if(someVal instanceof String s || s.length()>5) { //Compilation error
    
     }
```
