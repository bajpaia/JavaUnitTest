package space.harbour.java.hw7;

import javax.json.*;

public interface Jsonable
{

    JsonObject toJsonObject();
    String toJsonString();

}