package com.maxmind.geoip2.record;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Contains data for the represented country associated with an IP address.
 * </p>
 * <p>
 * This class contains the country-level data associated with an IP address for
 * the IP's represented country. The represented country is the country
 * represented by something like a military base.
 * </p>
 */
public final class RepresentedCountry extends Country {

    private final String type;

    public RepresentedCountry() {
        this(null, null, null, null, null, null);
    }

    public RepresentedCountry(
            @JacksonInject("locales") List<String> locales,
            @JsonProperty("confidence") Integer confidence,
            @JsonProperty("geoname_id") Integer geoNameId,
            @JsonProperty("iso_code") String isoCode,
            @JsonProperty("names") Map<String, String> names,
            @JsonProperty("type") String type
    ) {
        super(locales, confidence, geoNameId, isoCode, names);
        this.type = type;
    }

    /**
     * @return A string indicating the type of entity that is representing the
     * country. Currently we only return {@code military} but this could
     * expand to include other types in the future.
     */
    public String getType() {
        return this.type;
    }

}
