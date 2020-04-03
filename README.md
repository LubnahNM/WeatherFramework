# Weather Framework

----

## Specifications
### Notes from the Product Owner (Paraphrased)
- Build a framework for a tester to use.
- It should:
    - take a URL.
    - make an API call.
    - return a JSON object.
    - make that object into a POJO.
    - run tests on the POJO.
- The API key should be in a separate file that should not be pushed to GitHub.
- It should follow the Service Object Model:
    - DTO
    - ConnectionManager
    - Injector
- There should be a Trello board with user stories.
- There should be a ReadMe and a sprint log (for the one sprint) on GitHub.
- Planning should occur.
- A UML diagram should exist.
- There will be a presentation.

----

## Guide
### How to Download, Install and Use the Project
- Clone this repository using:
    ```
    git clone https://github.com/LubnahNM/WeatherFramework.git"
    ```
- Open the project using your IDE of choice.
- Get an access token from Open Weather.
- Paste your token into "token.properties" located at "WeatherFramework/src/test/resources"
- Create a new RequestHandler object, passing in the properties you wish to query:
    ```java
    String s = "weather?q=London,uk";
    RequestHandler requestHandler = new RequestHandler(s);
    ```
- If your query will return a single result:
    - Make a new weatherDTO object:
    ```java
    WeatherDTO weatherDTO;
    ```
    - Call the createResult method and catch it with your new object:
    ```java
    weatherDTO = requestHandler.createResult();
    ```
    - Access the information with your new object:
    ```java
    weatherDTO.getCoord().getLon();
    ```
- If your query will return multiple results:
    - Make a new multiWeatherDTO object:
    ```java
    MultiWeatherDTO multiWeatherDTO;
    ```
    - Call the createMultiResult method and catch it with your new object:
    ```java
    multiWeatherDTO = requestHandler.createMultiResult();
    ```
    - Access the information with your new object:
    ```java
    weatherDTO.getCalctime();
    ```
- If you want to update your query, call the updateQuery method on the RequestHandler object:
    ```java
    requestHandler.updateQuery("weather?q=Paris,France);
    ```
    - Assign a weatherDTO object or a multiWeatherDTO object accordingly:
    ```java
    weatherDTO = requestHandler.createResult();
    ```

----

## Dependencies
- Jackson
- JUnit

----

## Contributors
### List of Shiny, Happy Sparta Friends
- Alonso
- Colette
- James
- Lubnah
- Philip
- Sebastian 
- Tolga

----

![Blatant sucking up, courtesy of Philip.](https://img.redbull.com/images/c_fill,g_auto,w_1030,h_687/q_auto,f_auto/redbullcom/2013/12/06/1331623503485_3/baneling-gg)
