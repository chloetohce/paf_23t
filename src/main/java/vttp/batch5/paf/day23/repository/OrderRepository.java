package vttp.batch5.paf.day23.repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp.batch5.paf.day23.model.Item;
import vttp.batch5.paf.day23.model.Order;

@Repository
public class OrderRepository {
    @Autowired
    private JdbcTemplate template;

    public boolean checkout(Order order) {
        int add = template.update(Query.ADD_ORDER, order.getName(), order.getAddress(), order.getDeliveryDate());
        if (add == 0) {
            return false;
        }

        SqlRowSet rs = template.queryForRowSet(Query.FIND_ORDER, order.getName(), order.getAddress(), order.getDeliveryDate());
        if (!rs.next()) {
            return false;
        }
        int orderId = rs.getInt("oid");
        List<Item> items = order.getLineItems();
        List<Object[]> params = items.stream()
            .map(i -> new Object[]{i.getName(), i.getQuantity(), i.getUnitPrice(), orderId})
            .collect(Collectors.toList());
        int added[] = template.batchUpdate(Query.ADD_ITEM, params);
        return Arrays.stream(added).allMatch(n -> n != 0);
    }
}
