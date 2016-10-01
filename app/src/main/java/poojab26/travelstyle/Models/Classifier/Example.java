
package poojab26.travelstyle.Models.Classifier;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Example {

    @SerializedName("custom_classes")
    @Expose
    private Integer customClasses;
    @SerializedName("images")
    @Expose
    private List<Image> images = new ArrayList<Image>();
    @SerializedName("images_processed")
    @Expose
    private Integer imagesProcessed;

    /**
     * 
     * @return
     *     The customClasses
     */
    public Integer getCustomClasses() {
        return customClasses;
    }

    /**
     * 
     * @param customClasses
     *     The custom_classes
     */
    public void setCustomClasses(Integer customClasses) {
        this.customClasses = customClasses;
    }

    /**
     * 
     * @return
     *     The images
     */
    public List<Image> getImages() {
        return images;
    }

    /**
     * 
     * @param images
     *     The images
     */
    public void setImages(List<Image> images) {
        this.images = images;
    }

    /**
     * 
     * @return
     *     The imagesProcessed
     */
    public Integer getImagesProcessed() {
        return imagesProcessed;
    }

    /**
     * 
     * @param imagesProcessed
     *     The images_processed
     */
    public void setImagesProcessed(Integer imagesProcessed) {
        this.imagesProcessed = imagesProcessed;
    }

}
