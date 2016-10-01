package poojab26.travelstyle.Models.Weather;

/**
 * Created by pblead26 on 30-Sep-16.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forecast {

    @SerializedName("class")
    @Expose
    private String _class;
    @SerializedName("expire_time_gmt")
    @Expose
    private Integer expireTimeGmt;
    @SerializedName("fcst_valid")
    @Expose
    private Integer fcstValid;
    @SerializedName("fcst_valid_local")
    @Expose
    private String fcstValidLocal;
    @SerializedName("num")
    @Expose
    private Integer num;
    @SerializedName("temp")
    @Expose
    private Integer temp;
    @SerializedName("pop")
    @Expose
    private Integer pop;
    @SerializedName("icon_extd")
    @Expose
    private Integer iconExtd;
    @SerializedName("icon_code")
    @Expose
    private Integer iconCode;
    @SerializedName("dow")
    @Expose
    private String dow;
    @SerializedName("daypart_name")
    @Expose
    private String daypartName;
    @SerializedName("phrase_12char")
    @Expose
    private String phrase12char;
    @SerializedName("phrase_22char")
    @Expose
    private String phrase22char;
    @SerializedName("phrase_32char")
    @Expose
    private String phrase32char;
    @SerializedName("subphrase_pt1")
    @Expose
    private String subphrasePt1;
    @SerializedName("subphrase_pt2")
    @Expose
    private String subphrasePt2;
    @SerializedName("subphrase_pt3")
    @Expose
    private String subphrasePt3;
    @SerializedName("precip_type")
    @Expose
    private String precipType;
    @SerializedName("rh")
    @Expose
    private Integer rh;
    @SerializedName("wspd")
    @Expose
    private Integer wspd;
    @SerializedName("wdir")
    @Expose
    private Integer wdir;
    @SerializedName("wdir_cardinal")
    @Expose
    private String wdirCardinal;
    @SerializedName("clds")
    @Expose
    private Integer clds;
    @SerializedName("qualifier_code")
    @Expose
    private Object qualifierCode;
    @SerializedName("qualifier")
    @Expose
    private Object qualifier;

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
     *     The fcstValid
     */
    public Integer getFcstValid() {
        return fcstValid;
    }

    /**
     *
     * @param fcstValid
     *     The fcst_valid
     */
    public void setFcstValid(Integer fcstValid) {
        this.fcstValid = fcstValid;
    }

    /**
     *
     * @return
     *     The fcstValidLocal
     */
    public String getFcstValidLocal() {
        return fcstValidLocal;
    }

    /**
     *
     * @param fcstValidLocal
     *     The fcst_valid_local
     */
    public void setFcstValidLocal(String fcstValidLocal) {
        this.fcstValidLocal = fcstValidLocal;
    }

    /**
     *
     * @return
     *     The num
     */
    public Integer getNum() {
        return num;
    }

    /**
     *
     * @param num
     *     The num
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     *
     * @return
     *     The temp
     */
    public Integer getTemp() {
        return temp;
    }

    /**
     *
     * @param temp
     *     The temp
     */
    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    /**
     *
     * @return
     *     The pop
     */
    public Integer getPop() {
        return pop;
    }

    /**
     *
     * @param pop
     *     The pop
     */
    public void setPop(Integer pop) {
        this.pop = pop;
    }

    /**
     *
     * @return
     *     The iconExtd
     */
    public Integer getIconExtd() {
        return iconExtd;
    }

    /**
     *
     * @param iconExtd
     *     The icon_extd
     */
    public void setIconExtd(Integer iconExtd) {
        this.iconExtd = iconExtd;
    }

    /**
     *
     * @return
     *     The iconCode
     */
    public Integer getIconCode() {
        return iconCode;
    }

    /**
     *
     * @param iconCode
     *     The icon_code
     */
    public void setIconCode(Integer iconCode) {
        this.iconCode = iconCode;
    }

    /**
     *
     * @return
     *     The dow
     */
    public String getDow() {
        return dow;
    }

    /**
     *
     * @param dow
     *     The dow
     */
    public void setDow(String dow) {
        this.dow = dow;
    }

    /**
     *
     * @return
     *     The daypartName
     */
    public String getDaypartName() {
        return daypartName;
    }

    /**
     *
     * @param daypartName
     *     The daypart_name
     */
    public void setDaypartName(String daypartName) {
        this.daypartName = daypartName;
    }

    /**
     *
     * @return
     *     The phrase12char
     */
    public String getPhrase12char() {
        return phrase12char;
    }

    /**
     *
     * @param phrase12char
     *     The phrase_12char
     */
    public void setPhrase12char(String phrase12char) {
        this.phrase12char = phrase12char;
    }

    /**
     *
     * @return
     *     The phrase22char
     */
    public String getPhrase22char() {
        return phrase22char;
    }

    /**
     *
     * @param phrase22char
     *     The phrase_22char
     */
    public void setPhrase22char(String phrase22char) {
        this.phrase22char = phrase22char;
    }

    /**
     *
     * @return
     *     The phrase32char
     */
    public String getPhrase32char() {
        return phrase32char;
    }

    /**
     *
     * @param phrase32char
     *     The phrase_32char
     */
    public void setPhrase32char(String phrase32char) {
        this.phrase32char = phrase32char;
    }

    /**
     *
     * @return
     *     The subphrasePt1
     */
    public String getSubphrasePt1() {
        return subphrasePt1;
    }

    /**
     *
     * @param subphrasePt1
     *     The subphrase_pt1
     */
    public void setSubphrasePt1(String subphrasePt1) {
        this.subphrasePt1 = subphrasePt1;
    }

    /**
     *
     * @return
     *     The subphrasePt2
     */
    public String getSubphrasePt2() {
        return subphrasePt2;
    }

    /**
     *
     * @param subphrasePt2
     *     The subphrase_pt2
     */
    public void setSubphrasePt2(String subphrasePt2) {
        this.subphrasePt2 = subphrasePt2;
    }

    /**
     *
     * @return
     *     The subphrasePt3
     */
    public String getSubphrasePt3() {
        return subphrasePt3;
    }

    /**
     *
     * @param subphrasePt3
     *     The subphrase_pt3
     */
    public void setSubphrasePt3(String subphrasePt3) {
        this.subphrasePt3 = subphrasePt3;
    }

    /**
     *
     * @return
     *     The precipType
     */
    public String getPrecipType() {
        return precipType;
    }

    /**
     *
     * @param precipType
     *     The precip_type
     */
    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    /**
     *
     * @return
     *     The rh
     */
    public Integer getRh() {
        return rh;
    }

    /**
     *
     * @param rh
     *     The rh
     */
    public void setRh(Integer rh) {
        this.rh = rh;
    }

    /**
     *
     * @return
     *     The wspd
     */
    public Integer getWspd() {
        return wspd;
    }

    /**
     *
     * @param wspd
     *     The wspd
     */
    public void setWspd(Integer wspd) {
        this.wspd = wspd;
    }

    /**
     *
     * @return
     *     The wdir
     */
    public Integer getWdir() {
        return wdir;
    }

    /**
     *
     * @param wdir
     *     The wdir
     */
    public void setWdir(Integer wdir) {
        this.wdir = wdir;
    }

    /**
     *
     * @return
     *     The wdirCardinal
     */
    public String getWdirCardinal() {
        return wdirCardinal;
    }

    /**
     *
     * @param wdirCardinal
     *     The wdir_cardinal
     */
    public void setWdirCardinal(String wdirCardinal) {
        this.wdirCardinal = wdirCardinal;
    }

    /**
     *
     * @return
     *     The clds
     */
    public Integer getClds() {
        return clds;
    }

    /**
     *
     * @param clds
     *     The clds
     */
    public void setClds(Integer clds) {
        this.clds = clds;
    }

    /**
     *
     * @return
     *     The qualifierCode
     */
    public Object getQualifierCode() {
        return qualifierCode;
    }

    /**
     *
     * @param qualifierCode
     *     The qualifier_code
     */
    public void setQualifierCode(Object qualifierCode) {
        this.qualifierCode = qualifierCode;
    }

    /**
     *
     * @return
     *     The qualifier
     */
    public Object getQualifier() {
        return qualifier;
    }

    /**
     *
     * @param qualifier
     *     The qualifier
     */
    public void setQualifier(Object qualifier) {
        this.qualifier = qualifier;
    }



}
