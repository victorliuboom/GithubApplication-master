package youga.github.app.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by liuwei on 2017/3/3.
 */

public class Repository implements Parcelable {

    private int id;
    private String name;
    private String full_name;
    private User owner;
    @SerializedName("private")
    private boolean privateX;
    private String html_url;
    private String description;
    private boolean fork;
    private String url;
    private String forks_url;
    private String keys_url;
    private String collaborators_url;
    private String teams_url;
    private String hooks_url;
    private String issue_events_url;
    private String events_url;
    private String assignees_url;
    private String branches_url;
    private String tags_url;
    private String blobs_url;
    private String git_tags_url;
    private String git_refs_url;
    private String trees_url;
    private String statuses_url;
    private String languages_url;
    private String stargazers_url;
    private String contributors_url;
    private String subscribers_url;
    private String subscription_url;
    private String commits_url;
    private String git_commits_url;
    private String comments_url;
    private String issue_comment_url;
    private String contents_url;
    private String compare_url;
    private String merges_url;
    private String archive_url;
    private String downloads_url;
    private String issues_url;
    private String pulls_url;
    private String milestones_url;
    private String notifications_url;
    private String labels_url;
    private String releases_url;
    private String deployments_url;
    private String created_at;
    private String updated_at;
    private String pushed_at;
    private String git_url;
    private String ssh_url;
    private String clone_url;
    private String svn_url;
    //    private Object homepage;
    private int size;
    private int stargazers_count;
    private int watchers_count;
    private String language;
    private boolean has_issues;
    private boolean has_downloads;
    private boolean has_wiki;
    private boolean has_pages;
    private int forks_count;
    //    private Object mirror_url;
    private int open_issues_count;
    private int forks;
    private int open_issues;
    private int watchers;
    private String default_branch;

    public User getOwner() {
        return owner;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }

    public boolean isPrivateX() {
        return privateX;
    }

    public String getHtml_url() {
        return html_url;
    }

    public String getDescription() {
        return description;
    }

    public boolean isFork() {
        return fork;
    }

    public String getUrl() {
        return url;
    }

    public String getForks_url() {
        return forks_url;
    }

    public String getKeys_url() {
        return keys_url;
    }

    public String getCollaborators_url() {
        return collaborators_url;
    }

    public String getTeams_url() {
        return teams_url;
    }

    public String getHooks_url() {
        return hooks_url;
    }

    public String getIssue_events_url() {
        return issue_events_url;
    }

    public String getEvents_url() {
        return events_url;
    }

    public String getAssignees_url() {
        return assignees_url;
    }

    public String getBranches_url() {
        return branches_url;
    }

    public String getTags_url() {
        return tags_url;
    }

    public String getBlobs_url() {
        return blobs_url;
    }

    public String getGit_tags_url() {
        return git_tags_url;
    }

    public String getGit_refs_url() {
        return git_refs_url;
    }

    public String getTrees_url() {
        return trees_url;
    }

    public String getStatuses_url() {
        return statuses_url;
    }

    public String getLanguages_url() {
        return languages_url;
    }

    public String getStargazers_url() {
        return stargazers_url;
    }

    public String getContributors_url() {
        return contributors_url;
    }

    public String getSubscribers_url() {
        return subscribers_url;
    }

    public String getSubscription_url() {
        return subscription_url;
    }

    public String getCommits_url() {
        return commits_url;
    }

    public String getGit_commits_url() {
        return git_commits_url;
    }

    public String getComments_url() {
        return comments_url;
    }

    public String getIssue_comment_url() {
        return issue_comment_url;
    }

    public String getContents_url() {
        return contents_url;
    }

    public String getCompare_url() {
        return compare_url;
    }

    public String getMerges_url() {
        return merges_url;
    }

    public String getArchive_url() {
        return archive_url;
    }

    public String getDownloads_url() {
        return downloads_url;
    }

    public String getIssues_url() {
        return issues_url;
    }

    public String getPulls_url() {
        return pulls_url;
    }

    public String getMilestones_url() {
        return milestones_url;
    }

    public String getNotifications_url() {
        return notifications_url;
    }

    public String getLabels_url() {
        return labels_url;
    }

    public String getReleases_url() {
        return releases_url;
    }

