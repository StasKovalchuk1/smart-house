package org.example.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import netscape.javascript.JSObject;
import org.example.builders.HouseBuilder;
import org.example.director.Director;
import org.example.houseComponents.Floor;
import org.example.houseComponents.Garage;
import org.example.houseComponents.Pool;
import org.example.houses.*;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class ConfigBuilder {
    private static JSONObject object;

    public static House buildHouseFromJson(String jsonFileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(new File(jsonFileName));

        String type = node.get("type").asText();
        List<Floor> floors = mapper.readValue(node.get("floors").toString(), new TypeReference<List<Floor>>(){});
        Garage garage;
        Pool pool;

        switch (type) {
            case "Simple":
                return new SimpleHouse(floors);
            case "With Garage":
                garage = mapper.readValue(node.get("garage").toString(), Garage.class);
                return new HouseWithGarage(floors, garage);
            case "With Pool":
                pool = mapper.readValue(node.get("pool").toString(), Pool.class);
                return new HouseWithPool(floors, pool);
            case "With Garage and Pool":
                garage = mapper.readValue(node.get("garage").toString(), Garage.class);
                pool = mapper.readValue(node.get("pool").toString(), Pool.class);
                return new HouseWithGarageAndPool(floors, garage, pool);
            default:
                throw new IllegalArgumentException("Unknown home type: " + type);
        }
    }

    public static House build(String path) {
        File file = new File(path);
        try {
            String str = new String(Files.readAllBytes(Paths.get(file.toURI())));
            object = new JSONObject(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Director director = new Director();
        HouseBuilder houseBuilder;

        return null;
    }
}
