
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
    "320",
    "640",
    "full"
})
public class Clips {

    @JsonProperty("320")
    private String _320;
    @JsonProperty("640")
    private String _640;
    @JsonProperty("full")
    private String full;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("320")
    public String get320() {
        return _320;
    }

    @JsonProperty("320")
    public void set320(String _320) {
        this._320 = _320;
    }

    @JsonProperty("640")
    public String get640() {
        return _640;
    }

    @JsonProperty("640")
    public void set640(String _640) {
        this._640 = _640;
    }

    @JsonProperty("full")
    public String getFull() {
        return full;
    }

    @JsonProperty("full")
    public void setFull(String full) {
        this.full = full;
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
