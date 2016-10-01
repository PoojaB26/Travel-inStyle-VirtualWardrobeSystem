package poojab26.travelstyle.Models.Classifier;

/**
 * Created by pblead26 on 30-Sep-16.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Class {

    @SerializedName("class")
    @Expose
    private String _class;
    @SerializedName("score")
    @Expose
    private Double score;

    /**
     *
     * @return
     *     The _class
     */
    public String getClass_() {
        return _class;
    }

    /**
     *
     * @param _class
     *     The class
     */
    public void setClass_(String _class) {
        this._class = _class;
    }

    /**
     *
     * @return
     *     The score
     */
    public Double getScore() {
        return score;
    }

    /**
     *
     * @param score
     *     The score
     */
    public void setScore(Double score) {
        this.score = score;
    }

}
