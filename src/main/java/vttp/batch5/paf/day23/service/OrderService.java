package vttp.batch5.paf.day23.service;

import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import vttp.batch5.paf.day23.model.Item;
import vttp.batch5.paf.day23.model.Order;
import vttp.batch5.paf.day23.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public boolean checkout(String entity) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        JsonReader reader = Json.createReader(new StringReader(entity));
        JsonObject order = reader.readObject();
        JsonArray lineItems = order.getJsonArray("lineItems");
        String name = order.getString("name");
        String address = order.getString("address");
        Date deliveryDate = sdf.parse(order.getString("deliveryDate"));

        List<Item> items = new ArrayList<>();
        for (JsonValue i : lineItems) {
            JsonObject item = i.asJsonObject();
            items.add(new Item(item.getString("name"), item.getInt("quantity"), item.getJsonNumber("unitPrice").doubleValue()));
        }

        Order o = new Order(name, address, deliveryDate, items);
        return repository.checkout(o);
    }
}
