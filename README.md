# events-app
Events app assignment (Spring boot, ReactJS)


TEST:
 
The following consists of two parts. Part 1 is mandatory, Part 2 should be completed if you are happy with Part 1 and you feel you have time to complete Part 2.
 
Part 1)
Using any Java technology / frameworks you wish, connect to the EventFul.com API and retrieve event data for London.
Below is an example of a query that pulls back music events for London
http://eventful.com/events?q=music&l=London
Events should be displayed in a Web page, sorted by Categories and Dates.
Pick as many or few categories / dates as you wish.
The front end should be easily readable, functional and clear but we are not expecting a finished and polished front end experience.
 
Part 2)
Locate any free weather API from the Internet. Integrate this into your code such that you are able to display the weather for the events you are displaying from part 1.
The weather should be as close to the start of the event as the weather data allows. If you are unable to locate any weather API, consider mocking a service to provide the data you require.

Your code should be as clean as practical, use standard patterns where appropriate and be well tested.
The application should be able to reasonably handle the eventful API being unavailable and other errors that may occur (bad data, etc.).
You should assume that your application will be a success with the general public and as such you may want to consider how it might scale in the future and how you might handle any issues.
You may use any IDE you wish but the resulting code should be able to be built with Maven.
As stated earlier you can use any libraries/frameworks you wish as long as you can explain the reasoning behind them.


http://eventful.com/events?q=music&l=London

eventtestlondon@mailinator.com

API documentation http://api.eventful.com/docs/events/search

Application key jW4gNrLwvg7z7Rh6.

Search by location http://api.eventful.com/json/events/search?app_key=jW4gNrLwvg7z7Rh6&location=London

List of categories http://api.eventful.com/json/categories/list?app_key=jW4gNrLwvg7z7Rh6

List by location and various categories http://api.eventful.com/json/events/search?app_key=jW4gNrLwvg7z7Rh6&location=London&categories=music,sports

