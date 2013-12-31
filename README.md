# (Java) World Beer Tour Client
Allows interaction with the World Beer Tour Service hosted at ocwbt.com

## Installation


## Usage
Simply provide a Client with with your keys, then ask for the data you want:

    Client client = new Client(apiKey, secretKey);
    client.getBeer(beerId);                     // get a single beer
    client.getBeers();                          // get a list of beers
    client.getLocation(locationId);             // get a single location
    client.getLocationBeers(locationId);        // get a list of beers at a specific location
    client.getLocations();                      // get a list of locations
    client.getLocationsBeers();                 // get a list of beers for all locations
    client.getMiniTour(miniTourId);             // get a single minitour
    client.getMiniTours();                      // get a list of minitours
    client.getUser(userId);                     // get a single user
    client.getUserBeer(userId, userBeerId);     // get a single user beer
    client.getUserBeers(userId);                // get a list of user beers
    client.getUserTours(userId);                // get a list of user tours

Responses from list endpoints are wrapped in a `ListResponse` object, which allows you to iterate through pages:

    ListConfig cfg = new ListConfig();
    cfg.setPage(1);
    do {
        ListResponse<Beer> response = client.getBeers(cfg);

        // work with each beer here

        cfg.setPage(response.getPage() + 1);
    } while (response.morePages());