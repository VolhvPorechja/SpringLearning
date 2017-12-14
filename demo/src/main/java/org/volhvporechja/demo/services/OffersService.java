package org.volhvporechja.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.volhvporechja.demo.contracts.Offer;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OffersService {

    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Offer> offerRowMapper = (rs, rowNum) -> {

        Offer result = new Offer();
        result.setId(rs.getInt("id"));
        result.setName(rs.getString("name"));
        result.setEmail(rs.getString("email"));
        result.setText(rs.getString("text"));
        return result;
    };

    @Autowired
    public void setDataSource(DataSource ds) {
        jdbc = new NamedParameterJdbcTemplate(ds);
    }

    public boolean createOffer(Offer offer) {
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(offer);

        return jdbc.update("insert into Offers (name,email,text) values (:name,:email,:text)", param) == 1;
    }

    public List<Offer> getOffers() {
        return jdbc.query("select * from Offers", offerRowMapper);
    }

    public List<Offer> getOfferByName(String name) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", name);

        return jdbc.query("select * from Offers where name = :name", params, offerRowMapper);
    }
}
