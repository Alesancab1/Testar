
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
    "clip",
    "clips",
    "video",
    "preview"
})
public class Clip {

    @JsonProperty("clip")
    private String clip;
    @JsonProperty("clips")
    private Clips clips;
    @JsonProperty("video")
    private String video;
    @JsonProperty("preview")
    private String preview;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("clip")
    public String getClip() {
        return clip;
    }

    @JsonProperty("clip")
    public void setClip(String clip) {
        this.clip = clip;
    }

    @JsonProperty("clips")
    public Clips getClips() {
        return clips;
    }

    @JsonProperty("clips")
    public void setClips(Clips clips) {
        this.clips = clips;
    }

    @JsonProperty("video")
    public String getVideo() {
        return video;
    }

    @JsonProperty("video")
    public void setVideo(String video) {
        this.video = video;
    }

    @JsonProperty("preview")
    public String getPreview() {
        return preview;
    }

    @JsonProperty("preview")
    public void setPreview(String preview) {
        this.preview = preview;
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
