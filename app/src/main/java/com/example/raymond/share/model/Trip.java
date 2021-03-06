package com.example.raymond.share.model;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

/**
 * Created by jiaminglow on 4/19/16.
 */

@Parcel
public class Trip {
    int id;
    String source, destination, information, role, date, time, status, distance, duration;
    String user_name, imageUrl;
    int user_id;

    public Trip(){}

    public Trip(int id, String source, String destination, String date, String time, String information, String role, String status){
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.information = information;
        this.role = role;
        this.status = status;
    }

    public Trip(int id, String source, String destination, String date, String user_name, String imageUrl, String status, String distance, String duration){
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.user_name = user_name;
        this.imageUrl = imageUrl;
        this.status = status;
        this.distance = distance;
        this.duration = duration;
    }

    public Trip(int id, String source, String destination, String date, String time, String information, String role, String status, int user_id, String user_name, String imageUrl){
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.information = information;
        this.role = role;
        this.status = status;
        this.user_id = user_id;
        this.user_name = user_name;
        this.imageUrl = imageUrl;
    }

    public Trip(JSONObject response){

        try {
            response = response.getJSONObject("result");

            try {
                this.id = response.getInt("id");
            } catch (JSONException e) {
                Log.d(getClass().getName(), "Id is null");
            }

            try {
                this.source = response.getString("source");
            } catch (JSONException e) {
                Log.d(getClass().getName(), "Source is null");
            }

            try {
                this.destination = response.getString("destination");
            } catch (JSONException e) {
                Log.d(getClass().getName(), "Destination is null");
            }

            try {
                this.date = response.getString("date");
            } catch (JSONException e) {
                Log.d(getClass().getName(), "Date is null");
            }

            try {
                this.time = response.getString("time");
            } catch (JSONException e) {
                Log.d(getClass().getName(), "Time is null");
            }

            try {
                this.information = response.getString("information");
            } catch (JSONException e) {
                Log.d(getClass().getName(), "Information is null");
            }

            try {
                this.role = response.getString("role");
            } catch (JSONException e) {
                Log.d(getClass().getName(), "Role is null");
            }

            try {
                this.status = response.getString("status");
            } catch (JSONException e) {
                Log.d(getClass().getName(), "Status is null");
            }

            try {
                this.user_id = response.getInt("user_id");
            } catch (JSONException e) {
                Log.d(getClass().getName(), "User id is null");
            }

            try {
                this.user_name = response.getString("name");
            } catch (JSONException e) {
                Log.d(getClass().getName(), "Name is null");
            }

            try {
                this.imageUrl = response.getString("imageUrl");
            } catch (JSONException e) {
                Log.d(getClass().getName(), "Image Url is null");
            }

            try {
                this.distance = response.getString("distance");
            } catch (JSONException e) {
                Log.d(getClass().getName(), "Distance is null");
            }

            try {
                this.duration = response.getString("duration");
            } catch (JSONException e) {
                Log.d(getClass().getName(), "Duration is null");
            }

        } catch (JSONException ex) {

            try {
                this.id = response.getInt("id");
            } catch (JSONException e) {
                Log.d(getClass().getName(), "Id is null");
            }

            try {
                this.source = response.getString("source");
            } catch (JSONException e) {
                Log.d(getClass().getName(), "Source is null");
            }

            try {
                this.destination = response.getString("destination");
            } catch (JSONException e) {
                Log.d(getClass().getName(), "Destination is null");
            }

            try {
                this.date = response.getString("date");
            } catch (JSONException e) {
                Log.d(getClass().getName(), "Date is null");
            }

            try {
                this.time = response.getString("time");
            } catch (JSONException e) {
                Log.d(getClass().getName(), "Time is null");
            }

            try {
                this.information = response.getString("information");
            } catch (JSONException e) {
                Log.d(getClass().getName(), "Information is null");
            }

            try {
                this.role = response.getString("role");
            } catch (JSONException e) {
                Log.d(getClass().getName(), "Role is null");
            }

            try {
                this.status = response.getString("status");
            } catch (JSONException e) {
                Log.d(getClass().getName(), "Status is null");
            }

            try {
                this.user_id = response.getInt("user_id");
            } catch (JSONException e) {
                Log.d(getClass().getName(), "User id is null");
            }

            try {
                this.user_name = response.getString("name");
            } catch (JSONException e) {
                Log.d(getClass().getName(), "Name is null");
            }

            try {
                this.imageUrl = response.getString("imageUrl");
            } catch (JSONException e) {
                Log.d(getClass().getName(), "Image Url is null");
            }

            try {
                this.distance = response.getString("distance");
            } catch (JSONException e) {
                Log.d(getClass().getName(), "Distance is null");
            }

            try {
                this.duration = response.getString("duration");
            } catch (JSONException e) {
                Log.d(getClass().getName(), "Duration is null");
            }
        }
    }

    public int getId() {
        return id;
    }

    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() {return time;}
    public void setTime(String time) { this.time = time; }

    public String getInformation() {return information; }

    public String getRole() {return role; }
    public void setRole(String role) { this.role = role; }

    public String getStatus() {return status; }

    public int getUserId() {return user_id; }
    public String getName() {return user_name; }
    public void setName(String user_name) { this.user_name = user_name; }

    public String getImageUrl() {return imageUrl; }

    public String getDistance() {return distance; }

    public String getDuration() {return duration; }
}
