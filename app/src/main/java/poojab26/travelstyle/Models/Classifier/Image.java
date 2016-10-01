
package poojab26.travelstyle.Models.Classifier;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Image {

    @SerializedName("classifiers")
    @Expose
    private List<Classifier> classifiers = new ArrayList<Classifier>();
    @SerializedName("resolved_url")
    @Expose
    private String resolvedUrl;
    @SerializedName("source_url")
    @Expose
    private String sourceUrl;




    /**
     * 
     * @return
     *     The classifiers
     */
    public List<Classifier> getClassifiers() {
        return classifiers;
    }

    /**
     * 
     * @param classifiers
     *     The classifiers
     */
    public void setClassifiers(List<Classifier> classifiers) {
        this.classifiers = classifiers;
    }

    /**
     * 
     * @return
     *     The resolvedUrl
     */
    public String getResolvedUrl() {
        return resolvedUrl;
    }

    /**
     * 
     * @param resolvedUrl
     *     The resolved_url
     */
    public void setResolvedUrl(String resolvedUrl) {
        this.resolvedUrl = resolvedUrl;
    }

    /**
     * 
     * @return
     *     The sourceUrl
     */
    public String getSourceUrl() {
        return sourceUrl;
    }

    /**
     * 
     * @param sourceUrl
     *     The source_url
     */
    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

}
