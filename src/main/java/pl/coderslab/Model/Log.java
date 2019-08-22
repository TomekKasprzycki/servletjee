package pl.coderslab.Model;

public class Log {
    private int id;
    private String userAgent;
    private String userName;
    private long logStartDate;
    private long logEndDate;

    public Log(String userAgent, String userName, long logStartDate, long logEndDate) {
        this.userAgent = userAgent;
        this.userName = userName;
        this.logStartDate = logStartDate;
        this.logEndDate = logEndDate;
    }

    public Log(int id, String userAgent, String userName, long logStartDate, long logEndDate) {
        this.id = id;
        this.userAgent = userAgent;
        this.userName = userName;
        this.logStartDate = logStartDate;
        this.logEndDate = logEndDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getLogStartDate() {
        return logStartDate;
    }

    public void setLogStartDate(long logStartDate) {
        this.logStartDate = logStartDate;
    }

    public long getLogEndDate() {
        return logEndDate;
    }

    public void setLogEndDate(long logEndDate) {
        this.logEndDate = logEndDate;
    }
}
