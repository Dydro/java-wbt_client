package com.dydro.wbt;

import com.dydro.wbt.resource.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by a464344 on 12/30/13.
 */
public class Client {
    private static final String API_ROOT = "http://ocwbt.com/api/v1.0";

    private String mApiKey;

    /**
     * The GSON object for serializing/deserializing
     */
    protected Gson mGson;

    /**
     * The HTTP Client that will make requests
     */
    protected HttpClient mHttpClient;

    /**
     * The JSON parser to do preliminary checks
     */
    protected JsonParser mJsonParser;

    private String mSecretKey;

    public Client(String apiKey, String secretKey) {
        // Creates the json object which will manage the information received
        GsonBuilder builder = new GsonBuilder();

        // Register an adapter to manage the date types as int values
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsInt() * 1000);
            }
        });

        mApiKey = apiKey;
        mGson = builder.create();
        mHttpClient = HttpClientBuilder.create().build();
        mJsonParser = new JsonParser();
        mSecretKey = secretKey;
    }

    /******************************************************************************************************************
     *                                                                                                                *
     *                                                    GET                                                         *
     *                                                                                                                *
     ******************************************************************************************************************/

    //================================================================================
    // /beers
    //================================================================================

    public ListResponse<Beer> getBeers() throws WBTException, IOException {
        return getBeers(new ListConfig());
    }

    public ListResponse<Beer> getBeers(ListConfig listConfig) throws WBTException, IOException {
        return getList("/beers" + listConfig, Beer.class);
    }

    //================================================================================
    // /beers/{beer_id}
    //================================================================================

    public Beer getBeer(int beerId) throws WBTException, IOException {
        return getSingle("/beers/" + beerId + "?", Beer.class);
    }

    //================================================================================
    // /locations
    //================================================================================

    public ListResponse<Location> getLocations() throws WBTException, IOException {
        return getLocations(new ListConfig());
    }

    public ListResponse<Location> getLocations(ListConfig listConfig) throws WBTException, IOException {
        return getList("/locations" + listConfig, Location.class);
    }

    //================================================================================
    // /locations/beers
    //================================================================================

    public ListResponse<LocationBeer> getLocationsBeers() throws WBTException, IOException {
        return getLocationsBeers(new ListConfig());
    }

    public ListResponse<LocationBeer> getLocationsBeers(ListConfig listConfig) throws WBTException, IOException {
        return getList("/locations/beers" + listConfig, LocationBeer.class);
    }

    //================================================================================
    // /locations/{location_id}
    //================================================================================

    public Location getLocation(int locationId) throws WBTException, IOException {
        return getSingle("/locations/" + locationId + "?", Location.class);
    }

    //================================================================================
    // /locations/{location_id}/beers
    //================================================================================

    public ListResponse<LocationBeer> getLocationBeers(int locationId) throws WBTException, IOException {
        return getLocationBeers(locationId, new ListConfig());
    }

    public ListResponse<LocationBeer> getLocationBeers(int locationId, ListConfig listConfig)
            throws WBTException, IOException {
        return getList("/locations/" + locationId + "/beers" + listConfig, LocationBeer.class);
    }

    //================================================================================
    // /minitours
    //================================================================================

    public ListResponse<MiniTour> getMiniTours() throws WBTException, IOException {
        return getMiniTours(new ListConfig());
    }

    public ListResponse<MiniTour> getMiniTours(ListConfig listConfig) throws WBTException, IOException {
        return getList("/minitours" + listConfig, MiniTour.class);
    }

    //================================================================================
    // /minitours/{minitour_id}
    //================================================================================

    public MiniTour getMiniTour(int miniTourId) throws WBTException, IOException {
        return getSingle("/minitours/" + miniTourId + "?", MiniTour.class);
    }

    //================================================================================
    // /users/login
    //================================================================================

    public User login(String emailOrCardNumber, Date birthday) throws WBTException, IOException {
        String bday = new SimpleDateFormat("yyyy-MM-dd").format(birthday);
        String login = URLEncoder.encode(emailOrCardNumber, "UTF-8");
        return getSingle("/users/login?login=" + login + "&birthday=" + bday + "&", User.class);
    }

    //================================================================================
    // /users/{user_id}
    //================================================================================

    public User getUser(int userId) throws WBTException, IOException {
        return getSingle("/users/" + userId + "?", User.class);
    }

    //================================================================================
    // /users/{user_id}/beers
    //================================================================================

    public ListResponse<UserBeer> getUserBeers(int userId) throws WBTException, IOException {
        return getUserBeers(userId, new ListConfig());
    }

    public ListResponse<UserBeer> getUserBeers(int userId, ListConfig listConfig) throws WBTException, IOException {
        return getList("/users/" + userId + "/beers" + listConfig, UserBeer.class);
    }

    //================================================================================
    // /users/{user_id}/beers/{user_beer_id}
    //================================================================================

    public UserBeer getUserBeer(int userId, int userBeerId) throws WBTException, IOException {
        return getSingle("/users/" + userId + "/beers/" + userBeerId + "?", UserBeer.class);
    }

    //================================================================================
    // /users/{user_id}/endpoints
    //================================================================================

    public List<String> getEndpoints(int userId, long since) throws WBTException, IOException {
        HttpGet get = new HttpGet(API_ROOT + sign("/users/" + userId + "/endpoints?since=" + since + "&"));
        JsonReader reader = new JsonReader(new InputStreamReader(mHttpClient.execute(get).getEntity().getContent()));
        reader.beginObject();

        // success
        reader.nextName();
        if (reader.nextBoolean()) {
            reader.nextName();
            return mGson.fromJson(reader, new TypeToken<List<String>>(){}.getType());
        } else {
            // message
            reader.nextName();
            throw new WBTException(reader.nextString());
        }
    }

    //================================================================================
    // /users/{user_id}/tours
    //================================================================================

    public ListResponse<UserTour> getUserTours(int userId) throws WBTException, IOException {
        return getUserTours(userId, new ListConfig());
    }

    public ListResponse<UserTour> getUserTours(int userId, ListConfig listConfig) throws WBTException, IOException {
        return getList("/users/" + userId + "/tours" + listConfig, UserTour.class);
    }

    /******************************************************************************************************************
     *                                                                                                                *
     *                                                    POST                                                        *
     *                                                                                                                *
     ******************************************************************************************************************/

    //================================================================================
    // /users/{user_id}/beers/{user_beer_id}/rate
    //================================================================================

    public List<Integer> rateUserBeer(int userId, int userBeerId, Float rating, String comment)
            throws WBTException, IOException {
        HttpPost post = new HttpPost(API_ROOT + sign("/users/" + userId + "/beers/" + userBeerId + "/rate?"));
        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
        if (rating != null) {
            params.add(new BasicNameValuePair("rating", rating.toString()));
        }
        if (comment != null) {
            params.add(new BasicNameValuePair("comment", comment));
        }

        try {
            post.setEntity(new UrlEncodedFormEntity(params));
        } catch (UnsupportedEncodingException uee) {
            throw new WBTException("Failed to send rating/comment");
        }

        JsonReader reader = new JsonReader(new InputStreamReader(mHttpClient.execute(post).getEntity().getContent()));
        reader.beginObject();

        // success
        reader.nextName();
        if (reader.nextBoolean()) {
            reader.nextName();
            return mGson.fromJson(reader, new TypeToken<List<Integer>>(){}.getType());
        } else {
            // message
            reader.nextName();
            throw new WBTException(reader.nextString());
        }
    }

    /******************************************************************************************************************
     *                                                                                                                *
     *                                                   INTERNAL                                                     *
     *                                                                                                                *
     ******************************************************************************************************************/

    private <T> ListResponse<T> getList(String uri, Class<T> type) throws WBTException, IOException {
        HttpGet get = new HttpGet(API_ROOT + sign(uri));
        JsonReader reader = new JsonReader(new InputStreamReader(mHttpClient.execute(get).getEntity().getContent()));
        reader.beginObject();

        // success
        reader.nextName();
        if (reader.nextBoolean()) {
            // page
            reader.nextName();
            int page = reader.nextInt();

            // pages
            reader.nextName();
            int pages = reader.nextInt();

            // total
            reader.nextName();
            int total = reader.nextInt();

            ListResponse<T> response = new ListResponse<T>(page, pages, total);
            reader.nextName();
            reader.beginArray();
            while (reader.hasNext()) {
                try {
                    response.add((T) mGson.fromJson(reader, type));
                } catch (JsonParseException jpe) {
                    throw new WBTException("Failed to parse response");
                }
            }
            return response;
        } else {
            // message
            reader.nextName();
            throw new WBTException(reader.nextString());
        }
    }

    private <T> T getSingle(String uri, Class<T> type) throws WBTException, IOException {
        HttpGet get = new HttpGet(API_ROOT + sign(uri));
        JsonReader reader = new JsonReader(new InputStreamReader(mHttpClient.execute(get).getEntity().getContent()));
        reader.beginObject();

        // success
        reader.nextName();
        if (reader.nextBoolean()) {
            reader.nextName();
            try {
                return (T) mGson.fromJson(reader, type);
            } catch (JsonParseException jpe) {
                throw new WBTException("Failed to parse response");
            }
        } else {
            // message
            reader.nextName();
            throw new WBTException(reader.nextString());
        }
    }

    private String sign(String uri) {
        uri = uri + "key=" + mApiKey;

        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(mSecretKey.getBytes(), "HmacSHA1"));

            String b64 = new String(new Base64().encode(mac.doFinal(uri.getBytes()))).trim();
            return uri + "&signature=" + URLEncoder.encode(b64, "UTF-8");
        } catch (java.lang.Exception e) {
            return uri + "&signature=error";
        }
    }
}
