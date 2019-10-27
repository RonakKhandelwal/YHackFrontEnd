
package networking.Modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompanyQuestion {

    @SerializedName("companyName")
    @Expose
    private String companyName;
    @SerializedName("questionFrequency")
    @Expose
    private Integer questionFrequency;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getQuestionFrequency() {
        return questionFrequency;
    }

    public void setQuestionFrequency(Integer questionFrequency) {
        this.questionFrequency = questionFrequency;
    }

}
