package cl.blueprintsit.powercenter.wrapper;

/**
 * Created by Ivan on 03-02-2016.
 */
public class LoginDetails {
    private String username;
    private String password;
    private String repoDomainName;
    private String repoName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepoDomainName() {
        return repoDomainName;
    }

    public void setRepoDomainName(String repoDomainName) {
        this.repoDomainName = repoDomainName;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }
}
