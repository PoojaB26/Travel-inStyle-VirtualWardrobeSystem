
package poojab26.travelstyle.Models.Classifier;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;

public class Classifier {

    @SerializedName("classes")
    @Expose
    private List<Class> classes = new ArrayList<Class>();
    @SerializedName("classifier_id")
    @Expose
    private String classifierId;
    @SerializedName("name")
    @Expose
    private String name;

    /**
     * 
     * @return
     *     The classes
     */
    public List<Class> getClasses() {
        return classes;
    }

    /**
     * 
     * @param classes
     *     The classes
     */
    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    /**
     * 
     * @return
     *     The classifierId
     */
    public String getClassifierId() {
        return classifierId;
    }

    /**
     * 
     * @param classifierId
     *     The classifier_id
     */
    public void setClassifierId(String classifierId) {
        this.classifierId = classifierId;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

}