    public String getDeployments_url() {
        return deployments_url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getPushed_at() {
        return pushed_at;
    }

    public String getGit_url() {
        return git_url;
    }

    public String getSsh_url() {
        return ssh_url;
    }

    public String getClone_url() {
        return clone_url;
    }

    public String getSvn_url() {
        return svn_url;
    }

    public int getSize() {
        return size;
    }

    public int getStargazers_count() {
        return stargazers_count;
    }

    public int getWatchers_count() {
        return watchers_count;
    }

    public String getLanguage() {
        return language == null ? language = "" : language;
    }

    public boolean isHas_issues() {
        return has_issues;
    }

    public boolean isHas_downloads() {
        return has_downloads;
    }

    public boolean isHas_wiki() {
        return has_wiki;
    }

    public boolean isHas_pages() {
        return has_pages;
    }

    public int getForks_count() {
        return forks_count;
    }

    public int getOpen_issues_count() {
        return open_issues_count;
    }

    public int getForks() {
        return forks;
    }

    public int getOpen_issues() {
        return open_issues;
    }

    public int getWatchers() {
        return watchers;
    }

    public String getDefault_branch() {
        return default_branch;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.full_name);
        dest.writeParcelable(this.owner, flags);
        dest.writeByte(this.privateX ? (byte) 1 : (byte) 0);
        dest.writeString(this.html_url);
        dest.writeString(this.description);
        dest.writeByte(this.fork ? (byte) 1 : (byte) 0);
        dest.writeString(this.url);
        dest.writeString(this.forks_url);
        dest.writeString(this.keys_url);
        dest.writeString(this.collaborators_url);
        dest.writeString(this.teams_url);
        dest.writeString(this.hooks_url);
        dest.writeString(this.issue_events_url);
        dest.writeString(this.events_url);
        dest.writeString(this.assignees_url);
        dest.writeString(this.branches_url);
        dest.writeString(this.tags_url);
        dest.writeString(this.blobs_url);
        dest.writeString(this.git_tags_url);
        dest.writeString(this.git_refs_url);
        dest.writeString(this.trees_url);
        dest.writeString(this.statuses_url);
        dest.writeString(this.languages_url);
        dest.writeString(this.stargazers_url);
        dest.writeString(this.contributors_url);
        dest.writeString(this.subscribers_url);
        dest.writeString(this.subscription_url);
        dest.writeString(this.commits_url);
        dest.writeString(this.git_commits_url);
        dest.writeString(this.comments_url);
        dest.writeString(this.issue_comment_url);
        dest.writeString(this.contents_url);
        dest.writeString(this.compare_url);
        dest.writeString(this.merges_url);
        dest.writeString(this.archive_url);
        dest.writeString(this.downloads_url);
        dest.writeString(this.issues_url);
        dest.writeString(this.pulls_url);
        dest.writeString(this.milestones_url);
        dest.writeString(this.notifications_url);
        dest.writeString(this.labels_url);
        dest.writeString(this.releases_url);
        dest.writeString(this.deployments_url);
        dest.writeString(this.created_at);
        dest.writeString(this.updated_at);
        dest.writeString(this.pushed_at);
        dest.writeString(this.git_url);
        dest.writeString(this.ssh_url);
        dest.writeString(this.clone_url);
        dest.writeString(this.svn_url);
        dest.writeInt(this.size);
        dest.writeInt(this.stargazers_count);
        dest.writeInt(this.watchers_count);
        dest.writeString(this.language);
        dest.writeByte(this.has_issues ? (byte) 1 : (byte) 0);
        dest.writeByte(this.has_downloads ? (byte) 1 : (byte) 0);
        dest.writeByte(this.has_wiki ? (byte) 1 : (byte) 0);
        dest.writeByte(this.has_pages ? (byte) 1 : (byte) 0);
        dest.writeInt(this.forks_count);
        dest.writeInt(this.open_issues_count);
        dest.writeInt(this.forks);
        dest.writeInt(this.open_issues);
        dest.writeInt(this.watchers);
        dest.writeString(this.default_branch);
    }

    public Repository() {
    }

    protected Repository(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.full_name = in.readString();
        this.owner = in.readParcelable(User.class.getClassLoader());
        this.privateX = in.readByte() != 0;
        this.html_url = in.readString();
        this.description = in.readString();
        this.fork = in.readByte() != 0;
        this.url = in.readString();
        this.forks_url = in.readString();
        this.keys_url = in.readString();
        this.collaborators_url = in.readString();
        this.teams_url = in.readString();
        this.hooks_url = in.readString();
        this.issue_events_url = in.readString();
        this.events_url = in.readString();
        this.assignees_url = in.readString();
        this.branches_url = in.readString();
        this.tags_url = in.readString();
        this.blobs_url = in.readString();
        this.git_tags_url = in.readString();
        this.git_refs_url = in.readString();
        this.trees_url = in.readString();
        this.statuses_url = in.readString();
        this.languages_url = in.readString();
        this.stargazers_url = in.readString();
        this.contributors_url = in.readString();
        this.subscribers_url = in.readString();
        this.subscription_url = in.readString();
        this.commits_url = in.readString();
        this.git_commits_url = in.readString();
        this.comments_url = in.readString();
        this.issue_comment_url = in.readString();
        this.contents_url = in.readString();
        this.compare_url = in.readString();
        this.merges_url = in.readString();
        this.archive_url = in.readString();
        this.downloads_url = in.readString();
        this.issues_url = in.readString();
        this.pulls_url = in.readString();
        this.milestones_url = in.readString();
        this.notifications_url = in.readString();
        this.labels_url = in.readString();
        this.releases_url = in.readString();
        this.deployments_url = in.readString();
        this.created_at = in.readString();
        this.updated_at = in.readString();
        this.pushed_at = in.readString();
        this.git_url = in.readString();
        this.ssh_url = in.readString();
        this.clone_url = in.readString();
        this.svn_url = in.readString();
        this.size = in.readInt();
        this.stargazers_count = in.readInt();
        this.watchers_count = in.readInt();
        this.language = in.readString();
        this.has_issues = in.readByte() != 0;
        this.has_downloads = in.readByte() != 0;
        this.has_wiki = in.readByte() != 0;
        this.has_pages = in.readByte() != 0;
        this.forks_count = in.readInt();
        this.open_issues_count = in.readInt();
        this.forks = in.readInt();
        this.open_issues = in.readInt();
        this.watchers = in.readInt();
        this.default_branch = in.readString();
    }

    public static final Parcelable.Creator<Repository> CREATOR = new Parcelable.Creator<Repository>() {
        @Override
        public Repository createFromParcel(Parcel source) {
            return new Repository(source);
        }

        @Override
        public Repository[] newArray(int size) {
            return new Repository[size];
        }
    };
}
