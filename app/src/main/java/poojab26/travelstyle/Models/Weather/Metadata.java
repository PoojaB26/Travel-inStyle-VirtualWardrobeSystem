package poojab26.travelstyle.Models.Weather;

/**
 * Created by pblead26 on 30-Sep-16.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metadata {

    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("transaction_id")
    @Expose
    private String transactionId;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("units")
    @Expose
    private String units;
    @SerializedName("expire_time_gmt")
    @Expose
    private Integer expireTimeGmt;
    @SerializedName("status_code")
    @Expose
    private Integer statusCode;

    /**
     *
     * @return
     *     The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     *
     * @param language
     *     The language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     *
     * @return
     *     The transactionId
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     *
     * @param transactionId
     *     The transaction_id
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     *
     * @return
     *     The version
     */
    public String getVersion() {
        return version;
    }

    /**
     *
     * @param version
     *     The version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     *
     * @return
     *     The latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     *
     * @param latitude
     *     The latitude
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     *
     * @return
     *     The longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     *
     * @param longitude
     *     The longitude
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     *
     * @return
     *     The units
     */
    public String getUnits() {
        return units;
    }

    /**
     *
     * @param units
     *     The units
     */
    public void setUnits(String units) {
        this.units = units;
    }

    /**
     *
     * @return
     *     The expireTimeGmt
     */
    public Integer getExpireTimeGmt() {
        return expireTimeGmt;
    }

    /**
     *
     * @param expireTimeGmt
     *     The expire_time_gmt
     */
    public void setExpireTimeGmt(Integer expireTimeGmt) {
        this.expireTimeGmt = expireTimeGmt;
    }

    /**
     *
     * @return
     *     The statusCode
     */
    public Integer getStatusCode() {
        return statusCode;
    }

    /**
     *
     * @param statusCode
     *     The status_code
     */
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

}
