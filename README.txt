# Beer Diary
##### Daniel ruffing, Elijah Pena, Alex Eaton

## Features 
### Explore Tab
* Type in a beer's name or brand and add it to your collection!
* Filter by type of beer (IPA, Wheat, Lagers, etc.)
### Add Tab
* Add your own personal beer to your collection
* Rate it
* Describe the flavor
### Collection Tab
* Look back at your consumed beers
* Keep track of how many you've had 😉
* Sort by rating or name
## Difficulties and Challenges
When the idea of Beer Diary came to us, we had the hopes of using the RateBeer API which is a community sourced collection of beers that users rate and share with others. This would have allowed us to share reviews and filter by the best beers voted on by the community... Sadly the API is closed and we never heard back from the developer. We instead had to use the OpenFoodFacts API which doesn't just house beer, it houses all foods. There is no moderation for submitted foods and beverages so the beer category is filled with things like beer brats and nutella. Also if you search for something and not enough results come back it will disregard your categorical preference for beer and instead throw results from every category.

While we wanted to add the ability to sort by date you last consumed a certain beer, we quickly found out that MySQL has no easy way of storing dates. There is also no good way of storing byte information, so images not hosted on the internet represented a serious challenge. 
## What We Would Change
* Different API or create our own
* Scrape a website to get images and information
* Better UI
