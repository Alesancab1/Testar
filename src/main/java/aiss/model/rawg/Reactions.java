
package aiss.model.rawg;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "1",
    "2",
    "3",
    "4",
    "5",
    "6",
    "7",
    "8",
    "9",
    "10",
    "11",
    "12"
})
public class Reactions {

    @JsonProperty("1")
    private Integer _1;
    @JsonProperty("2")
    private Integer _2;
    @JsonProperty("3")
    private Integer _3;
    @JsonProperty("4")
    private Integer _4;
    @JsonProperty("5")
    private Integer _5;
    @JsonProperty("6")
    private Integer _6;
    @JsonProperty("7")
    private Integer _7;
    @JsonProperty("8")
    private Integer _8;
    @JsonProperty("9")
    private Integer _9;
    @JsonProperty("10")
    private Integer _10;
    @JsonProperty("11")
    private Integer _11;
    @JsonProperty("12")
    private Integer _12;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("1")
    public Integer get1() {
        return _1;
    }

    @JsonProperty("1")
    public void set1(Integer _1) {
        this._1 = _1;
    }

    @JsonProperty("2")
    public Integer get2() {
        return _2;
    }

    @JsonProperty("2")
    public void set2(Integer _2) {
        this._2 = _2;
    }

    @JsonProperty("3")
    public Integer get3() {
        return _3;
    }

    @JsonProperty("3")
    public void set3(Integer _3) {
        this._3 = _3;
    }

    @JsonProperty("4")
    public Integer get4() {
        return _4;
    }

    @JsonProperty("4")
    public void set4(Integer _4) {
        this._4 = _4;
    }

    @JsonProperty("5")
    public Integer get5() {
        return _5;
    }

    @JsonProperty("5")
    public void set5(Integer _5) {
        this._5 = _5;
    }

    @JsonProperty("6")
    public Integer get6() {
        return _6;
    }

    @JsonProperty("6")
    public void set6(Integer _6) {
        this._6 = _6;
    }

    @JsonProperty("7")
    public Integer get7() {
        return _7;
    }

    @JsonProperty("7")
    public void set7(Integer _7) {
        this._7 = _7;
    }

    @JsonProperty("8")
    public Integer get8() {
        return _8;
    }

    @JsonProperty("8")
    public void set8(Integer _8) {
        this._8 = _8;
    }

    @JsonProperty("9")
    public Integer get9() {
        return _9;
    }

    @JsonProperty("9")
    public void set9(Integer _9) {
        this._9 = _9;
    }

    @JsonProperty("10")
    public Integer get10() {
        return _10;
    }

    @JsonProperty("10")
    public void set10(Integer _10) {
        this._10 = _10;
    }

    @JsonProperty("11")
    public Integer get11() {
        return _11;
    }

    @JsonProperty("11")
    public void set11(Integer _11) {
        this._11 = _11;
    }

    @JsonProperty("12")
    public Integer get12() {
        return _12;
    }

    @JsonProperty("12")
    public void set12(Integer _12) {
        this._12 = _12;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
