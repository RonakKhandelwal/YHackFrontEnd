
package networking.Modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metadata {

    @SerializedName("leetcodeId")
    @Expose
    private Integer leetcodeId;
    @SerializedName("leetcodeFrontendId")
    @Expose
    private Integer leetcodeFrontendId;
    @SerializedName("titleSlug")
    @Expose
    private String titleSlug;
    @SerializedName("newQuestion")
    @Expose
    private Boolean newQuestion;
    @SerializedName("hiddenQuestion")
    @Expose
    private Boolean hiddenQuestion;

    public Integer getLeetcodeId() {
        return leetcodeId;
    }

    public void setLeetcodeId(Integer leetcodeId) {
        this.leetcodeId = leetcodeId;
    }

    public Integer getLeetcodeFrontendId() {
        return leetcodeFrontendId;
    }

    public void setLeetcodeFrontendId(Integer leetcodeFrontendId) {
        this.leetcodeFrontendId = leetcodeFrontendId;
    }

    public String getTitleSlug() {
        return titleSlug;
    }

    public void setTitleSlug(String titleSlug) {
        this.titleSlug = titleSlug;
    }

    public Boolean getNewQuestion() {
        return newQuestion;
    }

    public void setNewQuestion(Boolean newQuestion) {
        this.newQuestion = newQuestion;
    }

    public Boolean getHiddenQuestion() {
        return hiddenQuestion;
    }

    public void setHiddenQuestion(Boolean hiddenQuestion) {
        this.hiddenQuestion = hiddenQuestion;
    }

}
