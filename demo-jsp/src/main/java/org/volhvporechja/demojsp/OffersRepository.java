package org.volhvporechja.demojsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.volhvporechja.demojsp.dao.Offer;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class OffersRepository {

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

	public List<Offer> getOffers() {
		return jdbc.query("select * from Offers", offerRowMapper);
	}
}
