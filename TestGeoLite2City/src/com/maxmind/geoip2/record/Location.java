package com.maxmind.geoip2.record;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>
 * Contains data for the location record associated with an IP address.
 * </p>
 * <p>
 * This record is returned by all the end points except the Country end point.
 * </p>
 */
public class Location extends AbstractRecord  {

    private final Integer accuracyRadius;
    private final Integer averageIncome;
    private final Double latitude;
    private final Double longitude;
    private final Integer metroCode;
    private final Integer populationDensity;
    private final String timeZone;

    public Location() {
        this(null, null, null, null, null, null, null);
    }

    public Location(
            @JsonProperty("accuracy_radius") Integer accuracyRadius,
            @JsonProperty("average_income") Integer averageIncome,
            @JsonProperty("latitude") Double latitude,
            @JsonProperty("longitude") Double longitude,
            @JsonProperty("metro_code") Integer metroCode,
            @JsonProperty("population_density") Integer populationDensity,
            @JsonProperty("time_zone") String timeZone
    ) {
        this.accuracyRadius = accuracyRadius;
        this.averageIncome = averageIncome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.metroCode = metroCode;
        this.populationDensity = populationDensity;
        this.timeZone = timeZone;
    }

    /**
     * @return The average income in US dollars associated with the requested
     * IP address. This attribute is only available from the Insights end point.
     */
    @JsonProperty("average_income")
    public Integer getAverageIncome() {
        return this.averageIncome;
    }

    /**
     * @return The estimated population per square kilometer associated with the
     * IP address. This attribute is only available from the Insights end point.
     */
    @JsonProperty("population_density")
    public Integer getPopulationDensity() {
        return this.populationDensity;
    }

    /**
     * @return The time zone associated with location, as specified by the <a
     * href="http://www.iana.org/time-zones">IANA Time Zone
     * Database</a>, e.g., "America/New_York". This attribute is
     * returned by all end points except the Country end point.
     */
    @JsonProperty("time_zone")
    public String getTimeZone() {
        return this.timeZone;
    }

    /**
     * @return The radius in kilometers around the specified location where the
     * IP address is likely to be. This attribute is only available from
     * the Insights end point.
     */
    @JsonProperty("accuracy_radius")
    public Integer getAccuracyRadius() {
        return this.accuracyRadius;
    }

    /**
     * @return The metro code of the location if the location is in the US.
     * MaxMind returns the same metro codes as the <a href=
     * "https://developers.google.com/adwords/api/docs/appendix/cities-DMAregions"
     * >Google AdWords API</a>. This attribute is returned by all end
     * points except the Country end point.
     */
    @JsonProperty("metro_code")
    public Integer getMetroCode() {
        return this.metroCode;
    }

    /**
     * @return The latitude of the location as a floating point number. This
     * attribute is returned by all end points except the Country end
     * point.
     */
    public Double getLatitude() {
        return this.latitude;
    }

    /**
     * @return The longitude of the location as a floating point number. This
     * attribute is returned by all end points except the Country end
     * point.
     */
    public Double getLongitude() {
        return this.longitude;
    }
}
