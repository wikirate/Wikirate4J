# Wikirate4J

Wikirate4J is a Java library for the [Wikirate API](https://wikirate.org/Use_the_API) licensed under GNU GPL v3.

Detail documentation of this library can be found [here](https://wikirate.github.io/Wikirate4J/)

[![wikirate](https://img.shields.io/twitter/follow/wikirate?style=social)](https://twitter.com/wikirate)

## Declaring dependency to Wikirate4J

Maven

*Step 1: Add the JitPack repository to your build file*

```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

*Step 2: Add the dependency*

```
<dependency>
    <groupId>com.github.wikirate</groupId>
	<artifactId>wikirate4j</artifactId>
	<version>1.0.0</version>
</dependency>
```

### Getting Started

If you are new using Wikirate4J, this is the place to begin. The main goal of this short tutorial is to get you started
with Wikirate4J. We will not go into too much detail here but we will present some basics.

#### Hello Wikirate4J

Wikirate4J makes it trivial to interact with Wikirate4J API 

####

```java
import org.wikirate4j.*;

public class Main {
    
  public static void main(String... args){
      // creates an instance of wikirate's client with the given api key
      WikirateClient client = new WikirateClientImpl.Builder()
              .api_key("your_api_key")
              .build();
      
      // requesting to get details about a specific Wikirate company based on its name
      // Wikirate4J models the response into a Company object
      Company company = client.getCompany("Adidas AG");
      
      // prints company's details
      System.out.println(company.toString());
      
      // get raw json response
      System.out.println(company.raw_json());
  }
  
}
```


#### WikirateClient

The `WikirateClient` class provides access to almost the entire Wikirate RESTful API methods.

### Contributing

Bug reports, feature suggestions requests are welcome on GitHub at https://github.com/wikirate/Wikirate4J/issues.

### License

The library is available as Open Source under the terms of
the [GNU General Public License v3 (GPLv3)](https://www.gnu.org/licenses/gpl-3.0.txt).
