package poojab26.travelstyle.Models.Weather;

/**
 * Created by pblead26 on 30-Sep-16.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Weather {

    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("forecasts")
    @Expose
    private List<Forecast> forecasts = new ArrayList<Forecast>();

    /**
     *
     * @return
     *     The metadata
     */
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     *
     * @param metadata
     *     The metadata
     */
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    /**
     *
     * @return
     *     The forecasts
     */
    public List<Forecast> getForecasts() {
        return forecasts;
    }

    /**
     *
     * @param forecasts
     *     The forecasts
     */
    public void setForecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }


}
