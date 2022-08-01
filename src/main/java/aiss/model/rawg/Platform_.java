
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
    "platform",
    "released_at",
    "requirements"
})
public class Platform_ {

    @JsonProperty("platform")
    private Platform__ platform;
    @JsonProperty("released_at")
    private String releasedAt;
    @JsonProperty("requirements")
    private Object requirements;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("platform")
    public Platform__ getPlatform() {
        return platform;
    }

    @JsonProperty("platform")
    public void setPlatform(Platform__ platform) {
        this.platform = platform;
    }

    @JsonProperty("released_at")
    public String getReleasedAt() {
        return releasedAt;
    }

    @JsonProperty("released_at")
    public void setReleasedAt(String releasedAt) {
        this.releasedAt = releasedAt;
    }

    @JsonProperty("requirements")
    public Object getRequirements() {
        return requirements;
    }

    @JsonProperty("requirements")
    public void setRequirements(Object requirements) {
        this.requirements = requirements;
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
