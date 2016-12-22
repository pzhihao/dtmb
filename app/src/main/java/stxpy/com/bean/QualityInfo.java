package stxpy.com.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/10.
 */

public class QualityInfo {

    /**
     * msg :
     * data : [{"id":1,"detectionProject":"检测项目1","detectionValue":"1","decisionValue":"1","decisionResult":"判定结果"},{"id":2,"detectionProject":"项目2","detectionValue":"2","decisionValue":"2","decisionResult":"结果"},{"id":3,"detectionProject":"项目3","detectionValue":"1","decisionValue":"2","decisionResult":"成功"}]
     * code : true
     */

    private String msg;
    private boolean code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isCode() {
        return code;
    }

    public void setCode(boolean code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * detectionProject : 检测项目1
         * detectionValue : 1
         * decisionValue : 1
         * decisionResult : 判定结果
         */

        private int id;
        private String detectionProject;
        private String detectionValue;
        private String decisionValue;
        private String decisionResult;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDetectionProject() {
            return detectionProject;
        }

        public void setDetectionProject(String detectionProject) {
            this.detectionProject = detectionProject;
        }

        public String getDetectionValue() {
            return detectionValue;
        }

        public void setDetectionValue(String detectionValue) {
            this.detectionValue = detectionValue;
        }

        public String getDecisionValue() {
            return decisionValue;
        }

        public void setDecisionValue(String decisionValue) {
            this.decisionValue = decisionValue;
        }

        public String getDecisionResult() {
            return decisionResult;
        }

        public void setDecisionResult(String decisionResult) {
            this.decisionResult = decisionResult;
        }
    }
}
