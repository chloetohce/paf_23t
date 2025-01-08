package vttp.batch5.paf.day23.repository;

public class Query {
    public static final String ADD_ORDER = """
            insert into orders(name, address, delivery_date)
                values(?, ?, ?);
            """;

    public static final String FIND_ORDER = """
            select * from orders
                where name = ? and
                    address = ? and
                    delivery_date = ?;
            """;

    public static final String ADD_ITEM = """
            insert into items(name, quantity, unit_price, oid)
                values(?, ?, ?, ?);
            """;

}
