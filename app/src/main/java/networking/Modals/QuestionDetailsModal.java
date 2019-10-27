package Networking.Modals;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestionDetailsModal {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("difficultyLevel")
    @Expose
    private Integer difficultyLevel;
    @SerializedName("upVoteCount")
    @Expose
    private Integer upVoteCount;
    @SerializedName("downVoteCount")
    @Expose
    private Integer downVoteCount;
    @SerializedName("acceptedCount")
    @Expose
    private Integer acceptedCount;
    @SerializedName("submissionsCount")
    @Expose
    private Integer submissionsCount;
    @SerializedName("questionFrequency")
    @Expose
    private String questionFrequency;
    @SerializedName("companyQuestions")
    @Expose
    private List<CompanyQuestion> companyQuestions = null;
    @SerializedName("relatedTopics")
    @Expose
    private List<RelatedTopic> relatedTopics = null;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("url")
    @Expose
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(Integer difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public Integer getUpVoteCount() {
        return upVoteCount;
    }

    public void setUpVoteCount(Integer upVoteCount) {
        this.upVoteCount = upVoteCount;
    }

    public Integer getDownVoteCount() {
        return downVoteCount;
    }

    public void setDownVoteCount(Integer downVoteCount) {
        this.downVoteCount = downVoteCount;
    }

    public Integer getAcceptedCount() {
        return acceptedCount;
    }

    public void setAcceptedCount(Integer acceptedCount) {
        this.acceptedCount = acceptedCount;
    }

    public Integer getSubmissionsCount() {
        return submissionsCount;
    }

    public void setSubmissionsCount(Integer submissionsCount) {
        this.submissionsCount = submissionsCount;
    }

    public String getQuestionFrequency() {
        return questionFrequency;
    }

    public void setQuestionFrequency(String questionFrequency) {
        this.questionFrequency = questionFrequency;
    }

    public List<CompanyQuestion> getCompanyQuestions() {
        return companyQuestions;
    }

    public void setCompanyQuestions(List<CompanyQuestion> companyQuestions) {
        this.companyQuestions = companyQuestions;
    }

    public List<Networking.Modals.RelatedTopic> getRelatedTopics() {
        return relatedTopics;
    }

    public void setRelatedTopics(List<RelatedTopic> relatedTopics) {
        this.relatedTopics = relatedTopics;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
